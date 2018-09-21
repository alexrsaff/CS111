public class Compress
{
  public static String compress(String original)
  {
    int count=1;
    String output="";
    for(int pos=1;pos<original.length();pos++)
    {
      if(original.charAt(pos)==original.charAt(pos-1))
        count++;
      if(original.charAt(pos)!=original.charAt(pos-1)||pos==original.length()-1)
      {
        if(count>1)
        {
          output+= Integer.toString(count) + original.charAt(pos-1);
          count=1;
        }
        else
          output+=original.charAt(pos-1);
        if(pos==original.length()-1 && original.charAt(pos)!=original.charAt(pos-1))
          output+=original.charAt(pos);
      }
    }
    return output;
  }

  public static void main (String[] args)
  {
    System.out.println(compress(IO.readString()));
  }
}
