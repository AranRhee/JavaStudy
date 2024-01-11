package codingTest.programmers.level1;


import java.util.HashMap;
import java.util.*;

// 키패드 누르기
// 8점

class Keypad {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> status = new HashMap<>();
        String handLetter = hand.equals("right")? "R" : "L";

        status.put("L", "*");
        status.put("R", "#");

        String getFinger = null;

        for(int num : numbers){
            getFinger = getFinger(num, status.get("L"), status.get("R"), handLetter);
            status.put(getFinger, String.valueOf(num));
            sb.append(getFinger);
        }

        return sb.toString();
    }

    public String getFinger(int number, String leftStatus, String rightStatus, String hand){
        String retVal = null;
        if(number == 1 || number == 4 || number == 7){
            retVal = "L";
        } else if (number == 3 || number == 6 || number == 9){
            retVal = "R";
        } else {
            int[] leftStatusArr = getCurrentStatus(String.valueOf(leftStatus));
            int[] rightStatusArr = getCurrentStatus(String.valueOf(rightStatus));
            int[] togoStatusArr = getCurrentStatus(String.valueOf(number));
            int leftDistance = getDistance(togoStatusArr, leftStatusArr);
            int rightDisatance = getDistance(togoStatusArr, rightStatusArr);

            if(leftDistance == rightDisatance){
                retVal = hand;
            } else if(leftDistance < rightDisatance){
                retVal =  "L";
            } else {
                retVal =  "R";
            }
        }
        return retVal;
    }

    public int[] getCurrentStatus(String number){
        int[] answer = new int[2];
        if(number.equals("*")){
            answer[0] = 0;
            answer[1] = 3;
        } else if(number.equals("#")){
            answer[0] = 2;
            answer[1] = 3;
        } else if(number.equals("0")){
            answer[0] = 1;
            answer[1] = 3;
        } else {
            answer[0] = ((Integer.parseInt(number) + 2) % 3);
            answer[1] = ((Integer.parseInt(number) - 1) / 3);
        }

        return answer;
    }

    public int getDistance(int[] current, int[] toGo){
        return Math.abs(toGo[0] - current[0]) + Math.abs(toGo[1] - current[1]);

    }

    public static void main(String[] args){
        Keypad kp = new Keypad();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String retVal = kp.solution(numbers, hand);
        System.out.println(retVal);
    }
}