package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Double yourXLocation = Double.parseDouble(args[0]);
        Double yourYLocation = Double.parseDouble(args[1]);
        String fileName = args[2];
        Comparator<Shop> comp = new Shop();
        PriorityQueue<Shop> shopQueue = new PriorityQueue<>(8,comp);
        if (populateDataStructure(shopQueue,fileName,yourXLocation,yourYLocation)) {
            int numShop = 3; //we need top 3 shops
            getNearByCoffeeShop(shopQueue,numShop);
        }else {
            System.out.println("Coffee Shop Not Available");
        }

    }
    private static boolean populateDataStructure(PriorityQueue<Shop> shopQueue, String fileName,
                                                Double yourXLocation, Double yourYLocation){

        FileReader fir = null;

        try {
            fir = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(fir);
            return populateQueue(buffer,shopQueue,yourXLocation,yourYLocation);
        } catch (IOException e){
            e.printStackTrace();
            return false;
        } finally {
            try{
                if (fir!=null) {
                    fir.close();
                }
            } catch (IOException|NullPointerException e){
                e.printStackTrace();
            }
        }
    }

    private static boolean populateQueue(BufferedReader buffer,PriorityQueue<Shop> shopQueue,
                                         Double yourXLocation, Double yourYLocation){

        String nextLine;

        try {
            while ((nextLine = buffer.readLine()) != null){

                String arr[] = nextLine.split(",");
                String name = arr[0];
                Double XLocation = Double.parseDouble(arr[1]);
                Double YLocation = Double.parseDouble(arr[2]);
                Shop shop = new Shop(name,XLocation,YLocation);
                shop.setDistance(yourXLocation,yourYLocation);
                shopQueue.add(shop);
            }
            return true;

        }catch (IOException | NumberFormatException ex){
            ex.printStackTrace();
            return false;
        }

    }

    private static void getNearByCoffeeShop(PriorityQueue<Shop> shopQueue, int numShop){
        int counter = 0;
        while ((!shopQueue.isEmpty())&&(counter<numShop)){
            System.out.println(shopQueue.poll().toString());
            counter++;
        }
    }


}
