import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());

        int[][] board = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] visited = new int[h][w];
        for (int i = 0; i < h; i++) Arrays.fill(visited[i], k + 1);


        int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] dHorse = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        q1.add(new int[]{0, 0, 0});
        visited[0][0] = 0;

        int count = 0;

        while (!q1.isEmpty()) {
            int[] now = q1.poll();

            if (now[0] == h - 1 && now[1] == w - 1) {
                System.out.println(count);
                return;
            }

            for (int[] d : D) {
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x < 0 || y < 0 || x >= h || y >= w || board[x][y] > 0|| visited[x][y] <= now[2]) continue;

                q2.add(new int[]{x, y, now[2]});
                visited[x][y] = now[2];
            }

            if (now[2] < k) {
                for (int[] d : dHorse) {
                    int x = now[0] + d[0];
                    int y = now[1] + d[1];

                    if (x < 0 || y < 0 || x >= h || y >= w || board[x][y] > 0|| visited[x][y] <= now[2] + 1) continue;

                    q2.add(new int[]{x, y, now[2] + 1});
                    visited[x][y] = now[2] + 1;
                }
            }

            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;

                count++;
            }
        }

        System.out.println(-1);
    }
}