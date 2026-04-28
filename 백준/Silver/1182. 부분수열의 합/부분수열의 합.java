import java.util.Scanner;

public class Main {
	static int N, S;
	static int [] seq;
	static int count;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		S=scann.nextInt();
		seq=new int[N];
		for (int i = 0; i < N; i++) {
			seq[i]=scann.nextInt();
		}
		count=0;
		subset(0,0);
		if(S==0){
			System.out.println(count-1);
		}else{
			System.out.println(count);
		}
		
	}
	private static void subset(int cnt, int tot) {
		if(cnt==N){
			if(tot==S){
				count++;
			}
			return ;
		}
		subset(cnt+1,tot+seq[cnt]);
		subset(cnt+1,tot);
	}

}