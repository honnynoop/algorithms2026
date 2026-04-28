
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int N,M,K;
	static int[][] A;
	static int[][] map;
	static LinkedList<Tree> list = new LinkedList<>();
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		A = new int[N+1][N+1];
		map = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				A[i][j] = sc.nextInt();
				map[i][j] = 5;
			}
		}
		int x,y,age;
		for(int i = 0 ; i < M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			age = sc.nextInt();
			list.add(new Tree(x,y,age,false));
		}
		for(int k = 0 ; k < K; k++) {
//			봄
			for(Tree t : list) {
				if(map[t.x][t.y] >= t.age) {
					map[t.x][t.y] -= t.age;
					t.age++;
				}else {
					t.life = true;
				}
			}
//			여름
			Iterator<Tree> iterator = list.iterator();
			Tree t1;
			while(iterator.hasNext()) {
				t1 = iterator.next();
				if(t1.life) {
					map[t1.x][t1.y] += t1.age/2;
					iterator.remove();
				}
			}
//			가을
			LinkedList<Tree> newTrees = new LinkedList<>();
			int nx,ny;
			for(Tree t : list) {
				if(t.age % 5 == 0) {
					for(int i = 0; i < 8; i++) {
						nx = t.x + dx[i];
						ny = t.y + dy[i];
						if(nx < 1 || nx > N || ny < 1 || ny > N) {
							continue;
						}
						newTrees.add(new Tree(nx,ny,1,false));
					}
				}
			}
			list.addAll(0, newTrees);
			
//			겨울			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j]  += A[i][j];
				}
			}
		}
		System.out.println(list.size());
	}
	
	static class Tree{
		int x;
		int y;
		int age;
		boolean life;
		public Tree(int x, int y, int age, boolean life) {
			this.x = x;
			this.y = y;
			this.age = age;
			this.life = life;
		}		
	}
}
