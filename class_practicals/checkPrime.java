import java.util.Scanner;

public class checkPrime{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        for(i = 2; i < n ; i++){
            if(n%i == 0){
                System.out.print("number is composite");
                return;
            }
        }
        /*if(i < n){
            System.out.print("number is composite");
        }else{
            System.out.print("number is prime");
        } */
        System.out.print("number is prime");
    }
}