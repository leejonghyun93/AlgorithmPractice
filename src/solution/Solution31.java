package solution;


/* 문제 : 폰켓몬*/


import java.util.Arrays;

import java.util.HashSet;
import java.util.stream.Collectors;

class Solution31 {
    public int solution(int[] nums){
        // nums 리스트에서 중복을 제거한 집합(set)을 구함
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        // 폰켓몬의 총수
        int n = nums.length;
        // 선택할 폰켓몬의 수
        int k = n / 2;
        // 중복을 제거한 폰켓몬의 종류 수와 선택할 폰켓몬의 수 중 작은 값 반환
        return Math.min(k,set.size());
    }
}

/**
 *
 **/
