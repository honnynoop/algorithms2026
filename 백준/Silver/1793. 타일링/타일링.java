import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		BigInteger[]p=new BigInteger[251];
		p[0]=new BigInteger("1");
		p[1]=new BigInteger("1");
		p[2]=new BigInteger("3");
		for (int i = 3; i <250+1; i++) {
			p[i] = p[i-2].multiply(new BigInteger("2"));
            p[i] = p[i].add(p[i-1]);
		}
		while(scann.hasNextInt()){
           int N = scann.nextInt();
           System.out.println(p[N]);
        }
	}

}