import java.util.Scanner;

public class Main {

	static int cnt;
	static int N;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		cnt=0;
		cycle(N,1);
		System.out.println(cnt);
	}
	static void cycle(int m, int count) {
		int n=m;
		if(n>=0 && n<10) {
			StringBuilder sb=new StringBuilder();
			sb.append(n);
			sb.append(n);
			n=Integer.parseInt(sb.toString());
		}else {
			int a=n%10;
			int b=(n/10);
			int c=(a+b)%10;
			StringBuilder sb2=new StringBuilder();
			sb2.append(a);
			sb2.append(c);
			n=Integer.parseInt(sb2.toString());
		}
		if(N==n) {
			cnt= count;
			return;
		}else {
			cycle(n,count+1);
		}
		
	}

}