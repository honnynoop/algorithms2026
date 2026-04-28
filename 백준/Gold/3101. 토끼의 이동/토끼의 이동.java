import java.util.Scanner;

public class Main {

	static int[] dr= {-1,0,1,0};
	static int[] dc= { 0,1,0,-1};// 상우하좌 URDL
	static int N,K;
	static char[] jump;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		K=scann.nextInt();
		jump=scann.next().toCharArray();
		
		int r=0;
		int c=0;   //0,0에서 시작
		long sum=1L; //0,0 -> 1
		int d=0;
		//System.out.printf("(%d,%d)=(%d),sum=>%d\n",r,c,1,sum);
		for (int i = 0; i < K; i++) {
			d=turn(jump[i]);
			r=r+dr[d];
			c=c+dc[d];
			long ttt=0L+go(r,c);
			sum+= ttt;
			//System.out.printf("(%d,%d)=(%d),sum=>%d\n",r,c,ttt,sum);
		}
		System.out.println(sum);
	}
	static long go(int r, int c) {
		int g=r+c;  //(2,3) 5군
		long val=0;  // 4군까지 마지막 +1(5군시작)
		if(g>=N) {
			long n=0L+2*N-1L-g;// 11-6=5개 
			val+=((0L+N)*N-n*(n+1L)/2);
		}else {
			long t=0L+g*(g+1L)/2;
			val+=t;
		}
		val++;
		if(g%2==0) {// 0 2 4 6 8 군 증가 (i,0)에서 (a,b)로 
			//(2,4) -> 6군 5군마지막수
			if(g<N) {
				val=val+c;
			}else {
				val=val+(c-g+N-1);
			}
		}else {     // 1 3 5 7 9 군 (0,i)에서 (c,d)로 
			if(g<N) {
				val=val+r;
			}else {
				val=val+(r-g+N-1);
			}
		}
		return val;
	}
	private static int turn(char c) {
		int d=-1;
		if(c=='U') {
			d=0;
		}else if(c=='R') {
			d=1;
		}else if(c=='D') {
			d=2;
		}else if(c=='L') {
			d=3;
		}
		return d;
	}
}