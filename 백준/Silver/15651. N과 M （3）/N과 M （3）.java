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
		perm(0);
		System.out.print(sb.toString());
	}

	static void perm(int cnt) {
		if(cnt==M) {
			//StringBuilder sb=new StringBuilder();
			for (int i = 0; i < nums.length; i++) {
				//System.out.print(nums[i]+" ");
				sb.append(nums[i]+" ");
			}
			sb.append("\n");
			//System.out.println(sb.toString());
			return ;
		}
		for (int i = 0; i < N; i++) {
			//if(visited[i]) continue;
			visited[i]=true;
			nums[cnt]=(i+1);
			perm(cnt+1);
			nums[cnt]=(0);
			visited[i]=false;
		}
	}

}