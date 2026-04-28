import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		long N=scann.nextLong();
		
		long five=0;
		long three=0;
		long cnt=0;
		five=N/5;
		three=(N%5);
		while(true) {
			if(three%3==0) {
				break;
			}else {
				five--;
				three+=5;
			}
			if(five<0) {
				break;
			}
			//System.out.println(five+" "+three);
		}
		cnt=five+three/3;
		if(five<0) {
			System.out.println("-1");
		}else {
			System.out.println(cnt);
		}
	}

}