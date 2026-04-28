import java.util.Scanner;

public class Main {

	static int K;
	static int[] nums;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		while(true) {
			K=scann.nextInt();
			if(K==0) break ;
			nums=new int[K];
			for (int i = 0; i < K; i++) {
				nums[i]=scann.nextInt();
			}
			//로직
			ncr(0,0, new int[6]);
			System.out.println();
		}
		
	}

	private static void ncr(int start, int cnt, int[] ks) {
		if(cnt==6) {
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i <6; i++) {
				//System.out.print(ks[i]+" ");
				sb.append(ks[i]).append(" ");
			}
			System.out.println(sb.toString());
			return ;
		}
		for (int i = start; i < K; i++) {
			ks[cnt]=nums[i];
			ncr(i+1, cnt+1, ks);
		}
	}

}