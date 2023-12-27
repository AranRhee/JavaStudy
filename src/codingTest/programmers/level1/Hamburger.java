package codingTest.programmers.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Hamburger {
    public int solution(int[] ingredient) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        for (int i : ingredient) {
            sb.append(i);
        }

        while (sb.indexOf("1231") != -1) {
            int index = sb.indexOf("1231");
            sb.delete(index, index + 4);
            answer++;
        }

        return answer;

    }

    public int solution2(int[] ingredient) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i : ingredient) {
            sb.append(i);
            index = sb.indexOf("1231");
        }

        while (sb.indexOf("1231") >= 0) {
            sb.delete(index, index + 4);
            answer++;
            index = sb.indexOf("1231");
        }


        return answer;

    }


    public static void main(String[] args) {
        Hamburger ham = new Hamburger();
        int[] testCase = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int result = ham.solution2(testCase);
        System.out.println(result);

    }
}

