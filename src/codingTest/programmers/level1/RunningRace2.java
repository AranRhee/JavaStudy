package codingTest.programmers.level1;
import java.util.*;
class RunningRace2 {
    public String[] solution(String[] players, String[] callings) {
        int idx = 0;
        String tmp = null;
        for(int i=0; i<callings.length; i++){
            idx = getIndex(players, callings[i]);
            tmp = players[idx];
            players[idx] = players[idx-1];
            players[idx-1] = tmp;
        }
        return players;
    }

    public int getIndex(String[] players, String name) {
        int num = 0;
        List<String> playerList = Arrays.asList(players);
        return playerList.indexOf(name);
    }
}
