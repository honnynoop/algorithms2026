import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int a;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		a=2;
		while(N>1) {
			if(N%a==0) {
				N/=a;
				System.out.println(a);
			}else {
				a++;
			}
		}
		
	}//main
	
}//class
