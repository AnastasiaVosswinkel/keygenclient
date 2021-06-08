package com.example.demo.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class LicenseKey {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("keyComment")
    @Expose
    private String keyComment;
    @SerializedName("decryptedKey")
    @Expose
    private String decryptedKey;
    @SerializedName("encryptedKey")
    @Expose
    private String encryptedKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getKeyComment() {
        return keyComment;
    }

    public void setKeyComment(String keyComment) {
        this.keyComment = keyComment;
    }

    public String getDecryptedKey() {
        return decryptedKey;
    }

    public void setDecryptedKey(String decryptedKey) {
        this.decryptedKey = decryptedKey;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

}
