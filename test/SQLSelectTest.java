import static org.junit.Assert.*;

import org.junit.Test;


public class SQLSelectTest {

	@Test
	public void selectFromTable() {
		String sql = SQlizer.select("*").from("table").toString();
		assertEquals("SELECT * FROM table;", sql);
	}
	
	@Test(expected=IncompleteQueryException.class)
	public void selectSemFromDeveLancarExcecao() {
		SQlizer.select("*").toString();
	}
	
	@Test
	public void selectFromWhere() {
		String sql = SQlizer.select("*").from("table").where("field = 1").toString();
		assertEquals("SELECT * FROM table WHERE field = 1;", sql);
	}
	
	@Test
	public void selectFromWhereAndWhere() {
		String sql = SQlizer
				.select("*")
				.from("table")
				.where("field = 1")
				.andWhere("otherField = 2")
				.toString();
		
		assertEquals("SELECT * FROM table WHERE field = 1 AND otherField = 2;", sql);
	}
	
	@Test
	public void selectFromAndWhereDeveLancarExcecao() {
		try {
			SQlizer
				.select("*")
				.from("table")
				.andWhere("otherField = 2")
				.toString();
			fail();
		} catch (IncompleteQueryException e) {
			assertEquals("Você deve usar o método where() antes andWhere().", e.getMessage());
		}
	}
	
	@Test
	public void selectFromOrderBy() {
		String sqlSelectFromOrder = SQlizer
				.select("*")
				.from("table")
				.orderBy("field ASC").toString();
		
		assertEquals("SELECT * FROM table ORDER BY field ASC;", sqlSelectFromOrder);
	}

}
