package aran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class RunningRace {
    public String[] solution(String[] players, String[] callings) {
        String tmp;
        for (String calling : callings) {
            for (int j = 1; j < players.length; j++) {
                if (calling.equals(players[j])) {
                    tmp = players[j-1];
                    players[j - 1] = players[j];
                    players[j] = tmp;
                }
            }
        }

        return players;
    }
}
