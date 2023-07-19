import java.util.Scanner;

public class Main {
    static int answer;
    static int N;
    static int[] col;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        answer = 0;
        N=in.nextInt();
        col=new int[N+1];    // 0번 행을 제외하고 작업하기 위해 1을 더한다.각 행에 하나씩만 배치할 수 있기 때문에 1차원, col[i]번째방에 여왕을 배치할 열값을 저장한다.
        setQueens(1);        // 1행부터 시도
        System.out.println(answer);

    }

    public static void setQueens(int rowNo){
 
        if(rowNo>N) {     // 시도하려는 rowNo행번호가 N보다 크면 말판끝까지 다 놓은 경우
            answer++;
            return;
        }
        for(int j=1; j<=N;j++){    // 해당 행의 1열부터 n열까지 퀸 놓는 시도
            col[rowNo]=j; 
            if(checking(rowNo)){ 
                setQueens(rowNo+1); 
            }
        }
    }

    // rowNo행에 퀸을 놓을수 있는지 1행부터 기존 rowNo-1행까지 rowNo행와 비교하며 체크
    public static boolean checking(int rowNo){
        for(int k=1; k<rowNo; k++){
        	// 같은 열에 놓여있거나, (행1-행2)와(열1-열2)의 값이 같으면 대각선 이므로 불가.
        	if(col[rowNo] == col[k] || Math.abs(col[rowNo]-col[k]) == rowNo-k){
                return false;
            }
        }
        return true;
    }
}