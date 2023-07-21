
import java.io.*;
import java.util.*;

public class Main {

	
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n=input.nextInt();
		String s = "1";
		dfs(s);
	}
	private static void dfs(String s) {
		// TODO Auto-generated method stub
		if(s.length()==n) {
			System.out.println(s);
			System.exit(0);
		}
		// 좋은 수열인지 체크해야한다. (원소는 1,2,3 세개로 진행)
		for(int i=1;i<=3;i++) {
			if(isgood(s+i))
			{
				dfs(s+i);
			}
		}
	}
	private static boolean isgood(String s) {
		// TODO Auto-generated method stub
		int l= s.length();
		int m=l/2;
		// 1부터 n/2까지의 부분수열에 대해서 확인을 해야한다. 
		for(int i=1;i<=m;i++) {
			int k = i*2;
			for(int j=0;j+k<=l;j++) {
				// (0,1) (1,2) / (1,2) (2,3)... 비교
				String a = s.substring(j,i+j);
				String b = s.substring(i+j,k+j);
				if(a.equals(b)) {
					
					// 두 부분 문자열 (수열)이 같다면 나쁜 수열
					return false;
				}
			}
		}
		return true;
		
	}

}
