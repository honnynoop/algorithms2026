import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int R,C,N;
	static char[][] arr;
	static class Pos{
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static Stack<Pos> stack[];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		arr = new char[R+2][C+2];
		stack = new Stack[C+2];
		for(int i = 1; i<R+1; i++) {
			String line = sc.next();
			for(int j = 1; j<C+1; j++) {
				arr[i][j] = line.charAt(j-1);
			}
		}

		for(int i = 0 ; i<R+2; i++) {
			arr[i][0] = 'X';
			arr[i][C+1] = 'X';
		}
		for(int j = 0; j<C+2;j++) {
			stack[j] = new Stack<>();
			for(int i = 1; i<=R; i++) {
				if (stack[j].isEmpty() && arr[i][j] == 'X') {
					stack[j].push(new Pos(i-1,j));
					break;
				}
			}
			if(stack[j].isEmpty()) {
				stack[j].push(new Pos(R,j));
			}
			arr[0][j] = 'X';
			arr[R+1][j] = 'X';
		}
		
		N = sc.nextInt();
		for(int i = 0 ; i<N; i++) {
			int col = sc.nextInt();
			throwStone(col);
		}
		
		for(int i = 1; i<R+1; i++) {
			for(int j = 1; j<C+1; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}//main
	
	static void throwStone(int col) {
		Pos now = stack[col].pop();
		while(!stack[col].isEmpty() && arr[now.r][now.c]!= '.' ) {
			now = stack[col].pop();
		}
		while(now.r >1 && arr[now.r][now.c]!= '.' ) {
			now.r -= 1;
		}
		if(stack[col].isEmpty()) {
			stack[col].push(new Pos(now.r, now.c));
		}
		for (int i = now.r; i<=R; i++) {
			if(arr[i+1][now.c]=='X' ) {
				arr[i][now.c]= 'O';
				break;
			} else if (arr[i+1][now.c]== 'O' ) {
				if (arr[i][now.c-1] == '.' && arr[i+1][now.c-1] =='.') {
					stack[col].push(new Pos(i,now.c));
					now.c -=1;
				}else if (arr[i][now.c+1] == '.' && arr[i+1][now.c+1] =='.') {
					stack[col].push(new Pos(i,now.c));
					now.c +=1;
				}else {
					arr[i][now.c]= 'O';
					break;
				}
			}
		}
	}
}