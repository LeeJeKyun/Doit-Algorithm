package problem_solve.two_pointer;

import java.util.Arrays;
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

class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;

        //입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }


        int sp = 0;
        int ep = sp + 1;
        while(sp < n-1) {   //시작포인터가 마지막 주소보다 작은 동안 진행
            if(ep==n) {     //End포인터가 마지막 주소보다 커지면
                sp++; ep=sp+1;  //포인터 초기화
            } else if(arr[sp] == 0) {   //이미 사용된 숫자인 경우
                sp++; ep=sp+1;  //포인터 초기화
            } else if(arr[sp] + arr[ep] == m) { //정답인 경우
                ans++;  //답 + 1
                arr[sp] = 0; arr[ep] = 0;   //사용된 숫자로 설정
                sp++; ep=sp+1;  //포인터 초기화
            } else {    //모두 아닌 경우
                ep++;   //End포인터 + 1
            }
        }

        System.out.println(ans);

    }
}

class Second2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;

        //입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
//        Arrays.sort(arr);

        int sp = 0;
        int ep = arr.length-1;
        while(sp < ep) {
            if(arr[sp] == 0) {
                sp++;
            } else if(arr[sp] + arr[ep] == m) {
                ans++;
                arr[ep]=0;
                sp++;
                ep = arr.length - 1;
            } else {
                ep--;
            }
        }
        System.out.println(ans);

    }
}

class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;

        //입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        //1회 반복을 위한 정렬
        Arrays.sort(arr);

        int sp = 0;
        int ep = arr.length-1;

        //둘이 교차되기 전까지
        while(sp < ep) {
            //두 수의 합이 기준보다 크면 큰 수를 작게
            if(arr[sp] + arr[ep] > m) ep--;
            //두 수의 합이 기준보다 작으면 작은 수를 크게
            else if(arr[sp] + arr[ep] < m) sp++;
            //두 수의 합이 같다면 모두 사용된 숫자이므로 한칸씩 이동 후 결과+1
            else if(arr[sp] + arr[ep] == m) {
                sp++;
                ep--;
                ans++;
            }
            //두 수의 합을 기준으로 경우의 수를 모두 없앨 수 있었다.
        }
        System.out.println(ans);

    }
}
