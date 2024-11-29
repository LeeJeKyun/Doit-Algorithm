package problem_solve.array_list;

import java.util.Scanner;

/**
 * 배열 관련 문제
 */
public class BJ1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int maxNum = 0;
        int[] scoreArr = new int[num];
        int totalScore = 0;
        for(int i=0; i<num; i++) {
            scoreArr[i] = sc.nextInt();
            if(scoreArr[i] > maxNum) {
                maxNum = scoreArr[i];
            }
            totalScore += scoreArr[i];
        }
        double average = totalScore / (double)num;

        System.out.println(average/maxNum*100);
    }
}
