import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PrintStream;

import org.json.simple.parser.ParseException;

import java.io.PrintWriter; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap; 
import java.util.List;
import java.util.Map; 

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;



public class Main {

	public static void main(String[] args) {
		Kare[] map = new Kare[40];
		try {
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String proc = "";
		String pro = "";
		ArrayList<Integer> Mulk = new ArrayList<>();
		ArrayList<Integer> Sans = new ArrayList<>();
		ArrayList<Integer> Kamu = new ArrayList<>();
		Kamu.add(3);
		Kamu.add(18);
		Kamu.add(34);
		Sans.add(8);
		Sans.add(23);
		Sans.add(37);
		Mulk.add(2);
		Mulk.add(4);
		Mulk.add(7);
		Mulk.add(9);
		Mulk.add(10);
		Mulk.add(12);
		Mulk.add(14);
		Mulk.add(15);
		Mulk.add(17);
		Mulk.add(19);
		Mulk.add(20);
		Mulk.add(22);
		Mulk.add(24);
		Mulk.add(25);
		Mulk.add(27);
		Mulk.add(28);
		Mulk.add(30);
		Mulk.add(32);
		Mulk.add(33);
		Mulk.add(35);
		Mulk.add(38);
		Mulk.add(40);
		ArrayList<Integer> Station = new ArrayList<>();
		Station.add(6);
		Station.add(16);
		Station.add(26);
		Station.add(36);
		ArrayList<Integer> Comp = new ArrayList<>();
		Comp.add(13);
		Comp.add(29);
		ArrayList<String> ChanceList = new ArrayList<>();
		ArrayList<String> CommunityList = new ArrayList<>();
		int cnt1=0;
		int cnt2=0;
		
		
		
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
	
		try
		{
			Object object = new JSONParser().parse(new FileReader("property.json"));
			JSONObject jsonObject = (JSONObject) object;
			JSONArray one = (JSONArray) jsonObject.get("1");
			/*System.out.println(jsonObject);
			int id = (int) jsonObject.get("id");*/
			for(int i = 0;i<one.size();i++){
				//System.out.println(one.get(i));
				JSONObject temp_line  = (JSONObject) one.get(i);
				String name = (String) temp_line.get("name");
				String cost = (String) temp_line.get("cost");
				String id = (String) temp_line.get("id");
				//System.out.println("name :"+ name);
				//System.out.println("cost :"+cost);
				//System.out.println("id   :"+id);
				Land land = new Land();
				land.setCost(Integer.valueOf(cost));
				land.setName(name);
				land.setSquareID(Integer.valueOf(id));
				map[Integer.valueOf(id)-1] = land;
				//System.out.println(map[Integer.valueOf(id)-1].getName());
				
			}
				JSONArray two = (JSONArray) jsonObject.get("2");
				/*System.out.println(jsonObject);
				int id = (int) jsonObject.get("id");*/
				for(int ii = 0;ii<two.size();ii++){
					//System.out.println(one.get(i));
					JSONObject temp_line1  = (JSONObject) two.get(ii);
					String name1 = (String) temp_line1.get("name");
					String cost1 = (String) temp_line1.get("cost");
					String id1 = (String) temp_line1.get("id");
					//System.out.println("name :"+ name1);
					//System.out.println("cost :"+cost1);
					//System.out.println("id   :"+id1);
					Railroad railroad = new Railroad();
					railroad.setCost(Integer.valueOf(cost1));
					railroad.setName(name1);
					railroad.setSquareID(Integer.valueOf(id1));
					map[Integer.valueOf(id1)-1] = railroad;
			}
				JSONArray three = (JSONArray) jsonObject.get("3");
				/*System.out.println(jsonObject);
				int id = (int) jsonObject.get("id");*/
				for(int iii = 0;iii<three.size();iii++){
					//System.out.println(one.get(i));
					JSONObject temp_line1  = (JSONObject) three.get(iii);
					String name1 = (String) temp_line1.get("name");
					String cost1 = (String) temp_line1.get("cost");
					String id1 = (String) temp_line1.get("id");
					//System.out.println("name :"+ name1);
					//System.out.println("cost :"+cost1);
					//System.out.println("id   :"+id1);
					Company company = new Company();
					company.setCost(Integer.valueOf(cost1));
					company.setName(name1);
					company.setSquareID(Integer.valueOf(id1));
					map[Integer.valueOf(id1)-1] = company;
			}
				Object object1 = new JSONParser().parse(new FileReader("list.json"));
				JSONObject jsonObject1 = (JSONObject) object1;
				JSONArray chanceList = (JSONArray) jsonObject1.get("chanceList");
				for(int i = 0; i<chanceList.size(); i++){
					JSONObject temp_line = (JSONObject) chanceList.get(i);
					String item = (String) temp_line.get("item");
					ChanceCard card1 = new ChanceCard();
					card1.setItem(item);
					card1.setCardQueue(cnt1);
					ChanceList.add(item);
					cnt1++;
					//System.out.println("item : " + item);
					
				}
				JSONArray communityChestList = (JSONArray) jsonObject1.get("communityChestList");
				for(int i = 0; i<communityChestList.size(); i++)
				{
					JSONObject temp_line = (JSONObject) communityChestList.get(i);
					String item = (String) temp_line.get("item");
					CommunityCard card2 = new CommunityCard();
					card2.setItem(item);
					card2.setCardQueue(cnt2);
					CommunityList.add(item);
					cnt2++;
					
					//System.out.println("item : " + item);
				}
				map[2] = new Kare();
				map[2].setName("Community Chest");
				map[2].setSquareID(3);
				map[17] = new Kare();
				map[17].setName("Community Chest");
				map[17].setSquareID(18);
				map[33] = new Kare();
				map[33].setName("Community Chest");
				map[33].setSquareID(34);
				map[36] = new Kare();
				map[36].setName("Chance List");
				map[36].setSquareID(37);
				map[22] = new Kare();
				map[22].setName("Chance List");
				map[22].setSquareID(23);
				map[7] = new Kare();
				map[7].setName("Chance List");
				map[7].setSquareID(8);
				map[0] = new Kare();
				map[0].setName("GO");
				map[0].setSquareID(1);
				map[4] = new Kare();
				map[4].setName("Income Tax");
				map[4].setSquareID(5);
				map[10] = new Kare();
				map[10].setName("Jail");
				map[10].setSquareID(11);
				map[20] = new Kare();
				map[20].setName("Free Parking");
				map[20].setSquareID(21);
				map[30] = new Kare();
				map[30].setName("Go to Jail");
				map[30].setSquareID(31);
				map[38] = new Kare();
				map[38].setName("Super Tax");
				map[38].setSquareID(39);
				Player P1 = new Player();
				Player P2 = new Player();
				Banker Banker = new Banker();
				Banker.setMoney(100000);
				P1.setMoney(15000);
				P2.setMoney(15000);
				//System.out.println(P1.getJailCounter());
				List<String> allLines = Files.readAllLines(Paths.get(args[0]));
				for (String line : allLines)
				{
					String mystring = line;
					String arr[] = mystring.split(" ",2);
					String firstWord = arr[0];   // ilk kelime (komut)
					//System.out.println(firstWord);
					if(firstWord.equals("Player"))
					{
						String theRest = arr[1];
						String parameters[] = theRest.split(";",2);
						if (parameters[0].equals("1"))
						{
							if (P1.isInJail() == false)
							{
								P1.setDice(Integer.valueOf(parameters[1]));
								if (P1.getLocation()+P1.getDice()>40)
								{
									P1.setMoney(P1.getMoney()+200);
									Banker.setMoney(Banker.getMoney()-200);
								}
								P1.setLocation((P1.getLocation()+ Integer.valueOf(parameters[1]))%40);
								if(P1.getLocation()==0)
								{
									P1.setLocation(40);
								}
								if(P1.getLocation()==31)
								{
									P1.setLocation(11);
								}
								//System.out.println("atilan zar: " + P1.getDice());
								//System.out.println("bulunulan konum: " + P1.getLocation());
								//System.out.println(P1.getJailCounter());
								
								if (P1.getLocation()==11 || P1.getLocation()==31)
								{
									//System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\tPlayer 1 went to jail");
									proc = "Player 1 went to jail";
									//System.out.println("mapus: " + P1.getJailCounter());
									P1.setInJail(true);}
								else {
									//System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney());
									
									}
							}
							else if (P1.getLocation()==11 || P1.getLocation()==31)
							{
								//System.out.println("mapus: " + P1.getJailCounter());
								P1.setInJail(true);
								P1.setLocation(11);
								P1.setDice(Integer.valueOf(parameters[1]));
								//System.out.println("atilan zar: " + P1.getDice());
								if (P1.getJailCounter()==0)
								{
									//System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\tPlayer 1 went to jail");
									proc ="Player 1 went to jail";
								}
								//System.out.println("bulunulan konum: " + P1.getLocation());
								P1.setJailCounter(P1.getJailCounter()+1);
								//System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\tPlayer 1 in jail (count="+(P1.getJailCounter()-1)+")");
								proc="Player 1 in jail (count="+(P1.getJailCounter()-1+")");
								//System.out.println(P1.getJailCounter());
								if (P1.getJailCounter() == 4)
								{
									P1.setJailCounter(1);
									P1.setInJail(false);
								}
							}
							if(Sans.contains(P1.getLocation()))
							{
								if(ChanceList.get(0).equals("Advance to Go (Collect $200)"))
								{
									P1.setLocation(1);
									P1.setMoney(P1.getMoney()+200);
									Banker.setMoney(Banker.getMoney()-200);
									ChanceList.add("Advance to Go (Collect $200");
									proc="Player 1 draw Advance to Go (Collect $200";
									ChanceList.remove(0);
								}
								else if(ChanceList.get(0).equals("Advance to Leicester Square"))
								{
									if(P1.getLocation()==37){
										P1.setMoney(P1.getMoney()+200);
										Banker.setMoney(Banker.getMoney()-200);
									}
									P1.setLocation(27);
									ChanceList.add("Advance to Leicester Square");
									proc="Player 1 draw Advance to Leicester Square";
									pro="Player 1 draw Advance to Leicester Square ";
									ChanceList.remove(0);
									
								}
								else if(ChanceList.get(0).equals("Go back 3 spaces"))
								{
									P1.setLocation(P1.getLocation()-3);
									ChanceList.add("Go back 3 spaces");
									proc="Player 1 draw Go back 3 spaces";
									pro="Player 1 draw Go back 3 spaces";
									ChanceList.remove(0);
								}
								else if(ChanceList.get(0).equals("Pay poor tax of $15"))
								{
									if(P1.getMoney()<15){
										proc="Player 1 goes bankrupt";
										System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{	
									P1.setMoney(P1.getMoney()-15);
									Banker.setMoney(Banker.getMoney()+15);
									ChanceList.add("Pay poor tax of $15");
									proc="Pay poor tax of $15";
									ChanceList.remove(0);
									}
								}
								else if(ChanceList.get(0).equals("Your building loan matures - collect $150"))
								{
									P1.setMoney(P1.getMoney()+150);
									Banker.setMoney(Banker.getMoney()-150);
									ChanceList.add("Your building loan matures - collect $150");
									proc="Your building loan matures - collect $150";
									ChanceList.remove(0);
								}
								else if(ChanceList.get(0).equals("You have won a crossword competition - collect $100 "))
								{
									P1.setMoney(P1.getMoney()+100);
									Banker.setMoney(Banker.getMoney()-100);
									ChanceList.add("You have won a crossword competition - collect $100 ");
									proc="You have won a crossword competition - collect $100 ";
									ChanceList.remove(0);
								}
								//System.out.println(ChanceList.get(0));
								//proc="Sans karti cektim";
								//System.out.println(proc);
							}
							if(Mulk.contains(P1.getLocation()) || Station.contains(P1.getLocation() ) || Comp.contains(P1.getLocation()))
							{
								if(P2.hasProperty(map[P1.getLocation()-1].getName()))
								{
									if(Mulk.contains(P1.getLocation()))
									{
										if(P1.getMoney()<map[P1.getLocation()-1].getRent()){
											System.exit(0);
										}else{
											if(P1.getMoney()<map[P1.getLocation()-1].getRent()){
												proc="Player 1 goes to bankrupt";
												System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
												System.out.println("-----------------------------------------------------------------------------------------------------------");
												System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
												//n.toString().replace("[","").replace("]",""));
												System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
												System.out.println("Banker\t"+Banker.getMoney());
												if(P1.getMoney()<P2.getMoney())
												{
													System.out.println("Winner Player 2");
												}
												else if(P1.getMoney()>P2.getMoney())
												{
													System.out.println("Winner Player 1");
												}
												else
												{
													System.out.println("Draw");
												}
												System.out.println("-----------------------------------------------------------------------------------------------------------");
												System.exit(0);}
											else{
										P1.setMoney(P1.getMoney()-map[P1.getLocation()-1].getRent());
										P2.setMoney(P2.getMoney()+map[P1.getLocation()-1].getRent());
										proc="Player 1 paid rent for "+map[P1.getLocation()-1].getName();
										//System.out.println("player 1 rent");
											}
										}
									}
									if(Station.contains(P1.getLocation()))
									{
										if(P1.getMoney()<map[P1.getLocation()-1].getRent()){
											proc="Player 1 goes bankrupt";
											System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
													System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
											//n.toString().replace("[","").replace("]",""));
											System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
											System.out.println("Banker\t"+Banker.getMoney());
											if(P1.getMoney()<P2.getMoney())
											{
												System.out.println("Winner Player 2");
											}
											else if(P1.getMoney()>P2.getMoney())
											{
												System.out.println("Winner Player 1");
											}
											else
											{
												System.out.println("Draw");
											}
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.exit(0);
										}else{
										P1.setMoney(P1.getMoney()-P2.getOwningRailroads()*25);
										P2.setMoney(P2.getMoney()+P2.getOwningRailroads()*25);
										proc="Player 1 paid rent for "+map[P1.getLocation()-1].getName();
										//System.out.println("player 1 rent");
										}
									}
									if(Comp.contains(P1.getLocation()))
									{
										if(P1.getMoney()<P1.getDice()*4){
											proc="Player 1 goes bankrupt";
											System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
													System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
											//n.toString().replace("[","").replace("]",""));
											System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
											System.out.println("Banker\t"+Banker.getMoney());
											if(P1.getMoney()<P2.getMoney())
											{
												System.out.println("Winner Player 2");
											}
											else if(P1.getMoney()>P2.getMoney())
											{
												System.out.println("Winner Player 1");
											}
											else
											{
												System.out.println("Draw");
											}
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.exit(0);
										}else{
										P1.setMoney(P1.getMoney()-P1.getDice()*4);
										P2.setMoney(P2.getMoney()+P1.getDice()*4); 
										proc="Player 1 paid rent for "+map[P1.getLocation()-1].getName();
										//System.out.println("player 1 rent");
										}
									}
								}
								else if(P1.hasProperty(map[P1.getLocation()-1].getName()))
								{
									proc="Player 1 has "+map[P1.getLocation()-1].getName();
									//System.out.println("Player 1 has");
								}
								else 
								{
									if(P1.getMoney()>=map[P1.getLocation()-1].getCost())
									{
										if(P1.getMoney()<map[P1.getLocation()-1].getCost())
										{
											proc="Player 1 goes bankrupt";
											System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
											//n.toString().replace("[","").replace("]",""));
											System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
											System.out.println("Banker\t"+Banker.getMoney());
											if(P1.getMoney()<P2.getMoney())
											{
												System.out.println("Winner Player 2");
											}
											else if(P1.getMoney()>P2.getMoney())
											{
												System.out.println("Winner Player 1");
											}
											else
											{
												System.out.println("Draw");
											}
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.exit(0);
										}
										else
										{
										P1.addProp(map[P1.getLocation()-1].getName());
										P1.setMoney(P1.getMoney()-map[P1.getLocation()-1].getCost());
										Banker.setMoney(Banker.getMoney()+map[P1.getLocation()-1].getCost());
										proc="Player 1 bought "+map[P1.getLocation()-1].getName();
										}
										if(Station.contains(P1.getLocation()))
										{
											P1.setOwningRailroads(P1.getOwningRailroads()+1);
										}
									}
									
								}
							}
							
							else if(Kamu.contains(P1.getLocation()))
							{
								if(CommunityList.get(0).equals("Advance to Go (Collect $200)"))
								{
									P1.setLocation(1);
									P1.setMoney(P1.getMoney()+200);
									Banker.setMoney(Banker.getMoney()-200);
									CommunityList.add("Advance to Go (Collect $200)");
									proc="Player 1 draw Advance to Go (Collect $200)";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Bank error in your favor - collect $75"))
								{
									P1.setMoney(P1.getMoney()+75);
									Banker.setMoney(Banker.getMoney()-75);
									CommunityList.add("Bank error in your favor - collect $75");
									proc="Bank error in your favor - collect $75";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Doctor's fees - Pay $50"))
								{
									if(P1.getMoney()<50)
									{
										proc="Player 1 goes bankrupt";
										System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P1.setMoney(P1.getMoney()-50);
									Banker.setMoney(Banker.getMoney()+50);
									CommunityList.add("Doctor's fees - Pay $50");
									proc="Doctor's fees - Pay $50";
									CommunityList.remove(0);
									}
								}
								else if(CommunityList.get(0).equals("It is your birthday Collect $10 from each player"))
								{
									if(P2.getMoney()<10)
									{
										proc="Player 2 goes bankrupt";
										System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P1.setMoney(P1.getMoney()+10);
									P2.setMoney(P2.getMoney()-10);
									CommunityList.add("It is your birthday Collect $10 from each player");
									proc="It is your birthday Collect $10 from each player";
									CommunityList.remove(0);
									}
								}
								else if(CommunityList.get(0).equals("Grand Opera Night - collect $50 from every player for opening night seats"))
								{
									if(P2.getMoney()<50)
									{
										proc="Player 2 goes bankrupt";
										System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P1.setMoney(P1.getMoney()+50);
									P2.setMoney(P2.getMoney()-50);
									CommunityList.add("Grand Opera Night - collect $50 from every player for opening night seats");
									proc="Grand Opera Night - collect $50 from every player for opening night seats";
									CommunityList.remove(0);
									}
								}
								else if(CommunityList.get(0).equals("Income Tax refund - collect $20"))
								{
									P1.setMoney(P1.getMoney()+20);
									Banker.setMoney(Banker.getMoney()-20);
									CommunityList.add("Income Tax refund - collect $20");
									proc="Income Tax refund - collect $20";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Life Insurance Matures - collect $100"))
								{
									P1.setMoney(P1.getMoney()+100);
									Banker.setMoney(Banker.getMoney()-100);
									CommunityList.add("Life Insurance Matures - collect $100");
									proc="Life Insurance Matures - collect $100";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Pay Hospital Fees of $100"))
								{
									if(P1.getMoney()<100)
									{
										proc="Player 1 goes bankrupt";
										System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P1.setMoney(P1.getMoney()-100);
									Banker.setMoney(Banker.getMoney()+100);
									CommunityList.add("Pay Hospital Fees of $100");
									proc="Pay Hospital Fees of $100";
									CommunityList.remove(0);
									}
								}
								else if(CommunityList.get(0).equals("Pay School Fees of $50"))
								{
									if(P1.getMoney()<50)
									{
										proc="Player 1 goes bankrupt";
										System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P1.setMoney(P1.getMoney()-50);
									Banker.setMoney(Banker.getMoney()+50);
									CommunityList.add("Pay School Fees of $50");
									proc="Pay School Fees of $50";
									CommunityList.remove(0);
									}
								}
								else if(CommunityList.get(0).equals("You inherit $100"))
								{
									P1.setMoney(P1.getMoney()+100);
									Banker.setMoney(Banker.getMoney()-100);
									CommunityList.add("You inherit $100");
									proc="You inherit $100";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("From sale of stock you get $50"))
								{
									P1.setMoney(P1.getMoney()+50);
									Banker.setMoney(Banker.getMoney()-50);
									CommunityList.add("From sale of stock you get $50");
									proc="From sale of stock you get $50";
									CommunityList.remove(0);
								}
							}
							else if (P1.getLocation()==5 || P1.getLocation()==39)
							{
								if(P1.getMoney()<100)
								{
									proc="Player 1 goes bankrupt";
									System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
									System.out.println("-----------------------------------------------------------------------------------------------------------");
									System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
									//n.toString().replace("[","").replace("]",""));
									System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
									System.out.println("Banker\t"+Banker.getMoney());
									if(P1.getMoney()<P2.getMoney())
									{
										System.out.println("Winner Player 2");
									}
									else if(P1.getMoney()>P2.getMoney())
									{
										System.out.println("Winner Player 1");
									}
									else
									{
										System.out.println("Draw");
									}
									System.out.println("-----------------------------------------------------------------------------------------------------------");
									System.exit(0);
								}
								else{
								P1.setMoney(P1.getMoney()-100);
								Banker.setMoney(Banker.getMoney()+100);
								proc="Player 1 paid Tax";
								}
							}
							else if(P1.getLocation()==21)
							{
								proc="Player 1 is in Free Parking";
							}
							else if(P1.getLocation()==1)
							{
								proc="Player 1 is in GO square";
							}
							//System.out.println(proc);
							if(parameters[0].equals("1")){
								
							System.out.println("Player 1\t"+P1.getDice()+"\t"+P1.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
							proc="";
							pro="";
							}
						}
						else if (parameters[0].equals("2"))
						{
							if (P2.isInJail() == false)
							{
								P2.setDice(Integer.valueOf(parameters[1]));
								if (P2.getLocation()+P2.getDice()>40)
								{
									P2.setMoney(P2.getMoney()+200);
									Banker.setMoney(Banker.getMoney()-200);
								}
								P2.setLocation((P2.getLocation()+ Integer.valueOf(parameters[1]))%40);
								if(P2.getLocation()==0)
								{
									P2.setLocation(40);
								}
								if(P2.getLocation()==31)
								{
									P2.setLocation(11);
								}
								//System.out.println("atilan zar: " + P1.getDice());
								//System.out.println("bulunulan konum: " + P1.getLocation());
								//System.out.println(P1.getJailCounter());
								
								if (P2.getLocation()==11 || P2.getLocation()==31)
								{
									//System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\tPlayer 2 went to jail");
									proc="Player 2 went to jail";
									//System.out.println("mapus: " + P1.getJailCounter());
									P2.setInJail(true);}
								else {
									//System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney());
									}
							}
							else if (P2.getLocation()==11 || P2.getLocation()==31)
							{
								//System.out.println("mapus: " + P1.getJailCounter());
								P2.setInJail(true);
								P2.setLocation(11);
								P2.setDice(Integer.valueOf(parameters[1]));
								//System.out.println("atilan zar: " + P1.getDice());
								if (P2.getJailCounter()==0)
								{
									//System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\tPlayer 2 went to jail");
									proc="Player 2 went to jail";
								}
								//System.out.println("bulunulan konum: " + P1.getLocation());
								P2.setJailCounter(P2.getJailCounter()+1);
								//System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\tPlayer 2 in jail (count="+(P2.getJailCounter()-1)+")");
								proc="Player 2 in jail (count="+(P2.getJailCounter()-1)+")";
								//System.out.println(P1.getJailCounter());
								if (P2.getJailCounter() == 4)
								{
									P2.setJailCounter(1);
									P2.setInJail(false);
								}
							}
							if(Sans.contains(P2.getLocation()))
							{
								if(ChanceList.get(0).equals("Advance to Go (Collect $200)"))
								{
									P2.setLocation(1);
									P2.setMoney(P2.getMoney()+200);
									Banker.setMoney(Banker.getMoney()-200);
									ChanceList.add("Advance to Go (Collect $200)");
									proc="Player 2 draw Advance to Go (Collect $200)";
									ChanceList.remove(0);
								}
								else if(ChanceList.get(0).equals("Advance to Leicester Square"))
								{
									if(P2.getLocation()==37){
										P2.setMoney(P2.getMoney()+200);
										Banker.setMoney(Banker.getMoney()-200);
									}
									P2.setLocation(27);
									ChanceList.add("Advance to Leicester Square");
									proc="Player 2 draw Advance to Leicester Square";
									pro="Player 2 draw Advance to Leicester Square ";
									ChanceList.remove(0);
								}
								else if(ChanceList.get(0).equals("Go back 3 spaces"))
								{
									P2.setLocation(P2.getLocation()-3);
									ChanceList.add("Go back 3 spaces");
									proc="Player 2 draw Go back 3 spaces";
									pro="Player 2 draw Go back 3 spaces";
									ChanceList.remove(0);
								}
								else if(ChanceList.get(0).equals("Pay poor tax of $15"))
								{
									if(P2.getMoney()<15)
									{
										proc="Player 2 goes bankrupt";
										System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P2.setMoney(P2.getMoney()-15);
									Banker.setMoney(Banker.getMoney()+15);
									ChanceList.add("Pay poor tax of $15");
									proc="Pay poor tax of $15";
									ChanceList.remove(0);
									}
								}
								else if(ChanceList.get(0).equals("Your building loan matures - collect $150"))
								{
									P2.setMoney(P2.getMoney()+150);
									Banker.setMoney(Banker.getMoney()-150);
									ChanceList.add("Your building loan matures - collect $150");
									proc="Your building loan matures - collect $150";
									ChanceList.remove(0);
								}
								else if(ChanceList.get(0).equals("You have won a crossword competition - collect $100 "))
								{
									P2.setMoney(P2.getMoney()+100);
									Banker.setMoney(Banker.getMoney()-100);
									ChanceList.add("You have won a crossword competition - collect $100 ");
									proc="You have won a crossword competition - collect $100 ";
									ChanceList.remove(0);
								}
								//System.out.print(proc);
							}
							if(Mulk.contains(P2.getLocation()) || Station.contains(P2.getLocation() ) || Comp.contains(P2.getLocation()))
							{
								if(P1.hasProperty(map[P2.getLocation()-1].getName()))
								{
									if(Mulk.contains(P2.getLocation()))
									{
										if(P2.getMoney()<map[P2.getLocation()-1].getRent()){
											proc="Player 2 goes bankrupt";
											System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
											//n.toString().replace("[","").replace("]",""));
											System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
											System.out.println("Banker\t"+Banker.getMoney());
											if(P1.getMoney()<P2.getMoney())
											{
												System.out.println("Winner Player 2");
											}
											else if(P1.getMoney()>P2.getMoney())
											{
												System.out.println("Winner Player 1");
											}
											else
											{
												System.out.println("Draw");
											}
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.exit(0);
										}else{
										P2.setMoney(P2.getMoney()-map[P2.getLocation()-1].getRent());
										P1.setMoney(P1.getMoney()+map[P2.getLocation()-1].getRent());
										proc="Player 2 paid rent for "+map[P2.getLocation()-1].getName();
										//System.out.println("player 1 rent");
										}
									}
									if(Station.contains(P2.getLocation()))
									{
										if(P2.getMoney()<map[P2.getLocation()-1].getRent()){
											proc="Player 2 goes bankrupt";
											System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
											//n.toString().replace("[","").replace("]",""));
											System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
											System.out.println("Banker\t"+Banker.getMoney());
											if(P1.getMoney()<P2.getMoney())
											{
												System.out.println("Winner Player 2");
											}
											else if(P1.getMoney()>P2.getMoney())
											{
												System.out.println("Winner Player 1");
											}
											else
											{
												System.out.println("Draw");
											}
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.exit(0);
										}else{
										P2.setMoney(P2.getMoney()-P1.getOwningRailroads()*25);
										P1.setMoney(P1.getMoney()+P1.getOwningRailroads()*25); 
										proc="Player 2 paid rent for "+map[P2.getLocation()-1].getName();
										//System.out.println("player 1 rent");
										}
									}
									if(Comp.contains(P2.getLocation()))
									{
										if(P2.getMoney()<P2.getDice()*4){
											proc="Player 2 goes bankrupt";
											System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
											//n.toString().replace("[","").replace("]",""));
											System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
											System.out.println("Banker\t"+Banker.getMoney());
											if(P1.getMoney()<P2.getMoney())
											{
												System.out.println("Winner Player 2");
											}
											else if(P1.getMoney()>P2.getMoney())
											{
												System.out.println("Winner Player 1");
											}
											else
											{
												System.out.println("Draw");
											}
											System.out.println("-----------------------------------------------------------------------------------------------------------");
											System.exit(0);
										}else{
										P2.setMoney(P2.getMoney()-P2.getDice()*4);
										P1.setMoney(P1.getMoney()+P2.getDice()*4); 
										proc="Player 2 paid rent for "+map[P2.getLocation()-1].getName();
										//System.out.println("player 1 rent");
										}
									}
								}
								else if(P2.hasProperty(map[P2.getLocation()-1].getName()))
								{
									proc="Player 2 has "+map[P2.getLocation()-1].getName();
									//System.out.println("Player 1 has");
								}
								else 
								{
									if(P2.getMoney()>=map[P2.getLocation()-1].getCost())
									{
										P2.addProp(map[P2.getLocation()-1].getName());
										P2.setMoney(P2.getMoney()-map[P2.getLocation()-1].getCost());
										Banker.setMoney(Banker.getMoney()+map[P2.getLocation()-1].getCost());
										proc="Player 2 bought "+map[P2.getLocation()-1].getName();
										if(Station.contains(P2.getLocation()))
										{
											P2.setOwningRailroads(P2.getOwningRailroads()+1);
										}
									}
									else{
										proc="Player 2 goes bankrupt";
										System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
								}
							}
							
							else if(Kamu.contains(P2.getLocation()))
							{
								if(CommunityList.get(0).equals("Advance to Go (Collect $200)"))
								{
									P2.setLocation(1);
									P2.setMoney(P2.getMoney()+200);
									Banker.setMoney(Banker.getMoney()-200);
									CommunityList.add("Advance to Go (Collect $200)");
									proc="Player 2 draw Advance to Go (Collect $200)";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Bank error in your favor - collect $75"))
								{
									P2.setMoney(P2.getMoney()+75);
									Banker.setMoney(Banker.getMoney()-75);
									CommunityList.add("Bank error in your favor - collect $75");
									proc="Bank error in your favor - collect $75";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Doctor's fees - Pay $50"))
								{
									if(P2.getMoney()<50)
									{
										proc="Player 2 goes bankrupt";
										System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P2.setMoney(P2.getMoney()-50);
									Banker.setMoney(Banker.getMoney()+50);
									CommunityList.add("Doctor's fees - Pay $50");
									proc="Doctor's fees - Pay $50";
									CommunityList.remove(0);
									}
								}
								else if(CommunityList.get(0).equals("It is your birthday Collect $10 from each player"))
								{
									P2.setMoney(P2.getMoney()+10);
									P1.setMoney(P1.getMoney()-10);
									CommunityList.add("It is your birthday Collect $10 from each player");
									proc="It is your birthday Collect $10 from each player";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Grand Opera Night - collect $50 from every player for opening night seats"))
								{
									P2.setMoney(P2.getMoney()+50);
									P1.setMoney(P1.getMoney()-50);
									CommunityList.add("Grand Opera Night - collect $50 from every player for opening night seats");
									proc="Grand Opera Night - collect $50 from every player for opening night seats";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Income Tax refund - collect $20"))
								{
									P2.setMoney(P2.getMoney()+20);
									Banker.setMoney(Banker.getMoney()-20);
									CommunityList.add("Income Tax refund - collect $20");
									proc="Income Tax refund - collect $20";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Life Insurance Matures - collect $100"))
								{
									P2.setMoney(P2.getMoney()+100);
									Banker.setMoney(Banker.getMoney()-100);
									CommunityList.add("Life Insurance Matures - collect $100");
									proc="Life Insurance Matures - collect $100";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("Pay Hospital Fees of $100"))
								{
									if(P2.getMoney()<100)
									{
										proc="Player 2 goes bankrupt";
										System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P2.setMoney(P2.getMoney()-100);
									Banker.setMoney(Banker.getMoney()+100);
									CommunityList.add("Pay Hospital Fees of $100");
									proc="Pay Hospital Fees of $100";
									CommunityList.remove(0);
									}
								}
								else if(CommunityList.get(0).equals("Pay School Fees of $50"))
								{
									if(P2.getMoney()<50)
									{
										proc="Player 2 goes bankrupt";
										System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
										//n.toString().replace("[","").replace("]",""));
										System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
										System.out.println("Banker\t"+Banker.getMoney());
										if(P1.getMoney()<P2.getMoney())
										{
											System.out.println("Winner Player 2");
										}
										else if(P1.getMoney()>P2.getMoney())
										{
											System.out.println("Winner Player 1");
										}
										else
										{
											System.out.println("Draw");
										}
										System.out.println("-----------------------------------------------------------------------------------------------------------");
										System.exit(0);
									}
									else{
									P2.setMoney(P2.getMoney()-50);
									Banker.setMoney(Banker.getMoney()+50);
									CommunityList.add("Pay School Fees of $50");
									proc="Pay School Fees of $50";
									CommunityList.remove(0);
									}
								}
								else if(CommunityList.get(0).equals("You inherit $100"))
								{
									P2.setMoney(P2.getMoney()+100);
									Banker.setMoney(Banker.getMoney()-100);
									CommunityList.add("You inherit $100");
									proc="You inherit $100";
									CommunityList.remove(0);
								}
								else if(CommunityList.get(0).equals("From sale of stock you get $50"))
								{
									P2.setMoney(P2.getMoney()+50);
									Banker.setMoney(Banker.getMoney()-50);
									CommunityList.add("From sale of stock you get $50");
									proc="From sale of stock you get $50";
									CommunityList.remove(0);
								}
							}
							else if (P2.getLocation()==5 || P2.getLocation()==39)
							{
								if(P2.getMoney()<100)
								{
									proc="Player 2 goes bankrupt";
									System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
									System.out.println("-----------------------------------------------------------------------------------------------------------");
									System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
									//n.toString().replace("[","").replace("]",""));
									System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
									System.out.println("Banker\t"+Banker.getMoney());
									if(P1.getMoney()<P2.getMoney())
									{
										System.out.println("Winner Player 2");
									}
									else if(P1.getMoney()>P2.getMoney())
									{
										System.out.println("Winner Player 1");
									}
									else
									{
										System.out.println("Draw");
									}
									System.out.println("-----------------------------------------------------------------------------------------------------------");
									System.exit(0);
								}
								else{
								P2.setMoney(P2.getMoney()-100);
								Banker.setMoney(Banker.getMoney()+100);
								proc="Player 2 paid Tax";
								}
							}
							else if(P2.getLocation()==21)
							{
								proc="Player 2 is in Free Parking";
							}
							else if(P2.getLocation()==1)
							{
								proc="Player 2 is in GO square";
							}
						}
						
						//System.out.println(parameters[0]); playerin numarasi geliyor (1 ya da 2 olarak)
						//System.out.println(parameters[1]); zar geliyor
						
						if(parameters[0].equals("2")){
						System.out.println("Player 2\t"+P2.getDice()+"\t"+P2.getLocation()+"\t"+P1.getMoney()+"\t"+P2.getMoney()+"\t"+pro+proc);
						proc="";
						pro="";
						}
						
					}else
					{
						System.out.println("-----------------------------------------------------------------------------------------------------------");
						System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
						//n.toString().replace("[","").replace("]",""));
						System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
						System.out.println("Banker\t"+Banker.getMoney());
						if(P1.getMoney()<P2.getMoney())
						{
							System.out.println("Winner Player 2");
						}
						else if(P1.getMoney()>P2.getMoney())
						{
							System.out.println("Winner Player 1");
						}
						else
						{
							System.out.println("Draw");
						}
						System.out.println("-----------------------------------------------------------------------------------------------------------");
						//System.out.println(mystring); //show
					}
					/*System.out.println("-----------------------------------------------------------------------------------------------------------");
					System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
					//n.toString().replace("[","").replace("]",""));
					System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
					System.out.println("Banker\t"+Banker.getMoney());
					if(P1.getMoney()<P2.getMoney())
					{
						System.out.println("Winner Player 2");
					}
					else if(P1.getMoney()>P2.getMoney())
					{
						System.out.println("Winner Player 1");
					}
					else
					{
						System.out.println("Draw");
					}
					System.out.println("-----------------------------------------------------------------------------------------------------------");*/
				}
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				System.out.println("Player 1\t"+P1.getMoney()+"\thave: "+P1.getProperties().toString().replace("[","").replace("]",""));
				//n.toString().replace("[","").replace("]",""));
				System.out.println("Player 2\t"+P2.getMoney()+"\thave: "+P2.getProperties().toString().replace("[","").replace("]",""));
				System.out.println("Banker\t"+Banker.getMoney());
				if(P1.getMoney()<P2.getMoney())
				{
					System.out.println("Winner Player 2");
				}
				else if(P1.getMoney()>P2.getMoney())
				{
					System.out.println("Winner Player 1");
				}
				else
				{
					System.out.println("Draw");
				}
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				
		} 
		catch(FileNotFoundException e) { e.printStackTrace();}
		catch(IOException e) { e.printStackTrace();}
		catch(ParseException e) { e.printStackTrace();}
		catch(Exception e) { e.printStackTrace();}
		
		
		
	}


}

