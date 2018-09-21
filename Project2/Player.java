public class Player
{
  //initialize your fields in the constructor
  double Balance = 0;
  Hand hand = new Hand();
  public Player(double balance)
  {
    this.Balance = balance;
  }

  public void deal(Card c)
  {
    hand.addCard(c);
  }

  //Returns an array of Cards that the Player wishes to discard.
  //The game engine will call deal() on this player for each card
  //that exists in the return value. MS2 Instructions: Print the hand to
  //the terminal using System.out.println and ask the user which cards
  //they would like to discard. The user will first the number of cards they
  //wish to discard, followed by the indices, one at a time, of
  //the card(s) they would like to discard,
  //Return an array with the appropriate Card objects
  //that have been discarded, and remove the Card objects from this
  //player's hand. Use IO.readInt() for all inputs. In cases of error
  //re-ask the user for input.
  //
  // Example call to discard():
  //
  // This is your hand:
  // 0: Ace of Hearts
  // 1: 2 of Diamonds
  // 2: 5 of Hearts
  // 3: Jack of Spades
  // 4: Ace of Clubs
  // How many cards would you like to discard?
  // 2
  // 1
  // 2
  //
  // The resultant array will contain the 2 of Diamonds and the 5 of hearts in that order
  // This player's hand will now only have 3 cards
  public Card[] discard()
  {
    System.out.println("This is your hand:");
    for(int position = 0; position < hand.getCardCount();position++)
      System.out.println(position + " " + hand.getCard(position));
    System.out.println("How many cards would you like to remove?");
    int number = IO.readInt();
    while(number<0 || number >5)
    {
      System.out.println("How many cards would you like to remove?");
      number = IO.readInt();
    }
    int remove;
    Card[] removed = new Card[5];
    for(int count = 0; count < number; count ++)
    {
      remove = IO.readInt();
      while(remove<0 || remove >5)
        remove = IO.readInt();
      removed[count]=hand.getCard(remove);
      hand.removeCard(remove);
    }
    return removed;
  }

  //Returns the amount that this player would like to wager, returns
  //-1.0 to fold hand. Any non zero wager should immediately be deducted
  //from this player's balance. This player's balance can never be below
  // 0 at any time. This player's wager must be >= to the parameter min
  // MS2 Instructions: Show the user the minimum bet via the terminal
  //(System.out.println), and ask the user for their wager. Use
  //IO.readDouble() for input. In cases of error re-ask the user for
  //input.
  //
  // Example call to wager()
  //
  // How much do you want to wager?
  // 200
  //
  // This will result in this player's balance reduced by 200

  public double wager(double min)
  {
    if(min > Balance)
      return -1;
    System.out.println("How much would you like to wager? (" + min + " minimum):");
    double wager = IO.readDouble();
    while(wager<min || wager <=0 || Balance-wager<0)
    {
      System.out.println("Invalid Amount. Please Enter A Different Amount (" + min + "): ");
      wager = IO.readDouble();
    }
    Balance = Balance - wager;
    return wager;
  }

  //Returns this player's hand
  public Hand showHand()
  {
    return hand;
  }

  //Returns this player's current balance
  public double getBalance()
  {
    return Balance;
  }

  //Increase player's balance by the amount specified in the parameter,
  //then reset player's hand in preparation for next round. Amount will
  //be 0 if player has lost hand
  public void winnings(double amount)
  {
    Balance+=amount;
    hand.clear();
  }
}
