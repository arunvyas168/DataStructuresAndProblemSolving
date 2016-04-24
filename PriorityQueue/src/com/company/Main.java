package com.company;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Comparator<Integer> comp = new ReverseSort();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(2,comp);
        pq.add(44);
        pq.add(8);
        pq.add(6);
        pq.add(75);
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }
        System.out.println("############### 2nd example ###############");
        PriorityQueue<Player> playerQueue = new PriorityQueue<Player>(3, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.getScore() < o2.getScore())
                {
                    return -1;
                }
                if (o1.getScore() > o2.getScore())
                {
                    return 1;
                }
                return 0;
            }
        });

        playerQueue.add(new Player("Arun",100.00));
        playerQueue.add(new Player("Shal",105.00));
        playerQueue.add(new Player("amma",99.00));
        playerQueue.add(new Player("appa",103.00));
        playerQueue.add(new Player("golu",104.00));
        Iterator<Player> it = playerQueue.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }


    }

}
