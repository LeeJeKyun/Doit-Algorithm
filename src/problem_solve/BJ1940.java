package problem_solve;

import java.util.Scanner;

public class BJ1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }


        int sp = 0;
        int ep = 0;
        while(sp < n) {
            int s = arr[sp];
            int e = arr[ep];
            if(arr[sp] + arr[ep] == m) {
                result++;
                s = 0; e = 0;
                sp++; ep=sp;
            } else if(ep==n-1){
                sp++; ep=sp;
            } else if(s == 0) {
                sp++; ep=sp;
            } else {
                ep++;
            }
        }

        System.out.println(result);

    }
}
