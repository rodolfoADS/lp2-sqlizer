
public class QueryConditions {
	private String condition;
	
	public void where(String condition) {
		this.condition = condition;
	}
	
	public void andWhere(String condition) {
		if (this.condition == null)
			throw new IncompleteQueryException("Você deve usar o método where() antes andWhere().");
		
		this.condition += " AND " + condition;
	}
	
	public boolean isEmpty() {
		return (condition == null);
	}
	
	public String getSql() {
		return "WHERE " + condition;
	}

	public void orWhere(String condition) {
		if (this.condition == null)
			throw new IncompleteQueryException("Você deve usar o método where() antes de orWhere().");
		
		this.condition += " OR " + condition;
	}
}
