package problem_solve.two_pointer;

import java.util.Scanner;

public class BJ2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        //sArr의 길이는 16
        int[] sArr = new int[num+1];
        for(int i=1; i<=num; i++){
            sArr[i] = sArr[i-1] + i;
        }

        int result = 0;
        //sArr[1] ~ sArr[15]까지는 연속된 수의 합
        //1부터 3까지의 합은 sArr[3]-sArr[0]
        //따라서 S[i]-S[j-1]이 각 숫자들의 합.
        for(int i=1; i<=num; i++) {
            for(int j=1; j<=num; j++) {
                if((sArr[j]-sArr[i-1])==num) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}

class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //연속된 수의 합
        int target = sc.nextInt();
        //시작점
        int startP = 1;
        //마지막점
        int endP = 1;
        //합
        int sum = 1;
        //정답
        int count = 1;
        //마지막 포인터가 타겟보다 작은동안
        while(endP<target) {
            //만약 합이 target보다 작으면
            if(sum < target){
                endP++;
                sum += endP;
            //만약 합이 target보다 크면
            } else if(sum > target) {
                sum -= startP;
                startP++;
            //만약 합이 target과 같다면
            } else if(sum == target) {
                endP++;
                sum += endP;
                count++;
            }
        }
        System.out.println(count);
    }
}
