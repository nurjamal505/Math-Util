public class MathUtil {

    // Method to check if a number is prime
    // Returns true if n is a prime number, otherwise false
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;  // 0 and 1 are not prime
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;  // If divisible, not a prime
            }
        }
        return true;  // No divisors found, it's a prime
    }

    // Method to calculate the greatest common divisor (GCD) of two numbers
    // Uses Euclidean algorithm to find GCD
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;  // GCD found when b becomes 0
        }
        return gcd(b, a % b);  // Recursively calculate GCD
    }

    // Method to calculate the least common multiple (LCM) of two numbers
    // LCM is calculated using the formula: (a * b) / GCD(a, b)
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);  // LCM formula
    }

    // Method to calculate the nth Fibonacci number using recursion
    // Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8...
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;  // Base cases: fib(0) = 0, fib(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2);  // Recursive Fibonacci calculation
    }

    // Method to calculate the factorial of a number n
    // Factorial is calculated as n * (n-1) * ... * 1
    public static int factorial(int n) {
        if (n == 0) {
            return 1;  // Base case: 0! = 1
        }
        return n * factorial(n - 1);  // Recursive factorial calculation
    }

    // Method to check if a number is a perfect number
    // A perfect number is equal to the sum of its divisors (excluding itself)
    public boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;  // Add divisor to sum
            }
        }
        return sum == n;  // Return true if sum equals n
    }

    // Method to calculate the sum of digits of a number
    public int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;  // Add last digit to sum
            n /= 10;  // Remove last digit from n
        }
        return sum;
    }

    // Method to reverse the digits of a number
    public int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;  // Append last digit to reversed
            n /= 10;  // Remove last digit from n
        }
        return reversed;
    }

    // Method to check if a number is an Armstrong number
    // An Armstrong number equals the sum of its digits each raised to the power of the number of digits
    public boolean isArmstrongNumber(int n) {
        int sum = 0;
        int temp = n;
        int digits = Integer.toString(n).length();  // Get the number of digits

        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);  // Add the digit raised to the power of digits
            temp /= 10;  // Remove last digit
        }

        return sum == n;  // Return true if sum equals n
    }

    // Method to find the next prime number greater than n
    public int nextPrime(int n) {
        n++;
        while (true) {
            if (isPrime(n)) {
                return n;  // Return n if it's prime
            }
            n++;  // Check next number
        }
    }

    public static void main(String[] args) {
        // Test for gcd and lcm methods
        int a = 6;
        int b = 8;
        System.out.println("Gcd of 6 and 8: " + gcd(a, b));  // Expected: 2
        System.out.println("Lcm of 6 and 8: " + lcm(a, b));  // Expected: 24

        // Test for Fibonacci method
        System.out.println("Fibonacci(5): " + fibonacci(5));  // Expected: 5
        System.out.println("Fibonacci(7): " + fibonacci(7));  // Expected: 13
        System.out.println("Fibonacci(10): " + fibonacci(10));  // Expected: 55

        // Test for factorial method
        System.out.println("Factorial(5): " + factorial(5));  // Expected: 120
        System.out.println("Factorial(0): " + factorial(0));  // Expected: 1
        System.out.println("Factorial(7): " + factorial(7));  // Expected: 5040

        // Object for non-static methods
        MathUtil util = new MathUtil();

        // Test for isPerfectNumber method
        System.out.println("Is 28 a perfect number? " + util.isPerfectNumber(28));  // Expected: true
        System.out.println("Is 6 a perfect number? " + util.isPerfectNumber(6));  // Expected: true
        System.out.println("Is 12 a perfect number? " + util.isPerfectNumber(12));  // Expected: false

        // Test for sumOfDigits method
        System.out.println("Sum of digits of 123: " + util.sumOfDigits(123));  // Expected: 6
        System.out.println("Sum of digits of 4567: " + util.sumOfDigits(4567));  // Expected: 22
        System.out.println("Sum of digits of 789: " + util.sumOfDigits(789));  // Expected: 24

        // Test for reverseNumber method
        System.out.println("Reversed number of 1234: " + util.reverseNumber(1234));  // Expected: 4321
        System.out.println("Reversed number of 5678: " + util.reverseNumber(5678));  // Expected: 8765
        System.out.println("Reversed number of 9876: " + util.reverseNumber(9876));  // Expected: 6789

        // Test for isArmstrongNumber method
        System.out.println("Is 153 an Armstrong number? " + util.isArmstrongNumber(153));  // Expected: true
        System.out.println("Is 370 an Armstrong number? " + util.isArmstrongNumber(370));  // Expected: true
        System.out.println("Is 123 an Armstrong number? " + util.isArmstrongNumber(123));  // Expected: false

        // Test for nextPrime method
        System.out.println("Next prime after 10: " + util.nextPrime(10));  // Expected: 11
        System.out.println("Next prime after 29: " + util.nextPrime(29));  // Expected: 31
        System.out.println("Next prime after 100: " + util.nextPrime(100));  // Expected: 101
    }
}
