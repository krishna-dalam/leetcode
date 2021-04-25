package com.practice.leetcode.tcsdigital.servicecenter;

public class ServiceCenter {

    private String serviceCenterName, branch;
    private double amountCharged;
    private boolean availableOnline;

    public ServiceCenter(String serviceCenterName, String branch, double amountCharged, boolean availableOnline) {
        this.serviceCenterName = serviceCenterName;
        this.branch = branch;
        this.amountCharged = amountCharged;
        this.availableOnline = availableOnline;
    }

    public String getServiceCenterName() {
        return serviceCenterName;
    }

    public void setServiceCenterName(String serviceCenterName) {
        this.serviceCenterName = serviceCenterName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(double amountCharged) {
        this.amountCharged = amountCharged;
    }

    public boolean isAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(boolean availableOnline) {
        this.availableOnline = availableOnline;
    }
}
