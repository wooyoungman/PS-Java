
import java.util.*;
import java.io.*;
public class Main {

	static int [][] map;
	static int N,M;
	static boolean[][] check;
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N+1][M+1];
		check = new boolean [N+1][M+1];
		for (int i=1; i <= N; i++)
		{
			String s = br.readLine();
			
			
			for(int j=1;j<=M;j++)
			{
				map[i][j]=s.charAt(j-1)-'0';
				//System.out.println(map[i][j]);
			}
		}

		bfs(1,1);
		System.out.println(map[N][M]);
	}
	private static void bfs(int _x, int _y) {
		Queue<int[]>queue=new LinkedList<>();
		queue.offer(new int[] {_x,_y}); // 큐에 배열 넣을 때 이런 형식임!
		check[_x][_y]=true;
		while(!queue.isEmpty()) {
			int cur[]=queue.poll();
			for(int i=0;i<4;i++) {
				int cur_x=cur[0]+dx[i];
				int cur_y=cur[1]+dy[i];
				if(cur_x>=1&&cur_x<=N && cur_y>=1&&cur_y<=M &&
						check[cur_x][cur_y]==false && map[cur_x][cur_y]!=0) {
					queue.offer(new int[] {cur_x,cur_y});
					check[cur_x][cur_y]=true;
					map[cur_x][cur_y]=map[cur[0]][cur[1]] + 1;
				}
			}
		}
		
	}
}
