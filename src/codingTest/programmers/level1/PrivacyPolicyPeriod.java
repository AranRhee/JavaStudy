package codingTest.programmers.level1;

import java.time.LocalDate;
import java.util.*;

// 개인정보 수집 유효기간
// 13점
// LocalDate 사용법 외우기..
public class PrivacyPolicyPeriod {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        LocalDate todayDate = LocalDate.parse(today.replace(".","-"));

        Map<String, Integer> termsMap = new HashMap<>();
        for(String term: terms){
            String[] termArr = term.split(" ");
            termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }

        List<Integer> answerList = new ArrayList<>();

        int idx = 1;
        for (String privacy : privacies) {
            String[] privacyArr = privacy.split(" ");
            boolean isDay1 = (privacyArr[0].substring(privacyArr.length-2)).equals("01");
            LocalDate privacyDate = LocalDate.parse(privacyArr[0].replace(".","-"));
            LocalDate checkDate = (isDay1)? privacyDate.plusMonths(termsMap.get(privacyArr[1]) - 1).withDayOfMonth(28): privacyDate.plusMonths(termsMap.get(privacyArr[1])).minusDays(1);
            if (todayDate.isAfter(checkDate)) {
                answerList.add(idx);
            }
            idx++;
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args){
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] policies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] result = PrivacyPolicyPeriod.solution("2022.05.19", terms, policies);
        System.out.println(Arrays.toString(result));
    }
}
