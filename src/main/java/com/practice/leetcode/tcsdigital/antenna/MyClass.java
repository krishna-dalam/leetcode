package com.practice.leetcode.tcsdigital.antenna;

import java.util.*;
import java.util.stream.Collectors;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Antenna> antennas = new ArrayList<>();

        for(int i=0; i<4; i++){
            int antennaId = sc.nextInt();
            sc.nextLine();
            String antennaName = sc.nextLine();
            String projectLead = sc.nextLine();
            double antennaVSWR = sc.nextDouble();

            antennas.add(new Antenna(antennaId, antennaName, projectLead, antennaVSWR));
        }

        sc.nextLine();

        String antennaName = sc.nextLine();
        double vswr = sc.nextDouble();

        int antennaId = searchAntennaByName(antennas, antennaName);
        if(antennaId == 0)
            System.out.println("There is no Antenna with the given parameter.");
        else
            System.out.println(antennaId);

        List<Antenna> antennaList = sortAntennaByVswr(antennas, vswr);
        if(antennaList.size() == 0) {
            System.out.println("No Antenna found.");
        } else {
            for(int i=0; i<antennaList.size()-1; i++){
                System.out.println(antennaList.get(i).getAntennaProjectLead());
            }
            System.out.println(antennaList.get(antennaList.size()-1).getAntennaProjectLead());
        }
    }

    private static int searchAntennaByName(List<Antenna> antennas, String antennaName){
        List<Antenna> antennaList =  antennas.stream()
                .filter(a -> (a.getAntennaName().equalsIgnoreCase(antennaName)))
                .collect(Collectors.toList());
        if(antennaList.size() != 0)
            return antennaList.get(0).getAntennaId();
        return 0;
    }

    private static List<Antenna> sortAntennaByVswr(List<Antenna> antennas, double vswr){
        return antennas.stream()
                .filter(a -> a.getAntennaAntennaVSWR() < vswr)
                .sorted(Comparator.comparingDouble(Antenna::getAntennaAntennaVSWR))
                .collect(Collectors.toList());
    }

}

class Antenna{
    private int antennaId;
    private String antennaName;
    private String projectLead;
    private double antennaVSWR;
    Antenna(int antennaId, String antennaName, String projectLead, double antennaVSWR) {
        this.antennaId = antennaId;
        this.antennaName = antennaName;
        this.projectLead = projectLead;
        this.antennaVSWR = antennaVSWR;
    }
    int getAntennaId() { return antennaId; }
    String getAntennaName() { return antennaName; }
    String getAntennaProjectLead() { return projectLead; }
    double getAntennaAntennaVSWR() { return antennaVSWR; }
}

