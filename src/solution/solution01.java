package solution;

import java.util.Arrays;

public class solution01 {
    public static void main(String[] args) {
        int[] org = {4,2,3,1,5};
        int[] sorted = solution(org);
        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(sorted));
    }
    private static int[] solution(int[] arr){
       int[] clone = arr;
       Arrays.sort(clone);
       return clone;
    }
}

/** Arrays.sort() 메서드는 배열을 오름차순으로 정렬 */
/** 배열의 clone() 메서드는 타겟이 되는 배열을 복사하여 새로운 배열로 생성*/