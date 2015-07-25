import java.util.HashMap;


 // Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        HashMap<RandomListNode, RandomListNode> origintocopy= new HashMap<RandomListNode, RandomListNode>();
        HashMap<RandomListNode, RandomListNode> copytoorigin = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode nHead = new RandomListNode(head.label);
        RandomListNode origin = head.next;
        RandomListNode cur = nHead;
        origintocopy.put(head, nHead);
        copytoorigin.put(nHead, head);
        while (origin != null) {
            RandomListNode node = new RandomListNode(origin.label);
            origintocopy.put(origin, node);
            copytoorigin.put(node, origin);
            cur.next = node;
            cur = node;
            origin = origin.next;
        }
        cur = nHead;
        while (cur != null) {
            RandomListNode rand = copytoorigin.get(cur).random;
            if (rand != null) cur.random = origintocopy.get(rand);
            cur = cur.next;
        }
        return nHead;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(5);
        RandomListNode n1 = new RandomListNode(3);
        RandomListNode n2 = new RandomListNode(6);
        RandomListNode n3 = new RandomListNode(7);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        head.random = n2;
        n2.random = n1;
        n3.random = head;
        Solution sol = new Solution();
        RandomListNode nHead = sol.copyRandomList(head);
        RandomListNode cur = nHead;
        while(cur != null) {
            System.out.println(cur.label + ", " + (cur.random == null ? "null" : cur.random.label));
            cur = cur.next;
        }
    }
}