import java.util.*;

class Node {
    public int data;
    public Node next;
    public Node prev;
    
    public Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    public Node head;
    public Node tail;
    
    public DoublyLinkedList(int[] arr) {
        if(arr.length <= 0) {
            this.head = null;
            this.tail = this.head;
            return;
        }
        this.head = new Node(arr[0]);
        Node currentNode = this.head;
        for(int i = 1; i < arr.length; i++) {
            currentNode.next = new Node(arr[i]);
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }
        this.tail = currentNode;
    }
    
    public void printList() {
        Node iterator = this.head;
        while(iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }
    
     //指定したインデックスのノード（ポインタ）を返す
    public Node at(int index) {
        Node iterator = this.head;
        for(int i = 0; i < index; i++) {
            iterator = iterator.next;
            if(iterator == null) return null;
        }
        return iterator;
    }
    
    //リストを逆向きにする
    public void reverse() {
        Node reverse = this.tail;
        Node iterator = this.tail.prev;
        
        Node currentNode = reverse;
        while(iterator != null) {
            currentNode.next = iterator;
            iterator = iterator.prev;
            
            if(iterator != null) iterator.next = null;
            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }
        this.tail = currentNode;
        this.head = reverse;
        this.head.prev = null;
    }
    
    //リストを逆順に出力
    public void reversePrint() {
        Node iterator = this.tail;
        while(iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.prev;
        }
    }
    
    //リストの先頭に要素追加。O(1)
    public void preappend(Node newNode) {
        this.head.prev = newNode;
        newNode.next = this.head;
        newNode.prev = null;
        this.head = newNode;
    }
    
    //リストの末尾に要素追加。O(1)
    public void append(Node newNode) {
        this.tail.next = newNode;
        newNode.prev = this.tail;
        newNode.next = null;
        this.tail = newNode;
    }
    
    //リストの特定の位置にノード追加
    public void addNextNode(Node node, Node newNode) {
        Node tempNode = node.next;
        node.next = newNode;
        newNode.next = tempNode;
        newNode.prev = node;
        //nodeが末尾だった場合、newNodeを末尾に変更する
        //nodeが末尾でない場合、tempNodeのprevを更新
        if(node == this.tail) {
            this.tail = newNode;
        } else {
            tempNode.prev = newNode;
        }
        
    }
    
    //ノードの先頭削除
    public void popFront() {
        this.head = this.head.next;
        this.head.prev = null;
    }
    
    //ノードの末尾削除
    public void pop() {
        this.tail = this.tail.prev;
        this.tail.next = null;
    }
    
    //特定のノード削除
    public void deleteNode(Node node) {
        if(node == this.tail) {
            this.pop();
        } else if(node == this.head) {
            this.popFront();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }
}

class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        int[] arr = new int[]{33,45,46,43,67,49,68,29,11};
        
        DoublyLinkedList list = new DoublyLinkedList(arr);
        // System.out.println(list.at(3).data);
        // list.preappend(new Node(465));
        // list.append(new Node(453));
        // list.addNextNode(list.at(0), new Node(495));
        list.popFront();
        list.pop();
        list.deleteNode(list.at(1));
        list.printList();
        // list.reverse();
        // list.reversePrint();
        // list.printList();
    }
}
