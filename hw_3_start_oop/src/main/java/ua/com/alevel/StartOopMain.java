package ua.com.alevel;

public class StartOopMain {
    public static void main(String[] args){
        System.out.println("StartOOPMAIN.main");
        int arry[]= new int [10];
        for (int i=0;i<arry.length;i++)
        {
            arry[i]=i+1;
        }
        int arry1[]= new int[15];
        arry1[arry.length]=77;
       // System.arraycopy(arry,0,arry1,0,arry.length);
        arrayCopy(arry,arry1);
        for (int i=0;i< arry1.length;i++){
            System.out.print(" "+arry1[i]);
        }
    }
    public static void arrayCopy(int [] oldArray, int newArray[]) {
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
    }
}
