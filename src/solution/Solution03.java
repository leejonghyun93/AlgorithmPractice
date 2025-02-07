package solution;


/* 문제 : 두 개 뽑아서 더하기 */

import java.util.HashSet;

public class Solution03 {
    public static int[] solution(int[] numbers){
        HashSet<Integer> set = new HashSet<>(); // 중복값 제거를 위한 해시셋 생성
        // 두 수를 선택하는 모든 경우의 수를 반복문으로 구함
        for(int i = 0; i<numbers.length -1; i++){
            for(int j= i+1; j < numbers.length; j++){
                // 두 수를 더한 결과를 해시셋에 추가
                set.add(numbers[i] + numbers[j]);
            }
        }
        // 해시셋의 값을 오름차순 정렬하고 int[] 형태의 배열로 변환하여 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}


/**
 new HashSet<>() : 중복을 허용하지 않는 해시셋(HashSet) 객체 생성
 set.add(value) : 해시셋에 값 추가 (중복 자동 제거)
 set.stream() : 해시셋을 스트림으로 변환하여 가공 가능하도록 만듬
 sorted() : 오름차순 정렬
 mapToInt(Integer::intValue) : Integer 객체를 int 기본형으로 변환
 toArray() : 최종 결과를 int[] 배열로 반환
 **/
