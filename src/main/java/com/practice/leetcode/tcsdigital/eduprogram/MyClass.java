package com.practice.leetcode.tcsdigital.eduprogram;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MyClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<EduProgram> eduProgramsInp = new ArrayList<>();
        for(int i=0; i<4; i++){
            String eduProgramName = sc.nextLine();
            String sponsor = sc.nextLine();
            int noOfPeopleAttended = Integer.parseInt(sc.nextLine());
            boolean stillAvailable = Boolean.parseBoolean(sc.nextLine());
            boolean withinCountry = Boolean.parseBoolean(sc.nextLine());
            eduProgramsInp.add(new EduProgram(eduProgramName, sponsor, noOfPeopleAttended, stillAvailable, withinCountry));
        }
        String sponsorName = sc.next();

        System.out.println(findEduProgramByClassification(eduProgramsInp));

        List<EduProgram> eduProgramsOut = findEduProgramBySponsor(eduProgramsInp, sponsorName);

        if(eduProgramsOut.isEmpty())
            System.out.println("No EduProgram is available for given sponsor");
        else {
            for (int i = 0; i < eduProgramsOut.size() - 1; i++) {
                System.out.println(eduProgramsOut.get(i).getEduProgramName());
                System.out.println(eduProgramsOut.get(i).getNoOfPeopleAttended());
            }
            System.out.println(eduProgramsOut.get(eduProgramsOut.size()-1).getEduProgramName());
            System.out.print(eduProgramsOut.get(eduProgramsOut.size()-1).getNoOfPeopleAttended());
        }

    }

    private static String findEduProgramByClassification(List<EduProgram> eduProgramsInp){
        String result = "EduPrograms are not available now";
        for(int i=0; i<eduProgramsInp.size()-1; i++){
            EduProgram eduProgram = eduProgramsInp.get(i);
            if(eduProgram.isStillAvailable() && eduProgram.isWithinCountry()){
                int noOfPPlAttended = eduProgram.getNoOfPeopleAttended();
                if(noOfPPlAttended >=1000)
                    return "EverGreen";
                if(noOfPPlAttended >= 500)
                    return "Golden";
                return "Emerging Star";
            }
        }
        return result;
    }
    private static List<EduProgram> findEduProgramBySponsor(List<EduProgram> eduPrograms, String sponserName){
        return eduPrograms.stream()
                .filter(ep -> ep.getSponsor().equalsIgnoreCase(sponserName))
                .sorted(Comparator.comparing(EduProgram::getNoOfPeopleAttended))
                .collect(Collectors.toList());
    }
}
