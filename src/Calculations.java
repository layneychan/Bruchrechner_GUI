import java.text.SimpleDateFormat;
import java.util.Objects;

public class Calculations
{
    int numer1, denom1, numer2, denom2;
    char operation;

    int numerator;
    int denominator;

    String result = "error";

    Calculations(int numer1, int denom1, int numer2, int denom2, char operation)
    {
        this.numer1 = numer1;
        this.denom1 = denom1;
        this.numer2 = numer2;
        this.denom2 = denom2;
        this.operation = operation;

        if (denom1 == 0 || denom2 == 0) throw new IllegalArgumentException("You can't divide by zero!");
    }

    public void CalculateResult()
    {
        switch (operation)
        {
            case '+':
                addition(numer1, numer2, denom1, denom2);
                break;

            case '-':
                subtraction(numer1, numer2, denom1, denom2);
                break;

            case '*':
                multiplication(numer1, numer2, denom1, denom2);
                break;

            case '/':
                division(numer1, numer2, denom1, denom2);
                break;
        }

        result = SimplifyResult(numerator, denominator);
    }

    public void addition(int numer1, int numer2, int denom1, int denom2)
    {
        if (denom1 != denom2)
        {
            numerator = numer1 * denom2 + numer2 * denom1;
            denominator = denom1 * denom2;
        } else
        {
            numerator = numer1 + numer2;
            denominator = denom1;
        }
    }

    public void subtraction(int numer1, int numer2, int denom1, int denom2)
    {
        if (denom1 != denom2)
        {
            numerator = numer1 * denom2 - numer2 * denom1;
            denominator = denom1 * denom2;
        } else
        {
            numerator = numer1 - numer2;
            denominator = denom1;
        }
    }

    public void multiplication(int numer1, int numer2, int denom1, int denom2)
    {
        numerator = numer1 * numer2;
        denominator = denom1 * denom2;
    }

    public void division(int numer1, int numer2, int denom1, int denom2)
    {
        numerator = numer1 * denom2;
        denominator = denom1 * numer2;
    }

    public int CalculateGgT(int denom1, int denom2)
    {
        int ggt;
        denom1 = Math.abs(denom1);
        denom2 = Math.abs(denom2);

        while (denom2 != 0)
        {
            int tmp = denom2;
            denom2 = denom1 % denom2;
            denom1 = tmp;
        }
        return denom1;
    }

    public String SimplifyResult(int numer, int denom)
    {
        int ggt = CalculateGgT(numer, denom);
        numer /= ggt;
        denom /= ggt;

        return "\n\n" + numer + "/" + denom;

    }
}
