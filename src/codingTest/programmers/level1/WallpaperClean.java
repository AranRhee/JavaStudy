package codingTest.programmers.level1;

import java.util.*;

public class WallpaperClean {
    // 바탕화면 정리
    // 5점...?
    public int[] solution(String[] wallpaper) {
        // 목표 : 상하좌우 max값의 범위를 리턴해줄 것
        int[] answer = new int[4];

        // 파일 위치 가져오기
        List<int[]> fileLocationList = new ArrayList<>();
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                for (int j = 0; j < wallpaper[i].length(); j++) {
                    if ("#".equals(String.valueOf(wallpaper[i].charAt(j)))) fileLocationList.add(new int[]{i, j});
                }
            }
        }

        // 임시 초기값 세팅
        int xMin = fileLocationList.get(0)[0]; // 가장 좌측 x
        int yMin = fileLocationList.get(0)[1]; // 가장 상단 y
        int xMax = fileLocationList.get(0)[0]; // 가장 우측 x
        int yMax = fileLocationList.get(0)[1]; // 가장 하단 y

        // 아이콘 위치 리스트에서 상하좌우 max 값 범위 리턴하기
        for (int[] location : fileLocationList) {
            if (xMin > location[0]) xMin = location[0];
            if (xMax < location[0]) xMax = location[0];
            if (yMin > location[1]) yMin = location[1];
            if (yMax < location[1]) yMax = location[1];
        }
        answer[0] = xMin;
        answer[1] = yMin;
        answer[2] = xMax + 1;
        answer[3] = yMax + 1;

        return answer;
    }
}
