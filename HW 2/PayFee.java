public class PayFee
{
  public static void main(String[] args)
  {
    System.out.println("java PayFee\n");
    System.out.print("Enter Payment Amount: ");
    double paymentAmount = IO.readDouble();
    double fee = 0.0;
    if(paymentAmount>=10000)
      {
        fee+=10000*0.02;
        if(paymentAmount<=15000)
          fee+=(paymentAmount-10000)*0.03;
        else
        {
          fee+=(5000)*0.03;
          fee+=(paymentAmount-15000)*0.04;
        }

      }
      else if(paymentAmount>=5000)
        {
          if(paymentAmount*0.02>120)
            fee=paymentAmount*0.02;
          else
            fee=120;
        }
      else if(paymentAmount>500)
          {
            if(paymentAmount*0.01>20)
              fee=paymentAmount*0.01;
            else
              fee=20;
          }
      else
        fee=10;
        System.out.println();
      IO.outputDoubleAnswer(fee);
  }
}
