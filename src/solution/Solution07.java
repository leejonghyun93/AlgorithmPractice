package solution;


/* 문제 : 방문 길이*/

import java.util.HashMap;
import java.util.HashSet;

class Solution07 {

    // 방향별 이동 좌표를 저장하는 해시맵 (U: 위, D: 아래, L: 왼쪽, R: 오른쪽)
    private static final HashMap<Character, int[]> location = new HashMap<>();

    // 이동 방향에 따른 x, y 좌표 변화량을 초기화하는 메서드
    private static void initLocation() {
        location.put('U', new int[]{0, 1});  // 위로 이동 (y 증가)
        location.put('D', new int[]{0, -1}); // 아래로 이동 (y 감소)
        location.put('L', new int[]{-1, 0}); // 왼쪽으로 이동 (x 감소)
        location.put('R', new int[]{1, 0});  // 오른쪽으로 이동 (x 증가)
    }

    // 좌표가 평면(0~10 범위) 내에 있는지 검사하는 메서드
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    // 주어진 이동 명령(dirs)에 따라 이동한 경로의 개수를 계산하는 메서드
    public int solution(String dirs) {
        initLocation(); // 이동 방향 정보 초기화
        int x = 5, y = 5; // 시작 위치 (5,5)

        HashSet<String> visitedPaths = new HashSet<>(); // 중복된 경로를 방지하기 위한 HashSet

        // 주어진 이동 명령을 하나씩 처리
        for (int i = 0; i < dirs.length(); i++) {
            char direction = dirs.charAt(i); // 현재 이동 방향
            int[] offset = location.get(direction); // 해당 방향의 x, y 변화량 가져오기

            int nx = x + offset[0]; // 새로운 x 좌표
            int ny = y + offset[1]; // 새로운 y 좌표

            // 만약 새로운 좌표가 좌표평면을 벗어나면 무시
            if (!isValidMove(nx, ny))
                continue;

            // (x, y) → (nx, ny) 이동한 경로를 문자열로 저장
            String path1 = x + " " + y + " " + nx + " " + ny;
            String path2 = nx + " " + ny + " " + x + " " + y;

            // 양방향 이동을 고려하여 경로 저장
            visitedPaths.add(path1);
            visitedPaths.add(path2);

            // 좌표 업데이트 (이동)
            x = nx;
            y = ny;
        }

        // 총 방문한 경로 개수는 HashSet 크기의 절반
        return visitedPaths.size() / 2;
    }
}


/**
 **/
