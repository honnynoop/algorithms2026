import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int [] nums;
	static int N;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		nums=new int[1001];
		//1~99까지 채워 넣고 시작 
		for (int i = 1; i < 100; i++) {
			nums[i]=nums[i-1]+1;
		}
		for (int i = 100; i < N+1; i++) {
			if(isHansu(i)) {
				nums[i]=nums[i-1]+1;
			}else {
				nums[i]=nums[i-1];
			}
		}
		System.out.println(nums[N]);
	}
	private static boolean isHansu(int n) {
		String s=String.valueOf(n);//1234=>"1234"
		char[] cs=s.toCharArray();
		int [] rn=new int[s.length()];
		for (int i = 0; i < rn.length; i++) {
			rn[i]=cs[i]-'0';
		}
		//System.out.println(Arrays.toString(rn));
		//2자리 이상
		int d=rn[1]-rn[0];
		for (int i = 1; i < rn.length-1; i++) {
			if(rn[i+1]-rn[i]!=d) {
				return false;
			}
		}
		return true;
	}

}
