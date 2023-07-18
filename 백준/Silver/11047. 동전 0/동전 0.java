
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

		int temp_idx=n-1;
		int cnt=0;
		arr= new int[n+1]; // 동전 종류  
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); // 동전 값
			arr[i]=v;
		}
		
		while(m>0) {
			
			if(m/arr[temp_idx]!=0) {
				cnt+=m/arr[temp_idx];
				m%=arr[temp_idx];
			}
			temp_idx--;
			
		}
		System.out.println(cnt);
	}

}
