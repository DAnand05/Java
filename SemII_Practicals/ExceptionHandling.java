package SemII_Practicals;

class temp{
    int a=10,b=0;
    void div(){
        try{
            int c = a/b;
            System.out.print(c);
        }catch(Exception e){
            System.out.print(e);
        }finally{
                int c = a*b;
                System.out.print(" "+c);
        }
    }
}

class ExceptionHandling{
    public static void main(String[] args) {
        temp t = new temp();
        t.div();
    }
}