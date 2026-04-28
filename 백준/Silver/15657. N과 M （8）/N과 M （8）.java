import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int [] p;
	static int [] nums;
	static boolean[] visited;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		p=new int[N];
		nums=new int[M];
		visited=new boolean[N];
		for (int i = 0; i < N; i++) {
			p[i]=scann.nextInt();
		}
		Arrays.sort(p);
		perm(0);
		System.out.println(sb.toString());
	}

	static void perm(int cnt) {
		if(cnt==M) {
			for (int i = 0; i < nums.length; i++) {
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			return ;
		}
		for (int i = 0; i < N; i++) {
			
			visited[i]=true;
			nums[cnt]=p[i];
			if(cnt>0 && nums[cnt-1]>nums[cnt]) continue;
			perm(cnt+1);
			visited[i]=false;
		}
	}

}