package codingTest.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class UnCompletedPlayer {
    // 완주하지 못한 선수

    // 에러 케이스. 동명이인까지 싹 지워버림
//    public String solution(String[] participant, String[] completion) {
//        List<String> participantList = Arrays.asList(participant);
//        List<String> completionList = Arrays.asList(completion);
//        participantList.removeAll(completionList);
//        return participantList.get(0);
//    }

    public String solution(String[] participants, String[] completions){
        Map<String, Integer> participantsMap = new HashMap<>();
        String retVal = null;
        for(String participant : participants){
            participantsMap.put(participant,
                    participantsMap.getOrDefault(participant, 0) + 1);
        }

        for(String completion : completions){
            if(participantsMap.get(completion) == 1){
                participantsMap.remove(completion);
            } else if(participantsMap.get(completion) > 1){
                participantsMap.put(completion, participantsMap.get(completion) - 1);
            }
        }

        for(String user : participantsMap.keySet()){
            retVal  = user;
        }

        return retVal;


    }
}
