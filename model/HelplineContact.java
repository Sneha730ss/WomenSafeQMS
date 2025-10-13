package com.WomenSafeQMS.model;

public class HelplineContact {
	private int helplineId;
    private String departmentName;
    private String contactNumber;

    public HelplineContact() {}

    public HelplineContact(String departmentName, String contactNumber) {
        this.departmentName = departmentName;
        this.contactNumber = contactNumber;
    }

    public int getHelplineId() {
        return helplineId;
    }

    public void setHelplineId(int helplineId) {
        this.helplineId = helplineId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
