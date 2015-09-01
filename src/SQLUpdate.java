
public class SQLUpdate {

	private String table;
	private String set;
	private String where;
	
	public SQLUpdate(String table) {
		this.table = table;
	}

	public SQLUpdate set(String field, String value) {
		String setValue = field + "=\"" + value + "\"";
		
		if (this.set == null) {
			this.set = setValue;
		} else {
			this.set += ", " + setValue;
		}
		
		return this;
	}
	
	@Override
	public String toString() {
		if (set == null)
			throw new IncompleteQueryException("Sua consulta UPDATE deve definir o valor de ao menos 1 campo.");
		
		String sql = "UPDATE " + this.table + " SET " + this.set;
		
		if (this.where != null)
			sql += " WHERE " + this.where;
		
		return sql + ";";
	}

	public SQLUpdate set(String field, int value) {
		String setValue = field + "=" + String.valueOf(value);
		
		if (this.set == null) {
			this.set = setValue;
		} else {
			this.set += ", " + setValue;
		}
		
		return this;
	}

	public SQLUpdate where(String field, String value) {
		this.where = field + "=\"" + value + "\"";
		
		return this;
	}

	public SQLUpdate andWhere(String field, String value) {
		if (this.where == null)
			throw new IncompleteQueryException("Você deve usar o método where() antes andWhere().");
		
		this.where += " AND " + field + "=\"" + value + "\"";
		
		return this;
	}
	
	
}
