import java.util.Scanner;

class acc{
    String name;
    int acNo;
    int time;
    int amount;

    acc(){
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        acNo = sc.nextInt();
        time = sc.nextInt();
        amount = sc.nextInt();
    }

    void withdrawAmt(){
        Scanner sc = new Scanner(System.in);
        int withdraw = sc.nextInt();
        if(withdraw < amount){
            amount -=withdraw;
            System.out.println("amount withdrawn from account");
        }else{
            System.out.println("Insufficient balance");
        }
    }

    void print(){
        System.out.println("name : " +name);
        System.out.println("account number : " +acNo);
        System.out.println("Time : " +time);
        System.out.println("Amount : " +amount);
    }
}

public class fd {
    public static void main(String[] args) {
        acc p1 = new acc();
        p1.withdrawAmt();
        p1.print();
    }
    
}
