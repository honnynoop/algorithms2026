import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] sums;
	static int N,M;
	static int I,J;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		sums=new int[N+1];
		st=new StringTokenizer(br.readLine());
		// 받는 변수도 제거하자.
		for (int i = 1; i < N+1; i++) {
			sums[i]=sums[i-1]+Integer.parseInt(st.nextToken());
			// 읽으면서 구해 놓는다. tabulation
		}
		//------------------I
		//------------------------------J
	    // I~J까지의 합 입력받은 후 다시 계산 하려면 시간이 걸린다. 
		// 읽으면서 합을 구하면 한번에 계산할 수 있다. sum[J]-sum[I]하면
        // I 다음 부터가 되기 때문에 nums[I]를 더해준다. 
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			I=Integer.parseInt(st.nextToken());
			J=Integer.parseInt(st.nextToken());
			//System.out.println(sums[J]-sums[I]+nums[I]);
			sb.append(sums[J]-sums[I-1]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
