


public class Land extends Kare{
	private int cost;
	private String owner;
	private int rent;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getRent() {
		if (cost<2001)
		{
			rent = cost * 40 / 100;
		}
		else if (cost<3001)
		{
			rent = cost * 30 / 100;
		}
		else if (cost<4001)
		{
			rent = cost * 35 / 100;
		}
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}
	
}

