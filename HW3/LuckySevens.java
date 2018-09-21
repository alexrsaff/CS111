public class LuckySevens
{
  public static void main(String[] args)
  {
    int count =0;
    System.out.print("Enter Lower: ");
    int lowerlim = IO.readInt();
    System.out.print("Enter Upper: ");
    int upperlim = IO.readInt();
    if(lowerlim>upperlim)
    {
      IO.reportBadInput();
      return;
    }
    for( int num = lowerlim; num<=upperlim; num++)
    {
      for(int temp = num; (float)temp / 10.0 !=0;)
      {
        if(temp % 10==7 || temp % 10==-7)
          count++;
        temp=temp/10;
        //IO.outputIntAnswer(temp);
      }
    }
    IO.outputIntAnswer(count);
  }
}
