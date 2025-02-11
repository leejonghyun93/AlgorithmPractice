package solution;


/* 문제 : 실패율*/

import java.util.HashMap;

public class Solution06 {
   public int[] solution(int N,int[] stages){
       // 스테이지별 도전자 수를 구함
       int[] challenger = new int[N + 2];
       for(int i = 0; i < stages.length; i++){
           challenger[stages[i]] += 1;
       }

       // 스테이지별 실패한 사용자 수 계산
       HashMap<Integer,Double> fails = new HashMap<>();
       double total = stages.length;

       // 각 스테이지를 순회하며 , 실패율 계산
       for(int i =1; i <= N; i++){
           if(challenger[i] == 0){
               fails.put(i,0.);
           }
           else {
               fails.put(i, challenger[i] / total); // 실패율 구함
               total -= challenger[i]; // 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
           }
       }

       // 실패율이 높은 스테이지부터 내림차순으로 정렬
       return fails.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.
               getValue(),o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
   }
}

/**
 solution(int N, int[] stages) : N개의 스테이지에서 실패율을 계산하여 내림차순으로 정렬된 스테이지 번호 배열 반환
 challenger[i] : 각 스테이지별 도전한 플레이어 수를 저장
 HashMap<Integer, Double> fails : 스테이지 번호 → 실패율 을 저장하는 HashMap
 total -= challenger[i] : 현재 스테이지의 도전자를 제거하여 다음 스테이지 계산
 .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())) : 실패율 기준으로 내림차순 정렬
 .mapToInt(HashMap.Entry::getKey).toArray() : 정렬된 스테이지 번호를 배열로 변환
 **/
