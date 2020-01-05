import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // All denominations of existing Currency
    static int deno[] = {50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000};
    static int n = deno.length;

    static void findMin(int V)
    {
        // Initialize result
        List<Integer> ans = new ArrayList<>();

        // Traverse through all denomination
        for (int i = n - 1; i >= 0; i--)
        {
            // Find denominations
            while (V >= deno[i])
            {
                V -= deno[i];
                ans.add(deno[i]);
            }
        }

        // Print result
        int pivot = ans.get(0);
        int count = 1;
        int i;
        int countMoney = 0;
        for (i = 1; i < ans.size(); i++)
        {
            if (pivot == ans.get(i)) {
                count++;
            } else {
                System.out.println("Rp"+ ans.get(i - 1) + " (" + count + "x)");
                count = 1;
                countMoney++;
            }
            pivot = ans.get(i);
        }
        System.out.println("Rp" + ans.get(i - 1) + " (" + count + ")");
        System.out.println("Fractional currency : " + (countMoney + 1));
    }

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.print("Please input money to change (Rp) : ");
        int n = input.nextInt();
        System.out.println("Following is minimal number of change for " + n + " : ");
        findMin(n);
    }
}
