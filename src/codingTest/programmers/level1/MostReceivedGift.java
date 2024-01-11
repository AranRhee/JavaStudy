package codingTest.programmers.level1;

import java.util.*;

class MostReceivedGift {
    public int solution(String[] friends, String[] gifts) {

        int[] giftCount = new int[friends.length];
        for(int i=0; i<friends.length; i++){
            giftCount[i] = 0;
        }

        Map<String, Integer> userGiftScoreMap = new HashMap<>();
        for(String name : friends){
            userGiftScoreMap.put(name, getGiftScore(name, gifts));
        }


        for(int i=0; i<friends.length; i++){
            for(int j=i+1; j<friends.length; j++){
                int aToB = getGiveCount(friends[i], friends[j], gifts);
                int bToA = getGiveCount(friends[j], friends[i], gifts);
                if(aToB > bToA){
                    giftCount[i] = giftCount[i] + 1;
                } else if (bToA > aToB){
                    giftCount[j] = giftCount[j] + 1;
                } else {
                    if(getGiftScore(friends[i], gifts) > getGiftScore(friends[j], gifts)){
                        giftCount[i] = giftCount[i] + 1;
                    } else if (getGiftScore(friends[i], gifts) < getGiftScore(friends[j], gifts)){
                        giftCount[j] = giftCount[j] + 1;
                    }
                }

            }
        }


        int answer = getMax(giftCount);
        return answer;
    }

    public int getGiftScore(String user, String[] gifts){
        int giveCount = 0;
        int receiveCount = 0;
        for(String gift : gifts){
            String[] temp = gift.split(" ");
            if(temp[0].equals(user)){
                giveCount++;
            } else if(temp[1].equals(user)){
                receiveCount++;
            }
        }

        return giveCount - receiveCount;
    }

    public int getGiveCount(String user, String user2, String[] gifts){
        String checkName = user + " " + user2;
        int retVal = 0;
        for(String gift : gifts){
            if(gift.equals(checkName)) retVal++;
        }

        return retVal;
    }

    public int getMax(int[] giftCounts){
        int temp = 0;
        for(int i : giftCounts){
            if(temp < i) temp = i;
        }

        return temp;
    }


}