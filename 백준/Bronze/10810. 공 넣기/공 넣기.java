
import java.util.*;
import java.io.*;

public class Main {

	
	static int []arr;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr= new int[n+1]; // 바구니 개수  
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int j=a;j<=b;j++) {
				arr[j]=c;
			}
		}
		for(int i = 1;i<=n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
