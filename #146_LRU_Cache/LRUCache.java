import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;

class DLL {
	private Node head;
	private Node tail;
	private int size;

	public DLL() {
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
		size = 0;
	};
	public void addFirst(Node nd) {
		nd.next = head.next;
		head.next.prev = nd;
		head.next = nd;
		nd.prev = head;
		size++;
	}
	public Node remove(Node nd) {
		nd.prev.next = nd.next;
		nd.next.prev = nd.prev;
		nd.prev = null;
		nd.next = null;
		size--;
		return nd;
	}
	public boolean isEmpty() {return size == 0;}
	public Node getTail() {
		if (tail.prev == head) return null;
		return tail.prev;
	}
	public int size() { return size;}
}

class Node {
	int key;
	int val;
	Node next;
	Node prev;
	Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
}

public class LRUCache {

	HashMap<Integer, Node> map;
	DLL dll;
	int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        dll = new DLL();
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		Node nd = dll.remove(map.get(key));
    		dll.addFirst(nd);
    		return map.get(key).val;
    	}
    	return -1;
    }
    
    public void set(int key, int value) {
    	if (map.containsKey(key)) {
    		Node nd = dll.remove(map.get(key));
    		nd.val = value;
    		dll.addFirst(nd);
    		return;
    	}
    	if (dll.size() == capacity) {
    		Node nd = dll.remove(dll.getTail());
    		map.remove(nd.key);
    		set(key, value);
    		return;
    	}
    	Node nd = new Node(key, value);
        map.put(key, nd);
        dll.addFirst(nd);
    }

    public static void main(String[] args) {
    	LRUCache sol = new LRUCache(1);
    	sol.set(2, 1);
    	sol.set(1, 1);
    	System.out.println(sol.get(2));
    	sol.set(4, 1);
    	System.out.println(sol.get(1));
    	System.out.println(sol.get(2));
    	System.out.println(sol.get(4));
    }
}