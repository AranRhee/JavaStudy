package aran;
import java.util.*;
public class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int endIndex = 0;
        for(int i=0; i<commands.length; i++){
            //endIndex = commands[i].length;
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }
    public static void main(String[] args){
        KNumber knumber = new KNumber();
        int[] arr = {1,5,2,6,3,7,4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] test = knumber.solution(arr,commands);

    }
}
