import java.math.*;
import java.io.*;
import java.util.*;
class KMPFunction
{
	StringTokenizer st;
	BufferedReader in;
	PrintWriter ob;
	public static void main(String args[])throws IOException {
		new KMPFunction().run();
	}
	void run()throws IOException   {
		//in=new BufferedReader(new FileReader("input.txt"));
		//ob=new PrintWriter("output.txt");
		in=new BufferedReader(new InputStreamReader(System.in));
		ob=new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	void solve()throws IOException {
		read();
		char s[]=ns().toCharArray();
		int l=s.length;
		int f[]=new int[l];   // sandip's built kmp function
		int index=0;
		f[0]=0;
		for(int i=0;i<l;){
				if(s[i]==s[index]){
					f[i]=index+1;
					index+=1;
					i++;
				}
				else{
					if(index!=0){
						index=f[index-1];
					}
					else
					{
						f[i]=0;
						i++;
					}
				}
		}
		for(int i=0;i<l;i++)
			ob.print(f[i]+" ");
		ob.println();
	}
	void read()throws IOException  {
		st=new StringTokenizer(in.readLine());
	}
	int ni(){
		return Integer.parseInt(st.nextToken());
	}
	long nl(){
		return Long.parseLong(st.nextToken());
	}
	double nd(){
		return Double.parseDouble(st.nextToken());
	}
	String ns(){
		return st.nextToken();
	}
	char nc(){
		return st.nextToken().charAt(0);
	}
	int[] nia(int n)throws IOException {
		int a[]=new int[n];
		read();
		for(int i=0;i<n;i++){
			a[i]=Integer.parseInt(st.nextToken());
		}
		return a;
	}
	long[] nla(int n)throws IOException {
		long a[]=new long[n];
		read();
		for(int i=0;i<n;i++){
			a[i]=Long.parseLong(st.nextToken());
		}
		return a;
	}
}
