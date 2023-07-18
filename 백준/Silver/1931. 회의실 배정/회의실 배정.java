
import java.util.*;
import java.io.*;

public class Main {

	
	static int [][]arr;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		// 시작 시간과 종료 시간을 저장할 2차원 배열 선언
		arr = new int[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			// (i,0)에 시작시간, (i,1)에 종료시간 저장
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		// 종료시간 순으로 배열 정렬
		Arrays.sort(arr,new Comparator<int[]>(){
			@Override
			public int compare(int[] S, int[] E) {
				// return값이 -1이면 left가 왼쪽
				// return값이 0이면 left와 right가 같음
				// return값이 1이면 left가 오른쪽 
				if(S[1]==E[1]) {// 종료 시간이 같을 때
					return S[0]-E[0]; // 시작 시간이 더 큰값이 뒤로
				}
				return S[1]-E[1]; // 종료 시간이 큰값이 뒤로
			}
		});
		int cnt=0;
		int end=-1;
		for(int i=0;i<n;i++) {
			if(arr[i][0]>=end) {
				end=arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}










