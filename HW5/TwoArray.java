public class TwoArray
{
  public static void main (String[] args)
  {
    int One[] =  {5,6,7,8,9};
    int Two[] =  {0,1,2,3,4};
    int numcompare = 0;
    for(int entry = 0; entry < One.length; entry++)
    {
      for(int position = 0; position < Two.length; position++)
      {
        numcompare++;
        if(One[entry]==Two[position])
          {
            System.out.println("ABORTING " + numcompare);
            return;
          }
      }
    }
    System.out.println("FINISHED " + numcompare);
  }
}
