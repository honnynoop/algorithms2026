import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] nums;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		nums=new int[N];
		 st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());;
		}
		//------------읽기
		max=-1;
		for (int i = 0; i <N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N ; k++) {
					int r=nums[i]+nums[j]+nums[k];
					if(r<=M) {
						max=Math.max(max,r);
					}
				}
			}
		}
		System.out.println(max);
	}

}