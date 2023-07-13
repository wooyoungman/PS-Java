
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int N,Q;
		long []F=new long[21];
		int []S=new int[21];
		boolean visited[] = new boolean[21];
		BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		Q=Integer.parseInt(st.nextToken());
		F[0]=1;
		
		// 팩토리얼 배열 채우기
		for(int i=1;i<=N;i++) {
			F[i]=F[i-1]*i;
		}
		
		if(Q==1) {
			long K =Long.parseLong(st.nextToken());
			for(int i=1;i<=N;i++) {
				for(int j=1,cnt=1;j<=N;j++) {
					if(visited[j]) {
						continue; // 이미 사용한 숫자는 사용 불가
					}
					if(K<=cnt*F[N-i]) {
						// 주어진 k에 따라 각 자리에 들어갈 수 있는 수 찾기
						K-=((cnt-1)*F[N-i]);
						S[i]=j;
						visited[j]=true;
						break;
					}
					cnt++;
				}
			}
			for(int i=1;i<=N;i++) {
				System.out.print(S[i]+" ");
			}
		}
		else
		{
			long K = 1;
			for(int i=1;i<=N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
				long cnt=0;
				for(int j=1;j<S[i];j++) {
					if(!visited[j]) {
						cnt++; // 미사용 숫자 개수 만큼 카운트
					}
				}
				K+=cnt*F[N-i]; // 자릿수에 따라 순서 더하기
				visited[S[i]]=true;
			}
			System.out.println(K);
		}
	}
}
