package com.practice.leetcode.tcsdigital.appliance;

import java.util.*;
import java.util.stream.Collectors;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Appliance[] appliances = new Appliance[4];

        for(int i=0; i<4; i++){
            int applianceId = sc.nextInt();
            sc.nextLine();
            String applianceName = sc.nextLine();
            String applianceCategory = sc.nextLine();
            double applianceAmount = sc.nextDouble();

            appliances[i] = new Appliance(applianceId, applianceName, applianceCategory, applianceAmount);
        }

        sc.nextLine();

        int applianceId = sc.nextInt();
        boolean insurance = sc.nextBoolean();
        sc.nextLine();
        String applianceCategory = sc.nextLine();

        double applianceAmount = getApplianceAmount(Arrays.asList(appliances), applianceId, insurance);
        System.out.println(applianceAmount);

        Appliance appl = getCostliestAppliance(Arrays.asList(appliances), applianceCategory);
        if(appl != null) {
            System.out.println(appl.getApplianceId());
            System.out.println(appl.getApplianceName());
            System.out.println(appl.getApplianceAmount());
        } else {
            System.out.println("NULL");
        }
    }

    private static double getApplianceAmount(List<Appliance> appliances, int applianceId, boolean insurance){
        return appliances
                .stream()
                .filter(a -> (a.getApplianceId() == applianceId) && insurance)
                .map(a -> a.getApplianceAmount() + ((a.getApplianceAmount()*20)/100))
                .collect(Collectors.averagingDouble(a -> a));
    }

    private static Appliance getCostliestAppliance(List<Appliance> appliances, String applianceCategory){
        return appliances.stream()
                .filter(a -> a.getApplianceCategory().equalsIgnoreCase(applianceCategory))
                .sorted(Comparator.comparingDouble(Appliance::getApplianceAmount).reversed())
                .collect(Collectors.toList()).get(0);
    }

}

class Appliance{
    private int applianceId;
    private String applianceName;
    private String applianceCategory;
    private double applianceAmount;
    private boolean insurance;
    Appliance(int applianceId, String applianceName, String applianceCategory, double applianceAmount) {
        this.applianceId = applianceId;
        this.applianceName = applianceName;
        this.applianceCategory = applianceCategory;
        this.applianceAmount = applianceAmount;
    }
    int getApplianceId() { return applianceId; }
    String getApplianceName() { return applianceName; }
    String getApplianceCategory() { return applianceCategory; }
    public boolean isInsurance() { return insurance; }
    double getApplianceAmount() { return applianceAmount; }
}
