package problem_solve.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 구간 합 관련 문제
 */
public class BJ11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int count = sc.nextInt();
        int[] iArr = new int[length];
        for(int i=0; i<length; i++) {
            iArr[i] = sc.nextInt();
        }

        int[] sArr = new int[length];
        for(int i=0; i<length; i++) {
            if(i==0) {
                sArr[i] = iArr[i];
            } else {
                sArr[i] = sArr[i-1] + iArr[i];
            }
        }

        int[] answer = new int[count];

        for(int i=0; i<count; i++) {
            int j = sc.nextInt() - 1;
            int k = sc.nextInt() - 1;
            if(j<=0) answer[i] = sArr[k];
            else answer[i] = sArr[k] - sArr[j-1];
        }
        for(int a : answer) {
            System.out.println(a);
        }

    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int count = sc.nextInt();
        int[] iArr = new int[length + 1];
        for(int i=1; i<=length; i++) {
            iArr[i] = sc.nextInt();
        }

        int[] sArr = new int[length + 1];
        for(int i=1; i<=length; i++) {
                sArr[i] = sArr[i-1] + iArr[i];
        }

        int[] answer = new int[count];

        for(int i=0; i<count; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            answer[i] = sArr[k] - sArr[j-1];
        }
        for(int a : answer) {
            System.out.println(a);
        }

    }
}

class Explanation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        long[] sArr = new long[length + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=length; i++) {
            sArr[i] = sArr[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int r=0; r<count; r++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(sArr[j] - sArr[i-1]);
        }
    }
}
