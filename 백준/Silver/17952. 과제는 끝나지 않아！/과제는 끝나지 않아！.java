import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Info {
	int a;
	int t;
	
	public Info(int a, int t) {
		this.a = a;
		this.t = t;
	}
}

public class Main {
	static int N;
	static Deque<Info> dq;
	
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dq = new LinkedList<>();
		
		for(int n = 0; n < N; n++) { // N분째에 주어진 업무의 정보
			st = new StringTokenizer(br.readLine(), " ");
			int kind = Integer.parseInt(st.nextToken());
			
			if(kind == 0) { // 해당 시점에는 업무가 주어지지 않음
				if(dq.isEmpty()) {
					continue;
				}
				
				if(--dq.peek().t == 0) { // 다 끝남
					answer += dq.peek().a;
					dq.pollFirst();
				}
				continue;
			}
			
			int a = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken()) - 1; // 받자마자 처리
			
			if(t == 0) {
				answer += a;
				continue;
			}
			
			dq.offerFirst(new Info(a, t)); // 새로운 업무부터 시작
		}
		
		System.out.println(answer);
	}
}