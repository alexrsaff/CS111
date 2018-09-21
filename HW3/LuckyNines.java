public class LuckyNines
{
  public static int countLuckyNines(int lowerEnd, int upperEnd)
  {
    int count =0;
    if(lowerEnd>upperEnd)
    {
      //IO.reportBadInput();
      return -1;
    }
    for( int num = lowerEnd; num<=upperEnd; num++)
    {
      for(int temp = num; (float)temp / 10.0 !=0;)
      {
        if(temp % 10==9 || temp % 10==-9)
          count++;
        temp=temp/10;
        //IO.outputIntAnswer(temp);
      }
    }
    IO.outputIntAnswer(count);
    return count;
  }
  public static void main(String[] args)
  {
    System.out.print("Enter Lower: ");
    int lowerlim = IO.readInt();
    System.out.print("Enter Upper: ");
    int upperlim = IO.readInt();
    countLuckyNines(lowerlim,upperlim);
  }
}
