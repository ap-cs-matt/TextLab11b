import java.util.Arrays;


public class TextLab11b_Matthew_Pearce {

	public static void main(String args[])
	{
		System.out.println("Lab11b 100 Point Version Matthew Pearce\n");     
      
		Deck deck = new Deck();
        System.out.println(deck);   
	}
}

class Deck 
{
	private Card[] deck;
	private Card[] Shuffled;
	private int size;
	private int i = 0;
	private int r = 1; //use to assign card rank

	public Deck() 
	{
      size = 52;
	  deck = new Card[size];
	  while (r <= 52)
	  {
	  	if (r <= 13){
	  		deck[i] = new Card("Clubs",determineRank(r));}
	  	
	  	else if (r <= 26){  
			  deck[i] = new Card("Spades",determineRank(r));}
	  	
	  	else if (r <= 39){ 
			  deck[i] = new Card("Hearts",determineRank(r));}
	  	
	  	else if (r <= 52){ 
			  deck[i] = new Card("Diamonds",determineRank(r));}	 
	  	i++;
		r++;
	  }
		  Shuffle(deck);
	}
	  
	 private String determineRank(int r){
		
		 while (r > 13){
			 r -= 13;		//makes r in range of 1-13
		 }					
		 
		 switch (r){
		 case 1:  return "Two";
		 case 2:  return "Three";
		 case 3:  return "Four";
		 case 4:  return "Five";
		 case 5:  return "Six";
		 case 6:  return "Seven";
		 case 7:  return "Eight";
		 case 8:  return "Nine";
		 case 9:  return "Ten";
		 case 10: return "Jack";
		 case 11: return "Queen";
		 case 12: return "King";
		 default: return "Ace";  //if r = 13
		 }	 
	 }
	 	  
	 
	 /*/shuffle method 1 							
	   private void Shuffle(Card[] ogDeck){
		 
		 int i = 0;
		 int a = 0;
		 int b = 0;
		 Card cardB;
		 Card cardA;

		 while (i < 1000){
			
			 a = (int) (Math.random() * 52);
			 cardA = deck[a];
			 
			 b = (int) (Math.random() * 52);
			 cardB = deck[b];
			 
			 deck[a] = cardB;
			 deck[b] = cardA;			 
			 
			 i++;
		 } 
	 }*/
	
	 
	 //Shuffle method 2
	 private void Shuffle(Card[] ogDeck){
		 Card[] tempDeck = new Card[ogDeck.length];
		 int[] checkStore = new int[ogDeck.length];
		 
		 //creates temporary copy of deck array
		 int i = 0;
		 for (Card temp: ogDeck){
			 tempDeck[i] = ogDeck[i];
			 i++; 
		 }
		 
		 //reasigns the values to random locations
		 i = 0;
		 int random = 0;
		 int k = 0;
		 
		 while (k < 52){
			 
				 random = (int) (Math.random() * 52);
				 checkStore[k] = random;
				 
				 while (i < 52){ 
					 
					 if (i == k ); //does nothing skips the else statement to prevent and endless loop
					 
					 else if (random == checkStore[i])// tests if value has been used at any location in the check array
					 {
						 random = (int) (Math.random() * 52);
						 checkStore[k] = random;
						 i = -1;// as i increaces by one to make while loop work but i still want it to check location 0
					 }
					 i++; 
			 }
			 i = 0; // resets i
			 deck[random] = tempDeck[k];  //reasigns deck card in location from a copy so all values get printed and none are missed
			 k++;
		 }
	 }
	 
	 public String toString(){
		  
		  String printOut = "";
		  for (Card i: deck)
			  printOut += i + "\n";
		  
		  return printOut;
	  }
}

class Card
{
	private String suit;
	private String rank;
	private int pointValue;
	
	public Card(String suit, String rank)
	{
		this.suit = suit;
		this.rank = rank;
		pointValue = findPointValue(rank);     
	}
	
	private int findPointValue(String rank){
		String modRank = rank.toLowerCase();   //lower cases inputed rank
		
			//using a switch to make changing point values very easy if needed in future
	         switch (modRank) {
	         case "two":    return 2;
	         case "three":  return 3;
	         case "four":   return 4;
	         case "five":   return 5;
	         case "six":    return 6;
	         case "seven":  return 7;
	         case "eight":  return 8;
	         case "nine":   return 9;
	         case "ten":    return 10;
	         case "jack":   return 10;
	         case "queen":  return 10;
	         case "king":   return 10;
	         default:       return 11; 	//ace
	         }
		}
	
	public String toString(){
		return "[" + suit + ", " + rank + ", " + pointValue + "]";
	}	
}

