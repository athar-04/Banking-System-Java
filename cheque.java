package BankingSystems;
import java.util.Calendar;
import java.util.Scanner;
public class cheque
{
    private static final String[] zeroToTeen = {"Zero ", "one ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    
    private static final String[] twentyToNinety = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static String ConvertToWords(int n)
    {
        if(n<=0||n>999999999)
            return "*** INVALID AMOUNT ***";
        String stg = null;
        String stg1 = null;
        String stg2 = null;
        String stg3 = null;
        if(n/10000000!=0)
        {
            stg=ConvertUpto99(n/10000000)+"Crore";
            n%=10000000;
        }
        if(n/100000!=0)
        {
            stg1=ConvertUpto99(n/100000)+"Lakh";
            if(stg!=null)
                stg=stg+" "+stg1;
            else
                stg=stg1;
            n%=100000;
        }
        if(n/1000!=0)
        {
            stg2=ConvertUpto99(n/1000);
            stg2=stg2+"Thousand";
            if(stg!=null)
                stg=stg+" " + stg2;
            else
                stg=stg2;
            n%=1000;
        }
        if(n%1000!=0)
        {
            stg3=ConvertUpto999(n%1000);
            if(stg!=null)
                stg=stg+" "+stg3;
            else
                stg=stg3;
        }
        return stg;
    }
    private static String ConvertUpto999(int n)
    {
        String stg1=zeroToTeen[n/100]+"Hundred";
        String stg2=ConvertUpto99(n%100);
        if(n<=99)
            return stg2;
        else if(n%100==0)
            return stg1;
        else
            return stg1+" "+stg2;
    }
    private static String ConvertUpto99(int n)
    {
        if(n<20)
            return zeroToTeen[n];
        String stg=twentyToNinety[n/10-2];
        if(n%10==0)
            return stg;
        return stg+" "+zeroToTeen[n%10];
    }
    public static void PrintCheque(int amount, String payee)
    {
        String amountInString;
        String amountInWords=ConvertToWords(amount);
        if(amountInWords.startsWith("***"))
            amountInString="*******";
        else
            amountInString=String.valueOf(amount);
        Calendar c = Calendar.getInstance();
        String strDate = c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR);
        String d="**************************************************************************************************";
        System.out.println("**************************************************************************************************");
        System.out.println("*           --------------                                              --------------           *");
        System.out.println("*           A/C Payee Only                Athar BANK LTD.               Non Negotiable           *");
        System.out.println("*           --------------                                              --------------           *");
        System.out.println("*                                                                       Date: "+strDate+"           *");
        System.out.print("*  Pay: "+payee);
        PrintSpaces(d.length()-payee.length()-9);
        System.out.println("*");
        System.out.print("*  Rupees "+amountInWords+"Only");
        PrintSpaces(d.length()-amountInWords.length()-15);
        System.out.println("*");
        System.out.println("*                                                                                                *");
        System.out.println("*                                                                 ----------------               *");
        System.out.print("*                                                                 "+amountInString+"/-");
        PrintSpaces(d.length()-amountInString.length()-69);
        System.out.println("*");
        System.out.println("*                                                                 ----------------               *");
        System.out.println("*    ------------------                                                                          *");
        System.out.println("*    A/C No. 7022135804                                                                          *");
        System.out.println("*    ------------------                                                                          *");
        System.out.println("*                                                                 --------------------           *");
        System.out.println("*  IFS Code  ABCX5O09YT                                           Authorised Signature           *");
        System.out.println("**************************************************************************************************");
    }
    private static void PrintSpaces(int n)
    {
        for(int i=1;i<=n;i++)
        {
            System.out.print(" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Cheque Amount: ");
        int amt=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Payee Name: ");
        String payee =sc.nextLine();
        System.out.println();
        PrintCheque(amt, payee.trim());
    }
}