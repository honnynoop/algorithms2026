import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,K;
    static int [][] dp;
    static int []w, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
		dp=new int[N+1][K+1];
		w=new int[N+1];
		v=new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
		}
	
		
		for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
            	// i번째 무게를 더 담을 수 없는 경우 
        		if(w[i] > j) {
        			dp[i][j] = dp[i - 1][j];
        		}
        		// i번째 무게를 더 담을 수 있는 경우 
        		else {
        			dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
        		}
            }
        }
        
        System.out.println(dp[N][K]);
	}

}