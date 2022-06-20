


public class Company extends Kare{
	private int cost;
	private String owner;
	private int rent;
	private int comingDice;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getRent() {
		rent = 4 * comingDice;
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getComingDice() {
		return comingDice;
	}

	public void setComingDice(int comingDice) {
		this.comingDice = comingDice;
	}
}

