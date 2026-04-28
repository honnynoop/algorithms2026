import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 테스트 케이스의 개수 T 입력
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            // 각 테스트 케이스마다 H, W, N 입력
            int H = scanner.nextInt(); // 호텔의 층 수
            int W = scanner.nextInt(); // 각 층의 방 수
            int N = scanner.nextInt(); // N번째 손님
            
            int floor; // 배정될 층
            int room;  // 배정될 호수
            
            // 손님이 묵을 층 계산
            if (N % H == 0) {
                floor = H;
                room = N / H;
            } else {
                floor = N % H;
                room = (N / H) + 1;
            }
            
            // 방 번호 출력 (YXX 또는 YYXX 형태)
            System.out.printf("%d%02d\n", floor, room);
        }
        
        scanner.close();
    }
}