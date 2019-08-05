package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Student;

public class StudentTest {

	@Test
	public void test() {
		Student s = new Student("R03", "Ronan", "Roche", "rr@gmail.com", "0856944412", "05/12/1994");
		String fname = s.getName().getFname();
		String mname = s.getName().getMname();
		String lname = s.getName().getLname();
		String email = s.getEmail();
		String phone = s.getPhone();
		String id = s.getStudentId();
		String dob = s.getDob();
		assertEquals("Ronan", fname);
		assertEquals(null, mname);
		assertEquals("Roche", lname);
		assertEquals("R03", id);
		assertEquals("rr@gmail.com", email);
		assertEquals("0856944412", phone);
		assertEquals("05/12/1994", dob);
		//fail("Failed");
	}

}
