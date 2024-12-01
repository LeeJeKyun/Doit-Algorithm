package problem_solve.sliding_window;

import java.util.Scanner;

public class BJ12891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        int s = sc.nextInt();
        int p = sc.nextInt();
        sc.nextLine();
        char[] charArray = sc.nextLine().toCharArray();
        //ACGT의 기준
        int[] factor = new int[4]; //ACGT
        for(int i = 0; i < p; i++) {
            factor[i] = sc.nextInt();
        }
        //좌, 우 포인터
        int left = 0;
        int right = left + p - 1;

        int answer = 0;

        //우 포인터가 길이보다 작은 경우
        while(right < s){
            int[] question = new int[4];
            boolean notDna = false;
            //자른 배열동안
            for(int i = left; i <= right; i++) {
                char c = charArray[i];
                if(c == 'A') {
                    question[0]++;
                } else if (c == 'C') {
                    question[1]++;
                } else if (c == 'G') {
                    question[2]++;
                } else if (c == 'T') {
                    question[3]++;
                } else {
                    break;
                }
            }
            if(!notDna){
                if(question[0] >= factor[0]
                        && question[1] >= factor[1]
                        && question[2] >= factor[2]
                        && question[3] >= factor[3]
                ) answer++;
            }
            left++;
            right = left + p - 1;
        }

        System.out.println(answer);

    }
}
