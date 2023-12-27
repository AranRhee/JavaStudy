package codingTest.programmers.level2;

// JadenCase 문자열 만들기
// 14점

class JadenCase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(i==0) {
                sb.append(s.substring(0,1).toUpperCase());
            } else {
                if(String.valueOf(s.charAt(i-1)).equals(" ")){
                   sb.append(s.substring(i,i+1).toUpperCase());
                } else {
                    sb.append(s.substring(i,i+1).toLowerCase());
                }
            }
        }


        return sb.toString();
    }
}