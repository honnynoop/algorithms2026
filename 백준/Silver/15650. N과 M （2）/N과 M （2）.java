import java.util.Scanner;

public class Main {

	static int N, M;
	static int [] nums;

	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		nums=new int[M];
		perm(0,0);
		
	}

	static void perm(int cnt, int start) {
		if(cnt==M) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return ;
		}
		for (int i = start; i < N; i++) {
			nums[cnt]=(i+1);
			perm(cnt+1, i+1);
		}
	}

}