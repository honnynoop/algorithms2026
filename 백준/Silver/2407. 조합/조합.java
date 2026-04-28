import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int N=0;
		int R=0;
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		R=scann.nextInt();
		BigDecimal[][] big=new BigDecimal[N+1][N+1];
		big[0][0]=new BigDecimal(1);

		for (int i = 1; i < N+1; i++) {
			big[i][0]=new BigDecimal(1);
			big[i][i]=new BigDecimal(1);
			for (int j = 1; j <i; j++) {
				big[i][j]=new BigDecimal(big[i-1][j-1].toBigInteger().add(
						big[i-1][j].toBigInteger()));
			}
		}
		
		System.out.println(big[N][R].toString());
	}
}
