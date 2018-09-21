public class Multiply
{
  public static void main(String[] args)
  {
    System.out.println("java Multiply\n");
    System.out.print("Enter integer number: ");
    int number1=IO.readInt();
    System.out.print("\nEnter integer number: ");
    int number2 = IO.readInt();
    System.out.println();
    IO.outputIntAnswer(number1*number2);
  }
}
