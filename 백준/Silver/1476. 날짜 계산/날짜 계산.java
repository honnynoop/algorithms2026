import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static long E,S,M;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		E=scann.nextLong();
		S=scann.nextLong();
		M=scann.nextLong();
		
		for (long i = 1L; i <=Long.MAX_VALUE; i++) {
			if(((i-E)%15L==0) && ((i-S)%28L==0) 
					&& ((i-M)%19L==0)) {
				System.out.println(i);
				return ;
			}
		}
	}
}