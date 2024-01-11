package codingTest.programmers.level1;

import java.util.*;

public class GymSuit {
    // 체육복

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> reserveList = new ArrayList<Integer>();
        for (int i : reserve) {
            reserveList.add(i);
        }


        for (int i : lost) {

            if (reserveList.contains(i - 1)) {
                reserveList.remove(Integer.valueOf(i - 1));
            } else if (reserveList.contains(i + 1)) {
                reserveList.remove(Integer.valueOf(i + 1));
            } else if (reserveList.contains(i)) {
                reserveList.remove(Integer.valueOf(i));
            } else {
                answer--;
            }
        }


        return answer;
    }

    public static void main(String[] args){
        GymSuit gs = new GymSuit();
        int[] lost = {4,5};
        int[] reserve = {3,4};
        gs.solution(5, lost, reserve);
    }
}
