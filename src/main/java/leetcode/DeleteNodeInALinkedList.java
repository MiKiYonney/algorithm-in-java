package leetcode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 * Created by yonney.yang on 2015/9/2.
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) return;

        if(node.next !=null){
            node.val = node.next.val;
            node.next = node.next.next;
        }else{
            return;
        }
    }
}
