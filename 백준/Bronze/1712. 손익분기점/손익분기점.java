import java.util.Scanner;

public class Main {
	
	static int A,B,C;

	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		
		A=scann.nextInt();
		B=scann.nextInt();
		C=scann.nextInt();
		long result=0L+A;
		int cnt=1;
		StringBuilder sb=new StringBuilder();
		if((result+B-C>=0 )&& (B-C>=0)) {
			sb.append("-1");
		}else {
			/*while(result+1L*(B-C)*cnt>=0) {
				cnt++;
			}*/
			sb.append((int)( (1.0*result)/(C-B) +1 ));
		}
		System.out.println(sb.toString());
	}

}