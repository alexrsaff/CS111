public class PigLatin
{
  public static String translate(String original)
  {
    original = original.toLowerCase();
    if(original.charAt(0)=='a'||original.charAt(0)=='e'||original.charAt(0)=='i'||original.charAt(0)=='o'||original.charAt(0)=='u')
      return original + "vai";
    char temp= original.charAt(0);
    String newString = "";
    for(int count=1; count<original.length();count++)
      newString+=original.charAt(count);
    return newString + temp + "ai";
  }
  public static void main(String[] args)
  {
    System.out.println(translate(IO.readString()));
  }
}
