
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
