
/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */

import java.util.ArrayList;

public class Hand {

   private Card[] hand;   // The cards in the hand.
   private int count;

   /**
    * Create a hand that is initially empty.
    */
   public Hand() {
      hand = new Card[5];
	  count = 0;
   }

   /**
    * Remove all cards from the hand, leaving it empty.
    */
   public void clear() {
      for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
	  count = 0;
   }

   /**
    * Add a card to the hand.  It is added at the end of the current hand.
    * @param c the non-null card to be added.
    * @throws NullPointerException if the parameter c is null.
    */
   public void addCard(Card c) {

	  for(int i=0 ; i<hand.length; i++){
		if (hand[i] == null){
			hand[i] = c;
			count = count + 1;
			break;
		}
	 }


   }

   /**
    * Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in
    * the hand, then nothing is done.
    */
   public void removeCard(Card c) {

	for(int i=0 ; i<hand.length; i++){
		if (hand[i].equals(c)){
			hand[i] = null;
			count = count-1;
		}
	}

   }

   /**
    * Remove the card in a specified position from the hand.
    * @param position the position of the card that is to be removed, where
    * positions are starting from zero.
    * @throws IllegalArgumentException if the position does not exist in
    * the hand, that is if the position is less than 0 or greater than
    * or equal to the number of cards in the hand.
    */
    public void removeCard(int position) {
    	if (position < 0 || position >= hand.length)
    		throw new IllegalArgumentException("Position does not exist in hand: " + position);
    	hand[position] = null;
    }

   /**
    * Returns the number of cards in the hand.
    */
   public int getCardCount() {
      return count;
   }

