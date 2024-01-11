package codingTest.programmers.level1;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        int decimalNumber = 4; // 변경하려는 10진수 숫자

        String binaryString = convertToBinary(decimalNumber);

        System.out.println("Binary representation: " + binaryString);
    }

    private static String convertToBinary(int decimalNumber) {
        StringBuilder binary = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binary.insert(0, remainder); // 나머지를 문자열의 맨 앞에 삽입
            decimalNumber = decimalNumber / 2;
        }

        // 만약 결과가 빈 문자열이라면 입력된 숫자가 0이었음을 의미
        if (binary.length() == 0) {
            binary.append("0");
        }

        return binary.toString();
    }
}
