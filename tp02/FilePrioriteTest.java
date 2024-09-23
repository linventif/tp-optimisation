package tp02;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for a priority queue
 * @author <a href="mailto:Frederic.Guyomarch@univ-lille1.fr">Frédéric Guyomarch</a>, IUT-A
 * @date January 18th
 */


public class FilePrioriteTest {

	@Test
	public void testIsEmpty() {
		FilePrioriteTas<Integer> tas = new FilePrioriteTas<>();
		assertTrue(tas.isEmpty());
		tas.offer(20);
    assertFalse(tas.isEmpty());
	}

	@Test
	public void testMakeEmpty() {
		FilePrioriteTas<Integer> tas = new FilePrioriteTas<>();
		tas.offer(20);
		tas.clear();
		assertTrue(tas.isEmpty());
	}

	@Test
	public void testToString() {
		FilePrioriteTas<Integer> tas = new FilePrioriteTas<>();
		assertEquals(tas.toString(), "[]");
		tas.offer(14);
		tas.offer(10);
		tas.offer(16);
		assertEquals("[16, 10, 14]", tas.toString());
	}

	@Test                                 
	public void testOffer() {
		FilePrioriteTas<Integer> tas = new FilePrioriteTas<>(10);
		assertTrue(tas.offer(33));
		assertTrue(tas.offer(45));
		assertTrue(tas.offer(7));
		assertTrue(tas.offer(20));
		assertTrue(tas.offer(10));
		assertTrue(tas.offer(50));
		assertEquals("[50, 33, 45, 20, 10, 7]", tas.toString());
	}

	@Test                                 
	public void testOfferFull() {
		FilePrioriteTas<Integer> tas = new FilePrioriteTas<>(4);
		assertTrue(tas.offer(33));
		assertTrue(tas.offer(45));
		assertTrue(tas.offer(7));
		assertTrue(tas.offer(20));
		assertFalse(tas.offer(10));
		assertFalse(tas.offer(50));
		assertEquals("[45, 33, 7, 20]", tas.toString());
	}

	@Test
	public void testSize() {
		FilePrioriteTas<Integer> tas = new FilePrioriteTas<>();
		assertEquals(0, tas.size());
		tas.offer(33);
		tas.offer(45);
		tas.offer(7);
		assertEquals(3, tas.size());
		tas.offer(17);
		tas.offer(1);
		assertEquals(5, tas.size());
	}

	@Test
	public void testPoll() {
		FilePrioriteTas<Integer> tas = new FilePrioriteTas<>();
		assertEquals(null, tas.poll());
		tas.offer(5);
		tas.offer(4);
		tas.offer(33);
		assertEquals(3, tas.size());
		assertEquals(new Integer(33), tas.poll());
		assertEquals(2, tas.size());
		assertEquals(new Integer(5), tas.poll());
		assertEquals(1, tas.size());
		assertEquals(new Integer(4), tas.poll());
		assertTrue(tas.isEmpty());
	}

	@Test
	public void testPeek() {
		FilePrioriteTas<Integer> tas = new FilePrioriteTas<>();
		tas.offer(5);
		tas.offer(4);
		tas.offer(33);
		assertEquals(new Integer(33), tas.peek());
		tas.offer(34);
		assertEquals(new Integer(34), tas.peek());
		tas.offer(28);
		assertEquals(new Integer(34), tas.peek());
	}
}

