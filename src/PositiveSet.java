import java.util.*;
public class PositiveSet{
    private static int setSplit(int A[]){
        if(A == null || A.length == 0) return 0;
        int len = A.length;
        int posSum = 0;
        for(int i = 0; i < len; i++){
            int curr = A[i];
            if(curr < 0){
                curr = -curr;
            }
            posSum += curr;
        }
        boolean dp[] = new boolean[posSum + 1];
        dp[0] = true;
        for(int i = 0; i < len; i++){
            int curr = A[i];
            for(int j = posSum; j >= curr; j--){
                if(dp[j - curr]){
                    dp[j] = true;
                }
            }
        }
        int mid = posSum/2;
        while(mid >= 0){
            if(dp[mid] == true){
                return Math.abs(posSum - mid - mid);
            }
                mid--;
        }
        return 0;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
        	System.out.println("Enter the length of the array");
            int len = sc.nextInt();
            if(len == 0){
                break;
            }
            int A[] = new int[len];
            System.out.println("Enter the elements");
            for(int i = 0; i < len; i++){
                A[i] = sc.nextInt();
            }
            int res = setSplit(A);
            System.out.println(res);
            break;
        }
    }
}
