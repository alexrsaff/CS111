public class ArraySearch
{
  public static void main (String[] args)
  {
    int array[][] = {{1,1,0},
                     {1,1,0},
                     {1,1,0}};
    int numcount = 0;
    for(int row = 0; row<array.length; row++)
    {
      int column = 0;
      for(; column<array[row].length && array[row][column]==1;column++)
        numcount++;
      //System.out.println("Column: " + column + "Length: "+ (array[row].length));
      if(column==array[row].length)
      {
        System.out.println("ABORTING " + numcount);
        return;
      }
    }
    System.out.println("FINISHED " + numcount);
  }
}
