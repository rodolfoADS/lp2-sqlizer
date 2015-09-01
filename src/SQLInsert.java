
public class SQLInsert {

	private String into;
	private String fields;
	private String values;
	
	public SQLInsert into(String table) {
		this.into = table;
		
		return this;
	}

	public SQLInsert set(String field, String value) {
		if (this.fields == null) {
			this.fields = field;
			this.values = "\"" + value + "\"";
		} else {
			this.fields += ", " + field;
			this.values += ", \"" + value + "\"";
		}
		
		return this;
	}
	
	public SQLInsert set(String field, int value) {
		if (this.fields == null) {
			this.fields = field;
			this.values = String.valueOf(value);
		} else {
			this.fields += ", " + field;
			this.values += ", " + String.valueOf(value) + "";
		}
		
		return this;
	}
	
	@Override
	public String toString() {
		if (into == null || fields == null)
			throw new IncompleteQueryException("A consulta SQLInsert deve especificar a tabela de destino e ao menos 1 campo");
		
		String sql = "INSERT INTO " + into + " (" + fields + ")" + " VALUES (" + values + ")"; 
		
		return sql + ";";
	}

}
