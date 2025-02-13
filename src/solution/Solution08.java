package solution;


/* 문제 : 올바른 괄호*/

import java.util.ArrayDeque;

class Solution08 {

    private boolean solution(String s ){
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();
        for(char c : a){
            if(c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty() || stack.pop() == c)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}


/**
 **/
