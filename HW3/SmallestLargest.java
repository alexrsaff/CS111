public class SmallestLargest
{
  public static void main(String[] args)
  {
    System.out.print("Enter a terminating value: ");
    double terminator = IO.readDouble();
    System.out.print("\nEnter numbers:\n");
    double currval = IO.readDouble();
    double max = currval;
    double  min = currval;
    while(currval!=terminator)
    {

      if(currval<min)
        min=currval;
      if(currval>max)
        max=currval;
      currval = IO.readDouble();
    }
    System.out.print("Minimum: ");
    IO.outputDoubleAnswer(min);
    System.out.print("\nMaximum: ");
    IO.outputDoubleAnswer(max);
  }
}
