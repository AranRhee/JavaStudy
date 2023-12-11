package codingTest.programmers.level1;

import java.util.*;

// 18분 8점
class Pcce10 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<int[]> filterList = new ArrayList<int[]>();
        int extIdx = getIndex(ext);
        for(int[] arr : data){
            if(arr[extIdx] < val_ext) filterList.add(arr);
        }

        int[] temp;
        int sortIdx = getIndex(sort_by);
        for(int i=0; i<filterList.size(); i++){
            for(int j=i+1; j<filterList.size(); j++){
                if(filterList.get(i)[sortIdx] > filterList.get(j)[sortIdx]){
                    temp = filterList.get(i);
                    filterList.set(i, filterList.get(j));
                    filterList.set(j, temp);
                }
            }
        }

        // list to array 할 때 파라미터로 자료형 넣어주기.. object[] > int[][] 형변환 에러 났었음
        return filterList.toArray(new int[0][]);
    }

    public int getIndex(String ext){
        String[] code = {"code", "date", "maximum", "remain"};
        List<String> codeList = Arrays.asList(code);
        return codeList.indexOf(ext);
    }
}