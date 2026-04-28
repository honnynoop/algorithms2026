import java.util.Scanner;
public class Main {

	static int N,M=5;
	static int[] nums;
	static int[] p= {1,3,5,7,9}; //두번째 부터는 짝수가 제거된다. 
	static int[] q= {2,3,5,7}; // 솟수로 시작한다.
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		for (int i = 0; i < 4; i++) {
			nums=new int[N];
			nums[0]=q[i];    //앞자리 한개를 주고 시작한다.
			npir(0);
		}
	}
	public static boolean isP(int n) {// 솟수인가
		for (int i = 2; i <=(int)Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		return true;
	}
	private static int toInt(int[]ns,int cnt) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			sb.append(ns[i]);
		}
		return Integer.parseInt(sb.toString());
	}
	private static void npir(int cnt) {
		int nn=toInt(nums,cnt+1);
		if(!isP(nn)) return ;// 가지치기 
		if(cnt==N-1) {// 
			System.out.println(nn);
			return ;
		}
		for (int i = 0; i < M; i++) {  
			nums[cnt+1]=p[i];
			npir(cnt+1);
		}
	}
	
}
