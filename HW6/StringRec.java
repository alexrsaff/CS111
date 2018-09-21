public class StringRec
{
  public static String decompress(String compressedText)
  {
    if(compressedText.length()<=1)
      return compressedText;

    if(compressedText.charAt(0)=='1')
      return compressedText.substring(1);

    if(compressedText.charAt(0)>=50 && compressedText.charAt(0)<=57)
      return compressedText.charAt(1) + decompress((char)(compressedText.charAt(0)-1) + decompress(compressedText.substring(1)));

    return compressedText.charAt(0) + decompress(compressedText.substring(1));
  }
  // public static void main(String[] args)
  // {
  //   //String test = "a".repeat(3);
  //   //System.out.println(test);
  //   System.out.println(decompress(IO.readString()));
  // }
}
