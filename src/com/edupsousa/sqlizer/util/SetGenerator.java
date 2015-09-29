package com.edupsousa.sqlizer.util;

import java.util.LinkedHashMap;

public class SetGenerator implements SetGeneration {

	@Override
	public String getSql(LinkedHashMap<String, String> fields) {
		String sql = "";
		
		for (String key : fields.keySet()) {
			String value = fields.get(key);
			if (sql.equals("")) {
				sql = "SET " + key + "=" + value;
			} else {
				sql += ", " + key + "=" + value;
			}
		}
		
		return sql;
	}
	
}
