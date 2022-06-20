import java.util.ArrayList;


public class Player extends User {
	private ArrayList<String> properties;
	private int dice;
	private int money = 15000;
	private int location = 1;
	private boolean inJail = false;
	private int jailCounter = 1;
	private int owningRailroads=0;
	
	public Player(){
		properties=new ArrayList<>();
	}
	public void addProp(String name){
		properties.add(name);
	}
	
	
	public ArrayList<String> getProperties() {
		return properties;
	}

	public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getJailCounter() {
		return jailCounter;
	}

	public void setJailCounter(int jailCounter) {
		this.jailCounter = jailCounter;
	}

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public int getOwningRailroads() {
		return owningRailroads;
	}

	public void setOwningRailroads(int owningRailroads) {
		this.owningRailroads = owningRailroads;
	}
	public boolean hasProperty(String name){return properties.contains(name);}
	
	
}

