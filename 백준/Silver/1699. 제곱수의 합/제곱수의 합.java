import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j, n = sc.nextInt(), d[] = new int[n+1];
		for(i=1;i<=n;i++) d[i] = i;
		for(i=2;i<=n;i++)
			for(j=2;j*j<=i;j++)
				d[i] = Math.min(d[i], d[i-j*j]+1);
		System.out.println(d[n]);
	}
}