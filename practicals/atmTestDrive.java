package practicals;
import java.util.Scanner;

class atm{
    int pin;
    int amt;
    String name;

    atm(String st){
        name = st;
        amt = 1000;
        pin = 0000;
    }

    void pinUpdate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new pin : ");
        int num = sc.nextInt();
        if(pin == 0000){
            if(num>999 && num<10000){
                pin = num;
                System.out.println("Pin Successfully Changed!!!");
            }else{
                System.out.print("Invalid pin");
                pinUpdate();
            }
        }else{
            System.out.println("Pin already updated once, try changing it using current password!!!");
        }
    }

    void pinChange(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter current password: ");
            int num = sc.nextInt();
            if(pin == num){
                System.out.println("Enter new password: ");
                int val = sc.nextInt();
                if(val>999 && val<10000){
                    pin = val;
                    System.out.println("Pin Successfully updated!!!");
                }else{
                    System.out.print("Invalid pin");
                    pinChange();
                }
            }else{
                System.out.println("Entered wrong pin, try again!!!");
            }
        
    }

    void depositAmt(){
        if(pin == 0000){
            System.out.println("Kindly update your pin first.");
            pinUpdate();
        }
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter pin: ");
            int num = sc.nextInt();
            if(pin == num){
                System.out.println("Enter Amount To Be Deposited In Your Account: ");
                int val = sc.nextInt();
                amt = amt+val;
                System.out.println("Amount Successfully Deposited");
            }else{
                System.out.println("Wrong Pin Entered");
            }
    }

    void withdrawAmt(){
        if(pin == 0000){
            System.out.println("Kindly update your pin first.");
            pinUpdate();
        }
            if(amt>1000){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter pin: ");
                int num = sc.nextInt();
                if(pin == num){
                    System.out.println("Enter Amount To Be Withdrawn From Your Account: ");
                    int val = sc.nextInt();
                    if(val<amt){
                        amt-=val;
                        System.out.println("Amount Successfully Withdrawn");
                    }else{
                        System.out.println("Insufficient Balance");
                    }
                }else{
                    System.out.println("Wrong Pin Entered");
                }   
            }else{
                System.out.println("Insufficient Balance");
            }
    }

    void tf(){
        if(pin == 0000){
            System.out.println("Kindly update your pin first.");
            pinUpdate();
        }
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter pin: ");
            int num = sc.nextInt();
            if(pin == num){
                System.out.println("Enter Amount To Be Transferred : ");
                int val = sc.nextInt();
                if(val>amt){
                    System.out.println("Insufficient balance");
                }else{
                    amt-=val;
                    System.out.println("Amount Successfully transferred");
                }
            }else{
                System.out.println("Entered Wrong PIN");
            }
    }

    void balInquiry(){
        if(pin == 0000){
            System.out.println("Kindly update your pin first.");
            pinUpdate();
        }
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter pin: ");
            int num = sc.nextInt();
            if(pin == num){
                System.out.println("Available amount in your account is: "+amt);
            }else{
                System.out.println("Entered Wrong PIN");
            }
        
    }

}

public class atmTestDrive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a language: ");
        String st = sc.nextLine();
        if(st.equals("English")){
            System.out.println("Language Successfully changed to English.");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawl");
            System.out.println("3. Transfer");
            System.out.println("4. Pin Generation");
            System.out.println("5. Pin Change");
            System.out.println("6. Balance Inquiry");
        }else if(st.equals("Hindi")){
            System.out.println("Language Successfully changed to Hindi.");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawl");
            System.out.println("3. Transfer");
            System.out.println("4. Pin Generation");
            System.out.println("5. Pin Change");
            System.out.println("6. Balance Inquiry");
        }else{
            System.out.println("Currently we only support English and Hindi as our prefferred languages.");
        }

        atm p1 = new atm("DayaRam");
        System.out.println("Enter no. of operations to be performed: ");
        int t = sc.nextInt();
        while(t>0){
            System.out.println("Select option to proceed:");
            int ch = sc.nextInt();
            switch(ch){
                case 1 : p1.depositAmt();
                break;
                case 2 : p1.withdrawAmt();
                break;
                case 3 : p1.tf();
                break;
                case 4 : p1.pinUpdate();
                break;
                case 5 : p1.pinChange();
                break;
                case 6 : p1.balInquiry();
                break;
                default : System.out.println("Enter valid option");
                break;
            }
            t-=1;
        }
    }
}
