package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Name;

public class NameTest {

	@Test
	public void testNoMname() {
		Name n = new Name("Ronan", "Roche");
		String fname = n.getFname();
		String mname = n.getMname();
		String lname = n.getLname();
		assertEquals("Ronan", fname);
		assertEquals(null, mname);
		assertEquals("Roche", lname);

	}
	
	@Test
	public void testWithMname() {
		Name n = new Name("Ronan", "asdf", "Roche");
		String fname = n.getFname();
		String mname = n.getMname();
		String lname = n.getLname();
		assertEquals("Ronan", fname);
		assertEquals("asdf", mname);
		assertEquals("Roche", lname);

	}

}
