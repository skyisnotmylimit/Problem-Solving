//Q-109@LeetCode
class Solution {
    public ListNode[] getMiddle(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode[] ans = new ListNode[2];
        ans[0] = prev;
        ans[1] = slow;
        return ans;
    }
    public TreeNode construct(ListNode start, ListNode end) {
        if (start != null && end != null && start.val <= end.val) {
            ListNode[] m = getMiddle(start, end);
            ListNode mid = m[1];
            ListNode prev = m[0];
            TreeNode root = new TreeNode(mid.val);
            root.left = construct(start, prev);
            root.right = construct(mid.next, end);
            return root;
        }
        return null;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
        return null;
        ListNode start = head;
        ListNode end = head;
        while (end.next != null)
        end = end.next;
        return construct(start, end);
    }
}
