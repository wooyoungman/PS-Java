
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());


		// 구간 합 배열 생성
		long[] S = new long[N+1];
		st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			S[i] = S[i-1] + Long.parseLong(st.nextToken());
		}
		
		long[] C = new long[M];
		long cnt = 0;
		// 구간 합 % M 배열 갱신
		for(int i=1; i<N+1; i++){
			long remain = S[i]%M;
			if(remain == 0)
				cnt++;

			// 나머지를 C의 인덱스로 받아서 저장 ( 차후 작업 )
			C[(int)(remain)]++;
		}
		
		for(int i=0; i<M; i++){
			if(C[i] > 1){

				cnt += (C[i]*(C[i]-1))/2;
			}


		}
		System.out.println(cnt);
	}
}
