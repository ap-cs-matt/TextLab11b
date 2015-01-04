import java.util.Arrays;


public class TextLab11b_Matthew_Pearce {

	public static void main(String args[])
	{
		System.out.println("Lab11b 100 Point Version Matthew Pearce\n");     
      
		Deck deck = new Deck();
        //System.out.println(deck);   //second shuffle method automatically prints out / uncomment this line to use original shuffle method
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
	 	  
	 /* 
	 //shuffle method 1 							need to uncomment line in main method
	   private void Shuffle(Card[] ogDeck){
		 
		//creates duplicate array
		 int k = 0; //loop for duplicating deck
		 Shuffled = new Card[52];
		 while (k < ogDeck.length){
			 Shuffled[k] = ogDeck[k];
			 k++;
		 }
		 ///////////
		 
		 int i = 0;
		 int a = 0;
		 int b = 0;
		 Card cardB;
		 Card cardA;

		 while (i < 1000){
			
			 a = (int) (Math.random() * 52);
			 cardA = Shuffled[a];
			 
			 b = (int) (Math.random() * 52);
			 cardB = Shuffled[b];
			 
			 Shuffled[a] = cardB;
			 Shuffled[b] = cardA;			 
			 
			 i++;
		 } 
	 }*/
	
	 //shuffle method 2
	 private void Shuffle(Card[] ogDeck){
			  
			 int i = 0;	//loop to print one card
			 int z = 0;  //random values
			 int m = 0;	//to make sure card hasnt already been printed
			 
			 int[] printCheck = new int[52];		//creates array to store locations of cards already printed to ensure no duplicates are printed
			 while (i < 52)  //prints 52 cards one at a time
			 {
				 z = (int) (Math.random() * 52); 	//puts in initial random value into check array
				 printCheck[i] = z;		
				 
				 while (m < 52)			//makes sure no duplicates have been printed 
				 {
					 if (z == printCheck[m]){
						 z = (int) (Math.random() * 52);
						 //System.out.println("error!");  // to see how many times it takes for a non printed card to be discovered
						 m = 0;
					 } 
					 m++;
				 }
				 
				 m=0;
				 printCheck[i] = z;			// puts in card number that has been sucesfully printed after checks
				 
				 System.out.println(deck[z]);		//prints all card information
				 i++;
			 }	 	 
	 }
	 
	 public String toString(){
		  
		  String printOut = "";
		  for (Card i: Shuffled)
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

