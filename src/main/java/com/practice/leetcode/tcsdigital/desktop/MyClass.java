package com.practice.leetcode.tcsdigital.desktop;

import java.util.*;
import java.util.stream.Collectors;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Desktop> desktops = new ArrayList<>();

        for(int i=0; i<4; i++){
            int desktopId = sc.nextInt();
            sc.nextLine();
            String desktopName = sc.nextLine();
            String osType = sc.nextLine();
            double price = sc.nextDouble();

            desktops.add(new Desktop(desktopId, desktopName, osType, price));
        }

        sc.nextLine();

        String brandName = sc.nextLine();
        String osType = sc.nextLine();

        double avg = findAveragePriceByBrand(desktops, brandName);
        if(avg == 0)
            System.out.println("The given brand is not available");
        else
            System.out.println((int)avg);

        List<Desktop> desktopList = searchDesktopByOs(desktops, osType);
        if(desktopList.size() == 0) {
            System.out.println("The given os is not available");
        } else {
            for(int i=0; i<desktopList.size()-1; i++){
                System.out.println(desktopList.get(i).getDesktopId());
                System.out.println(desktopList.get(i).getBrandName());
                System.out.println(desktopList.get(i).getPrice());
            }
            System.out.println(desktopList.get(desktopList.size()-1).getDesktopId());
            System.out.println(desktopList.get(desktopList.size()-1).getBrandName());
            System.out.println(desktopList.get(desktopList.size()-1).getPrice());
        }
    }

    private static double findAveragePriceByBrand(List<Desktop> desktops, String brandName){
        return desktops.stream()
                .filter(d -> (d.getBrandName().equalsIgnoreCase(brandName)))
                .collect(Collectors.averagingDouble(Desktop::getPrice));
    }

    private static List<Desktop> searchDesktopByOs(List<Desktop> desktops, String osType){
        return desktops.stream()
                .filter(d -> d.getOsType().equalsIgnoreCase(osType))
                .sorted(Comparator.comparingInt(Desktop::getDesktopId).reversed())
                .collect(Collectors.toList());
    }

}
class Desktop {
    private int desktopId;
    private String brandName;
    private String osType;
    private double price;

    Desktop(int desktopId, String brandName, String osType, double price) {
        this.desktopId = desktopId;
        this.brandName = brandName;
        this.osType = osType;
        this.price = price;
    }

    int getDesktopId() { return desktopId; }
    String getBrandName() { return brandName; }
    String getOsType() { return osType; }
    double getPrice() { return price; }
}

