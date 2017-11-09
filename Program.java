
import java.util.List;

class Program
{
    public static int TotalTime(int[] band, int n)
    {
        if (n < 3)
        {
            return band[n - 1];
        }
        else if (n == 3)
        {
            return band[0] + band[1] + band[2];
        }
        else
        {
            int temp1 = band[n - 1] + band[0] + band[n - 2] + band[0];
            int temp2 = band[1] + band[0] + band[n - 1] + band[1];

            if (temp1 < temp2)
            {
                return temp1 + TotalTime(band, n - 2);
            }
            else if (temp2 < temp1)
            {
                return temp2 + TotalTime(band, n - 2);
            }
            else
            {
                return temp2 + TotalTime(band, n - 2);
            }
        }
    }
}