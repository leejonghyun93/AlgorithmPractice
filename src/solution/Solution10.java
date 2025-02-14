package solution;


/* 문제 : 괄호 회전하기 */


import java.util.ArrayDeque;
import java.util.HashMap;

class Solution10 {
    public static int solution(String s){
        // 괄호 정보를 저장함. 코드를 간결하게 할 수 있음
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        int n = s.length(); // 원본 문자열의 길이 저장
        s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만들어줌
        int answer = 0;

        // 확인할 문자열의 시작 인덱스를 0부터 n까지 이동
        A:for(int i = 0; i < n; i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            // i(시작 위치)부터 원본 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확인
            for(int j = i; j < i + n; j++){
                char c = s.charAt(j);
                // 해시맵 안에 해당 키가 없다면 열리는 괄호임
                if(!map.containsKey(c)){
                    stack.push(c);
                }
                else {
                    // 짝이 맞지 않으면 내부 for문은 종료하고 for문 A로 이동
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            // 3에서 continue 되지 않았고, 스택이 비어있으면 올바른 괄호 문자열임
            if(stack.isEmpty())
                answer++;
        }
        return answer;
    }
}


/**
 solution(String s) : 문자열 s를 회전하며 올바른 괄호 문자열 개수를 계산
 HashMap<Character, Character> map : ) → (, ] → [, } → { 와 같은 괄호 짝을 저장
 s += s; : 문자열을 2배로 늘려서 회전 검사 가능하게 만듬
 ArrayDeque<Character> stack = new ArrayDeque<>(); : 여는 괄호를 저장할 스택
 map.containsKey(c) : 	현재 문자가 닫는 괄호인지 확인
 stack.push(c); : 여는 괄호는 스택에 저장
 stack.pop().equals(map.get(c)) : 닫는 괄호가 나올 때, 스택의 여는 괄호와 매칭 검사
 continue A; : 괄호 짝이 맞지 않으면 for문 A로 이동
 if (stack.isEmpty()) answer++; : 스택이 비어 있으면 올바른 괄호 문자열 개수 증가
 return answer; : 최종적으로 유효한 괄호 개수 반환
 **/
