package com.WomenSafeQMS.model;

public class SOSRequest {
	private int sosId;
    private int womanId;
    private String location;
    private String timestamp;
    private boolean resolved;

    // Getters and Setters
    public int getSosId() { return sosId; }
    public void setSosId(int sosId) { this.sosId = sosId; }

    public int getWomanId() { return womanId; }
    public void setWomanId(int womanId) { this.womanId = womanId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}


