import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N=0;
		int[] su=null;
		int[] dp=null;
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		su=new int[N];
		dp=new int[N];

		for (int i = 0; i < N; i++) {
			su[i]=scann.nextInt();
		}
		int len=0;
		for (int i = 0; i < N; i++) {
			int index = Arrays.binarySearch(dp, 0, len, su[i]);
	            if (index < 0) {
	                index = -(index + 1);
	            }
	     
	            dp[index] = su[i];
	            if (index == len) {
	                len++;
	            }
		}
		System.out.println(len);
	}
}