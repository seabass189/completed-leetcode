// Given a string, find the length of the longest substring without repeating characters.
//
// Example 1:
//   Input: "abcabcbb"
//   Output: 3
//   Explanation: The answer is "abc", with the length of 3.
//
// Example 2:
//   Input: "bbbbb"
//   Output: 1
//   Explanation: The answer is "b", with the length of 1.
//
// Example 3:
//   Input: "pwwkew"
//   Output: 3
//   Explanation: The answer is "wke", with the length of 3.
//      Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
import java.util.*;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
      int maxLength = 0;
      for (int i = 0; i < s.length(); i++) {
        int len = getLongestSubstringLength(s, i);
        if (maxLength < len) {
          maxLength = len;
        }
      }
      return maxLength;
    }

    private static int getLongestSubstringLength(String s, int index){
      HashSet<String> hset = new HashSet<String>();
      int j = 0;
      boolean stop = false;
      while (!stop) {
        String sub = s.substring(index+j, index+j+1);
        if (!hset.contains(sub)) {
          hset.add(sub);
          if ((s.length()-index) > j+1) {
            j++;
          }else{
            stop = true;
          }
        }else{
          stop = true;
        }
      }
      return hset.size();
    }

    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("abcabcbb");
        System.out.print("For abcabcbb, longest substring is " + len);
    }
}
