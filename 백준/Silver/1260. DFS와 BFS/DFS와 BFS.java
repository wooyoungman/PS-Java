
import java.io.*;
import java.util.*;

public class Main {

	static int N,M,V;
	static ArrayList<Integer>[] arr;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N과 M 입력 받기 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		visited = new boolean[N+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
			
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(arr[i]);
		}
		
		dfs(V);
		visited = new boolean[N+1];
		System.out.println();
		bfs(V);
	}

	private static void bfs(int i) {
		// TODO Auto-generated method stub
		Queue<Integer>queue=new LinkedList<>();
		visited[i]=true;
		queue.add(i);
		while(!queue.isEmpty()) {
			int cur=queue.poll();
			System.out.print(cur+" ");
			for(int a : arr[cur]) {
				if(!visited[a]) {
					visited[a]=true;
					queue.add(a);
				}
			}
		}
	}

	private static void dfs(int i) {
		// TODO Auto-generated method stub
		
		if(visited[i]) {
			return;
		}
		visited[i]=true;
		System.out.print(i+" ");
		for(int a:arr[i]) {
			if(!visited[a]) {
				dfs(a);
			}
		}
	}
	

}
