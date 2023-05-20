package class_practicals;
import java.net.SocketImpl;
import java.util.Scanner;

import javax.print.event.PrintEvent;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n%2==0){
            System.out.print("even");
        }else{
            System.out.print("odd");
        }
    }
    
}
