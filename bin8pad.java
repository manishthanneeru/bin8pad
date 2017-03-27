import java.lang.*;
import java.io.*;
public class bin8pad
{
public static void main(String [] args)
{
BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));   //reads input from user
try {
    String x= sc.readLine();
    String bytecodes=bin(x);                                            //calls bin function that pads the 0's
    System.out.println("The resultant String is:" +bytecodes);
} 
catch (IOException e) 
{
   e.printStackTrace(); //handle exception
}
}
public static String bin(String ip)
{
    String sel=ip;
    int l=0;
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the length of binary variable you want");
    try{
    l=Integer.parseInt(sc.readLine());
} 
catch(IOException e){
    e.printStackTrace();
}
        if(sel.length()<l){
            int tmp=sel.length();
            while(l-tmp>0)
            {
                sel="0"+sel;
                tmp++;
            }   
        }
        else if(sel.length()>l)
        {
          System.err.println("Given Binary out of Bounds");
        }
       return sel;
    }
    
}

