import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		long N=scann.nextLong();
		double X=(3.0+Math.sqrt(12.0*N-3.0))/(6.0);
		long Y=(long)(Math.ceil(X));
		System.out.println(Y);
		
	}

}