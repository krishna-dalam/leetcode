package com.practice.leetcode.codevita;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Codekart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<String, Integer> inventoryItemToCount = new HashMap<>();

        Map<String, Integer> inventoryItemToCost = new HashMap<>();

        Map<String, Integer> cartItemToCount = new HashMap<>();

        while(n>0){
            String input = scanner.next();

            if(input.toUpperCase().equals("END")){
                --n;
            }else if(input.toUpperCase().equals("CMD")) {

                try {
                    String role = scanner.next();

                    if (role.toUpperCase().equals("SM")) {

                        String type = scanner.next();
                        String item = scanner.next();
                        Integer quantity;
                        switch (type) {
                            case "ADD":
                                quantity = scanner.nextInt();
                                if (quantity < 1) {
                                    System.out.println(-1);
                                    continue;
                                }
                                inventoryItemToCount.put(item, quantity);
                                System.out.println(quantity);
                                break;
                            case "REMOVE":
                                if (inventoryItemToCount.get(item) == null)
                                    System.out.println(-1);
                                else {
                                    System.out.println(1);
                                    inventoryItemToCount.remove(item);
                                }
                                break;
                            case "INCR":
                                quantity = scanner.nextInt();
                                if (quantity < 1 || inventoryItemToCount.get(item) == null) {
                                    System.out.println(-1);
                                    continue;
                                }
                                inventoryItemToCount.put(item, inventoryItemToCount.get(item) + quantity);
                                System.out.println(quantity);
                                break;
                            case "DCR":
                                quantity = scanner.nextInt();

                                if (quantity < 1 || inventoryItemToCount.get(item) == null || (inventoryItemToCount.get(item) - quantity) < 1) {
                                    System.out.println(-1);
                                    continue;
                                }

                                inventoryItemToCount.put(item, inventoryItemToCount.get(item) - quantity);
                                System.out.println(quantity);
                                break;
                            case "SET_COST":
                                quantity = scanner.nextInt();

                                DecimalFormat df = new DecimalFormat("0.0");
                                inventoryItemToCost.put(item, quantity);
                                System.out.println(df.format(quantity));
                                break;
                            case "GET_QTY":
                                System.out.println(inventoryItemToCount.getOrDefault(item, 0));
                                break;
                        }
                    } else if (role.toUpperCase().equals("S")) {
                        String type = scanner.next();
                        if (type.equals("GET_ORDER_AMOUNT")) {
                            DecimalFormat df = new DecimalFormat("0.00");
                            int shoeCount = cartItemToCount.getOrDefault("SHOE", 0);
                            int shirtCount = cartItemToCount.getOrDefault("SHIRT", 0);
                            int shoeCost = inventoryItemToCost.get("SHOE");
                            int shirtCost = inventoryItemToCost.get("SHIRT");
                            Double sum = (double) (shoeCount * shoeCost + shirtCount * shirtCost);
                            System.out.print(df.format(sum));
                            continue;
                        }
                        String item = scanner.next();
                        Integer quantity;
                        switch (type) {
                            case "ADD":
                                quantity = scanner.nextInt();
                                if (quantity < 1) {
                                    System.out.println(-1);
                                    continue;
                                }
                                cartItemToCount.put(item, quantity);
                                System.out.println(quantity);
                                break;
                            case "REMOVE":
                                if (cartItemToCount.get(item) == null)
                                    System.out.println(-1);
                                else {
                                    System.out.println(1);
                                    cartItemToCount.remove(item);
                                }
                                break;
                            case "INCR":
                                quantity = scanner.nextInt();
                                if (quantity < 1 || cartItemToCount.get(item) == null) {
                                    System.out.println(-1);
                                    continue;
                                }
                                cartItemToCount.put(item, cartItemToCount.get(item) + quantity);
                                System.out.println(quantity);
                                break;
                            case "DCR":
                                quantity = scanner.nextInt();

                                if (quantity < 1 || cartItemToCount.get(item) == null || (cartItemToCount.get(item) - quantity) < 1) {
                                    System.out.println(-1);
                                    continue;
                                }

                                cartItemToCount.put(item, cartItemToCount.get(item) - quantity);
                                System.out.println(quantity);
                                break;
                        }
                    }
                }catch (Exception e){
                    System.out.println(-1);
                }
            }
        }
    }
}
