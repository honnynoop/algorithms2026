import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	private static Map<String, Integer> setMenu; //만들어진 세트메뉴 문자열(key), 개수(value)
	public String[] solution(String[] orders, int[] course) {
		List<String> res = new ArrayList<String>(); //만들어진 코스들을 담을 List
		for (int size : course) { // 만들어야 하는 코스 길이들 2
			setMenu = new HashMap<>();
			for (String order : orders) {// 주문한 단품메뉴 조합 ABCDE
				char[] sample = order.toCharArray(); //ABCDE
				Arrays.sort(sample); //영문 순서 통일을 위해서 정렬 ex) "CD"와 "DC"가 다른 코스 되지 않도록
				makeCourse(0, size, "", sample);  // 길이 2인 조합을 조합
			}
			//만들어진 코스가 1개이상 있으면, 결과에 넣어주기(단, 해당 메뉴가 2번이상 주문되어야함)
			if (!setMenu.isEmpty()) {
				int max = Collections.max(setMenu.values()); //가장 많이 주문되는 횟수 확인
				if (max > 1) {//2번 이상 주문 되는지 확인
					for (String key : setMenu.keySet()) {
						if (max == setMenu.get(key)) {
							res.add(key);
						}
					}
				}
			}

		}
		Collections.sort(res);//오름차순 정렬
		String[] answer = res.toArray(new String[0]);
		return answer;
	}

	private void makeCourse(int depth, int size, String course, char[] order) {
		if (course.length() == size) {
			if (setMenu.containsKey(course)) {// 이미 map에 추가되어 있는 course면
				int cnt = setMenu.get(course);
				setMenu.put(course, cnt + 1); //개수만 늘려주기
			} else
				setMenu.put(course, 1); //새로 추가하기
			return;
		}

		for (int i = depth; i < order.length; i++) {
			// 이번 메뉴 선택하기
			makeCourse(i + 1, size, course + order[i], order);

		}
	}

}