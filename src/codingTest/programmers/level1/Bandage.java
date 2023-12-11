package codingTest.programmers.level1;

import java.util.*;

public class Bandage {
    // 붕대감기
    // T초동안 붕대를 감으면서 1초마다 x의 체력 회복
    // t초 연속으로 붕대를 감는데 성공한다면 Y의 추가 체력 회복
    // 최대체력 이상으로 체력 회복 불가

    // 몬스터에게 공격당할 시 기술취소, 체력 회복 불가
    // 기술 취소 혹은 종료 시 붕대감기 다시 실행. 연속 실행 시간 0으로 초기화됨

    // 몬스터 공격을 받으면 정해진 피해량만큼 체력 감소
    // 체력이 0 이하가 되면 사망

    // int[] bandage // 붕대감기 기술 시전시간, 초당 회복량, 추가 회복량
    // int health // 최대 체력
    // int[][] attacks // 믄스터의 공격 시간, 피해량
    // 남은 체력 return , 죽으면 -1 return
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = attacks[attacks.length - 1][0];
        int remainHealth = health;
        int successCount = 0;
        int skillTime = bandage[0];

        List<Integer> attackTime = new ArrayList<Integer>();
        for (int i = 0; i < attacks.length; i++) {
            attackTime.add(attacks[i][0]);
        }

        for (int i = 1; i <= time; i++) {
            if (attackTime.contains(i)) {
                remainHealth -= getDamage(i, attacks);
                successCount = 0;
            } else {
                remainHealth = (remainHealth + bandage[1] > health) ? health : remainHealth + bandage[1];
                successCount++;
                if (successCount == bandage[0]) {
                    remainHealth += bandage[2];
                    successCount = 0;
                }
            }
            if (remainHealth <= 0) break;
            System.out.println(remainHealth);
        }

        return remainHealth > 0 ? remainHealth : -1;
    }

    public int getDamage(int now, int[][] attacks) {
        int damage = 0;
        for (int[] attack : attacks) {
            if (now == attack[0]) {
                damage = attack[1];
            }
        }
        return damage;
    }
}
