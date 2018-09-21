public class Det
{
  public static double[][] make_matrix(double[][] matrix, int column_skip)
  {
    double[][] return_matrix = new double[matrix.length-1][matrix.length-1];
    for(int row = 1; row < matrix.length; row ++)
    {
      for(int column = 0, subtract = 0; column < matrix.length; column ++)
      {
        if(column == column_skip)
        {
          subtract=1;
          continue;
        }
        return_matrix[row-1][column-subtract] = matrix[row][column];
      }
    }
    return return_matrix;
  }

  public static double find_det(double[][] matrix)
  {
    int neg = 0;
    double result = 0;
    if(matrix.length==2)
      return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
    for(int column = 0; column< matrix.length; column ++)
    {
      neg = -1;
      for(int count = 0; count <= column; count++)
        neg*=-1;
      result += (neg * matrix[0][column] * find_det(make_matrix(matrix,column)));
    }
    return result;
  }

  public static void main(String[] args)
  {
    System.out.print("Enter matrix size: ");
    int size = IO.readInt();
    double[][] matrix = new double[size][size];
    for(int row = 0; row< size; row++)
    {
      System.out.println("Enter row "+ row + ": ");
      for(int column = 0; column<size; column++)
        matrix[row][column]=IO.readDouble();
    }
    System.out.println("\nYou entered:");
    System.out.println();
    for(int row = 0; row< size; row++)
    {
      for(int column = 0; column<size; column++)
        System.out.print(matrix[row][column] + " ");
      System.out.print("\n");
    }
    System.out.println("\nDeterminant: " + find_det(matrix));
  }
}
