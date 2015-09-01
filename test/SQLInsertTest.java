import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;


public class SQLInsertTest {

	@Test
	public void insertIntoSet() {
		String sql = SQlizer
				.insert()
				.into("table")
				.set("field", "value")
				.toString();
		
		assertEquals("INSERT INTO table (field) VALUES (\"value\");", sql);
	}
	
	@Test
	public void insertIntoSetStringSetInteger() {
		String sql = SQlizer
				.insert()
				.into("table")
				.set("field", "value")
				.set("fieldB", 2)
				.toString();
		
		assertEquals("INSERT INTO table (field, fieldB) VALUES (\"value\", 2);", sql);
	}
	
	@Test
	public void insertIntoSetDoubleSetDate() {
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.SEPTEMBER, 1, 12, 0, 0);
		
		String sql = SQlizer
				.insert()
				.into("table")
				.set("field", 2.55)
				.set("fieldB", c.getTime())
				.toString();
		
		assertEquals("INSERT INTO table (field, fieldB) VALUES (2.55, \"2015-09-01 12:00:00\");", sql);
	}

}
