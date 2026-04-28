import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int S, P;
	static char[] DNA;
	static int a, c, g, t;
	static int a_cnt, c_cnt, g_cnt, t_cnt;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		DNA = str.toCharArray();

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < P; i++) {
			plus(DNA[i]);
		}

		if (check())
			cnt++;

		for (int i = 0; i < S - P; i++) {
			minus(DNA[i]);
			plus(DNA[i + P]);
			if (check())
				cnt++;

		}
		System.out.println(cnt);
	}

	private static void minus(char x) {
		if (x == 'A')
			a_cnt--;
		else if (x == 'C')
			c_cnt--;
		else if (x == 'G')
			g_cnt--;
		else if (x == 'T')
			t_cnt--;
	}

	private static void plus(char x) {
		if (x == 'A')
			a_cnt++;
		else if (x == 'C')
			c_cnt++;
		else if (x == 'G')
			g_cnt++;
		else if (x == 'T')
			t_cnt++;
	}

	private static boolean check() {
		if (a_cnt >= a && c_cnt >= c && g_cnt >= g && t_cnt >= t)
			return true;
		return false;
	}

}