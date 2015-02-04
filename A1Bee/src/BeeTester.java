import static org.junit.Assert.*;

import org.junit.Test;


public class BeeTester {

	public Bee b;
	public Bee b1;
	public Bee b2;
	public Bee b3;
	public Bee b4;
	public Bee b5;
	public Bee b6;
	public Bee b7;
	
	@Test
	public void testA() {
		b = new Bee("Badass", 'F', 2014, 5);
		assertEquals("Badass", b.getNickname());
		assertEquals(false , b.isMale());
		assertEquals(2014, b.getYear());
		assertEquals(5, b.getMonth());
		assertEquals(null, b.getMom());
		assertEquals(null, b.getDad());
		assertEquals(0, b.getNumChildren());
	}
	
	@Test
	public void testB() {
		
		b = new Bee("Badass", 'F', 2014, 5);
		b1 = new Bee("Badass1", 'M', 2013, 4);
		b2 = new Bee("Badass2", 'F', 2012, 3);
		b.addDad(b1);
		b.addMom(b2);
		
		assertEquals("Badass", b.getNickname());
		assertEquals(false, b.isMale());
		assertEquals(2014, b.getYear());
		assertEquals(5, b.getMonth());
		assertEquals(b2, b.getMom());
		assertEquals(b1, b.getDad());
		assertEquals(0, b.getNumChildren());
	}

	@Test
	public void testC() {
		// creating parent
		b1 = new Bee("Badass1", 'M', 2013, 4);
		b2 = new Bee("Badass2", 'F', 2012, 3);
		
		// testing first constructor 
		b3 = new Bee("Badass3", 2011, 2, b2);

		assertEquals("Badass3", b3.getNickname());
		assertEquals(true, b3.isMale());
		assertEquals(2011, b3.getYear());
		assertEquals(2, b3.getMonth());
		assertEquals(b2, b3.getMom());
		assertEquals(null, b3.getDad());
		assertEquals(0, b1.getNumChildren());
		assertEquals(1, b2.getNumChildren());
		
		// testing second constructor
		b4 = new Bee("Badass4", 2010, 1, b2, b1);
		
		assertEquals("Badass4", b4.getNickname());
		assertEquals(false, b4.isMale());
		assertEquals(2010, b4.getYear());
		assertEquals(1, b4.getMonth());
		assertEquals(b2, b4.getMom());
		assertEquals(b1, b4.getDad());
		assertEquals(1, b1.getNumChildren());
		assertEquals(2, b2.getNumChildren());
	}
	
	@Test
	public void testD() {
		// creating parent
		b1 = new Bee("Badass1", 'M', 2013, 4);
		b2 = new Bee("Badass2", 'F', 2012, 3);
		b6 = new Bee("Baddass6", 'F', 2012, 3);
		
		// creating kids (siblings)
		b3 = new Bee("Badass3", 2011, 2, b2);
		b4 = new Bee("Badass4", 2010, 1, b2, b1);
		b7 = new Bee("Baddass7", 2010, 2, b6);

		// testing isYounger
		assertEquals(true, b1.isYounger(b2));
		assertEquals(false, b2.isYounger(b6));
		assertEquals(true, b7.isYounger(b4));
		assertEquals(true, b3.isYounger(b7));
		assertEquals(false, b1.isYounger(b1));
		
		// testing isSibling, e is null
		b5 = null;
		assertEquals(false, b1.isSibling(b5));
		//mother is null
		assertEquals(false, b1.isSibling(b2));
		//siblings
		assertEquals(true, b3.isSibling(b4));		
		//not siblings
		assertEquals(false, b7.isSibling(b6));
		//testing itself
		assertEquals(false, b7.isSibling(b7));
		
	}
	
}
