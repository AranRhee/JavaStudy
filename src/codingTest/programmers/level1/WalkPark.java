package codingTest.programmers.level1;

public class WalkPark {
    // 공원 산책
    // 14점
    // 1. 공원 밖을 벗어나는것이 max 뿐만 아니라 0 미만인 경우도 체크했어야 함
    // 2. 진입로 S 가 무조건 첫줄에 있지 않을 수 있음... 이걸 놓침..
    public static int[] solution(String[] park, String[] routes) {
        String[] temp;
        int[] startLocation = getStartLocation(park);
        int[] location = startLocation;
        int xTemp = startLocation[0];
        int yTemp = startLocation[1];
        int xMax = park[0].length() - 1;
        int yMax = park.length - 1;

        for (String route : routes) {
            temp = route.split(" ");
            int move = Integer.parseInt(temp[1]);
            int yMove = 0;
            int xMove = 0;

            // 이동 도중에 장애물 여부, 공원 밖인지 체크
            for (int i = 1; i <= move; i++) {
                int[] moveCount = checkLocationToMove(temp[0]);
                if (checkLocationIsOut(new int[]{xTemp + moveCount[0] + xMove, yTemp + moveCount[1] + yMove}, xMax, yMax)
                        || checkBlocked(park, xTemp, yTemp, moveCount[0], moveCount[1], xMove, yMove)) {
                    break;
                } else {
                    xMove += moveCount[0];
                    yMove += moveCount[1];
                }
            }

            // 경로 전체 체크 해도 이상 없는 경우 최종 이동
            if (move == Math.abs(xMove) + Math.abs(yMove)) {
                location[0] = location[0] + xMove;
                location[1] = location[1] + yMove;
                xTemp = location[0];
                yTemp = location[1];
            }

        }

        return new int[]{location[1],location[0]};
    }

    public static int[] getStartLocation(String[] park){
        int x = 0;
        int y = 0;
        for(int i=0; i<park.length; i++){
            if(park[i].indexOf("S") != -1){
                y = i;
                x = park[i].indexOf("S");
            }
        }

        return new int[]{x,y};
    }

    public static boolean checkBlocked(String[] park, int x, int y, int xMove, int yMove, int xMoveHistory, int yMoveHistory){
        return Character.toString(park[y + yMove + yMoveHistory].charAt(x + xMove + xMoveHistory)).equals("X");
    }

    // 현재 상태가 공원 밖인지 체크
    public static boolean checkLocationIsOut(int[] status, int xMax, int yMax) {
        return (xMax < status[0]) || (yMax < status[1]) || (status[0] < 0) || (status[1] < 0);
    }

    // 방향에 따른 증감 리턴
    public static int[] checkLocationToMove(String direction) {
        int xMove = 0;
        int yMove = 0;
        if (direction.equals("N")) {
            yMove = -1;
        } else if (direction.equals("E")) {
            xMove = 1;
        } else if (direction.equals("W")) {
            xMove = -1;
        } else {
            yMove = 1;
        }
        return new int[]{xMove, yMove};
    }

    public static void main(String[] args) {
        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};
        int[] result = WalkPark.solution(park, routes);


    }


}
