/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i < lists.length;i++) {
            ListNode headCurrentList = lists[i];
            // System.out.println(head.val);
            ListNode temp = headCurrentList;
            while (temp != null) {
                pq.offer(temp.val);
                temp = temp.next;
            }
        }
        System.out.println(pq);
        ListNode ans = new ListNode(-1);
        ListNode tmp = ans;
        while(!pq.isEmpty()) {
            tmp.next = new ListNode(pq.poll());
            tmp = tmp.next;
        }
        return ans.next;
    }
}