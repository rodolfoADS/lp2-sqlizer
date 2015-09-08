import static org.junit.Assert.*;

import org.junit.Test;


public class SQLDeleteTest {

	@Test
	public void deleteFromTable() {
		String sqlDelete = SQlizer
				.delete()
				.from("table")
				.toString();
		
		assertEquals("DELETE FROM table;", sqlDelete);
	}
	
	@Test
	public void deleteFromWhere() {
		String sql = SQlizer
				.delete()
				.from("table")
				.where("field = 1")
				.toString();
		assertEquals("DELETE FROM table WHERE field = 1;", sql);
	}
	
	@Test
	public void deleteFromWhereAndWhere() {
		String sql = SQlizer
				.delete()
				.from("table")
				.where("field = 1")
				.andWhere("otherField = 2")
				.toString();
		
		assertEquals("DELETE FROM table WHERE field = 1 AND otherField = 2;", sql);
	}
	
	@Test
	public void deleteFromWhereOrWhere() {
		String sql = SQlizer
				.delete()
				.from("table")
				.where("field = 1")
				.orWhere("otherField = 2")
				.toString();
		
		assertEquals("DELETE FROM table WHERE field = 1 OR otherField = 2;", sql);
	}
	
	@Test
	public void deleteFromAndWhereDeveLancarExcecao() {
		try {
			SQlizer
				.delete()
				.from("table")
				.andWhere("otherField = 2")
				.toString();
			fail();
		} catch (IncompleteQueryException e) {
			assertEquals("Você deve usar o método where() antes andWhere().", e.getMessage());
		}
	}
}
