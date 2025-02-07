package solution;

import java.util.Arrays;
import java.util.Collections;

/* 문제 : 정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution()함수를 구현하세요. */

public class Solution02 {
    private static int[] solution(int[] arr){
        // 중복값 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder()); // 내림차순 정렬
        // int형 배열로 변경 후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}

/**
 Arrays.stream(arr) : int[] 배열로 스트림으로 변환(IntStream)
 .boxed() : 기본형 int -> 객체형 Integer 변환(Stream<Integer>)
 .distinct() : 중복 제거
 .toArray(Integer::new) : 스트림을 Integer[] 배열로 변환
 Arrays.sort(result, Collections.reverseOrder()) : 배열을 내림차순 정렬
 Arrays.stream(result).mapToInt(Integer::intValue).toArray() : Integer[] → int[] 변환
 **/