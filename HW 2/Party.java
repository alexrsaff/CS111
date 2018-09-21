public class Party
{
  public static void main(String[] args)
  {
    int nPies = 0, nCases = 0;
    double totalPieCost = 0.0, totalCaseCost = 0.0, totalCost = 0.0;
    System.out.println("java Party\n");
    System.out.print("Enter the number of people attending the party: ");
    int people = IO.readInt();
    System.out.print("\nEnter the number of slices of pizza each person should be able to eat: ");
    int pizzaPerPerson = IO.readInt();
    System.out.print("\nEnter the number of cans of soda each person should be able to drink: ");
    int cansPerPerson = IO.readInt();
    System.out.print("\nEnter the cost of a pizza pie: ");
    double pieCost = IO.readDouble();
    System.out.print("\nEnter the number of slices in a pizza pie: ");
    int pizzaPerPie = IO.readInt();
    System.out.print("\nEnter the cost of a case of soda: ");
    double caseCost = IO.readDouble();
    System.out.print("\nEnter the number of cans in a case of soda: ");
    int cansPerCase = IO.readInt();
    nPies = (people * pizzaPerPerson) / pizzaPerPie;
    nCases = (people * cansPerPerson) / cansPerCase;
    if ((people * pizzaPerPerson) % pizzaPerPie >0)
      nPies += 1;
    if((people * cansPerPerson) % cansPerCase>0)
      nCases += 1;
    totalPieCost = nPies * pieCost;
    totalCaseCost = nCases * caseCost;
    totalCost = totalPieCost + totalCaseCost;
    System.out.println();
    IO.outputDoubleAnswer(totalCost);
  }
}
