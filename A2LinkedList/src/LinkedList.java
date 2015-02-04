import java.util.ArrayList;


public class LinkedList {
	/** Head of the linked list */
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
	}

	public void append(int i) {
		if (head == null) {
			Node n = new Node(i, null);
			head = n;
			size++;
		}
		else {
			Node n = new Node(i, null);
			tail.next = n;
			tail = n;
			size++;
		}
	}
	
	public ArrayList <LinkedList> split(LinkedList l) {
		ArrayList <LinkedList> answer = new ArrayList(2);
		int s = l.size / 2;
		int count = 0;
		while (count < size) {
			Node h = l.head;
			Node n = h.next;
			if (count < s) {
				answer.get(0).append(h.value);
			}
			else {
				answer.get(1).append(h.value);
			}
			h = n;
			n = n.next;
			count++;
		}
		return answer;
	}
	
	public LinkedList merge(LinkedList l1, LinkedList l2) {
		LinkedList answer = new LinkedList();
		while (l1.size > 0 && l2.size > 0) {
			if (l1.head.value < l2.head.value) {
				answer.append(l1.head.value);
				l1.head = l1.head.next;
				l1.size = l1.size - 1;
			}
			else {
				answer.append(l2.head.value);
				l2.head = l2.head.next;
				l2.size = l2.size - 1;
			}
		}
		while (l2.size > 0) {
			answer.append(l2.head.value);
			l2.head = l2.head.next;
			l2.size = l2.size - 1;
		}
		while (l1.size > 0) {
			answer.append(l1.head.value);
			l1.head = l1.head.next;
			l1.size = l1.size - 1;
		}
		return answer;
	}
	
	public LinkedList mergeSort(LinkedList l) {
		if (l.size == 1) {
			return l;
		}
		else {
			ArrayList <LinkedList> s = split(l);
			LinkedList left = s.get(0);
			LinkedList right = s.get(1);
			return merge(mergeSort(left), mergeSort(right));
		}
		
	}
	

	public class Node {
		/** Value of this node */
		private int value;

		/** Next node after this, null if on tail */
		private Node next;

		/** Constructor: returns an instance of a Node 
		 * @param v Integer value stored in this Node
		 * @param s Node linked after this Node (null if it's the tail)
		 */
		public Node(int v, Node n) {

			value = v;
			next = n;
		}

		public int getValue() {
			return value;
		}
		
		public Node next() {
			return next;
		}

	}

}