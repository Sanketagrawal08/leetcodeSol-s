class Solution {
   
    public ListNode getmid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode lefthalf, ListNode righthalf) {
        if (lefthalf == null)
            return righthalf;
        if (righthalf == null)
            return lefthalf;

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        
        while (lefthalf != null && righthalf != null) {
            if (lefthalf.val < righthalf.val) {
                temp.next = lefthalf;
                temp = lefthalf;
                lefthalf = lefthalf.next;
            } else {
                temp.next = righthalf;
                temp = righthalf;
                righthalf = righthalf.next;
            }
        }

        while (lefthalf != null) {
            temp.next = lefthalf;
            temp = lefthalf;
            lefthalf = lefthalf.next;
        }
        while (righthalf != null) {
            temp.next = righthalf;
            temp = righthalf;
            righthalf = righthalf.next;
        }
        return ans.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getmid(head);

        ListNode lefthalf = head;
        ListNode righthalf = mid.next;
        mid.next = null;

        // recursive call to merge sort
        ListNode left = sortList(lefthalf);
        ListNode right = sortList(righthalf);

        //merge boht lefthalf and righthalf
        ListNode result = merge(left, right);

        return result;
    }
}