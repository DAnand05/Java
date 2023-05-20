import java.util.Scanner;

public class non_recursive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>1){
            int curr = 0;
        	int res = 0;
        	int next = 1;
            for(int i = 1; i < n; i++){
                res = curr+next;
                curr = next;
                next = res;
                System.out.print(res+" ");
            }
            //System.out.print(res);
        }else{
            System.out.print("1");
        }
        sc.close();
    }
}
