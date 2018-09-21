public class CountCat
{
  public static void main(String[] args)
  {
    String test = "This is a string";
    test=test.toUpperCase();
    System.out.println(test);
    char arr[] = test;
    for (int i = 0; i < test.length()-1; i++)
    {
        int min_idx = i;
        for (int j = i+1; j < test.length(); j++)
            if (test.charAt(j).compareTo(test.charAt(min_idx))<0)
                min_idx = j;
        char temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
  }
}
