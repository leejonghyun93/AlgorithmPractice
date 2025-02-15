package solution;


/* 문제 : 짝지어 제거하기 */


import java.util.Stack;

class Solution11 {
   public int solution(String s){
       Stack<Character> stack = new Stack<>();
       for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           // 스택이 비어 있지 않고,현재 문자와 스택의 맨 위 문자가 같으면
           if(!stack.isEmpty() && stack.peek() == c){
               stack.pop(); // 스택의 맨 위 문자 제거
           }
           else {
               stack.push(c); // 스택에 현재 문자 추가
           }
       }
       return stack.isEmpty() ? 1 : 0; // 스택이 비어 있으면 1, 그렇지 않으면 0 반환
   }
}


/**
 stack.push(c) : c 문자를 스택에 추가
 stack.pop() : 스택의 맨 위 문자를 제거
 stack.peek() : 스택의 맨 위 문자를 확인 (제거하지 않음)
 stack.isEmpty() : 스택이 비어 있는지 확인
 **/
