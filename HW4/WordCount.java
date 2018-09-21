public class WordCount
{
  public static int countWords(String original, int maxLength)
  {
    int wordCount = 0, length=0;
    for(char junk=0;junk<65;junk++)
      original=original.replace(junk,' ');
    for(char junk=91;junk<97;junk++)
      original=original.replace(junk,' ');
    for(char junk=123;junk<128;junk++)
      original=original.replace(junk,' ');
    System.out.println(original);
    for(int pos=0;pos<original.length();pos++)
    {
      if(original.charAt(pos)==' ' || pos==original.length()-1)
      {
        if(original.charAt(pos)!=' ')
          length++;
        //System.out.println(length);
        if(length<=maxLength && length>0)
          wordCount++;
        length=0;
        continue;
      }
      else
        length++;
    }
    return wordCount;
  }
  public static void main(String[] args)
  {
    System.out.println(countWords(IO.readString(),10));
  }
}
//a~b!v#c$h%j^k&l*l(f)y-p=o_l+g{h}w[r]l\M|n`b:m"c'f;d<m>s?a,v.b/k
