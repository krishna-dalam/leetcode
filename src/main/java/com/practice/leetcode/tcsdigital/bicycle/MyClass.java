package com.practice.leetcode.tcsdigital.bicycle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Bicycle {
    private String bicycleName, brand;
    private int cost;

    public Bicycle(String bicycleName, String brand, int cost, int ageGroup) {
        this.bicycleName = bicycleName;
        this.brand = brand;
        this.cost = cost;
        this.ageGroup = ageGroup;
    }

    public String getBicycleName() {
        return bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    private int ageGroup;
}
public class MyClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Bicycle> bicycles = new ArrayList<>();
        for(int i=0; i<4; i++){
            String bicycleName = sc.next();
            String brand = sc.next();
            int cost = sc.nextInt();
            int ageGroup = sc.nextInt();
            bicycles.add(new Bicycle(bicycleName, brand, cost, ageGroup));
        }
        String brand = sc.next();
        int age = sc.nextInt();

        List<Bicycle> bicycleList = findBicycleByAgeGroup(bicycles, age);
        if(bicycleList.isEmpty()){
            System.out.println("Bicycle is not available for the given Agegroup");
        }else {
            bicycleList.forEach( b -> System.out.println(b.getBicycleName()));
        }
        int sum = totalCostByBrand(bicycles, brand);
        System.out.print(sum > 0 ? sum : "No Bicycle is available for the given brand");
    }

    private static List<Bicycle> findBicycleByAgeGroup(List<Bicycle> bicycles, int age){
        return bicycles.stream()
                .filter(b -> b.getAgeGroup() <= age)
                .sorted(Comparator.comparing(Bicycle::getCost).reversed())
                .collect(Collectors.toList());
    }

    private static int totalCostByBrand(List<Bicycle> bicycles, String brand){
        return bicycles.stream().filter(b -> b.getBrand().equalsIgnoreCase(brand)).mapToInt(Bicycle::getCost).sum();
    }
}
