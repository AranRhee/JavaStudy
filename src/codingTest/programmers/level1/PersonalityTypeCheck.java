package codingTest.programmers.level1;

import java.util.*;

// 성격 유형 검사하기
// 7점..

class PersonalityTypeCheck {
    public String solution(String[] survey, int[] choices) {

        Map<String, Integer> surveyMap = new HashMap<>();

        surveyMap.put("R", 0);
        surveyMap.put("T", 0);
        surveyMap.put("C", 0);
        surveyMap.put("F", 0);
        surveyMap.put("J", 0);
        surveyMap.put("M", 0);
        surveyMap.put("A", 0);
        surveyMap.put("N", 0);



        for(int i=0; i<choices.length; i++){
            if(choices[i] == 4) continue;
            String[] surveyDetail = survey[i].split("");
            String surveyTitle = 4 - choices[i] > 0 ? surveyDetail[0] : surveyDetail[1];
            surveyMap.put(surveyTitle, surveyMap.getOrDefault(surveyTitle, 0) + Math.abs(4 - choices[i]));
        }

        return getType(surveyMap);



    }

    public String getType(Map<String, Integer> surveyMap){
        String answer = "";
            answer += surveyMap.get("R") == surveyMap.get("T") ? "R" : surveyMap.get("R") > surveyMap.get("T") ? "R" : "T";

            answer += surveyMap.get("C") == surveyMap.get("F") ? "C" : surveyMap.get("C") > surveyMap.get("F") ? "C" : "F";

            answer += surveyMap.get("J") == surveyMap.get("M") ? "J" : surveyMap.get("J") > surveyMap.get("M") ? "J" : "M";

            answer += surveyMap.get("A") == surveyMap.get("N") ? "A" : surveyMap.get("A") > surveyMap.get("N") ? "A" : "N";


        return answer;
    }
}