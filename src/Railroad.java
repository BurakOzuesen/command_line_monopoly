

public class Railroad extends Kare{
	private int cost;
	private String owner;
	private int rent;
	private int chain;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getRent() {
		rent = chain * 25;
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

	public int getChain() {
		return chain;
	}

	public void setChain(int chain) {
		this.chain = chain;
	}
	
	
	
	
}	

