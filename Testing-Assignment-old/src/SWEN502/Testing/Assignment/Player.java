package SWEN502.Testing.Assignment;

public class Player {

	private String name;
	private String nation;
	private String club;
	private int age;
	private String position;
	private double market_value;
	
	public Player(String name, int age, String club, String nation, String position, double market_value) {
		
		if(name == null) {
			System.out.println("Player name must not be null\n");
			return;
		}
		
		this.name = name;
		this.age = age;
		this.club = club;
		this.nation = nation;
		this.position = position;
		this.market_value = market_value;

	}

	public String getName() {
		return name;
	}

	public String getNation() {
		return nation;
	}
	
	public String getClub() {
		return club;
	}

	public int getAge() {
		return age;
	}

	public String getPosition() {
		return position;
	}

	public double getMarketValue() {
		return market_value;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nNation: " + nation + "\nClub: " + club + "\nAge: " + age + "\nPosition: "
				+ position + "\nMarket value: £"+ market_value +"M\n";
	}


}

