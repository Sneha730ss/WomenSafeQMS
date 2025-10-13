package com.WomenSafeQMS.model;

public class Woman {
	private int womanId;
    private String fullName;
    private int age;
    private String mobileNumber;
    private String email;
    private String address;

    // Constructors
    public Woman() {}

    public Woman(String fullName, int age, String mobileNumber, String email, String address) {
        this.fullName = fullName;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public int getWomanId() { return womanId; }
    public void setWomanId(int womanId) { this.womanId = womanId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
	}


