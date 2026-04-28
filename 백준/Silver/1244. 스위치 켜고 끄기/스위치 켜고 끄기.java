import java.util.Scanner;

public class Main {
	static int[] nums;
	static int N;
	static int S;
	static int[][] stus;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		nums=new int[N+1];
		for (int i = 1; i < N+1; i++) {
			nums[i]=scann.nextInt();
		}
		S=scann.nextInt();
		stus=new int[S+1][2];
		for (int i = 1; i < S+1; i++) {
			stus[i][0]=scann.nextInt();
			stus[i][1]=scann.nextInt();
		}
		// 읽기 끝
		for (int i = 1; i < S+1; i++) {
			if(stus[i][0]==1) {  //남자
				goMan(stus[i][1],1);
			}
			else if(stus[i][0]==2) { //여자
				goWoMan(stus[i][1],0);
			}
		}
		for (int i = 1; i < N+1; i++) {
			System.out.print(nums[i]+" ");
			if((i)%20==0) {
				System.out.println();
			}
		}
	}

	private static void goWoMan(int i, int cnt) {
		if(i>0 && i<N+1) {
			nums[i]=(nums[i]+1)%2;
		}else return;
			
		for (int j = 1; j <= N/2; j++) {
			if(i-j>0 && i+j<N+1) {
				if(nums[i-j]==nums[i+j]) {
					nums[i-j]=(nums[i-j]+1)%2;
					nums[i+j]=(nums[i+j]+1)%2;
				}else {
					return ;
				}
			}
		}
	}

	private static void goMan(int i, int cnt) {
		if(i*cnt>N)  return ;
		nums[i*cnt]=(nums[i*cnt]+1)%2;
		goMan(i, cnt+1);
	}

}
