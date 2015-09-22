package com.edupsousa.sqlizer.sqlclauses;
import com.edupsousa.sqlizer.util.IncompleteQueryException;
import com.edupsousa.sqlizer.util.QueryConditions;


public class SQLSelect {
	
	private String fields;
	private String from;
	private QueryConditions conditions = new QueryConditions();
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
		
		if (!conditions.isEmpty())
			sql += " " + this.conditions.getSql();
		
		if (orderBy != null)
			sql += " ORDER BY " + this.orderBy;
		
		return sql + ";";
	}

	public SQLSelect where(String condition) {
		this.conditions.where(condition);
		return this;
	}

	public SQLSelect andWhere(String condition) {
		this.conditions.andWhere(condition);		
		return this;
	}

	public SQLSelect orderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public SQLSelect orWhere(String condition) {
		this.conditions.orWhere(condition);		
		return this;
	}
}
