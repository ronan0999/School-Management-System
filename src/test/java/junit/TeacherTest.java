package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Teacher;

public class TeacherTest {

	@Test
	public void test() {
		Teacher t = new Teacher("T03", "Ronan", "Roche", "rr@gmail.com", "0856944412", "degree1");
		String fname = t.getName().getFname();
		String mname = t.getName().getMname();
		String lname = t.getName().getLname();
		String email = t.getEmail();
		String phone = t.getPhone();
		String id = t.getTeacherId();
		String dob = t.getDegree();
		assertEquals("Ronan", fname);
		assertEquals(null, mname);
		assertEquals("Roche", lname);
		assertEquals("T03", id);
		assertEquals("rr@gmail.com", email);
		assertEquals("0856944412", phone);
		assertEquals("degree1", dob);
		//fail("Failed");
	}

}
