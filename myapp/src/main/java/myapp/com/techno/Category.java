package myapp.com.techno;

public class Category {
	private int id;
    private String name;
    private int subid;
    
    
	public Category(int id, String name, int subid) {
		super();
		this.id = id;
		this.name = name;
		this.subid = subid;
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
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
 
    
}
