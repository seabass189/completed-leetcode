// ===== ADD TWO NUMBERS ====
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example:
//  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//  Output: 7 -> 0 -> 8
//  Explanation: 342 + 465 = 807

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
        val = x; 
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode current = result;
        int rem = 0;
        
        while((l1 != null) || (l2 != null)){
            int temp = rem;
            if(l1 != null){
                temp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            current.val = temp % 10;
            rem = temp/10;
            if(l1 != null || l2 != null){
                current.next = new ListNode(-1);
                current = current.next;
            }
        }
        if(rem > 0){
            current.next = new ListNode(rem);
        }
        return result;
    }

}