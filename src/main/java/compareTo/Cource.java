package compareTo;
public class Cource 
{
	int id;
	String name;
	double fees;
	String sortBy="desc_id";
	
	public Cource() {
		super();
	}
	public Cource(int id, String name, double fees) {
		super();
		this.id = id;
		this.name = name;
		this.fees = fees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	@Override
	public String toString() 
	{
		return "  "+id+"  "+name+"  "+fees+"  "+sortBy;
	}
}
