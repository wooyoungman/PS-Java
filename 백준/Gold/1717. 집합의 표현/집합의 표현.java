
import java.util.*;
import java.io.*;
public class Main {

	static int[] par;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		par = new int[N+1];
		
		for (int i=0; i <= N; i++)
		{
			par[i]=i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(q==0) {
				union(a,b);
			}
			else
			{
				if(checkSame(a,b)) {
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}

	}
	public static void union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			par[b]=a;
		}
	}
	
	public static int find(int a) {
		if(a==par[a]) {
			return a;
		}
		else
		{
			return par[a]=find(par[a]);
		}
	}
	public static boolean checkSame(int a,int b) {
		a=find(a);
		b=find(b);
		if(a==b) {
			return true;
		}
		return false;
	}
}
