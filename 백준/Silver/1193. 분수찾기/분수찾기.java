import java.util.Scanner;

public class Main {
	
	static int X;

	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		X=scann.nextInt();
		int N=(int)Math.ceil((-1+Math.sqrt(1+8*X))/2.0);
		int M=N-1;
		int L=M*(M+1)/2;
		//N군 => 1/N 시작  1+N=(X-L)+Y Y=1+N+L-X;
		if(N%2==0) {
			System.out.println((X-L)+"/"+(1+N+L-X));
		}else {
			System.out.println((1+N+L-X )+"/"+(X-L));
		}
		
	}

}