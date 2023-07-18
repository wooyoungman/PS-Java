
import java.util.*;
import java.io.*;

public class Main {

	
	static int []arr;
	static boolean find;
	static int n;
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			
		}

		Arrays.sort(arr);
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			int a =Integer.parseInt(st.nextToken());
			
			binsearch(0, a, n-1);
			
			if(find) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
			find=false;
	}

}

	static void binsearch(int left, int v, int right) {
		
		
		while(true) {
			int mid = (left+right)/2;
			if(arr[mid]==v) {
				find=true;
				break;
			}
			else if(arr[mid]>v) {
				right=mid-1;
			}
			else if(arr[mid]<v)
			{
				left=mid+1;
			}
			if(left>right || right<left) {
				break;
			}
			
		}
		return;
	}
	
	
}
	