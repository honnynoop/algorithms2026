import java.util.*;

public class Solution{

	
	class Robot {
		public int row1;
		public int col1; 
		public int row2;
		public int col2;
		public int time; //소요시간 
		
		Robot(int row1, int col1, int row2, int col2, int time){
			this.row1=row1;
			this.col1=col1;
			this.row2=row2;
			this.col2=col2;
			this.time=time;
		}
	}

	public int solution(int[][] board) {
		int n = board.length;
		int answer = 0;
		boolean[][][] visited = new boolean[2][n][n]; // 0: 가로로 놓였을 때, 1: 세로로 놓였을 때
		int[] dr = { 1, -1, 0, 0 }; // 상, 하, 좌, 우
		int[] dc = { 0, 0, -1, 1 };
		Queue<Robot> q = new ArrayDeque<>();
		//시작 위치 셋팅
		q.offer(new Robot(0,0,0,1,0));
		visited[0][0][0] = true;
		visited[0][0][1] = true;

		// BFS 탐색 시작
		while (!q.isEmpty()) {
			Robot robot = q.poll();
			int pos = checkPosition(robot.row1, robot.row2);

			//도착 지점에 도착한 경우 
			if ((robot.row1 == n - 1 && robot.col1  == n - 1) || (robot.row2 == n - 1 && robot.col2 == n - 1)) {
				answer =  robot.time;
				break;
			}
			//로봇 이동하기 
			for (int d = 0; d < 4; d++) {
				int nr1 = robot.row1 + dr[d];
				int nc1 = robot.col1 + dc[d];
				int nr2 = robot.row2 + dr[d];
				int nc2 = robot.col2 + dc[d];
				//경계 안에 있는지, 벽이 없는지 확인하기
				if (isRange(nr1, nc1, n) && isRange(nr2, nc2, n) && board[nr1][nc1] != 1 && board[nr2][nc2] != 1) {
					// 상, 하, 좌, 우 이동
					if ((!visited[pos][nr1][nc1] || !visited[pos][nr2][nc2])) {
						visited[pos][nr1][nc1] = true;
						visited[pos][nr2][nc2] = true;
						q.offer(new Robot(nr1, nc1, nr2, nc2, robot.time+1));
					}
					
					// 로봇이 가로 상태 : 상하가 비어 있어야 회전 가능
					// 로봇이 세로 상태 : 좌우가 비어 있어야 회전 가능
					int changeP = 1 ^ pos;
					if ((pos == 0 && d < 2) || (pos == 1 && d > 1)) {
						if (!visited[changeP][nr1][nc1] || !visited[changeP][robot.row1][robot.col1]) {
							visited[changeP][nr1][nc1] = true;
							visited[changeP][robot.row1][robot.col1] = true;
							q.offer(new Robot(nr1, nc1, robot.row1, robot.col1, robot.time+1));
						}

						if (!visited[changeP][nr2][nc2] || !visited[changeP][robot.row2][robot.col2]) {
							visited[changeP][nr2][nc2] = true;
							visited[changeP][robot.row2][robot.col2] = true;
							q.offer(new Robot(nr2, nc2, robot.row2, robot.col2, robot.time+1));
						}
					}

				}
			}
		}

		return answer;
	}
	
	//위치가 범위를 벗어 났는지 확인
	public boolean isRange(int row, int col, int n) {
		return 0 <= row && row < n && 0 <= col && col < n;
	}

	//현재 로봇의 상태 
	public int checkPosition(int row1, int row2) {
		if (row1 == row2)
			return 0; //가로로 놓여있음
		return 1; //세로로 놓여있음
	}
}
