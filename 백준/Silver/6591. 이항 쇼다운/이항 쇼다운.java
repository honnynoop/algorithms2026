

import java.util.Scanner;


public class Main {

	
	static long N,K; 
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		while(true){
			N=scann.nextLong();
			K=scann.nextLong();
			if(N==0L && K==0L){
			     break ;	
			}
			else if(K==0L || (K==N)){
				System.out.println(1);
			}else if(K>N/2){
				System.out.println(nCr(N,N-K));
			}else {
				System.out.println(nCr(N,K));
			}
		}
		
	}
	static long nCr(long n, long k) {
		double re=1L;
		for (long i = 1L; i <= k; i++) {
			re=(re*(n-k+i))/(i);
			
		}
		return (long)re;
	}
}
