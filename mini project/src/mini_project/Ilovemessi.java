package mini_project;
public class Ilovemessi extends soccerstars{
	private String position;
	public Ilovemessi(String name, int age, String height, String position) {
		super(name, age, height);
		this.position = position;
	}
	public String toString() {
		return super.getName() + ", " + super.getAge() + ", " + super.getheight() + ", " + position;
	}
	
	public String whatcoachdecides() {
		return position;
	}
	
	public boolean isshort() {
		if(super.getheight() == "170cm") {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Ilovemessi computer = new Ilovemessi("agile", 170, "striker", "Lionel Messi");
		System.out.println(computer);
		System.out.println(computer.isshort());
	}
	
	
}