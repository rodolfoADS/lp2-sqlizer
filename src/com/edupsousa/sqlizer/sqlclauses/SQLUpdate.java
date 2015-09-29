package com.edupsousa.sqlizer.sqlclauses;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.edupsousa.sqlizer.util.IncompleteQueryException;
import com.edupsousa.sqlizer.util.QueryConditions;
import com.edupsousa.sqlizer.util.QuerySetter;


public class SQLUpdate {

	private String table;
	private QuerySetter querySet = new QuerySetter();
	private QueryConditions conditions = new QueryConditions();
	
	public SQLUpdate(String table) {
		this.table = table;
	}

	@Override
	public String toString() {
		if (querySet.size() == 0)
			throw new IncompleteQueryException("Sua consulta UPDATE deve definir o valor de ao menos 1 campo.");
		
		String sql = "UPDATE " + this.table + " " + this.querySet.getSql(1);
		
		if (!this.conditions.isEmpty())
			sql += " " + this.conditions.getSql();
		
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

	public SQLUpdate where(String condition) {
		this.conditions.where(condition);
		
		return this;
	}

	public SQLUpdate andWhere(String condition) {
		this.conditions.andWhere(condition);
		
		return this;
	}

	public SQLUpdate orWhere(String condition) {
		this.conditions.orWhere(condition);
		
		return this;
	}

}
