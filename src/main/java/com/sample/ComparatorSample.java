package com.sample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
--input--
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150

--output--
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
*/

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o2.score == o1.score) {
            return o1.name.compareTo(o2.name);
        } else {
            return o2.score > o1.score ? 1 : -1;
        }
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class ComparatorSample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

}
