class Solution {
 
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode lp = left;
        ListNode rp = right;
        ListNode curr = head;

        while(curr != null) {
            if (curr.val < x) {
                lp.next = curr;
                lp = lp.next;
            }else{
                
                rp.next = curr;
                rp=rp.next;
            }
            
            curr = curr.next;
        }

        //cycle bnjayega warna
        rp.next = null;
        
        lp.next = right.next;
        return left.next;
    }
}