package solution;


/* 문제 : 두 개의 수로 특정값 만들기*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

class Solution18 {
    private static boolean solution(int[] arr, int target){
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i : arr){
            // target에서 현재 원소를 뺀 값이 해시셋 있는지 확인
            if(hashSet.contains(target - i)){
                return true;
            }
            // 해시셋 현재 값 저장
            hashSet.add(i);
        }

        return false;
    }
}

/**
 *
 **/
