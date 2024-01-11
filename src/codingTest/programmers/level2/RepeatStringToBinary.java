package codingTest.programmers.level2;

// 이진 변환 반복하기
// 1점;;
// Integer.toBinaryString, Integer.toOctalString, Integer.toHexString (2,8,16진수 변환)
class RepeatStringToBinary {
    public int[] solution(String s) {
        int retVal = 0;
        int zeroTotal = 0;
        int zeroCount = 0;
        int oneCount = 0;

        while(!s.equals("1")){
            zeroCount = checkZeroCount(s);
            zeroTotal += zeroCount;
            oneCount = s.length() - zeroCount;
            s = Integer.toBinaryString(oneCount);
            retVal++;
        }
        int[] answer = {retVal, zeroTotal};
        return answer;
    }

    public int checkZeroCount(String s){
        int retVal = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                retVal++;
            }
        }
        return retVal;
    }
}