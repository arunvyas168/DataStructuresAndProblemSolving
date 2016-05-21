package com.company;

public class Main {

    public static void main(String[] args) {
        Users user1 = new Users.Builder("arunvyas","arunvyas27@gmail.com").build();
        System.out.println(user1.toString());
        Users user2 = new Users.Builder("shal", "sridhar.shalini").firstName("Shalini").sex("F").build();
        System.out.println(user2.toString());

    }
}
