package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {

    static Map<String,Boolean> map = new HashMap<>();
    static List<File> fileList = new ArrayList<>();

    public static void main(String[] args) {
        List<File> fileList = getFileList("/Users/arun/Desktop/interview");
        for(File f : fileList){
            String sha1 = computeShah1(f);
            if(!isDuplicate(sha1)){
                map.put(sha1,true);
            }else {
                System.out.println(f.getName()+" is a duplicate file");
            }
        }
    }

    public static String computeShah1(File file){
        byte[] buffer = new byte[10000];
        MessageDigest md = null;
        FileInputStream fileInputStream;
        int n = 0;
        try {
            md = MessageDigest.getInstance("SHA-1");
            fileInputStream = new FileInputStream(file);
            while (n != -1){
                n = fileInputStream.read(buffer);
                if (n > 0) {
                    md.update(buffer);
                }
            }

        }catch (NoSuchAlgorithmException|IOException e){
            System.out.println(e);
        }

        //Copying to digest to create foreign copy
        byte[] digest = new byte[md.getDigestLength()];
        int i = 0;
        for(byte b :md.digest()){
            digest[i] = b;
            i++;
        }

        if(md.digest()!=null){
            return Arrays.toString(digest);
        }else{
            return null;
        }

    }


    public static List<File>getFileList(String directoryPath){
        File[] files = new File(directoryPath).listFiles();
        for (File f : files){
            if (f.isFile()){
                fileList.add(f);
            }else if(f.isDirectory()){
                getFileList(f.getAbsolutePath());
            }
        }
        return fileList;
    }


/*
    public static String convertBytesToString(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
*/

    public static boolean isDuplicate(String str){
        if(map.get(str) !=null){
            return true;
        }else {
            return false;
        }
    }
}