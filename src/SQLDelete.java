
public class SQLDelete {

	private String from;
	private QueryConditions conditions = new QueryConditions();
	
	public SQLDelete from(String table) {
		from = table;
		return this;
	}
	
	@Override
	public String toString() {
		if (from == null)
			throw new IncompleteQueryException("Não foi invocado o método from() para a consulta SQLDelete.");
		
		String sql = "DELETE FROM " + from;
		
		if (!conditions.isEmpty())
			sql += " " + this.conditions.getSql();
		
		return sql + ";";
	}

	public SQLDelete where(String condition) {
		this.conditions.where(condition);
		
		return this;
	}
	
	public SQLDelete andWhere(String condition) {
		this.conditions.andWhere(condition);
		
		return this;
	}

	public SQLDelete orWhere(String condition) {
		this.conditions.orWhere(condition);
		
		return this;
	}
}
