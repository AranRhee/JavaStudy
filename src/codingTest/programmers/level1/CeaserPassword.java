package codingTest.programmers.level1;

public class CeaserPassword {
    // 시저 암호
    // 9점
    // char to int, int to char 형변환 가능
    // 대문자 A Z -> 65, 90 / 소문자 a z -> 97, 122
    public String solution(String s, int n) {
        char[] charS = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char letter : charS){
            int letterCode = (int)letter;
            if(letterCode >= 65  && letterCode <= 90){
                int temp = ((letterCode + n) > 90) ? letterCode + n - 26 : letterCode + n;
                sb.append((char)temp);
            }else if(letterCode >= 97 && letterCode <= 122){
                int temp = ((letterCode + n) > 122) ? letterCode + n - 26 : letterCode + n;
                sb.append((char)temp);
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
