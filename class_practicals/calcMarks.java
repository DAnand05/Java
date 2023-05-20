import java.util.Scanner;

public class calcMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int m5 = sc.nextInt();
        int tot = m1+m2+m3+m4+m5;
        double avg = (tot*1.0)/5;
        double perc = (tot*100*1.0)/500;
        if(perc>=90){
            System.out.print("Grade = A");
        }else if(perc >= 80 && perc<90){
            System.out.print("Grade = B");
        }else if(perc>=70 && perc<=80){
            System.out.print("Grade = C");
        }else if(perc>=60 && perc<=70){
            System.out.print("Grade = D");
        }else{
            System.out.print("Fail hai bhai tu, koi na");
        }
    }
}
