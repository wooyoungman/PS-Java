
import java.util.*;
import java.io.*;

public class Main {

	
	static int []arr;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		
		// 안되는 경우는 단 두가지
		if (N == 4 || N == 7) {
			System.out.println(-1);
		}
		// 5의 배수
		else if (N % 5 == 0) {
			System.out.println(N / 5);
		}
		// 5의 배수 + 1 혹은 5의 배수 + 3 -> (6,8)은 (3*2), (5*1)+(3*1)
		else if (N % 5 == 1 || N % 5 == 3) {
			System.out.println((N / 5) + 1);
		}
		// 5의 배수 + 2 혹은 5의 배수 + 4 -> (12,14)은 (3*4)인데 이는 5*2+2이므로 N은 2에서 2+2
		else if (N % 5 == 2 || N % 5 == 4) {
			System.out.println((N / 5) + 2);
		}

	}

}
