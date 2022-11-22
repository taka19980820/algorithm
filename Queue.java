import java.util.*;

class Node {
    public int data;
    public Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    public Node head;
    public Node tail;
    
    public Queue() {
        this.head = null;
        this.tail = null;
    }
    
    public Integer peekFront() {
        if(this.head == null) return null;
        return this.head.data;
    }
    //末尾を取得。headだけあり、tailがない場合があるため（要素が一個のとき）tailがnullの時はpeekFrontを呼び出す
    public Integer peekBack() {
        if(this.tail == null) return this.peekFront();
        return this.tail.data;
    }
    //キューにデータを追加
    public void enqueue(int data) {
        if(this.head == null) {
            this.head = new Node(data);
        } else if(this.tail == null) {
            this.tail = new Node(data);
            this.head.next = this.tail;
        } else {
            this.tail.next = new Node(data);
            this.tail = this.tail.next;
        }
    }
    //キューの先頭を取得
    public Integer dequeue() {
        if(this.head == null) return null;
        Node temp = this.head;
        if(this.head.next == null) {
            this.head = null;
            this.tail = this.head;
        } else {
            this.head = this.head.next;
        }
        return temp.data;
    }
}

class Main {
    public static void main(String[] args) {
        // Your code here!
        Queue q = new Queue();
        q.enqueue(3);
        q.enqueue(908);
        q.enqueue(467);
        q.enqueue(45);
        System.out.println(q.peekFront());
        System.out.println(q.peekBack());
        q.dequeue();
        q.dequeue();
        System.out.println(q.peekFront());
        System.out.println(q.peekBack());
    }
}
