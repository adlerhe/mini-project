package mini_project;
public class ronaldofan extends Ilovemessi{
	private String position;
	public ronaldofan(String name, int age, String height, String position) {
		super(name, age, height, "Cristinao Ronaldo");
		this.position = position;
	}
	public String toString() {
		return super.getName() + ", " + super.getAge() + ", " + super.getheight()  + ", " + super.whatcoachdecides()+ ", "+ position; 
	}
	public int edisonAge() {
		int age = super.getAge();
		age = 2021- 1985;
		return age;
	}
	public static void main(String[] args) {
		ronaldofan basicin = new ronaldofan("explosive power", 142, "185cm", "left wing");
		System.out.println(basicin);
		System.out.println(basicin.edisonAge());
	}
}