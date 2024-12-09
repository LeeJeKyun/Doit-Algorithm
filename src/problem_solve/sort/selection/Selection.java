package problem_solve.sort.selection;

public class Selection {
    public static void main(String[] args) {
//        int[] arr = {28, 31, 24, 5, 8, 3, 54, 72, 63, 50};
        char[] arr = {'3','2','5','1','4'};
        //
        for(int i=0; i<arr.length; i++){
            int minP = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minP] > arr[j]){
                    minP = j;
                }
            }
            char temp = arr[i];
            arr[i] = arr[minP];
            arr[minP] = temp;
        }
        for(char i : arr) {
            System.out.println(i);
        }
    }
}
