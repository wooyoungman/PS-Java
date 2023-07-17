
import java.util.*;
import java.io.*;


public class Solution {

	
	static class Node{
		int value; // 노드 값
		char opr; // 노드 연산자
		int left,right; // 자식 노드 번호
		
		// 생성자 오버라이딩 2개 (연산자 있는 경우 없는 경우)
		public Node(int value, char opr, int left, int right) {
			super();
			// value와 opr은 서로 베타적이다. 공존하지 못함!
			this.value = value;
			this.opr = opr;
			this.left = left;
			this.right = right;
		}
		public Node(int value) {
			super();
			this.value = value;
		}

	}
	
	static int N; // 노드 개수
	static Node[] nodes;
	

	private static int calc(Node node) {
		// 연산자 추출
		
//		if(node==null) {
//			return 0;
//		}
		
		char opr = node.opr;		
		if(opr == '-') {
			return calc(nodes[node.left]) - calc(nodes[node.right]);
		}
		else if(opr == '+') {
			return calc(nodes[node.left]) + calc(nodes[node.right]);
			}
		else if(opr == '/') {
			return calc(nodes[node.left]) / calc(nodes[node.right]);
		}
		else if(opr == '*') {
			return calc(nodes[node.left]) * calc(nodes[node.right]);
		}
		else {
			return node.value;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		for(int i=1;i<=10;i++) {
			int ans=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			nodes = new Node[N+1];
			for(int j=1;j<=N;j++) {
				
				
				// st에는 현재 [정점번호, 연산자, 왼쪽 자식 번호, 오른쪽 자식 번호] 혹은 [정점번호, 숫자]
				st = new StringTokenizer(br.readLine());
				
				// 입력 토큰 개수 판별
				
				// 연산자인 경우
				if(st.countTokens()==4) {
					
					// 정점 번호는 제거하기
					st.nextToken();
					
					char c = st.nextToken().charAt(0);
					int left_v = Integer.parseInt(st.nextToken());
					int right_v = Integer.parseInt(st.nextToken());
					
					nodes[j]= new Node(0,c,left_v,right_v);
					
				}
				
				// 값인 경우
				else {
					
					// 정점 번호는 제거하기
					st.nextToken();
					nodes[j]= new Node(Integer.parseInt(st.nextToken()));
				}
							
			}
			ans=calc(nodes[1]);
			System.out.println("#"+i+" "+ans);
		}
	}

}
