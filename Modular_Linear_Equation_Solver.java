import java.io.*;
import java.util.*;
public class Modular_Linear_Equation_Solver // solve a * x =  (b mod n) : solve for x
{
	BufferedReader in;
	PrintWriter ob;
	StringTokenizer st;
	// a*x + n*y = b 
	// a*x = b (mod n) 
	// solve for x 
	// there are only d distinct values of x such that d=gcd(a,n) from 0  to d-1;
	public static void main(String[] args) throws IOException {
		new Modular_Linear_Equation_Solver().run();
	}
	void run() throws IOException {
		in=new BufferedReader(new InputStreamReader(System.in));
		ob=new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	void solve() throws IOException {
		int a=ni();
		int b=ni();
		int n=ni();
		Triplet p = extended_euclid(a , n , 0 , 0);
		ob.println(p.x+" "+p.y+" "+p.z);
		int gcd=p.z;
		if(b%gcd==0) {
			int x=(p.x*(b/gcd))%n;
			for(int i=0 ; i<=gcd-1 ; i++) {
				ob.print(((n+x+(i*(n/gcd)))%n)+ " ");
			}
			ob.println();
		}
		else
			ob.println("No Solution Exists");
	}
	Triplet extended_euclid(int a, int b, int x , int y) {
		if(b==0) {
			x=1;
			y=0;
			return new Triplet(x,y,a);
		}
		int x1=0, y1=0;
		Triplet p = extended_euclid( b , a%b , x1 , y1 ); // gcd( b , a%b ) = b*x + (a-(a/b)*b)*y = a*y + b*(x - (a/b) * y);
		x=p.y;
		y=p.x-((a/b)*(p.y));
		return new Triplet(x,y,p.z);
	}
	int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}
	String nextToken() throws IOException {
		if(st==null || !st.hasMoreTokens())
			st=new StringTokenizer(in.readLine());
		return st.nextToken();
	}
}
class Triplet
{
	int x,y,z;
	public Triplet(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
