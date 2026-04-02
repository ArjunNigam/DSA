/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int getSize(ListNode A)
    {
        int len = 0;
        ListNode temp = A;
        while(temp != null)
        {
            temp = temp.next;
            len++;
        }
        return len;
    }
    public ListNode reverseList(ListNode A, int B) {
        if(A == null)
        {
            return null;
        }
        // We will add a dummy node in front of the list to solve this question easily
        int n = getSize(A);
        ListNode dummy = new ListNode(-1);
        dummy.next = A;
        ListNode start = A, prev = dummy, curr = A, preStart = dummy;
        for(int i =0;i<n/B;i++)
        {
            for(int j =0;j<B;j++)
            {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            start.next = curr; 
            preStart.next = prev;
            prev = start;
            preStart = start;
            start = curr;
            
        }
        return dummy.next;
        

    }
}
