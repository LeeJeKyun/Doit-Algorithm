package problem_solve.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int p = 0;
        int m = 1;
        List<String> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        do{
            //NO를 출력하는 로직이 들어가야함.
            if(!stack.isEmpty()&&stack.peek()==arr[p]){
                stack.pop();
                list.add("-");
                p++;
            } else if( m>n ) {
                System.out.println("NO");
                return;
            }else {
                stack.push(m++);
                list.add("+");
            }
        } while(m<=n || !stack.empty());
        for (String str : list) {
            System.out.println(str);
        }
    }
}
