import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] x, y;
    static int robotX, robotY;
    static long result;
    static int[] operation;
    // S(north), J(south), I(east), Z(west)
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        x = new int[N];
        y = new int[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        char[] commands = br.readLine().toCharArray();
        operation = new int[M];
        
        for (int i = 0; i < M; i++) {
            if (commands[i] == 'S') {
                operation[i] = 0;
            } else if (commands[i] == 'J') {
                operation[i] = 1;
            } else if (commands[i] == 'I') {
                operation[i] = 2;
            } else if (commands[i] == 'Z') {
                operation[i] = 3;
            }
        }
        
        // 초기 위치
        robotX = 0;
        robotY = 0;
        
        // 초기 거리 합 계산
        result = 0L;
        for (int i = 0; i < N; i++) {
            result += Math.abs(x[i] - robotX) + Math.abs(y[i] - robotY);
        }
        
        // 조사점 좌표 정렬 (이진 탐색을 위해)
        Arrays.sort(x);
        Arrays.sort(y);
        
        StringBuilder sb = new StringBuilder();
        
        // 각 명령 수행
        for (int i = 0; i < M; i++) {
            // 이동할 새 위치
            int newX = robotX + dx[operation[i]];
            int newY = robotY + dy[operation[i]];
            
            // 거리 변화 계산
            long distanceChange = 0L;
            
            // X축 이동인 경우 (I 또는 Z)
            if (operation[i] == 2 || operation[i] == 3) {
                if (newX > robotX) { // 오른쪽으로 이동
                    int xIndex = findFirstGreaterEqual(x, newX);
                    // 로봇보다 왼쪽에 있는 점들은 거리가 증가, 오른쪽은 감소
                    distanceChange = xIndex - (N - xIndex);
                } else { // 왼쪽으로 이동
                    int xIndex = findLastLessEqual(x, newX);
                    // 로봇보다 왼쪽에 있는 점들은 거리가 감소, 오른쪽은 증가
                    distanceChange = -(xIndex + 1) + (N - xIndex - 1);
                }
            } 
            // Y축 이동인 경우 (S 또는 J)
            else if (operation[i] == 0 || operation[i] == 1) {
                if (newY > robotY) { // 위로 이동
                    int yIndex = findFirstGreaterEqual(y, newY);
                    // 로봇보다 아래에 있는 점들은 거리가 증가, 위에는 감소
                    distanceChange = yIndex - (N - yIndex);
                } else { // 아래로 이동
                    int yIndex = findLastLessEqual(y, newY);
                    // 로봇보다 아래에 있는 점들은 거리가 감소, 위에는 증가
                    distanceChange = -(yIndex + 1) + (N - yIndex - 1);
                }
            }
            
            // 로봇 위치 업데이트
            robotX = newX;
            robotY = newY;
            
            // 거리 업데이트
            result += distanceChange;
            
            // 결과 저장
            sb.append(result).append('\n');
        }
        
        // 최종 결과 출력
        System.out.print(sb);
    }
    
    // target보다 크거나 같은 첫 번째 요소의 인덱스를 찾는 함수
    public static int findFirstGreaterEqual(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int pos = arr.length; // 모든 요소가 target보다 작을 경우
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] >= target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return pos;
    }
    
    // target보다 작거나 같은 마지막 요소의 인덱스를 찾는 함수
    public static int findLastLessEqual(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int pos = -1; // 모든 요소가 target보다 클 경우
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] <= target) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return pos;
    }
}