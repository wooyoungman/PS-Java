
import java.util.*;
import java.io.*;


public class Solution {

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		
		
		for(int i=1;i<=10;i++) {
			int ans=1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			for(int j=0;j<N;j++) {
				
				// st에는 현재 [정점번호, 연산자 혹은 숫자, 왼쪽 자식 번호, 오른쪽 자식 번호]
				st = new StringTokenizer(br.readLine());
				// 첫번째 원소 정점 번호 꺼내기 
				st.nextToken();
				// 두번째 원소 연산자 혹은 숫자 꺼내기
				char v = st.nextToken().charAt(0);
				// 만약 자식 노드 (왼쪽 자식 번호, 오른쪽 자식 번호)가 있다면 
				if(st.hasMoreTokens()) {
					// 자식 노드가 존재하는데 자신이 숫자라면 이는 오답임 
					if(v>='0'&&v<='9') {
						ans=0;
					}
				}
				// 만약 자식 노드 (왼쪽 자식 번호, 오른쪽 자식 번호)가 없다면
				else {
					// 연산자라면 오답임
					if(!(v>='0'&&v<='9')) {
						ans=0;
					}
				}
			}
			System.out.println("#"+i+" "+ans);
		}
	}

}
