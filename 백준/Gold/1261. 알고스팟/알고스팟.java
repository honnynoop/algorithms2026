import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int r;
	int c;
	
	Node(int r, int c){
		this.r=r;
		this.c=c;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String size= br.readLine();
		
		StringTokenizer stringTokenizer=new StringTokenizer(size);
		
		int M=Integer.parseInt(stringTokenizer.nextToken());//가로의 길이(열의 수)
		int N=Integer.parseInt(stringTokenizer.nextToken());//세로의 길이(행의 수)
		
		int[][] map=new int[N][M];
		int[][] dist=new int[N][M];
		boolean[][] v=new boolean[N][M];
		
		int[] dr= {0,1, 0,-1};
		int[] dc= {1,0,-1, 0};// 우하좌상
		
		for(int i=0;i< N; i++) {
			String input=br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=input.charAt(j)-'0';
			}
		}
		
		Deque<Node> queue=new LinkedList<>();
		queue.add(new Node(0,0));
		v[0][0]=true;
		
		
		while(!queue.isEmpty()) {
			//Node now=queue.pollLast();  
			Node now=queue.poll();  
			int r=now.r;
			int c=now.c;
			
			for(int i=0; i<4; i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				
				if(nr<0 || nc <0 || nr>=N || nc>=M || v[nr][nc])
					continue;
				if(map[nr][nc]==0) {
					dist[nr][nc]=dist[r][c];
					queue.addFirst(new Node(nr, nc));
				}else {
					dist[nr][nc]=dist[r][c]+1;
					queue.add(new Node(nr, nc));
				}
				v[nr][nc]=true;
			
			}
		}
		System.out.println(dist[N-1][M-1]);
	}

}