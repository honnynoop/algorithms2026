import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dp, su, result;
    static int sum;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
		dp=new int[N];
		su=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			su[i]=Integer.parseInt(st.nextToken());
		}
		dp[0] = su[0];
		max = su[0];
		
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + su[i], su[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
 
	}

}