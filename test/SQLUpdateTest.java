import static org.junit.Assert.*;

import org.junit.Test;


public class SQLUpdateTest {

	@Test
	public void updateSet() {
		String sql = SQlizer
				.update("table")
				.set("field", "value")
				.toString();
		
		assertEquals("UPDATE table SET field=\"value\";", sql);
	}
	
	@Test
	public void updateSetSet() {
		String sql = SQlizer
				.update("table")
				.set("field", "value")
				.set("fieldA", "valueA")
				.toString();
		
		assertEquals("UPDATE table SET field=\"value\", fieldA=\"valueA\";", sql);
	}
	
	@Test
	public void updateSetSetInteger() {
		String sql = SQlizer
				.update("table")
				.set("field", 1)
				.set("fieldA", 2)
				.toString();
		
		assertEquals("UPDATE table SET field=1, fieldA=2;", sql);
	}
	
	@Test
	public void updateSetWhere() {
		String sql = SQlizer
				.update("table")
				.set("field", "value")
				.where("field", "valueCondition")
				.toString();
		
		assertEquals("UPDATE table SET field=\"value\" WHERE field=\"valueCondition\";", sql);
	}
	
	@Test
	public void updateSetWhereAndWhere() {
		String sql = SQlizer
				.update("table")
				.set("field", "value")
				.where("fieldA", "valueA")
				.andWhere("fieldB", "valueB")
				.toString();
		
		assertEquals("UPDATE table SET field=\"value\" WHERE fieldA=\"valueA\" AND fieldB=\"valueB\";", sql);
	}
	
	@Test
	public void updateSetAndWhereDeveLancarExcecao() {
		try {
			SQlizer
				.update("table")
				.set("field", "value")
				.andWhere("fieldB", "valueB")
				.toString();
			fail();
		} catch (IncompleteQueryException e) {
			assertEquals("Você deve usar o método where() antes andWhere().", e.getMessage());
		}
	}
	
	@Test
	public void updateIncompletoDeveLancarExcecao() {
		try {
			SQlizer
				.update("table")
				.toString();
			fail();
		} catch (IncompleteQueryException e) {
			assertEquals("Sua consulta UPDATE deve definir o valor de ao menos 1 campo.", e.getMessage());
		}
	}
	
}
