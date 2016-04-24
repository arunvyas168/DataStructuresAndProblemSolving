package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fileName = "/Users/arun/Desktop/interview/coverletter.txt";
        //Read File using scanner:
        System.out.println("################## Scanner #################");
        ScannerRead(fileName);
        //Read File usng FileInputStream
        System.out.println("################## FileInputStream by character #################");
        FileInputStreamChar(fileName);
        System.out.println("################## FileInputStream by Byte #################");
        FileInputStreamByte(fileName);
        System.out.println("################## FileReader Example #################");
        FileReaderExample(fileName);
        System.out.println("################## FileReader with BufferedReader #################");
        FileReaderBufferedReader(fileName);


    }

    public static void ScannerRead(String fileName){
        File file = new File(fileName);
        Scanner scan  = null;
        try{
            scan = new Scanner(file);
            while (scan.hasNext()){
                String line = scan.next();
                System.out.println(line);
            }
        } catch (IOException e){
            System.out.println(e + ": Could not open file");
        } finally {
            if (scan!=null){
                scan.close();
            }
        }
    }

    public static void FileInputStreamChar(String fileName){

        FileInputStream fins = null;
        int NextLine;

        try{
            fins = new FileInputStream(fileName);
            while ((NextLine = fins.read()) != -1){
                System.out.println((char)NextLine);
            }

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (fins != null)
                    fins.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void FileInputStreamByte(String fileName){
        FileInputStream fins = null;
        char c;
        try {
            fins = new FileInputStream(fileName);
            byte[] b = new byte[fins.available()];
            fins.read(b);
            System.out.println(new String(b));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void FileReaderExample(String fileName){

        FileReader fir = null;
        int NextLine;

        try{
            fir = new FileReader(fileName);
            while ((NextLine = fir.read()) != -1){
                System.out.println((char)NextLine);
            }

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (fir != null)
                    fir.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void FileReaderBufferedReader(String fileName){

        FileReader fir = null;
        String nextLine = null;

        try{
            fir = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(fir);
            while ((nextLine = buffer.readLine()) != null){

                System.out.println(nextLine);
                /*String[] arr = NextLine.split(" ");
                for ( String ss : arr) {

                    System.out.println(ss);
                }*/
            }

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (fir != null)
                    fir.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
