import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		int M=Integer.parseInt(br.readLine());
		int N=2*M-1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < Math.abs(i-N/2); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < -Math.abs(i-N/2)+1+N/2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
