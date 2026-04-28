
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] weight;
	static boolean[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		dp = new boolean[N+1][40001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			weight[i] = x;
		}
		
		solve(0,0);
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(dp[N][x]) sb.append("Y ");
			else sb.append("N ");
		}
		System.out.println(sb);
	}

	private static void solve(int cnt, int total) {
		
		if(dp[cnt][total]) return;
		dp[cnt][total] = true;
		if(cnt==N) return;
		
		solve(cnt+1, total + weight[cnt]); // 추를 구슬 반대편에 올리는 경우
		solve(cnt+1, total); // 추를 올리지 않는 경우
		solve(cnt+1, Math.abs(total - weight[cnt])); // 추를 구슬쪽에 올리는 경우
	}
}
