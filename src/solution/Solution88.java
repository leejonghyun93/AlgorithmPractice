package solution;


/* 문제 :  */


import java.util.Arrays;

class Solution88 {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int n : numbers)
            answer -= n;
        return answer;
    }
}


/*
 *
 **/
