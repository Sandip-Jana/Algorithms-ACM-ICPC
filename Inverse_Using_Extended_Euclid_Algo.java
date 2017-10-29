import java.io.*;
import java.util.*;
public class Inverse_Using_Extended_Euclid_Algo
{
	BufferedReader in;
	PrintWriter ob;
	StringTokenizer st;
	// find a*x =1 mod n
	// so x is multiplictaive inverse of a modulo n ; find such x...
	public static void main(String[] args) throws IOException {
		new Inverse_Using_Extended_Euclid_Algo().run();
	}	
	void run() throws IOException {
		in=new BufferedReader(new InputStreamReader(System.in));
		ob=new PrintWriter(System.out);
		solve();
		ob.flush();
	}
	void solve() throws IOException {
		int a=ni();
		int n=ni();
		Triplet p=extended_euclid(a,n,0,0);
		ob.println(p.x+" "+p.y+" "+p.z);
		int x=(p.x/p.z)%n; //  or directly write as inverse = (p.x%n+n)%n;
		ob.println("Multiplictaive inverse = " + (n+x)%n);
	}
	Triplet extended_euclid(int a,int b,int x ,int y) {
		if(b==0) {
			x=1;
			y=0;
			return new Triplet(x,y,a);
		}
		int x1=0, y1=0;
		Triplet p=extended_euclid( b , a%b , x1, y1 ); // gcd( b , a%b) = b*x + (a- (a/b)*b)*y = a*y + b*(x-(a/b)*y);
		x=p.y;
		y=p.x-((a/b)*p.y);
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
