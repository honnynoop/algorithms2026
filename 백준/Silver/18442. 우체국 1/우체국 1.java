import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long MIN;	// 거리의 합의 최소값이 저장될 변수
	static long[] result;	// 최종적으로 선택된 경찰서의 위치가 저장될 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 마을의 개수
		int P = Integer.parseInt(st.nextToken()); // 경찰서의 개수
		long L = Long.parseLong(st.nextToken()); // 길의 둘레
		long[] loc = new long[V]; // 마을의 위치
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) { // 마을의 위치를 입력받음
			loc[i] = Long.parseLong(st.nextToken());
		}
		long[] sel = new long[P]; // 현재 선택된 경찰서의 위치배열
		MIN=Long.MAX_VALUE;	// 초기화
		result=new long[P];
		//vCp
		combi(V, P, L, loc, sel, 0, 0);
		// 결과 출력
		System.out.printf("%d\n",MIN);
		for (long i : result) {
			System.out.print(i+" ");
		}
		System.out.println();
		br.close();
	}

	private static void combi(int V, int P, long L, long[] loc, long[] sel, int cnt, int start) {
		if (cnt == P) {
			long dis=0L;
			for (int i = 0; i < V; i++) {
				long min=Long.MAX_VALUE;
				for (int j = 0; j < P; j++) {
					min=Math.min(distance(loc[i],sel[j],L),min);
				}
				dis+=min;
				if(dis>MIN) return; // prun, 현재 구하고 있는 거리의 합이 MIN보다 크면 더 이상 확인해볼필요가 없음
			}
			if(MIN>dis) {
				MIN=dis;
				result=Arrays.copyOf(sel, P);
			}
			return;
		}
		for (int i = start; i < V; i++) {	// vCp 조합
			sel[cnt] = loc[i];
			combi(V, P, L, loc, sel, cnt + 1, i + 1);
		}

	}

	private static long distance(long a, long b, long L) {	// 거리를 구하는 메서드
		return Math.min(Math.abs(a - b), L - Math.abs(a - b));
	}
}