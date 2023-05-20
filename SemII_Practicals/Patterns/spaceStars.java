public class spaceStars {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            int sp=5-i;
            while(sp>0){
                System.out.print(" ");
                sp--;
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
