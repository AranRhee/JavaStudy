package aran;

class SortMyStyle {
    public String[] solution(String[] strings, int n) {
        String tmp = null;
        for(int i=0; i<strings.length; i++){
            for(int j=i+1; j<strings.length; j++){
                if(strings[i].charAt(n) == strings[j].charAt(n) && strings[i].compareTo(strings[j]) > 0){
                    tmp = strings[j];
                    strings[j] = strings[i];
                    strings[i] = tmp;
                } else if(strings[i].charAt(n) > strings[j].charAt(n)){
                    tmp = strings[j];
                    strings[j] = strings[i];
                    strings[i] = tmp;
                }
            }
        }
        String[] answer = {};
        return strings;
    }
}