import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] nums;
	static int[] temps;
	static boolean[] b;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		nums=new int[N];
		temps=new int[N];
		b=new boolean[N];
		for (int i = 0; i < N; i++) {
			nums[i]=(i+1);
		}
		nPr(0);
	}

	private static void nPr(int cnt) {
		if(cnt==N) {
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(temps[i]+" ");
			}
			System.out.println(sb.toString());
			return ;
		}
		for (int i = 0; i < N; i++) {
			if(b[i]) continue;
			b[i]=true;
			temps[cnt]=nums[i];
			nPr(cnt+1);
			b[i]=false;
		}
	}

}
