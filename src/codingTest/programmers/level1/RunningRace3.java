package codingTest.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class RunningRace3 {
    public String[] solution(String[] players, String[] callings) {
        int idx = 0;
        String tmp = null;
        String[] answer = new String[players.length];

        Map<String, Integer> userMap = new HashMap<>();
        for(int i=0; i<players.length; i++){
            userMap.put(players[i],i);
        }

        for (String calling : callings) {
            idx = userMap.get(calling) - 1;
            userMap.put(calling, idx);
            userMap.put(getName(userMap, idx+1), idx+1);
        }

        for(String key : userMap.keySet()){
           answer[userMap.get(key)] = key;
        }

        return answer;
    }

    public String getName(Map<String, Integer> userMap, int idx){
        String name = null;
        for(String key : userMap.keySet()){
            if(userMap.get(key) == idx) {
                name = key;
            }
        }
        return name;
    }
}
