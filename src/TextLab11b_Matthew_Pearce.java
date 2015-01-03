
public class TextLab11b_Matthew_Pearce {

	public static void main(String args[])
	{
		System.out.println("Lab11bst.JAVA\n");     
      
		Deck deck = new Deck();
        System.out.println(deck);   
	}
}

class Deck 
{
	private Card[] deck;
	Card [] shuffledDeck = new Card[52];
	private int size;
	private int i = 0;
	private int k = 0; //loop control for printing
	private int r = 1; //use to assign card rank

	public Deck() 
	{
      size = 52;
	  deck = new Card[size];
	  Card tempCard;
	  
	  	while (r <= 13){
			  tempCard = new Card("Clubs",determineRank(r));
			  deck[i] = tempCard;
			  
			  i++;
			  r++;
		  }
		  while (r <= 26){ 
			  tempCard = new Card("Spades",determineRank(r));
			  deck[i] = tempCard;
			  
			  i++;
			  r++;
		  }
		  while (r <= 39){ 
			  tempCard = new Card("Hearts",determineRank(r));
			  deck[i] = tempCard;
			  
			  i++;
			  r++;
		  }
		  while (r <= 52){ 
			  tempCard = new Card("Diamonds",determineRank(r));
			  deck[i] = tempCard;
			  
			  i++;
			  r++;
		  }	 	
		//Shuffle(deck);
	}
	  
	 public String determineRank(int r){
		
		 while (r > 13){
			 r -= 13;
		 }					//makes r in range of 1-13
		 
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
		 default: return "Ace";
		 }
	 }
	 	 
	 /*private void Shuffle(Card[] stDeck){
		 
		 int i = 0; //loop
		 
		 //creates duplicate array
		 int k = 0; //loop for duplicating deck
		 Card[] Shuffled = new Card[52];
		 while (k < 52){
			 Shuffled[k] = stDeck[k];
			 k++;
		 }
		 //////////////
		 
		 while (i < 1000){
			 
			 int a = (int) Math.random() * 52;
			 int b = (int) Math.random() * 52;
			 int tempA = a;
			 int tempB = b;
			 
			 Shuffled[a] = Shuffled[tempB];
			 Shuffled[b] = Shuffled[tempA];
			 i++;
		 } 
		 System.out.println(shuffledDeck);
		 //return Shuffled;
	 }*/
	 
	 private void Shuffle(Card[] stDeck){
		 
		//creates duplicate array
		 int k = 0; //loop for duplicating deck
		 Card[] Shuffled = new Card[52];
		 while (k < 52){
			 Shuffled[k] = stDeck[k];
			 k++;
		 }
		 
		 int i = 0;
		 for (Card shuffledCard: Shuffled)
			    System.out.print(shuffledCard + "  ");
	 }
	 
	 public String toString(){
		  
		  String blank = "";
		  
		  for (Card i: deck)
			  System.out.println(deck[k]);
		 
		  
		  /*while (k < size){
			  System.out.println(deck[k]);
			  
			  k++;
		  }*/
		  
		  k = 0;
		  
		  System.out.println("\n\n");
		  while (k < size){
			  System.out.println(shuffledDeck[k]);
			  
			  k++;
		  }
		  
		  return blank;
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
	
	public int findPointValue(String rank){
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