package codingTest.programmers.level1;

import java.util.*;

// 크레인 인형뽑기 게임
// 13점
// 깊은복사 얕은복사 제발 헷갈리지 말기
// break문 적절하게 사용하기
class DollCraneMachine {
    public static int solution(int[][] board, int[] moves) {
        List<int[]> pivotBoard = new ArrayList<>();
        List<Integer> basket = new ArrayList<>();
        int count = 0;
        // 주어진 배열 피벗
        for (int i = 0; i < board.length; i++) {
            int[] temp = new int[board.length]; // 또 얕은복사됨 병신이냐 하..
            for (int j = 0; j < board.length; j++) {
                temp[j] = board[j][i];
            }
            pivotBoard.add(temp);
        }

        // 인형 뽑기
        for (int move : moves) {
            int[] pickTarget = pivotBoard.get(move - 1);
            for (int i = 0; i < pickTarget.length; i++) {
                if (pickTarget[i] != 0) {
                    // 인형 겹치는지 확인
                    if (checkDollSame(basket, pickTarget[i])) {
                        basket.remove(basket.size() - 1);
                        count = count + 2;
                    } else {
                        basket.add(pickTarget[i]);

                    }
                    pickTarget[i] = 0;
                    break;// 이부분 누락됨

                }

            }

        }

        return count;


    }

    public static boolean checkDollSame(List<Integer> basket, int doll) {
        if (basket.isEmpty()) return false;
        return (basket.get(basket.size() - 1) == doll);
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int num = DollCraneMachine.solution(board, moves);
        System.out.println(num);
    }
}