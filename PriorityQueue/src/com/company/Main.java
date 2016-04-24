package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Comparator<Double> comp = new ReverseSort();
        PriorityQueue<Double> pq = new PriorityQueue<Double>(2,comp);
        pq.add(.0861);
        pq.add(10.0793);
        pq.add(85.1957);
        pq.add(.0645);
        pq.add(82.9224);
        pq.add(31.9107);
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }
        System.out.println("############### 2nd example ###############");
        PriorityQueue<Player> playerQueue = new PriorityQueue<Player>(3, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
               return o1.getScore().compareTo(o2.getScore());
            }
        });

        playerQueue.add(new Player("Arun",100.00));
        playerQueue.add(new Player("Shal",105.00));
        playerQueue.add(new Player("amma",99.00));
        playerQueue.add(new Player("appa",103.00));
        playerQueue.add(new Player("golu",104.00));
        /*Iterator<Player> it = playerQueue.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }*/

        Object last;
        while ((last = playerQueue.poll()) != null) {
            System.out.println(last);
        }
        System.out.println(playerQueue.size());

    }

}
