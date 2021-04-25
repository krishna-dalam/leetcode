package com.practice.leetcode.tcsdigital.eduprogram;

public class EduProgram {
    private String eduProgramName;
    private String sponsor;
    private int noOfPeopleAttended;
    private boolean stillAvailable;
    private boolean withinCountry;

    public EduProgram(String eduProgramName, String sponsor, int noOfPeopleAttended, boolean stillAvailable, boolean withinCountry) {
        this.eduProgramName = eduProgramName;
        this.sponsor = sponsor;
        this.noOfPeopleAttended = noOfPeopleAttended;
        this.stillAvailable = stillAvailable;
        this.withinCountry = withinCountry;
    }

    public String getEduProgramName() {
        return eduProgramName;
    }

    public void setEduProgramName(String eduProgramName) {
        this.eduProgramName = eduProgramName;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getNoOfPeopleAttended() {
        return noOfPeopleAttended;
    }

    public void setNoOfPeopleAttended(int noOfPeopleAttended) {
        this.noOfPeopleAttended = noOfPeopleAttended;
    }

    public boolean isStillAvailable() {
        return stillAvailable;
    }

    public void setStillAvailable(boolean stillAvailable) {
        this.stillAvailable = stillAvailable;
    }

    public boolean isWithinCountry() {
        return withinCountry;
    }

    public void setWithinCountry(boolean withinCountry) {
        this.withinCountry = withinCountry;
    }
}
