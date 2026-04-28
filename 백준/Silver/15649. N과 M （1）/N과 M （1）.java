import java.util.Scanner;

public class Main {

	static int N, M;
	static int [] p;
	static int [] nums;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		p=new int[N];
		nums=new int[M];
		visited=new boolean[N];
		perm(0);
		
	}

	static void perm(int cnt) {
		if(cnt==M) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return ;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			nums[cnt]=(i+1);
			perm(cnt+1);
			nums[cnt]=(0);
			visited[i]=false;
		}
	}

}