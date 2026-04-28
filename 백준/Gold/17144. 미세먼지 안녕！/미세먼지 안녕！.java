

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int R,C,T;
	static int [][] A, E, CP;
	
	static int[] dc = { 0, 0, 1, -1 };
    static int[] dr = { -1, 1, 0, 0 };
    //                 -->  위  <--- 아래
    static int[] ccw = { 2, 0, 3, 1 };//반시계
    static int[] cw = { 2, 1, 3, 0 }; //시계
	  
	static ArrayList<int[]> cleaner=new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		R=scann.nextInt();
		C=scann.nextInt();
		T=scann.nextInt();
		A=new int[R][C];
		CP=new int[R][C];
		cleaner.clear();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j <C; j++) {
				A[i][j]=scann.nextInt();
				if(A[i][j]==-1){
					cleaner.add(new int[]{i,j});
				}
			}
		}
		//T회(초) 만큼 확산+순환
		for (int t = 0; t < T; t++) {
			expand();     // 확산
			//A -> CP 깊은 복사
		    for (int i = 0; i < R; i++) {
				System.arraycopy(A[i], 0, CP[i], 0, C);
			}
			circulate(cleaner.get(0),ccw);  // 순환+미세먼지 제거
			circulate(cleaner.get(1),cw);  // 순환+미세먼지 제거
			
		}
		int result=0;
		for (int i = 0; i < R; i++) {
	      for (int j = 0; j < C; j++) {
	        if (A[i][j] > 0) {
	          result += A[i][j];
	        }
	      }
	    }
	    System.out.println(result);
	}
	
	

	static void circulate(int[] loc, int[] ccc) {
		
		int r=loc[0];
		int c=loc[1]+1;// 한칸 이동
		A[r][c]=0;
		//4 방향 돌면 끝
		for (int d = 0; d < 4; d++) {
			//끝날때 까지 돌자 
			while(true){
				int nr=r+dr[ccc[d]];  //ccw cw를 알아서 방향 전환
				int nc=c+dc[ccc[d]];
				if(!check(nr, nc)) break; // 밖으롤 나가면 방향을 바꾸자
				if(nr==loc[0] && nc==loc[1]) break; // 한바뀌 돌았다.
				A[nr][nc] = CP[r][c];
			    r = nr;
			    c = nc;
			}
		}
		
	}



	static void expand() {
		E=new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j <C; j++) {
				// 먼지가 있는곳 찾아서 
				if(A[i][j]>0){
					int dir=direction(i,j);
					E[i][j]+=-dir*(A[i][j]/5);
				}
			}
		}
		// 확산 결과
		for (int i = 0; i < R; i++) {
			for (int j = 0; j <C; j++) {
				A[i][j]+=E[i][j];
			}
		}
/*		System.out.println("-------------------------");
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
		*/
	}

	static int direction(int r, int c) {
		int dir=0;
		for (int d = 0; d < 4; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc)) continue;
			if(A[nr][nc]==-1) continue;
			E[nr][nc]+=A[r][c]/5;
			dir++;
		}
		return dir;
	}

	static boolean check(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

	
	
	
}
