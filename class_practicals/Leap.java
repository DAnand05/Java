import java.util.Scanner;

public class Leap {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if((n%4==0 && n%100!=0) || n%400==0){
            System.out.print("it's a Leap year");
        }else{
            System.out.print("Not a Leap year");
        }
    }
}