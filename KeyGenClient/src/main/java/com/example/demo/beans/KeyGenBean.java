package com.example.demo.beans;


import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.LicenseKey;
import com.example.demo.model.Product;
import com.example.demo.service.KeyService;

@ViewScoped
@Named
public class KeyGenBean {
	@Autowired
	private KeyService keyService;

	private LicenseKey licenseKey = new LicenseKey();
	private String selectedProduct;
	private String generatedKey = "";
	private String check = " ";
	String userKey;
	String keyComment;

	public void generate() {

		licenseKey = keyService.generateLicenseKey(selectedProduct);
		generatedKey = licenseKey.getEncryptedKey();
		licenseKey.setKeyComment(check);

	}

	public void check() {

		check = keyService.validateSaidKey(userKey);

	}

	public Product[] getProductList() {
		return Product.values();
	}

	public KeyService getKeyService() {
		return keyService;
	}

	public void setKeyService(KeyService keyService) {
		this.keyService = keyService;
	}

	public LicenseKey getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(LicenseKey licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(String selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public String getGeneratedKey() {
		return generatedKey;
	}

	public void setGeneratedKey(String generatedKey) {
		this.generatedKey = generatedKey;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getKeyComment() {
		return keyComment;
	}

	public void setKeyComment(String keyComment) {
		keyComment = keyComment;
	}
}
