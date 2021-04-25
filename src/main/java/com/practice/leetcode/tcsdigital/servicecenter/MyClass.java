package com.practice.leetcode.tcsdigital.servicecenter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MyClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<ServiceCenter> serviceCentersInp = new ArrayList<>();
        for(int i=0; i<4; i++){
            String serviceCenterName = sc.nextLine();
            String branch = sc.nextLine();
            double amountCharged = Double.parseDouble(sc.nextLine());;
            boolean availableOnline = Boolean.parseBoolean(sc.nextLine());;
            serviceCentersInp.add(new ServiceCenter(serviceCenterName, branch, amountCharged, availableOnline));
        }
        String branchName = sc.next();

        double res1 = findAvgCostOnlineServiceCenter(serviceCentersInp);
        System.out.println(res1 == Double.parseDouble("0") ? "No center is available in online" : res1);

        List<ServiceCenter> serviceCentersOut  = findServiceCenters(serviceCentersInp, branchName);

        if(serviceCentersOut.isEmpty())
            System.out.println("No EduProgram is available for given sponsor");
        else {
            for (int i = 0; i < serviceCentersOut.size() - 1; i++) {
                System.out.println(serviceCentersOut.get(i).getServiceCenterName());
                System.out.println(serviceCentersOut.get(i).getAmountCharged());
            }
            System.out.println(serviceCentersOut.get(serviceCentersOut.size()-1).getServiceCenterName());
            System.out.print(serviceCentersOut.get(serviceCentersOut.size()-1).getAmountCharged());
        }
    }

    private static double findAvgCostOnlineServiceCenter(List<ServiceCenter> serviceCenters){
        return serviceCenters.stream()
                .filter(ServiceCenter::isAvailableOnline)
                .mapToDouble(ServiceCenter::getAmountCharged)
                .average()
                .getAsDouble();
    }

    private static List<ServiceCenter> findServiceCenters(List<ServiceCenter> serviceCenters, String branch){
        return serviceCenters.stream()
                .filter(sc -> sc.getBranch().toLowerCase().startsWith(branch.toLowerCase()))
                .sorted(Comparator.comparing(ServiceCenter::getAmountCharged).reversed())
                .collect(Collectors.toList());
    }
}
