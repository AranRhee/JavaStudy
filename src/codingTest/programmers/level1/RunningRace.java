package codingTest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class RunningRace {
    // 달리기 경주 : 시간 초과(68.8%)
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
