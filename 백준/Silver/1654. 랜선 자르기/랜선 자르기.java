import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int K;
	static int N;
	static long L=1L;
	static long R;
	static int[] nums;
	static long M;
	static long result;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		K=scann.nextInt();
		N=scann.nextInt();
		nums=new int[K];
		for (int i = 0; i < K; i++) {
			nums[i]=scann.nextInt();
		}
		Arrays.sort(nums);
		// 457 539 743 802
		L=1L;
		R=nums[K-1];   //802
		while(R-L>=0) {
			M=(L+R)/2;
			if(cal(M)) {
				L=M+1;
				result=Math.max(result, M);
			}else {
				R=M-1;
			}
		}
		System.out.println(result);
	}
	static boolean cal(long m) {
		int len=0;
		for (int i = 0; i < K; i++) {
			len+=(nums[i]/m);
		}
		if(len>=N) {
			return true;
		}else return false;
	}

}