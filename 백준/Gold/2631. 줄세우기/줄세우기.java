import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 어린이 수
        int[] line = new int[N]; // 줄 서있는 어린이들의 번호
        
        for (int i = 0; i < N; i++) {
            line[i] = sc.nextInt();
        }
        
        int result = findMinimumMoves(line, N);
        System.out.println(result);
        sc.close();
    }
    
    // 최소 이동 횟수를 계산하는 함수
    private static int findMinimumMoves(int[] line, int N) {
        // 바이너리 서치를 이용한 LIS의 길이를 구함
        int lisLength = findLISLengthWithBinarySearch(line, N);
        
        // 최소 이동 횟수 = 전체 어린이 수 - LIS 길이
        return N - lisLength;
    }
    
    // 이진 탐색을 이용한 가장 긴 증가하는 부분 수열의 길이를 찾는 함수
    private static int findLISLengthWithBinarySearch(int[] arr, int n) {
        if (n == 0) return 0;
        
        // tails[i] = 길이가 i+1인 증가 부분 수열의 마지막 원소 중 가장 작은 값
        int[] tails = new int[n];
        tails[0] = arr[0]; // 초기값 설정
        
        // LIS의 현재 길이 (0부터 시작하므로 실제 길이는 length+1)
        int length = 0;
        
        for (int i = 1; i < n; i++) {
            // Case 1: 현재 값이 tails 배열의 마지막 값보다 크면, 추가
            if (arr[i] > tails[length]) {
                tails[++length] = arr[i];
            } 
            // Case 2: 현재 값이 tails 배열의 첫 번째 값보다 작거나 같으면, 첫 번째 값을 교체
            else if (arr[i] <= tails[0]) {
                tails[0] = arr[i];
            } 
            // Case 3: 그 외의 경우, tails 배열에서 적절한 위치를 찾아 교체
            else {
                int pos = Arrays.binarySearch(tails, 0, length + 1, arr[i]);
                
                // 값이 없으면 음수를 반환하며, 삽입되어야 할 위치는 -(반환값 + 1)
                if (pos < 0) {
                    pos = -(pos + 1);
                }
                
                tails[pos] = arr[i];
            }
        }
        
        // 실제 LIS 길이는 length + 1
        return length + 1;
    }
}