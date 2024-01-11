package codingTest.programmers.level2;

// 숫자의 표현
// 7점
class NumberExpression {
    public int solution(int n) {
        int retVal = 0;
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum = 0;
            for(int j=i; j<=n; j++){
                sum += j;
                if(sum == n){
                    retVal++;
                    break;
                } else if(sum > n){
                    break;
                }
            }
        }

        return retVal;
    }
}