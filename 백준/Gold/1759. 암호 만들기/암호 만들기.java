import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int L, C;
	static char[] alpa;
	static char[] result;
	static char[] moeum= {'a','e','i','o','u'};
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		L=scann.nextInt();
		C=scann.nextInt();
		alpa=new char[C];
		result=new char[L];
		for (int i = 0; i < C; i++) {
			alpa[i]=scann.next().charAt(0);
		}
		Arrays.sort(alpa);
		//System.out.println(Arrays.toString(alpa));
		alpabet(0,0);
	}
	
	private static void alpabet(int cnt, int start) {
		
		if(cnt==L) {
			if(zeromoum()) return ;  // 모듬이 없거나 자음이 0,1
			System.out.println(new String(result));
			return ;
		}
		for (int i = start; i <C; i++) {
			result[cnt]=alpa[i];
			alpabet(cnt+1, i+1);
		}
	}

	private static boolean zeromoum() {
		int count=0;
		for (int i = 0; i < L; i++) {
			if(result[i]=='a' || result[i]=='e' ||
					result[i]=='i'||result[i]=='o'||
					result[i]=='u') {
				count++;
			}
		}
		int nums=L-count;
		return (count==0) || (nums<2);
	}

	
}