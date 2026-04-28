import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException { // 메인 함수 선언, 입력 스트림에서 발생할 수 있는 IOException 처리 회피
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 스트림 만들기
		int k = Integer.parseInt(br.readLine()); // 가로/세로로 접는 횟수 k 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력된 접는 방법을 공백 기준으로 쪼개줄 StringTokenizer 생성
		int backR = 0; // 접고 나서 맨 뒤 칸의 R : R행 C열의 칸은 무조건 올바른 방향
		int backC = 0; // 접고 나서 맨 뒤 칸의 C : R행 C열의 칸은 무조건 올바른 방향
		for (int i = 0; i < 2 * k; i++) { // 2k번 접으므로 2k번 입력을 받는다 
			switch(st.nextToken().charAt(0)) { // i번째 입력, 즉 i번째 접는 방법
			case 'D': // 아래로 접는 경우
				backR = (backR << 1) + 1; // 마지막 비트 1인게 맨 뒤에 있다
				break; // 더 타고 내려가지 않도록 break
			case 'U': // 위로 접는 경우
				backR = backR << 1; // 마지막 비트 0인게 맨 뒤에 있다
				break; // 더 타고 내려가지 않도록 break
			case 'R': // 오른쪽으로 접는 경우
				backC = (backC << 1) + 1; // 마지막 비트 1인게 맨 뒤에 있다
				break; // 더 타고 내려가지 않도록 break
			case 'L': // 왼쪽으로 접는 경우
				backC = backC << 1; // 마지막 비트 0인게 맨 뒤에 있다
				break; // 더 타고 내려가지 않도록 break
			}
		}
		int h = Integer.parseInt(br.readLine()); // 구멍을 뚫을 위치 h 입력 받기
		StringBuilder sb = new StringBuilder(); // 출력할 내용을 저장할 StringBuilder 생성
		for (int i = 0; i < 1 << k; i++) { // 각 행에 대하여
			for (int j = 0; j < 1 << k; j++) { // 각 열에 대하여
				int curr = h; // i행 j열에 뚫린 구멍의 위치 선언
				if (((i - backR) & 1) != 0) { // 맨 뒷 칸의 행과 i행의 홀짝성이 다르다면 
					curr = curr ^ 0b10; // 칸이 상하로 뒤집힌다
				}
				if (((j - backC) & 1) != 0) { // 맨 뒷 칸의 열과 j열의 홀짝성이 다르다면
					curr = curr ^ 0b01; // 칸이 좌우로 뒤집힌다
				}
				sb.append(curr).append(' '); // 해당하는 칸의 구멍 번호 추가
			}
			sb.append('\n'); // 줄 바꿈
		}
		System.out.println(sb); // 답 출력
	}
}