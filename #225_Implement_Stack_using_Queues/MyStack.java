import java.util.*;

class MyStack {

    Deque<Integer> queue;
    Deque<Integer> aux;

    MyStack() {
        queue = new LinkedList();
        aux = new LinkedList();
    }

    // Push element x onto stack.
    public void push(int x) {
        if (empty()) queue.add(x);
        else {
            aux.add(x);
            while (!queue.isEmpty()) {
                aux.add(queue.remove());
            }
            Deque<Integer> tmp = queue;
            queue = aux;
            aux = tmp;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.element();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stk = new MyStack();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        System.out.println(stk.top());
        stk.pop();
        System.out.println(stk.top());
        stk.pop();
        System.out.println(stk.top());
        stk.pop();
    }
}