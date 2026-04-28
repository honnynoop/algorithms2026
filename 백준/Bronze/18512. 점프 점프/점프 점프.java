import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
 * @author DS Choi
 * 구현1. 껑충껑충 뛰어보자
 * 1. 한 친구를 먼저 최대 값 10000 미만까지 보폭으로 이동하며 visit에 방문을 남긴다.
 * 2. 두 번째 친구 또한 10000 미만까지 보폭을 이동하며, visit을 확인한다.
 * 2-1. visit에 먼저 간 친구 기록이 있다면(true) 빠져나와 그 칸을 출력해준다.
 * 2-2. 만약 없다면, -1을 출력한다.
 * */

public class Main {
	static boolean visit[] = new boolean[10001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken()); // 1번 사람의 보폭
		int Y = Integer.parseInt(st.nextToken()); // 2번 사람의 보폭
		int H1 = Integer.parseInt(st.nextToken()); // 1번 사람
		int H2 = Integer.parseInt(st.nextToken()); // 2번 사람
		
		int ans = -1; // 최종 출력 값, 만약 만나지 않을 경우 -1 출력.
		
		for(int i = H1; i<10000; i+=X) { // 만 이상 지점부터 -1이므로 최대 9999에서 만날 수 있다.
			visit[i] = true; // H1친구 기준으로 10000까지 이동 보폭을 모두 체크해준다.
		}
		
		for(int i = H2; i<10000; i+=Y) {
			if(visit[i] == true) { // H2 친구를 보폭만큼 움직이면서 아까 체크한 H1친구의 보폭이 있는지 체크한다. 
				ans = i; // 있다면, 그것이 최소 만나는 거리이므로 정답에 넣고, 빠져나간다.
				break;
			}
		}
		
		// 만나는 최소 지점이 있는지 체크 후, 출력 부분
		if(ans == -1)System.out.println(ans);
		else System.out.println(ans);
	}

}

/* Test Case
10 12 30 8 -> 80
1 1 7 12 -> 12
7 7 2 1 -> -1
 */