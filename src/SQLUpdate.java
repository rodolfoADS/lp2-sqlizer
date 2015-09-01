import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SQLUpdate {

	private String table;
	private QuerySetter querySet = new QuerySetter();
	private String where;
	
	public SQLUpdate(String table) {
		this.table = table;
	}

	@Override
	public String toString() {
		if (querySet.size() == 0)
			throw new IncompleteQueryException("Sua consulta UPDATE deve definir o valor de ao menos 1 campo.");
		
		String sql = "UPDATE " + this.table + " " + this.querySet.getSetSql();
		
		if (this.where != null)
			sql += " WHERE " + this.where;
		
		return sql + ";";
	}
	
	public SQLUpdate set(String field, String value) {
		querySet.set(field, value);
		return this;
	}

	public SQLUpdate set(String field, int value) {
		querySet.set(field, value);
		return this;
	}
	
	public SQLUpdate set(String field, double value) {
		querySet.set(field, value);
		return this;
	}
	
	public SQLUpdate set(String field, Date value) {
		querySet.set(field, value);
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
