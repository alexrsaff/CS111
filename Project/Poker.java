public class Poker
{
  public static void main(String[] args)
  {
    Hand FiveOfAKind = new Hand();
    Hand StraightFlush = new Hand();
    Hand FourOfAKind = new Hand();
    Hand FullHouse = new Hand();
    Hand Flush = new Hand();
    Hand Straight = new Hand();
    Hand ThreeOfAKind = new Hand();
    Hand TwoPair = new Hand();
    Hand OnePair = new Hand();
    Hand HighCard = new Hand();

    FiveOfAKind.addCard(new Card(4,4));
    FiveOfAKind.addCard(new Card(5,3));
    FiveOfAKind.addCard(new Card(5,2));
    FiveOfAKind.addCard(new Card(5,1));
    FiveOfAKind.addCard(new Card(5,0));

    StraightFlush.addCard(new Card(2,3));
    StraightFlush.addCard(new Card(3,3));
    StraightFlush.addCard(new Card(4,3));
    StraightFlush.addCard(new Card(5,3));
    StraightFlush.addCard(new Card(6,3));

    FourOfAKind.addCard(new Card(2,2));
    FourOfAKind.addCard(new Card(5,3));
    FourOfAKind.addCard(new Card(5,2));
    FourOfAKind.addCard(new Card(5,1));
    FourOfAKind.addCard(new Card(5,0));

    FullHouse.addCard(new Card(6,1));
    FullHouse.addCard(new Card(6,2));
    FullHouse.addCard(new Card(6,3));
    FullHouse.addCard(new Card(5,3));
    FullHouse.addCard(new Card(5,0));

    Flush.addCard(new Card(6,1));
    Flush.addCard(new Card(7,1));
    Flush.addCard(new Card(8,1));
    Flush.addCard(new Card(3,1));
    Flush.addCard(new Card(2,1));

    Straight.addCard(new Card(9,0));
    Straight.addCard(new Card(8,1));
    Straight.addCard(new Card(7,2));
    Straight.addCard(new Card(6,3));
    Straight.addCard(new Card(5,0));

    ThreeOfAKind.addCard(new Card(9,0));
    ThreeOfAKind.addCard(new Card(9,1));
    ThreeOfAKind.addCard(new Card(9,2));
    ThreeOfAKind.addCard(new Card(6,3));
    ThreeOfAKind.addCard(new Card(5,0));

    TwoPair.addCard(new Card(9,0));
    TwoPair.addCard(new Card(9,1));
    TwoPair.addCard(new Card(8,2));
    TwoPair.addCard(new Card(8,3));
    TwoPair.addCard(new Card(5,0));

    OnePair.addCard(new Card(9,0));
    OnePair.addCard(new Card(9,1));
    OnePair.addCard(new Card(2,2));
    OnePair.addCard(new Card(8,3));
    OnePair.addCard(new Card(5,0));

    HighCard.addCard(new Card(13,0));
    HighCard.addCard(new Card(3,1));
    HighCard.addCard(new Card(2,2));
    HighCard.addCard(new Card(8,3));
    HighCard.addCard(new Card(5,0));

    HighCard.printHand();
    System.out.println("Number of Pairs: " + HighCard.numPairs());
    System.out.println("Has Triplet: " + HighCard.hasTriplet());
    System.out.println("Has Flush: " + HighCard.hasFlush());
    System.out.println("Has Straight: " + HighCard.hasStraight());
    System.out.println("Has Full House: " + HighCard.hasFullHouse());
    System.out.println("Has Four of a Kind: " + HighCard.hasFourOfAKind());
    System.out.println("Highest Value: " + HighCard.highestValue());
    System.out.println("Highest Duplicate: " + HighCard.highestDuplicate());

    System.out.println("Compare To:");
    System.out.println(HighCard.compareTo(FiveOfAKind));
    System.out.println(HighCard.compareTo(StraightFlush));
    System.out.println(HighCard.compareTo(FourOfAKind));
    System.out.println(HighCard.compareTo(FullHouse));
    System.out.println(HighCard.compareTo(Flush));
    System.out.println(HighCard.compareTo(Straight));
    System.out.println(HighCard.compareTo(ThreeOfAKind));
    System.out.println(HighCard.compareTo(TwoPair));
    System.out.println(HighCard.compareTo(OnePair));
    System.out.println(HighCard.compareTo(HighCard));

    // System.out.println();
    //
    // test2.printHand();
    // System.out.println("Number of Pairs: " + test2.numPairs());
    // System.out.println("Has Triplet: " + test2.hasTriplet());
    // System.out.println("Has Flush: " + test2.hasFlush());
    // System.out.println("Has Straight: " + test2.hasStraight());
    // System.out.println("Has Full House: " + test2.hasFullHouse());
    // System.out.println("Has Four of a Kind: " + test2.hasFourOfAKind());
    // System.out.println("Highest Value: " + test2.highestValue());
    // System.out.println("Highest Duplicate: " + test2.highestDuplicate());
    // System.out.println("Compare To: " + test2.compareTo(test));
  }
}
