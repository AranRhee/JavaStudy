package codingTest.programmers.level1;


import java.util.*;

class UncompletedRaceUser {
    public String solution(String[] participants, String[] completions){
        Map<String, Integer> participantsMap = new HashMap<>();
        String retVal = null;
        String num = "1";
        for(String participant : participants){
            participantsMap.put(participant, participantsMap.getOrDefault(participant, 0) + 1);
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

    public boolean checkNeedDelete(String s){
        boolean retVal = false;
        String name = "aran";
        if(Character.isDigit(s.charAt(0))){
            retVal = false;
        } else {
            if(s.equals("-")
                    || s.equals("_")
                    || s.equals(".")
                    || (s.charAt(0) >= 'a' && s.charAt(0) <= 'z')){
                retVal = false;
            } else {
                retVal = true;
            }
        }

        return retVal;

    }
}