class rectangle{
    int len, wid;
    rectangle(int len, int wid){
        this.len = len;
        this.wid = wid;
    }
}
public class rectTestDrive {
    public static void main(String[] args) {
        rectangle r1=new rectangle(4,5);
        System.out.println("length = "+r1.len+", width = "+r1.wid);
    }
}
