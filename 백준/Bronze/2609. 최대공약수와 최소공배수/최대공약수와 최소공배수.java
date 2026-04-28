import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int gcd=gcd(A,B);
		int lcm=A*B/gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}

	static int gcd(int a, int b) {
		if(b==0) { return a;
		}else if(a==0) { return b;
		}else if(a>b) { return gcd(a%b,b);
		}else if(a<b) { return gcd(a,b%a);
		}else return a;
	}

}
