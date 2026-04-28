import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    static int M=3;
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[]paint;
    static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[N+1][M];
		map=new int[N+1][M];
		paint=new int[M];
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			map[i][0]=Integer.parseInt(st.nextToken());
			map[i][1]=Integer.parseInt(st.nextToken());
			map[i][2]=Integer.parseInt(st.nextToken());
		}
		answer = Integer.MAX_VALUE/10000;
		for (int k = 0; k < 3; k++) {
			Arrays.fill(dp[0], Integer.MAX_VALUE/10000);
			dp[0][k] = map[0][k];
			for (int i = 1; i <N; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
			}
			for (int i = 0; i <3; i++) {
				if(i!=k) {
					answer=Math.min(answer,  dp[N-1][i]);
				}
			}
		}
		System.out.println(answer);		
	}
	
}