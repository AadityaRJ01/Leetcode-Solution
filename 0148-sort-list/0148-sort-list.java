class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        // find middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // split list
        prev.next = null;

        // sort both halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // merge
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null) current.next = l1;
        if(l2 != null) current.next = l2;

        return dummy.next;
    }
}