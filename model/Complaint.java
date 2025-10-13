package com.WomenSafeQMS.model;

public class Complaint {
	private int complaintId;
    private int womanId;
    private String complaintDetails;
    private String dateFiled;
    private String status;

    public Complaint() {}

    public Complaint(int womanId, String complaintDetails, String status) {
        this.womanId = womanId;
        this.complaintDetails = complaintDetails;
        this.status = status;
    }

    // Getters and Setters
    public int getComplaintId() { return complaintId; }
    public void setComplaintId(int complaintId) { this.complaintId = complaintId; }

    public int getWomanId() { return womanId; }
    public void setWomanId(int womanId) { this.womanId = womanId; }

    public String getComplaintDetails() { return complaintDetails; }
    public void setComplaintDetails(String complaintDetails) { this.complaintDetails = complaintDetails; }

    public String getDateFiled() { return dateFiled; }
    public void setDateFiled(String dateFiled) { this.dateFiled = dateFiled; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
