
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Number implements Comparable<Number> { // Number 객체 선언
		int num; // 숫자 자체를 저장
		String write; // 읽었을 때 문자열 저장

		public Number(int num, String write) { // 생성자
			this.num = num;
			this.write = write;
		}

		@Override
		public int compareTo(Number o) { // CompareTo override
			return this.write.compareTo(o.write); // 읽었을 때 기준으로 사전 순으로 정렬 -> 읽었을 때 문자열 기준으로 정렬
		}

	}

	static int M, N; // N,M 전역변수 선언
	static String[] nums = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" }; // 읽었을 때의 문자열을 만들 때 사용할 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader 선언
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력을 받기 위한 StringTokenizer 선언
		M = Integer.parseInt(st.nextToken()); // N 저장
		N = Integer.parseInt(st.nextToken()); // M 저장
		ArrayList<Number> numList = new ArrayList<>(); // M~N사이의 숫자 객체를 저장할 List

		for (int num = M; num <= N; num++) { // M~N 범위 안의 숫자 반복
			numList.add(new Number(num, writeNumber(num))); // Number(숫자 자체(num), 읽었을 때 문자열(writeNumber(num)) 객체 생성하여 List에 저장
		}

		Collections.sort(numList); // 읽었을 때 기준 (사전 순으로) 정렬

		int cnt = 0; // 10개씩 출력하기 위한 변수
		for (Number current : numList) { // 사전순으로 정렬된 List에서 Number 객체를 순서대로 가져옴
			System.out.print(current.num + " "); // Number 객체의 num(숫자 자체)를 출력
			if ((++cnt) % 10 == 0) { // 만약 출력한 갯수가 10개라면
				System.out.println(); // 엔터 출력
			}
		}
	}

	private static String writeNumber(int num) { // 읽었을 때의 문자열을 만들어주는 메소드
		String answer = ""; // 문자열을 저장할 변수
		while (num != 0) { // num이 10이 아닐 때 까지 반복 -> 일의 자리부터 시작
			answer = nums[num % 10] + answer; // 현재 위치에 해당하는 num문자를 26 line 전역 변수에서 가져와 answer에 추가
			// 일의 자리부터 시작하기 때문에 answer의 앞에 추가해준다.
			num /= 10; // num을 10으로 나눠준다 -> 현재위치를 이동 (일의 자리 -> 십의 자리 -> 백의 자리 -> ...)
		}
		return answer; // answer를 return
	}

}
