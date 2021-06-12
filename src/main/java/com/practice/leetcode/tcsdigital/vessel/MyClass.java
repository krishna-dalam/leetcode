package com.practice.leetcode.tcsdigital.vessel;

import java.util.*;
import java.util.stream.Collectors;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vessel> desktops = new ArrayList<>();

        for(int i=0; i<4; i++){
            int vesselId = sc.nextInt();
            sc.nextLine();
            String vesselBrand = sc.nextLine();
            int capacity = sc.nextInt();
            sc.nextLine();
            String material = sc.nextLine();
            double price = sc.nextDouble();

            desktops.add(new Vessel(vesselId, vesselBrand, capacity, material, price));
        }

        sc.nextLine();

        String material = sc.nextLine();
        String brand = sc.nextLine();

        double avg = getAvgPriceBasedOnMaterial(desktops, material);
        if(avg == 0)
            System.out.println("There is no matching vessels");
        else{
            System.out.println((int)avg);
            System.out.println(material);
        }


        List<Vessel> desktopList = getVesselBySecondHighestPrice(desktops, brand);
        if(desktopList.size() < 2) {
            System.out.println("Vessels are not available for the given brand");
        } else {
            System.out.println(desktopList.get(1).getVesselId());
        }
    }

    private static double getAvgPriceBasedOnMaterial(List<Vessel> vessels, String material){
        return vessels.stream()
                .filter(v -> (v.getMaterial().equalsIgnoreCase(material)))
                .collect(Collectors.averagingDouble(Vessel::getPrice));
    }

    private static List<Vessel> getVesselBySecondHighestPrice(List<Vessel> vessels, String brand){
        return vessels.stream()
                .filter(v -> v.getVesselBrand().equalsIgnoreCase(brand))
                .sorted(Comparator.comparingDouble(Vessel::getPrice).reversed())
                .collect(Collectors.toList());
    }

}

class Vessel {
    private int vesselId;
    private String vesselBrand;
    private int capacity;
    private String material;
    private double price;

    Vessel(int vesselId, String vesselBrand, int capacity, String material, double price) {
        this.vesselId = vesselId;
        this.vesselBrand = vesselBrand;
        this.capacity = capacity;
        this.material = material;
        this.price = price;
    }

    int getVesselId() { return vesselId; }
    String getVesselBrand() { return vesselBrand; }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    String getMaterial() { return material; }
    double getPrice() { return price; }
}


