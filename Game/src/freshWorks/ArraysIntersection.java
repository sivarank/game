package freshWorks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A = [3,4,5,6,8,10, 6] n B = [1,3,8,7,6, 6] m
 * 
 * o/P = [3,6,6,8]
 * 
 * 
 * 
 * case1: A = [] B = [1,2,4,5,6] O/P : []
 * 
 * Q1) Range is fixed from 1 - 10 ?
 * 
 * Appraoch 1: use hash map ;
 * 
 * 
 * Time complexity : O(n) O(m) Space compexity: O(n)
 * 
 * TC1: a1 = [] , a2 = [1] , result = [] TC2: a1 = [1] , a2 = [1] , result = [1]
 * Tc3: a1=[1], a2 = [2] , result = [] Tc4: a1=[1,1] a2 = [1,2,1] , result =[]
 * 
 * @author SIVAR1
 *
 */
public class ArraysIntersection {

	List<Integer> findIntersection(List<Integer> a1, List<Integer> a2) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a1.size(); i++) {
			int curElement = a1.get(i);
			map.compute(curElement, (key, value)->{
				return map.containsKey(key) ? 1 + map.get(key) : 1;
			});
		}
		for (int i = 0; i < a2.size(); i++) {
			int curElement = a2.get(i);
			if (map.containsKey(curElement)) {
				result.add(curElement);
				if (map.get(curElement) > 1) {
					map.put(curElement, map.get(curElement) - 1);
				} else {
					map.remove(curElement);
				}
			}
		}
		return result;
	}
	
//Learning: program to interface , not to implementation
	List<Integer> intersectionArray(List<Integer> a1, List<Integer> a2) {
		List<Integer> result = new ArrayList<Integer>();
		if (a1.isEmpty() || a2.isEmpty()) {
			return result;
		}
		return a2.size() > a1.size() ? findIntersection(a1, a2) : findIntersection(a2, a1);
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);list1.add(2);list1.add(1);list1.add(3);
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);list2.add(2);list2.add(1);list2.add(4);
		(new ArraysIntersection().intersectionArray(list1, list2)).forEach((p)->System.out.println(p));
	}
}
