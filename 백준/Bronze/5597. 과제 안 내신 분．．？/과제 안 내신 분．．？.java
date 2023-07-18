import java.util.*;
import java.io.*;

public class Main {

	
	static int []arr;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr=new int[31];
		
		for(int i=0;i<28;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			arr[a]=1;
		}
		
		for(int i=1;i<=30;i++) {
			if(arr[i]==0) {
				System.out.println(i);
			}
		}
	}

}
