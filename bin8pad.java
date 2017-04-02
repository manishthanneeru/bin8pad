import java.lang.*;
import java.io.*;
import org.apache.commons.codec.binary.Base64;
public class bin8pad
{
public static void main(String [] args)
{
final long startTime = System.nanoTime();
//BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));   //reads input from user
//try {
    String x="1011111";
    String bytecodes=encoder(x);                                            //calls for key code gen
    bytecodes=xoring(bytecodes,bin(x,bytecodes));                          //xor's input data and key(bytecodes)
    bytecodes=div_func(bytecodes);
    byte[] hehe=bytecodes.getBytes();
    System.out.println("The resultant String is:" +Base64.encodeBase64String(hehe));
//} 
/*catch (IOException e) 
{
   e.printStackTrace();                                                       //handle exception
}*/
double duration =System.nanoTime() - startTime;
System.out.println(duration);
}
public static String bin(String ip, String ip2)                           //equals length of two binary strings String1<string2
{
    String sel=ip;
    int l=ip2.length();
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
    public static String encoder(String ip) {                                   //generates key from server
       int pi_val=6844;
       String dna_bin="11110100";
       String pi_bin=Integer.toBinaryString(pi_val);
       dna_bin=complement(dna_bin);
       dna_bin=bin(dna_bin,pi_bin); 
     String s= xoring(dna_bin,pi_bin);
   return s;
 }
 public static String complement(String ip){                                   //complements binary string values
     char[] s=ip.toCharArray();

     for(int i=0; i<s.length;i++){
         if(s[i]=='1'){
             s[i]='0';
         }
         else if(s[i]=='0'){
             s[i]='1';
         }        
     }
      String ip1= new String(s);
     return ip1;
         }
         public static String xoring(String ip, String ip1){                 //xor's two binary strings
             StringBuilder sb= new StringBuilder();
             for(int i=0;i<ip.length();i++){
                 sb.append(ip.charAt(i)^ip1.charAt(i));
             }
             return sb.toString();
         }
         public static String div_func(String ip) {
           int l=ip.length();
           StringBuilder sb=new StringBuilder();
         for(int i=0;i<l/2;i++){
          sb.append(ip.charAt(i)^ip.charAt(i+l/2));
         }  
         ip=ip+sb.toString();

         l=ip.length();
         int m=l/3;
         System.out.println(l+"  "+ip);
        for(int i=0;i<m;i++){
             sb.append(ip.charAt(i)^ip.charAt(1+i+2*m));
         }
         for(int i=0;i<m;i++){
             sb.append(ip.charAt(i+m)^ip.charAt(1+i+2*m));
         }
         String ip1=ip;
         ip=sb.toString()+ip1.substring(2*m,l); 
     
     return ip;  
     }
        
     }