   /**
    * Gets the card in a specified position in the hand.  (Note that this card
    * is not removed from the hand!)
    * @param position the position of the card that is to be returned
    * @throws IllegalArgumentException if position does not exist in the hand
    */
   public Card getCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
       return hand[position];
   }

   /**
    * Sorts the cards in the hand so that cards of the same suit are
    * grouped together, and within a suit the cards are sorted by value.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortBySuit() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;

      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.

         for (int i = nonnull+1; i < hand.length; i++) {
            Card c1 = hand[i];
			if (c1 != null){
				if ( c1.getSuit() < c.getSuit() ||
						(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }

   /**
    * Sorts the cards in the hand so that cards of the same value are
    * grouped together.  Cards with the same value are sorted by suit.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortByValue() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;

      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.

         for (int i = nonnull+1; i < hand.length; i++) {

			Card c1 = hand[i];
            if (c1 != null){
				if ( c1.getValue() < c.getValue() ||
						(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }

   public void printHand(){

	   for(int i=0; i<hand.length; i++){
		   if (hand[i] != null){
			   System.out.println(hand[i]);
		   }
	   }
	   System.out.println();
   }


   /******************************** Implement your methods here ****************************************/
   //Returns the card with the highest value in the hand. When there is
   //more than one highest value card, you may return any one of them
  public Card highestValue()
  {
     int maxpos = 0;
     for(int count = 0; count< hand.length;count++)
     {
      if(hand[count].getValue()>hand[maxpos].getValue())
        maxpos=count;
     }
     return hand[maxpos];
   }

  //Returns the number of pairs this hand contains
  public int numPairs()
  {
     sortByValue();
     int paircount = 0;
     for(int card = 0; card<hand.length; card++)
     {
       //System.out.println(card);
       int comparecard = card +1;
       int count =0;
       for(; comparecard<hand.length && hand[card].getValue()==hand[comparecard].getValue();comparecard++)
          count++;
       card=comparecard-1;
       if(count==1)
        paircount++;
       // if(count==3)
       //  paircount+=2;
     }
     return paircount;
   }

  //Returns true if this hand has 3 cards that are of the same value
  public boolean hasTriplet()
  {
     sortByValue();
     int paircount = 0;
     for(int card = 0; card<hand.length; card++)
     {
       int comparecard = card +1;
       int count =0;
       for(; comparecard<hand.length && hand[card].getValue()==hand[comparecard].getValue();comparecard++)
          count++;
       card=comparecard-1;
       if(count>1)
        return true;
     }
     return false;
   }

  //Returns true if this hand has all cards that are of the same suit
  public boolean hasFlush()
  {
     if(hand[0].getSuit()==hand[1].getSuit()&&
        hand[1].getSuit()==hand[2].getSuit()&&
        hand[2].getSuit()==hand[3].getSuit()&&
        hand[3].getSuit()==hand[4].getSuit())
        return true;
     return false;
   }

  //Returns true if this hand has 5 consecutive cards of any suit
  public boolean hasStraight()
  {
     sortByValue();
     int maxnum = highestValue().getValue();;
     boolean found = true;
     for(int count = 0; count< hand.length-1 && found == true;count++)
     {
       for(int pos =0; pos<hand.length;pos++)
       {
         found=false;
         if(hand[pos].getValue()==maxnum-1)
         {
           found=true;
           maxnum=hand[pos].getValue();
           break;
         }
       }
     }
     return found;
   }

  //Returns true if this hand has a triplet and a pair of different //values
  public boolean hasFullHouse()
  {
     if(hasTriplet() && numPairs()>0)
       return true;
    return false;
   }

  //Returns true if this hand has 4 cards that are of the same value
  public boolean hasFourOfAKind()
  {
     sortByValue();
     int paircount = 0;
     for(int card = 0; card<hand.length; card++)
     {
       //System.out.println(card);
       int comparecard = card +1;
       int count =0;
       for(; comparecard<hand.length && hand[card].getValue()==hand[comparecard].getValue();comparecard++)
          count++;
       card=comparecard-1;
       if(count==3)
        return true;
       // if(count==3)
       //  paircount+=2;
     }
     return false;
   }

  //Returns the highest valued Card of any pair or triplet found, null if
  // none. When values are equal, you may return either
  public Card highestDuplicate()
  {
     sortByValue();
     if(hasTriplet()==false || numPairs()==0)
       return null;
     boolean firsttime = true;
     int maxpos = 0;
     for(int card = 0; card<hand.length; card++)
     {
       int comparecard = card +1;
       int count =0;
       for(; comparecard<hand.length && hand[card].getValue()==hand[comparecard].getValue();comparecard++)
          count++;
       card=comparecard-1;
       if(count>0)
        {
          if(firsttime == true)
          {
            maxpos=card;
            firsttime=false;
          }
          else if(hand[card].getValue()>hand[maxpos].getValue())
            maxpos=card;
        }
     }
     return hand[maxpos];
   }

  //Returns -1 if the instance hand loses to the parameter hand, 0 if
  //the hands are equal, and +1 if the instance hand wins over the
  //parameter hand. Hint: you might want to use some of the methods
  //above
  public int compareTo(Hand h)
  {
    boolean[] FiveOfAKind = new boolean[2];
    boolean[] StraightFlush = new boolean[2];
    boolean[] FourOfAKind = new boolean[2];
    boolean[] FullHouse = new boolean[2];
    boolean[] Flush = new boolean[2];
    boolean[] Straight = new boolean[2];
    boolean[] ThreeOfAKind = new boolean[2];
    boolean[] TwoPair = new boolean[2];
    boolean[] OnePair = new boolean[2];
    int[] HighCard = new int[2];
    int[] HighestPair = new int[2];
    if(hasFourOfAKind() && (hand[0].getSuit()==Card.JOKER ||//if inst has five of
                            hand[1].getSuit()==Card.JOKER ||//a kind
                            hand[2].getSuit()==Card.JOKER ||
                            hand[3].getSuit()==Card.JOKER ||
                            hand[4].getSuit()==Card.JOKER))
      FiveOfAKind[0]=true;
    if(h.hasFourOfAKind() && (h.hand[0].getSuit()==Card.JOKER ||//if param has
                              h.hand[1].getSuit()==Card.JOKER ||//five of a kind
                              h.hand[2].getSuit()==Card.JOKER ||
                              h.hand[3].getSuit()==Card.JOKER ||
                              h.hand[4].getSuit()==Card.JOKER))
      FiveOfAKind[1]=true;

    if(hasFlush() && hasStraight())
      StraightFlush[0]=true;
    if(h.hasFlush() && h.hasStraight())
      StraightFlush[1]=true;

    if(hasFourOfAKind())
      FourOfAKind[0]=true;
    if(h.hasFourOfAKind())
      FourOfAKind[1]=true;

    if(hasFullHouse())
      FullHouse[0]=true;
    if(h.hasFullHouse())
      FullHouse[1]=true;

    if(hasFlush())
      Flush[0]=true;
    if(h.hasFlush())
      Flush[1]=true;

    if(hasStraight())
      Straight[0]=true;
    if(h.hasStraight())
      Straight[1]=true;

    if(hasTriplet())
      ThreeOfAKind[0]=true;
    if(h.hasTriplet())
      ThreeOfAKind[1]=true;

    if(numPairs()==2)
      TwoPair[0]=true;
    if(h.numPairs()==2)
      TwoPair[1]=true;

    if(numPairs()==1)
      OnePair[0]=true;
    if(h.numPairs()==1)
      OnePair[1]=true;

    HighCard[0]=highestValue().getValue();
    HighCard[1]=h.highestValue().getValue();
    if(highestDuplicate()==null)
      HighestPair[0]=-1;
    else
      HighestPair[0]=highestDuplicate().getValue();
    if(highestDuplicate()==null)
      HighestPair[1]=-1;
    else
      HighestPair[1]=highestDuplicate().getValue();
    // System.out.println(Arrays.toString(FiveOfAKind));
    // System.out.println(Arrays.toString(StraightFlush));
    // System.out.println(Arrays.toString(FourOfAKind));
    // System.out.println(Arrays.toString(FullHouse));
    // System.out.println(Arrays.toString(Flush));
    // System.out.println(Arrays.toString(Straight));
    // System.out.println(Arrays.toString(ThreeOfAKind));
    // System.out.println(Arrays.toString(TwoPair));
    // System.out.println(Arrays.toString(OnePair));
    // System.out.println(Arrays.toString(HighCard));

    if(FiveOfAKind[0])
    {
      if(FiveOfAKind[1])
      {
        if(HighCard[0]>HighCard[1])
          return 1;
        else if(HighCard[0]==HighCard[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(FiveOfAKind[1])
      return -1;

    if(StraightFlush[0])
    {
      if(StraightFlush[1])
      {
        if(HighCard[0]>HighCard[1])
          return 1;
        else if(HighCard[0]==HighCard[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(StraightFlush[1])
      return -1;

    if(FourOfAKind[0])
    {
      if(FourOfAKind[1])
      {
        if(HighestPair[0]>HighestPair[1])
          return 1;
        else if(HighestPair[0]==HighestPair[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(FourOfAKind[1])
      return -1;

    if(FullHouse[0])
    {
      if(FullHouse[1])
      {
        if(HighestPair[0]>HighestPair[1])
          return 1;
        else if(HighestPair[0]==HighestPair[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(FullHouse[1])
      return -1;

    if(Flush[0])
    {
      if(Flush[1])
      {
        if(HighCard[0]>HighCard[1])
          return 1;
        else if(HighCard[0]==HighCard[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(Flush[1])
      return -1;

    if(Straight[0])
    {
      if(Straight[1])
      {
        if(HighCard[0]>HighCard[1])
          return 1;
        else if(HighCard[0]==HighCard[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(Straight[1])
      return -1;

    if(ThreeOfAKind[0])
    {
      if(ThreeOfAKind[1])
      {
        if(HighestPair[0]>HighestPair[1])
          return 1;
        else if(HighestPair[0]==HighestPair[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(ThreeOfAKind[1])
      return -1;

    if(TwoPair[0])
    {
      if(TwoPair[1])
      {
        if(HighestPair[0]>HighestPair[1])
          return 1;
        else if(HighestPair[0]==HighestPair[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(TwoPair[1])
      return -1;

    if(OnePair[0])
    {
      if(OnePair[1])
      {
        if(HighestPair[0]>HighestPair[1])
          return 1;
        else if(HighestPair[0]==HighestPair[1])
          return 0;
        else
          return -1;
      }
      else
        return 1;
    }
    if(OnePair[1])
      return -1;

    if(HighCard[0]>HighCard[1])
      return 1;
    else if(HighCard[0]==HighCard[1])
      return 0;
    else
      return -1;

    //return 5;
  }
}
