/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node simplecopyll = new Node(-1);
        Node oldhead = head;
        Node oo = head;
        Node dummy = simplecopyll;
        Node temp = head;
        while (temp != null) {
            simplecopyll.next = new Node(temp.val);
            simplecopyll = simplecopyll.next;
            temp = temp.next;
        }
        Node nn = dummy.next;
        HashMap<Node,Node> map = new HashMap<>();
        while(oldhead != null) {
            map.put(oldhead, nn);
            oldhead = oldhead.next;
            nn = nn.next;
        }

        // new head - dummy
        Node curr = dummy.next;
        // oldhead
        // curr.random = oldhead.random;
        while (curr != null) {
            if(oo != null) {
                curr.random = map.get(oo.random);
                oo = oo.next;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}