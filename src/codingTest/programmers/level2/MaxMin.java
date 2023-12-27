package codingTest.programmers.level2;

import java.util.*;
// 최댓값과 최솟값
// 2점
class MaxMin {
    public String solution(String s) {

        List<Integer> numList = new ArrayList<>();
        String[] sArr = s.split(" ");
        for(String num : sArr){
            numList.add(Integer.valueOf(num));
        }

        Collections.sort(numList);
        String answer = numList.get(0).toString() + " " + numList.get(numList.size()-1).toString();
        return answer;
    }
}
