
public class SQLDelete {

	private String from;
	private String where;
	
	public SQLDelete from(String table) {
		from = table;
		return this;
	}
	
	@Override
	public String toString() {
		if (from == null)
			throw new IncompleteQueryException("Não foi invocado o método from() para a consulta SQLDelete.");
		
		String sql = "DELETE FROM " + from;
		
		if (where != null)
			sql += " WHERE " + where;
		
		return sql + ";";
	}

	public SQLDelete where(String condition) {
		this.where = condition;
		
		return this;
	}
	
	public SQLDelete andWhere(String condition) {
		if (this.where == null)
			throw new IncompleteQueryException("Você deve usar o método where() antes andWhere().");
		
		this.where += " AND " + condition;
		
		return this;
	}
}
