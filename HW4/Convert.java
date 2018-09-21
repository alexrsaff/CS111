public class Convert
{
  public static int convert(String binaryString, boolean signBit)
  {
    int number = 0;
    int result = 0;
    for(int count =binaryString.length()-1; count>=0; count--)
    {
      number = Integer.parseInt("" + binaryString.charAt(count));
      //System.out.println(number);
      if(signBit && (count==0))
      {
        if(number==1)
          result*=-1;
      }
      else
        result+=(number)*Math.pow(2,binaryString.length()-count-1);
    }
    return result;
  }

  public static void main(String[] args)
  {
    System.out.println(convert(IO.readString(),IO.readBoolean()));
  }
}
