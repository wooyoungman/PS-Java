
import java.util.*;
import java.io.*;
public class Solution {

	static List<Integer>[] list;
	static int T,N,M;
	static boolean[] check;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 테스트 케이스 수
		T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++)
		{
			st = new StringTokenizer(br.readLine());
			
			// N과 M 입력 받기 
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			
			
			list = new ArrayList[N+1];
			check= new boolean[N+1];
			
			for (int i = 1; i <= N; i++)
			{
				list[i] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			bfs(1);
			System.out.println("#"+t+" "+cnt);	
			cnt=0;
		}
	}
	private static void bfs(int i) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		check[i]=true;
		int turn = 0;
		while(!queue.isEmpty()) {
			// 턴 마다 큐에 담긴 모든 원소들에 대해서 탐색 (2회전까지)
			int size = queue.size();
			for(int s=0;s<size;s++)
			{	
				int cur = queue.poll();
				for(int temp : list[cur]) {
					if(!check[temp]) {
						cnt++;
						check[temp]=true;
						queue.add(temp);
					}
				}
			}
			turn++;
			if(turn==2) {
				break;
			}
		}

	}
}