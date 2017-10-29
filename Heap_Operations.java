import java.io.*;
import java.util.*;
class Heap_Operations
{
	BufferedReader in;
	int Heap_size;
	public static void main(String[] args)  throws IOException{
		new Heap_Operations().run();
	}
	void run()throws IOException {
		in=new BufferedReader(new InputStreamReader(System.in));
		solve();
	}
	void solve() throws IOException {
		int n=Integer.parseInt(in.readLine());
		StringTokenizer st=new StringTokenizer(in.readLine());
		int a[]=new int[n+1];
		// must always be 1-index bcz 0 ka parent 0*2=0 so 1- index only
		for(int i=1;i<=n;i++)
			a[i]=Integer.parseInt(st.nextToken());
		Heap(a);
	}
	void Heap(int a[]) throws IOException {
		Heap_size=a.length;
		build_Max_Heap(a);
		for(int i=1;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
		//building heap is complete
		//lets sort the array
		System.out.println("Enter 1 to sort");
		System.out.println("Enter 2 to find max");
		System.out.println("Enter 3 to heap Extract Max");
		int ch=Integer.parseInt(in.readLine());
		switch(ch) 
		{
			case 1 : heapsort(a);
					 Heap_size=a.length;
						for(int i=1;i<a.length;i++)
							System.out.print(a[i]+" ");
					 break;
			case 2 : System.out.println("Max = " + find_max(a)); break;	
			case 3 : System.out.println("Extract_MAX : "+Extract_MAX(a)); break;
			case 4 :System.out.println("Enter index and Key");
					int index=Integer.parseInt(in.readLine());
					int key=Integer.parseInt(in.readLine()); 
					heap_increase_key(a,index,key);
					System.out.println("heap Increased And Updated "); break;
			default : break;
		}
		
	}
	void heap_increase_key(int a[],int i,int key) {
		if(key<a[i])
			System.out.println("new key less than original");
		else
		{
			a[i]=key;
			while(i>1 && a[parent(i)]<a[i])
				{
					swap(a,i,parent(i));
					i=parent(i);
				}
		}
	}
	int find_max(int a[]) {
		if(a.length>=2)
			return a[1];
		else
			System.out.println("Heap Empty ... ");
		return 0;
	}
	int Extract_MAX(int a[]) {
		int max=-1;
		if(a.length<2)
			System.out.println("Heap Underflow");
		else
		{
			max=a[1];
			a[1]=a[a.length-1];
			Heap_size-=1;
			heapify(a,1);
		}
		return max;
	}
	void heapsort(int a[]) {
		for(int i=a.length-1;i>=2;i--) {
			swap(a,i,1);
			Heap_size-=1;
			heapify(a,1);
		}
		for(int i=1;i<a.length;i++)
			System.out.println(a[i]);
	}
	void build_Max_Heap(int a[]) {
		for(int i=a.length/2;i>=1;i--) {
			heapify(a,i);
		}
	}
	void heapify(int a[],int i) {
		int left=left_child(i);
		int right=right_child(i);
		int largest=-1;
		if(left<Heap_size && a[left]>a[i])
			largest=left;
		else
			largest=i;
		if(right<Heap_size && a[right]>a[largest]) 
			largest=right;
		if(largest!=i) {
			swap(a,i,largest);
			heapify(a,largest);
		}
	}
	void swap(int a[],int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	int parent(int i) {
		return i/2;
	}
	int left_child(int i) {
		return 2*i;
	}
	int right_child(int i) {
		return 2*i+1;
	}
}
