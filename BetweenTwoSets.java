// replace all the file with this program
import java.util.*;

public class BetweenTwoSets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        
        int lcmResult = lcm(arr1);
        int gcdResult = gcd(arr2);
        
        int count = 0;
        for (int i = lcmResult, j = 2; i <= gcdResult; i = lcmResult * j, j++) {
            if (gcdResult % i == 0) {
                count++;
            }
        }
        
        System.out.println(count);
        
        scanner.close();
    }
    
    // Function to calculate the Greatest Common Divisor (GCD) of an array of integers
    public static int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
    
    // Function to calculate the Greatest Common Divisor (GCD) of two integers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    // Function to calculate the Least Common Multiple (LCM) of an array of integers
    public static int lcm(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }
    
    // Function to calculate the Least Common Multiple (LCM) of two integers
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
