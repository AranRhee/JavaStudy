package aran;

public class NearestLetter {
    // 6점, 24분 소요
    public int[] solution(String s) {
        char[] sArr = s.toCharArray();
        int[] retArr = new int[s.length()];
        int checkCount = 0;
        for (int i = 0; i < sArr.length; i++) {
            checkCount = 0;
            if (i == 0) {
                retArr[i] = -1;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (sArr[j] == sArr[i]) {
                    checkCount++;
                    retArr[i] = i - j;
                    break;
                }
            }
            if (checkCount == 0) retArr[i] = -1;
        }
        return retArr;
    }
}
