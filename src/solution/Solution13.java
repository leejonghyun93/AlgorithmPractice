package solution;


/* 문제 : 크레인 인형 뽑기 게임*/


import java.util.Stack;

class Solution13 {
   public int solution(int[][] board, int[] moves){
       // 각 열에 대한 스택을 생성합니다
       Stack<Integer>[] lanes = new Stack[board.length];
       for(int i = 0; i < lanes.length; i++){
           lanes[i] = new Stack<>();
       }

       // board를 역순으로 탐색하며, 각 열의 인형을 lanes에 추가합니다.
       for(int i = board.length - 1; i >= 0; i--){
           for(int j = 0; j < board[i].length; j++){
               if(board[i][j] > 0){
                   lanes[j].push(board[i][j]);
               }
           }
       }

       // 인형을 담을 bucket을 생성합니다.
       Stack<Integer> bucket = new Stack<>();
       // 사라진 인형의 총 개수를 저장할 변수를 초기화합니다.
       int answer = 0;

       // moves를 순회하며, 각 열에서 인형을 뽑아 bucket에 추가합니다.
       for(int move : moves){
           if(!lanes[move - 1].isEmpty()){ // 해당 열에 인형이 있는 경우
               int doll = lanes[move - 1].pop();
               // 바구니에 인형이 있고,가장 위에 있는 인형과 같은 경우
               if(!bucket.isEmpty() && bucket.peek() == doll){
                   bucket.pop();
                   answer += 2;
               }
               else { // 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
                   bucket.push(doll);
               }
           }
       }
       return answer;
   }
}


/**
 stack.push(x) : x 값을 스택에 추가
 stack.pop() : 스택의 맨 위 요소(인덱스) 제거
 stack.peek() : 스택의 맨 위 요소(인덱스) 확인 (제거하지 않음)
 stack.isEmpty() : 스택이 비어 있는지 확인
 **/
