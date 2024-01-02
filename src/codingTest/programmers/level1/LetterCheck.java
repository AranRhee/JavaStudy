package codingTest.programmers.level1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LetterCheck {
    public String solution(String new_id) {
        // 1단계
        String answer = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();

        // 2단계
        List<String> answerArr = new ArrayList<String>(Arrays.asList(answer.split("")));
        for(int i=0; i<answerArr.size(); i++){
            if(checkNeedDelete(answerArr.get(i))){
                answerArr.remove(i);
            } else {
                sb.append(answerArr.get(i));
            }
        }

        // 3단계
        answer = trimPunctuation(sb.toString());

        // 4단계
        if(answer.startsWith(".")) {
            answer = answer.substring(1);
        }

        if(answer.endsWith(".")){
            answer = answer.substring(0, answer.length() -1);
        }

        // 5단계
        if(answer.length() == 0) answer = "a";

        // 6단계
        if(answer.length() >= 16){
            answer = answer.substring(0,15);
        }
        // 7단계
        while(answer.length() <= 2){
            answer += answer.charAt(answer.length() -1);
        }
        return answer;
    }

    public boolean checkNeedDelete(String s){
        boolean retVal = false;
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

    String trimPunctuation(String letters){
        String pattern = "\\.{2,}";
        String replacement = "\\.";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(letters);
        return m.replaceAll(replacement);
    }
}