import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] input;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		input = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 2개의 학급을 선택하기 위해서 combination 처럼 앞의 인덱스가 뒤의 인덱스보다 작게 했다.
		int cnt = 0;
		for (int i = 0; i < M-1; i++) {
			for (int j = i+1; j < M; j++) {
				if (findSimilarFair(i,j)) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	private static boolean findSimilarFair(int i, int j) {
		// 반의 1번부터 N까지 순서대로 내려가면서 해당 번호의 학생 점수가 다른 번호의 학생들보다 큰지 작은지를 비교하면서 탐색한다.
		for (int cur = 0; cur < N-1; cur++) {
			// 각 반의 기준이 될만한 학생의 점수
			int curI = input[i][cur];
			int curJ = input[j][cur];
			
			for (int next = cur+1; next < N; next++) {
				if ((input[i][next]-curI)*(input[j][next]-curJ)>0) {
					// 만약 각 반마다 기준 학생과 그 다음 학생들의 차이 곱이 양수이면, 양쪽반의 점수 크기 비교 관계가 같다는 뜻.
					continue;
				}else if((input[i][next]-curI)==0 && (input[j][next]-curJ)==0) {
					// 만약 차이가 둘다 0이라면 양쪽 반의 점수 크기 비교 관계가 같다는 뜻.
					continue;
				}else {
					return false;
				}
			}
		}
		return true;
		
	}

}