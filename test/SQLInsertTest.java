import static org.junit.Assert.*;

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

}
