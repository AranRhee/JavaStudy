package codingTest.programmers.level1;
 import java.util.*;

class Muji {
    public static int[] solution(String[] idList, String[] report, int k){
        int[] answer = new int[idList.length];
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        String[] dedupeReport = reportSet.toArray(new String[0]);
        String[] temp;
        Map<String, List<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportedMap = new HashMap<>();
        List<String> tempList = new ArrayList<>();
        int checkCount = 0;
        for (String string : idList) {
            for (String s : dedupeReport) {
                temp = s.split(" ");
                if (string.equals(temp[0])) {
                    tempList.add(temp[1]);
                } else if (string.equals(temp[1])) {
                    checkCount++;
                }
            }
            reportMap.put(string, new ArrayList<>(tempList));
            reportedMap.put(string, checkCount);
            checkCount = 0;
            tempList.clear();
        }

        int idx = 0;
        for(String name : idList){ //아란 0번째
            tempList = reportMap.get(name);
            for(String tmp : tempList){
                if(reportedMap.get(tmp) >= k){ // 다슬
                    checkCount ++;
                }
            }
            answer[idx] = checkCount;
            idx ++;
            checkCount = 0;
        }
        return answer;
    }

    public static void main(String[] args){
//        String[] idList = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        String[] idList = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        int[] result = Muji.solution(idList,report, k);
        System.out.println(result);
    }
}


