/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int getSize(ListNode head)
    {
        ListNode temp = head;
        int len = 0;
        while(temp != null)
        {
            len++;
            temp = temp.next;
        }
        return len;
    }
    public ListNode removeNthFromEnd(ListNode A, int B) {

        // Bth node from the end would be n-B from the front
        int size = getSize(A);
        if(size == 1 )
        {
            return null;
        }
        if(B > size)
        {
            return A.next;
        }
        B = size - B;
        if(B == 0)
        {
            return A.next;
        }
        ListNode temp = A;
        while(B > 1)
        {
            B--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return A;
    }
}
