import java.util.Scanner;

public class numTri {
    
	public static void main(String[] args) {
		/* Your class should be named Solution.
	 	* Read input as specified in the question.
	 	* Print output as specified in the question.
		*/
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 1;i<=n;i++){
            int sp = n-i;
            while(sp>0){
                System.out.print(" ");
                sp--;
            }
            int val = i;
            for(int j = 0; j < i; j++){
                System.out.print(val);
                val++;
            }
            val-=1;
            for(int k = val-1; k>=i; k--){
                System.out.print(k);
            }
            System.out.println("");
        }
        
	}
}
