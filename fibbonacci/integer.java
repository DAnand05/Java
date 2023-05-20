import java.util.Scanner;

public class integer {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n=sc.nextInt();
        if(n<0)
        System.out.print("the number is negative");
        else if(n>0)
        System.out.print("the number is positive");
        else 
        System.out.print("the number is zero");
 }
}
