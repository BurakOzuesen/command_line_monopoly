
public class ChanceCard extends Card {
	private int cardQueue;
	private ChanceCard[] addCard;
	public int cnt1=0;
	

	public int getCardQueue() {
		return cardQueue;
	}

	public void setCardQueue(int cardQueue) {
		this.cardQueue = cardQueue;
	}
	public void addCard(ChanceCard m) {
		//Scanner input = new Scanner(System.in);
		this.addCard[cnt1] = m;
		cnt1 = cnt1 + 1;
	}
}

