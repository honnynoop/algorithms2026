import java.io.*;

public class Main {
	static int N; // 보낸 문자의 개수
	//A~H 순서대로 나열
	static String[] codes = {"000000", "001111", "010011",
			"011100", "100110", "101001", "110101", "111010"};
	static String[] diary; // 받은 교환 일기
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		diary = new String[N];
		String s = br.readLine();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			diary[i] = s.substring(idx, idx+6);
			idx += 6;
		}

		if(decodeDiary()) { // 끝까지 해독 성공한 경우
			System.out.println(sb.toString()); // 해독한 문자들 출력
		}
		
	}
	public static boolean decodeDiary() {
		int[] find = new int[N]; // idx번째 문자열과 일치하는 문자열을 찾은 경우 1, 아니면 0
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < 8; j++) {
				if(compare(diary[i], codes[j])){ // 같거나 한 문자만 다른 경우
					sb.append((char)('A' + j));
					if(find[i] == 0) find[i]++;
				}
			}
			if(find[i] == 0) {
				System.out.println(i+1);
				return false; // 맞는 문자를 찾지 못함을 의미
			}
		}
		return true; // 모든 문자 해독 완료
	}
	//완전히 같거나 한 문자만 다르면 true, 두 문자 이상 다르면 false 
	public static boolean compare(String origin, String code) {
		char[] ori = origin.toCharArray();
		char[] cod = code.toCharArray();
		int diff = 0;
		for (int i = 0; i < 6; i++) {
			if(ori[i] == cod[i]) continue;
			diff++;
			if(diff > 1) return false;
		}
		return true;
	}
}