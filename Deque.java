import java.util.*;

class Node {
    public int data;
    public Node next;
    public Node prev;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Deque {
    public Node head;
    public Node tail;
    
    public Deque() {
        this.head = null;
        this.tail = null;
    }
    
    public Integer peekFront() {
        if(this.head == null) return null;
        return this.head.data;
    }
    
    public Integer peekBack() {
        if(this.tail == null) return null;
        return this.tail.data;
    }
    
    public void enqueueFront(int data) {
        if(this.head == null) {
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node node = new Node(data);
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }
    
    public void enqueueBack(int data) {
        if(this.tail == null) {
            this.tail = new Node(data);
            this.head = this.tail;
        } else {
            Node node = new Node(data);
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }
    
    //キューの先頭を取得
    public Integer dequeueFront() {
        if(this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        if(this.head != null) {
            this.head.prev = null;
        } else {
            this.tail = null;
        }
        return temp.data;
    }
    
    //キューの末尾を削除
    public Integer dequeueBack() {
        if(this.tail == null) return null;
        Node temp = this.tail;
        this.tail = this.tail.prev;
        if(this.tail != null) {
            this.tail.next = null;
        } else {
            this.head = null;
        }
        return temp.data;
    }
}

class Main {
    public static void main(String[] args) {
        // Your code here!
        Deque q = new Deque();
        q.enqueueFront(3);
        q.enqueueBack(908);
        System.out.println(q.peekFront()); //3
        System.out.println(q.peekBack()); //908
        q.enqueueFront(467);
        q.enqueueBack(45);
        q.dequeueFront();
        q.dequeueFront();
        System.out.println(q.peekFront()); //908
        System.out.println(q.peekBack()); //45
    }
}
