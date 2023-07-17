import java.util.*;
import java.io.*;

// 우선 이 문제는 구간 합 (S[j] - S[i-1])을 M으로 나눈 나머지가 0인 (i,j)의 값을 구해야한다.
// 수학적으로 정리를 해보면 다음과 같다.
// 1. (S[j] - S[i-1]) % M = 0
// 2. (S[j] % M) - (S[i-1] % M) = 0
// 3. (S[j] % M) = (S[i-1] % M)
// 이 수식을 통해 나머지 값이 같은 인덱스 중 2개를 뽑는 경우의수를 추가로 더해주면 해결되지 않을까?


public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력으로 받을 N개의 수, M으로 나누어 떨어지는 수 선언
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		// 구간 합 배열 생성
		long[] S = new long[N+1];
		st = new StringTokenizer(br.readLine());
		
		// 예제 1 2 3 1 2 입력, M = 3
		// S[1] = 1, S[1] % 3 = 1
		// S[2] = 3, S[2] % 3 = 0
		// S[3] = 6, S[3] % 3 = 0
		// S[4] = 7, S[4] % 3 = 1
		// S[5] = 9, S[5] % 3 = 0
		// 에서 나머지를 저장할 배열 r를 선언 하고 r의 인덱스를 나머지(0,1,2)로 설정하여 ++ 해준다.
		for(int i=1;i<=N;i++) {
			S[i]=S[i-1]+Long.parseLong(st.nextToken());
		}
		
		// 나머지를 인덱스로하며 개수를 저장할 배열 r 선언
		// 정답 도출을 위한 변수 cnt 선언 
		long[] r = new long[M];
		long  cnt = 0;
		
		// (구간 합) % (M) 배열 갱신
		for(int i = 1; i<=N; i++) {
			// 첫 구간 합 배열에서 M으로 나누어 떨어지는 구간 합이 있을 경우 cnt 증가 
			long remain = S[i]%M;
			if(remain==0) {
				cnt++;
			}
			
			// 나머지를 r의 인덱스로 받아서 저장 
			r[(int)(remain)]++;
		}
		
		for(int i = 0; i < M; i ++) {
			// r 배열이 갖는 값은 해당 나머지 숫자의 개수를 뜻한다.
			// 따라서 r 배열의 값 중에서 2개를 선택하는 수식 (조합)
			// r[i]C2 = ( (r[i] x (r[i]-1) ) / 2 을 추가로 계산하여 cnt를 증가시킨다.
			if(r[i]>1) {
				cnt+=(r[i]*(r[i]-1)/2);
			}
		}
		System.out.println(cnt);
	}

}
