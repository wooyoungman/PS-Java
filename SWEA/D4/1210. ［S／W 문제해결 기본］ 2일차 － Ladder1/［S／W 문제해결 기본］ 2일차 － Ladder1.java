import java.io.*;
import java.util.*;

public class Solution
{
 
    public static void main(String args[]) throws Exception
    {
         
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int ans = 0;
        int goal_x = 0 ,goal_y = 0;
         
        for(int i=0;i<10;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int [][]map = new int [100][100];
            // 100x100이라서 100번의 st 입력을 받아야함 
            for(int j=0;j<100;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<100;k++) {
                    map[k][j]=Integer.parseInt(st.nextToken());
                    if(map[k][j]==2) {
                        goal_x=k;
                        goal_y=j;
                    }
                }
            }
            while(true) {
                 
                // 도착 지점에서 좌 우 체크 후 상 체크
                if(goal_x>=1 && goal_x<=99 && map[goal_x-1][goal_y]==1) {
                    map[goal_x][goal_y]=0;
                    goal_x-=1;
                }
                else if(goal_x>=0 && goal_x<=98 && map[goal_x+1][goal_y]==1) {
                    map[goal_x][goal_y]=0;
                    goal_x+=1;
                }

                else {
                    map[goal_x][goal_y]=0;
                    goal_y-=1;
                }
                if(goal_y==0) {
                    ans=goal_x;
                    break;
                }
                }
             
            System.out.println("#"+t +" "+ans);
            ans=0;
            goal_x=0;
            goal_y=0;
        }
    }
}