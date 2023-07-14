
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N;
		int []arr1;
		int []arr2;
		int ans= 1000000000;
		
		Scanner sc= new Scanner(System.in);
		
		N=sc.nextInt();
		
		arr1= new int [N];
		arr2= new int [N];
		
		for(int i=0;i<N;i++) {
			arr1[i]=sc.nextInt();
			arr2[i]=sc.nextInt();
		}
		
		
		// 0001부터 2^n -1 (1111)까지 .. n자리수
		for(int i=1;i<(1<<N);i++) { // 최대 n-1칸 왼쪽으로 시프트
			int a=1, b=0;
			for(int x= 0;x<N;x++) {
				if((i&1<<x)>0) {
					a*=arr1[x];
					b+=arr2[x];
				}
			}
			ans=Math.min(ans, Math.abs(a-b));
		}
		System.out.println(ans);
	}

}
