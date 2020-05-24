// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example 1:
//   Input: "babad"
//   Output: "bab"
//   Note: "aba" is also a valid answer.
//
// Example 2:
//   Input: "cbbd"
//   Output: "bb"
class Solution {
  public String longestPalindrome(String s) {
    if (s.length() == 1) return s;
    else if (s.length() == 0 || s == null) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int size1 = longestFromCenter(s, i, i);
      int size2 = longestFromCenter(s, i, i+1);
      int len = Math.max(size1, size2);
      if (len > (end - start)) {
        start = i - ((len-1)/2);
        end = i + (len/2);
      }
    }
    System.out.println("Start at " + start);
    System.out.println("End at " + (end+1));
    return s.substring(start, end+1);
  }

  private int longestFromCenter(String s, int begin, int end){
    while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
      begin--;
      end++;
    }
    return end - begin - 1;
  }
}
