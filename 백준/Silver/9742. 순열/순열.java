import java.io.*;
import java.util.*;
public class Main {

	static char[] arr;
	static int m;
	static char[] ans;
	static boolean[] check;
	static int cnt;
	static boolean find_ans;
	static String s1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while((line=br.readLine())!=null) {
		StringTokenizer st = new StringTokenizer(line);
		s1 = st.nextToken();

				
		arr=s1.toCharArray();
		m=Integer.parseInt(st.nextToken());
		check = new boolean[arr.length];
		ans = new char[arr.length];
		find_ans=false;
		cnt=0;
		
		recur(0);
		
		if(!find_ans) {
			System.out.println(s1+" "+ m+ " = "+"No permutation");
		}
		}
	}


	private static void recur(int depth) {
		// TODO Auto-generated method stub
		
		// 종료조건 깊이와 길이가 같을 때
		if(depth==arr.length) {
			cnt++;
			if(cnt==m) {
				PrintAns();
				find_ans=true;
			}
			return ;
		}
		
		// 처리코드
		for(int i=0;i<arr.length;i++) {
			if(!check[i]) {
				ans[depth]=arr[i];
				check[i]=true;
				recur(depth+1);
				check[i]=false;
			}
		}
		
	}


	private static void PrintAns() {
		// TODO Auto-generated method stub
		System.out.print(s1+" "+m+" = ");
		for(char i: ans) {
			System.out.print(i);
		}
		System.out.println();
	}

}
