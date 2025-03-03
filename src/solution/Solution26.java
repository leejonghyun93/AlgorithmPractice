package solution;


/* 문제 : 예상 대진표*/


class Solution26 {
   public int soulution(int n,int a , int b){
       int answer;

       for(answer = 0; a!=b; answer++){
           a = (a + 1) / 2;
           b = (b + 1) / 2;
       }

       return answer;
   }
}

/**
 *
 **/
