import java.util.*;
import java.io.*;
public class Main {

	
	static int [] cnt;
	// ArrayList배열
	static List<Integer>[] list;
	static int N;
	static int M;
	static boolean [] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		cnt = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		int max = 0;
		
		// 리스트의 배열을 선언하기 
		// 문제 조건에서 1 -> 3인 경우 1 해킹 시 1개, 3 해킹 시 2개의 컴퓨터를 해킹한다.
		
		for(int i = 1; i<=N; i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			
		}
		
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			bfs(i);
		}
		
		for(int i=1;i<=N;i++) {
			if(max<cnt[i]) {
				max=cnt[i];
			}
		}
		for(int i=1;i<=N;i++) {
			if(max==cnt[i]) {
				System.out.print(i+" ");
			}
		}
	}

	// 노드 하나씩 탐색
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node]=true;
		
		// 큐에 노드를 넣고 이 노드에 연결된 ArrayList들을 모두 검색
		while(!queue.isEmpty()) {
			node=queue.poll();
			// 1~N까지의 노드에 연결된 ArrayList 탐색
			for(int next : list[node]) {
				if(!visited[next]) {
					// 연결이 되어 있으면 해당 값을 인덱스로 하는 cnt 배열 +1
					cnt[next]++;
					visited[next]=true;
					queue.add(next);
					
				}
			}
		}
	}

}
