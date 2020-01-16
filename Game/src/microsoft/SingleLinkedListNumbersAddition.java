package microsoft;

class ListNode {
	private int data;
	ListNode next;

	public ListNode(int val) {
		data = val;
	}

	public int getVal() {
		return data;
	}
}

public class SingleLinkedListNumbersAddition {
	ListNode calculateSum(ListNode L1, ListNode L2) {
		if (L1 == null || L2 == null) {
			return L1 == null ? L2 : L1; // new list should be return ,
		}
		// 1->2->3
		L1 = reverseList(L1); // 3->2->2
		L2 = reverseList(L2); // 4->5>6
								// L3 7->7->8 reverse ==> 8->7->7
		int remainder = 0;
		ListNode L3 = null, p1 = L1, p2 = L2, previousNode = null;
		// Better approach is 
		// While(p1!= null || p2!= null) // single while loop solution
		while (p1 != null && p2 != null) {
			int val1 = p1.getVal();
			int val2 = p2.getVal();
			ListNode node = new ListNode((val1 + val2 + remainder) % 10);
			remainder = (val1 + val2 + remainder) / 10; // 0 or 1
			// set new list header
			if (L3 == null) {
				L3 = node;
			} else {
				previousNode.next = node;
			}
			previousNode = node;
			p1 = p1.next;
			p2 = p2.next;
		}
		if (p1 != null) {
			p2 = p1;
		}
		while (p2 != null) {
			ListNode node = new ListNode((p2.getVal() + remainder) % 10); // 999999 remainder 1 0000001
			remainder = (p2.getVal() + remainder) / 10;
			previousNode.next = node;
			previousNode = node;
			p2 = p2.next;
		}
		if (remainder > 0) {
			previousNode.next = new ListNode(remainder);
		}

		L1 = reverseList(L1); // 1->2->3
		L2 = reverseList(L2);

		return reverseList(L3);
	}

	private ListNode reverseList(ListNode l1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
