
public class SQLSelect {
	
	private String fields;
	private String from;
	private String where;
	private String orderBy;

	public SQLSelect(String fields) {
		this.fields = fields;
	}

	public SQLSelect from(String from) {
		this.from = from;
		return this;
	}
	
	@Override
	public String toString() {
		if (from == null)
			throw new IncompleteQueryException("Sua consulta SELECT não invocou o método from().");
		
		String sql  = "SELECT " + this.fields + " FROM " + this.from;
		
		if (where != null)
			sql += " WHERE " + this.where;
		
		if (orderBy != null)
			sql += " ORDER BY " + this.orderBy;
		
		return sql + ";";
	}

	public SQLSelect where(String condition) {
		this.where = condition;
		
		return this;
	}

	public SQLSelect andWhere(String condition) {
		if (this.where == null)
			throw new IncompleteQueryException("Você deve usar o método where() antes andWhere().");
		
		this.where += " AND " + condition;
		
		return this;
	}

	public SQLSelect orderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}
}
