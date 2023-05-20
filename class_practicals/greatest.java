package class_practicals;
import java.util.Scanner;

public class greatest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    if(a>b && a>c){
        System.out.print("a is greater");
    }else if(b>a && b>c){
        System.out.print("b is greater");
    }else if(c>a && c>b){
        System.out.print("c is greater");
    }else{
        System.out.print("numbers are equal");
    }
    }
}
