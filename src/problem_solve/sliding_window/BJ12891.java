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
        for(int i = 0; i < 4; i++) {
            factor[i] = sc.nextInt();
        }

        //좌, 우 포인터
        int left = 0;
        int right = left + p - 1;

        int answer = 0;

        //우 포인터가 배열의 길이 보다 작은 경우
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
                    notDna = true;
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

class Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        //S는 전체 문자열의 길이
        int s = sc.nextInt();
        //P는 부분 문자열의 길이
        int p = sc.nextInt();
        sc.nextLine();

        //전체 문자열의 부분 문자가 순서대로 삽입된 배열
        char[] charArray = sc.nextLine().toCharArray();
        //ACGT의 기준
        int[] factor = new int[4]; //ACGT
        for(int i = 0; i < 4; i++) {
            factor[i] = sc.nextInt();
        }

        //좌, 우 포인터
        int left = 0;
        int right = left + p - 1;

        int answer = 0;
        int[] question = new int[4];
        for(int i=left; i<=right; i++) {
            char c = charArray[i];
//            System.out.println("c = " + c);
            if(c == 'A') {
                question[0]++;
            } else if (c == 'C') {
                question[1]++;
            } else if (c == 'G') {
                question[2]++;
            } else if (c == 'T') {
                question[3]++;
            }
        }

        //현재의 경우 첫 문자열의 갯수가 잘못됨.
        while(right < s){
            char c = charArray[right];
            //마지막 문자열이 ACGT중 하나이면 현재 문자수에 더하기
            if(c == 'A') {
                question[0]++;
            } else if (c == 'C') {
                question[1]++;
            } else if (c == 'G') {
                question[2]++;
            } else if (c == 'T') {
                question[3]++;
            }
            //조건에 만족하면 답+1
            if (question[0] >= factor[0]
                    && question[1] >= factor[1]
                    && question[2] >= factor[2]
                    && question[3] >= factor[3]
            ) answer++;
            //답이 아니면 부분문자열의 첫 문자열을 제외하기
            else {
                c = charArray[left];
                if(c == 'A') {
                    question[0]--;
                } else if (c == 'C') {
                    question[1]--;
                } else if (c == 'G') {
                    question[2]--;
                } else if (c == 'T') {
                    question[3]--;
                }
            }
            left++; right = left + p - 1;
        }
        System.out.println(answer);
    }
}

//등신같은새끼, 왜 슬라이딩 윈도우의 처음 인덱스를 답이 아닌 경우에만 지우게 해둔거야...
class Answer02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력
        //S는 전체 문자열의 길이
        int s = sc.nextInt();
        //P는 부분 문자열의 길이
        int p = sc.nextInt();
        sc.nextLine();

        //전체 문자열의 부분 문자가 순서대로 삽입된 배열
        char[] charArray = sc.nextLine().toCharArray();
        //ACGT의 기준
        int[] factor = new int[4]; //ACGT
        for(int i = 0; i < 4; i++) {
            factor[i] = sc.nextInt();
        }

        //좌, 우 포인터
        int left = 0;
        int right = left + p - 1;

        int answer = 0;
        int[] question = new int[4];
        for(int i=left; i<right; i++) {
            char c = charArray[i];
//            System.out.println("c = " + c);
            if(c == 'A') {
                question[0]++;
            } else if (c == 'C') {
                question[1]++;
            } else if (c == 'G') {
                question[2]++;
            } else if (c == 'T') {
                question[3]++;
            }
        }

        //현재의 경우 첫 문자열의 갯수가 잘못됨.
        while(right < s){
            char d = charArray[right];
            if(d == 'A') {
                question[0]++;
            } else if (d == 'C') {
                question[1]++;
            } else if (d == 'G') {
                question[2]++;
            } else if (d == 'T') {
                question[3]++;
            }
            if (question[0] >= factor[0]
                    && question[1] >= factor[1]
                    && question[2] >= factor[2]
                    && question[3] >= factor[3]
            ) answer++;
            //답이 아니면 부분문자열의 첫 문자열을 제외하기
            char c = charArray[left];
            if(c == 'A') {
                question[0]--;
            } else if (c == 'C') {
                question[1]--;
            } else if (c == 'G') {
                question[2]--;
            } else if (c == 'T') {
                question[3]--;
            }
            left++;
            right = left + p - 1;
        }
        System.out.println(answer);
    }
}