package com.edupsousa.sqlizer.util;

import java.util.LinkedHashMap;

public interface SetGeneration {

	public String getSql(LinkedHashMap<String, String> fields);
	
}
