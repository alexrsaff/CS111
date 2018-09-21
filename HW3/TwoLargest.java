public class TwoLargest
{
  public static void main(String[] args)
  {
    boolean success=false;
    while(success==false)
    {
      System.out.print("Enter a terminating value: ");
      double terminator = IO.readDouble();
      System.out.print("\nEnter numbers:\n");
      double currval = IO.readDouble();
      double max = currval;
      double  lowermax = currval;
      boolean firstNum = true;
      boolean secondNum = false;
      int count = 0;
      while(currval!=terminator)
      {
        if(currval>max)
        {
          lowermax=max;
          max=currval;
        }
        else if(currval>lowermax)
          lowermax=currval;
        else if(secondNum==true)
          lowermax=currval;
        currval = IO.readDouble();
        if(secondNum)
          secondNum=false;
        if(firstNum)
        {
          firstNum=false;
          secondNum=true;
        }
        count++;
      }
      if (count<2)
        IO.reportBadInput();
      else
      {
        System.out.print("Maximum: ");
        IO.outputDoubleAnswer(max);
        System.out.print("\nLower Maximum: ");
        IO.outputDoubleAnswer(lowermax);
        success = true;
      }
    }
  }
}
