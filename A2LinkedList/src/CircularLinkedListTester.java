import static org.junit.Assert.*;

import org.junit.Test;


public class CircularLinkedListTester {

	@Test
	public void testConstructor() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringReverse());
		assertEquals(0, b.size());
	}
	
	@Test
	public void testappend() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();
		b.append(7);
		assertEquals("[7]", b.toString());
		assertEquals("[7]", b.toStringReverse());
		assertEquals(1, b.size());
		b.append(8);
		assertEquals("[7, 8]", b.toString());
		assertEquals("[8, 7]", b.toStringReverse());
		assertEquals(2, b.size());
	}
	
	@Test
	public void testprepend() {
		CircularLinkedList<String> b= new CircularLinkedList<String>();
		b.prepend("a");
		assertEquals("[a]", b.toString());
		assertEquals("[a]", b.toStringReverse());
		assertEquals(1, b.size());
		b.prepend("b");
		assertEquals("[b, a]", b.toString());
		assertEquals("[a, b]", b.toStringReverse());
		assertEquals(2, b.size());
	}
	
	@Test
	public void testinsertBefore() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();
		b.append(18);
		b.insertBefore(5, b.getFirst());
		assertEquals("[18, 5]", b.toString());
		assertEquals("[5, 18]", b.toStringReverse());
		assertEquals(2, b.size());
		b.append(23);
		b.insertBefore(17, b.getLast());
		assertEquals("[18, 5, 17, 23]", b.toString());
		assertEquals("[23, 17, 5, 18]", b.toStringReverse());
		assertEquals(4, b.size());
	}
	
	@Test
	public void testinsertAfter() {
		CircularLinkedList<Double> b= new CircularLinkedList<Double>();
		b.append(12.5);
		b.insertAfter(6.2, b.getFirst());
		assertEquals("[12.5, 6.2]", b.toString());
		assertEquals("[6.2, 12.5]", b.toStringReverse());
		assertEquals(2, b.size());
		b.append(2.3);
		b.insertAfter(1.7, b.getLast());
		assertEquals("[12.5, 6.2, 2.3, 1.7]", b.toString());
		assertEquals("[1.7, 2.3, 6.2, 12.5]", b.toStringReverse());
		assertEquals(4, b.size());
	}
	
	@Test
	public void testremove() {
		CircularLinkedList<Integer> b= new CircularLinkedList<Integer>();
		b.append(1);
		b.remove(b.getFirst());
		assertEquals("[]", b.toString());
		assertEquals("[]", b.toStringReverse());
		assertEquals(0, b.size());
		b.append(1);
		b.append(2);
		b.append(3);
		b.remove(b.getFirst());
		assertEquals("[2, 3]", b.toString());
		assertEquals("[3, 2]", b.toStringReverse());
		assertEquals(2, b.size());
		b.append(4);
		b.append(5);
		b.remove(b.getLast());
		assertEquals("[2, 3, 4]", b.toString());
		assertEquals("[4, 3, 2]", b.toStringReverse());
		assertEquals(3, b.size());
	}
}
