import java.util.Scanner;

public class Main {
	static int N;
	static int[] day;
	static int []t;
	static int []p;
	static int max;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		t=new int[N+1];
		p=new int[N+1];
		day=new int[N+1];
		for (int i = 1; i < N+1; i++) {
			t[i]=scann.nextInt();
			p[i]=scann.nextInt();
		}
		max=-1;
		subset(0);
		System.out.println(max);
	}
	static void subset(int cnt) {
		if(cnt==N) {
			max=Math.max(max, daySum(day));
			return ;
		}
		day[cnt+1]=cnt+1;
		subset(cnt+1);
		day[cnt+1]=0;
		subset(cnt+1);
	}
	static int daySum(int[] day) {
		// 1~7일까지
		int psum=0;
		for (int i = 1; i < N+1; i++) {
			if(day[i]==0) continue;
			if((i+t[i]-1)>=N+1) return 0;  //7+1>=8
			psum+=p[i];
			for (int j = i+1; j <N+1 ; j++) {
				if(day[j]==0) continue;
				if((j+t[j]-1>N+1) || (j<=i+t[i]-1))  return 0;
			}
		}
		return psum;
	}
}