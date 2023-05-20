import java.util.Scanner;

public class recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = fibb(n);
        System.out.print(res);
        sc.close();
    }
    public static int fibb(int n){
        if(n <= 1){
            return n;
        }

        int res = fibb(n-1)+fibb(n-2);

        return res;

        
    }
}
