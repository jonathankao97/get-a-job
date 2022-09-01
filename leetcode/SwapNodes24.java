import java.io.*;
import java.util.*;

public class SwapNodes24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode ptr = head;
        ListNode prev = null;
        while (ptr != null && ptr.next != null) {
            if (ptr == head) {
                head = ptr.next;
            }
            if (prev != null) {
                prev.next = ptr.next;
            }
            ListNode temp = ptr.next;
            ptr.next = ptr.next.next;
            temp.next = ptr;
            prev = ptr;
            ptr = ptr.next;
        }
        return head;
    }
}