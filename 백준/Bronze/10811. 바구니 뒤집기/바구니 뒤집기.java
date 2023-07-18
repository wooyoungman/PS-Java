
import java.util.*;
import java.io.*;

public class Main {

	
	static int []arr;
	
	static void swap(int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=i;
		}
		
		
		for(int i =0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			while(x<y) {
				swap(x,y);
				x++;
				y--;
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
