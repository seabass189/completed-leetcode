// ==== REVERSE INTEGER ====
// Given a 32-bit signed integer, reverse digits of an integer.

// Example 1:
//  Input: 123
//  Output: 321

// Example 2:
//  Input: -123
//  Output: -321

// Example 3:
//  Input: 120
//  Output: 21

// Note:
// Assume we are dealing with an environment which could only 
// store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
// For the purpose of this problem, assume that your function 
// returns 0 when the reversed integer overflows.

class ReverseIntSolution {
    
    public static int reverse(int x) {
        int digit, r = 0;

        //while there are still values to reverse
        while(x != 0){
            //grab the last value of x and store it
            digit = x % 10;
            //remove the last value of x
            x /= 10;

            //check that the reversal of x (r) won't cause overflow
            if (r > Integer.MAX_VALUE/10 || (reverse(x) == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (r < Integer.MIN_VALUE/10 || (r == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            //add the removed digit to the end of r
            r = (r*10) + digit;
        }
        //return the reversal
        return r;
    }

    public static void main(String[] args) {
        int num = 1234567;
        System.out.println(num + " backwards is " 
        + reverse(num));
    }
}
