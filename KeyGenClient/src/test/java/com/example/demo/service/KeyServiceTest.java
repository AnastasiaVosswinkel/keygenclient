package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.LicenseKey;

@SpringBootTest
public class KeyServiceTest {

	static Logger log = LoggerFactory.getLogger(KeyServiceTest.class);

	@Autowired
	private KeyService service;

	@Test
	public void generateKeyTest() {
		LicenseKey li = service.generateLicenseKey("Product1");

		assertNotNull(li.getEncryptedKey());
		//assertNotNull(li.getDecryptedKey());
		
		log.debug(">>>>>>>>Encrypted Key:" + li.getEncryptedKey());
		

	}

	//@Test
	//public void decrypteLicenseKey() {
	//}

	@Test
	public void keyCheck() {

		String userKey = "12BD348D447B90B0F57BDEB20A86C11D";
		String text = service.validateSaidKey(userKey);

		assertEquals("12BD348D447B90B0F57BDEB20A86C11D Key Confirmed", text);
		log.debug(">>>>>>>>KeyCheck: " + text);

	}

}
