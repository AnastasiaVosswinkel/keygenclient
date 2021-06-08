package com.example.demo.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.example.demo.model.LicenseKey;

@Service
public class KeyService {
	static Logger log = LoggerFactory.getLogger(KeyService.class);
	
	RestTemplate template = new RestTemplate();


    // generateLicenseKey() creates a new License Key

	public LicenseKey generateLicenseKey(String product) {

		
		String url = "http://localhost:8089/licensekeys/generate";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		LicenseKey licenseKey= new LicenseKey();

		// create a map for post parameters
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", product);

		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		ResponseEntity<LicenseKey> response = template.postForEntity(url, entity, LicenseKey.class);
		
		String URLres = "http://localhost:8089/licensekeys";
		ResponseEntity<LicenseKey[]> re = template.getForEntity(URLres, LicenseKey[].class);

		LicenseKey[] liArr = re.getBody();
		LicenseKey key =   liArr[liArr.length - 1];
		String encryptedKey = key.getEncryptedKey();
		licenseKey.setEncryptedKey(encryptedKey);
		return licenseKey;
		
/*
		// check response status code
		if (response.getStatusCode() == HttpStatus.CREATED) {
			return response.getBody();
		} else {
			return null;
		}
		
*/		

	}

	public String validateSaidKey(String userKey) {
		String text = ";";

		String URL = "http://localhost:8089/licensekeys/encryptedkey?licensekey=" + userKey;
		log.debug(">>>>>>>>URL: " + URL);
		try {
			ResponseEntity<LicenseKey> re = template.getForEntity(URL, LicenseKey.class);
			LicenseKey licenseKey = re.getBody();
			text = licenseKey.getEncryptedKey() + " Key Confirmed";
		} catch (Exception e) {
			text = "Invalid Key";
		}
		return text;

	}
}
