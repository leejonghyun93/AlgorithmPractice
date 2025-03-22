package solution;


/* 문제 : 1부터 N까지 숫자 중 합이 10이 되는 조합구하기 */


import java.util.ArrayList;

class Solution43 {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(2));
        System.out.println(solution(7));
    }

    // ❶ 조합 결과를 담을 리스트
    private static ArrayList<ArrayList<Integer>> result;
    private static int n;
    private static void backtrack(int sum, ArrayList<Integer> selectedNums, int start) {
        // ❷ 합이 10이 되면 결과 리스트에 추가
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        // ❸ 다음에 선택할 수 있는 숫자들을 하나씩 선택하면서
        for (int i = start; i <= n; i++) {
            // ❹ 선택한 숫자의 합이 10보다 작거나 같으면
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);
                // ❺ 백트래킹 메소드를 재귀적으로 호출합니다.
                backtrack(sum + i, list, i + 1);
            }
        }
    }

    // 이 부분을 변경해서 실행해보세요.
    private static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        // ❻ 백트래킹 메소드 호출
        backtrack(0, new ArrayList<>(), 1);

        return result;
    }
}


/*
 *
 **/
