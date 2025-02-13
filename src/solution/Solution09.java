package solution;


/* 문제 : 10진수를 2진수로 변환하기*/


import java.util.Stack;

class Solution09 {
    public static String solution(int decimal){
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0){
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        // String의 + 연산은 시간 복잡도 측면에서 성능이 좋지 않음
        // 따라서 StringBuilder를 사용했음
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}


/**
 solution(int decimal) : 주어진 10진수(decimal)를 2진수 문자열로 변환하여 반환
 Stack<Integer> stack = new Stack<>(); : 2진수 변환 과정에서 나머지를 저장하는 스택
 decimal % 2 : 2로 나눈 나머지를 구함 (0 또는 1)
 stack.push(remainder); : 나머지를 스택에 저장
 decimal /= 2; : decimal 값을 2로 나누어 계속 변환
 while (!stack.isEmpty()) : 스택이 빌 때까지 값 꺼내기
 sb.append(stack.pop()); : 스택에서 꺼낸 값을 StringBuilder에 추가
 return sb.toString(); : 최종적으로 2진수 문자열을 반환
 **/
