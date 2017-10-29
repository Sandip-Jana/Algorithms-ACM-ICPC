import java.util.*;
import java.lang.*;
import java.io.*;
class IterativePermutations
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		printPermutationsIterative("aabbc");
	}
	private static void printPermutationsIterative(String string){
        int [] factorials = new int[string.length()+1];
        factorials[0] = 1;
        for (int i = 1; i<=string.length();i++) {
            factorials[i] = factorials[i-1] * i;
        }
		int cnt=0;
        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation="";
            String temp = string;
            int positionCode = i;
            for (int position = string.length(); position > 0 ;position--){
                int selected = positionCode / factorials[position-1];
                onePermutation += temp.charAt(selected);
                positionCode = positionCode % factorials[position-1];
                temp = temp.substring(0,selected) + temp.substring(selected+1);
            }
            cnt+=1;
            System.out.println(cnt+" "+onePermutation);
        }
    }
}
