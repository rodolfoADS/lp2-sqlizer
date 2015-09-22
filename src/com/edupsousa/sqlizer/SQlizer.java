package com.edupsousa.sqlizer;
import com.edupsousa.sqlizer.sqlclauses.SQLDelete;
import com.edupsousa.sqlizer.sqlclauses.SQLInsert;
import com.edupsousa.sqlizer.sqlclauses.SQLSelect;
import com.edupsousa.sqlizer.sqlclauses.SQLUpdate;


public class SQlizer {

	public static SQLSelect select(String fields) {
		return new SQLSelect(fields);
	}

	public static SQLDelete delete() {
		return new SQLDelete();
	}

	public static SQLInsert insert() {
		return new SQLInsert();
	}

	public static SQLUpdate update(String table) {
		return new SQLUpdate(table);
	}
	
}
