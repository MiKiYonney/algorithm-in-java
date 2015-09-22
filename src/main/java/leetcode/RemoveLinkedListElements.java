package leetcode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * Created by yonney.yang on 2015/9/2.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node0 = new ListNode(0);
        ListNode p = node0;
        if (head == null) return null;

        while (head != null) {
            if(head.val == val){
                p.next = head.next;
            }else {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        return node0.next;
    }
}
