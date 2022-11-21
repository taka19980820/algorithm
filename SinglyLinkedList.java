import java.util.*;

class Node {
    public int data;
    public Node next;
    
    public Node(int data) {
        this.data = data;
    }
    //新しいノードを受け取り、次のノードに設定する
    public void addNextNode(Node newNode) {
        Node tempNode = this.next;
        this.next = newNode;
        newNode.next = tempNode;
    }
}

class SinglyLinkedList {
    public Node head;
    
    public SinglyLinkedList(int[] arr) {
        this.head = new Node(arr[0]);
        Node currentNode = this.head;
        for(int i = 1; i < arr.length; i++) {
            currentNode.next = new Node(arr[i]);
            currentNode = currentNode.next;
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
    
    // //指定したインデックスのノードの値を返す
    // public Integer findNode(int index) {
    //     Node iterator = this.head;
    //     for(int i = 0; i < index; i++) {
    //         iterator = iterator.next;
    //         if(iterator == null) return null;
    //     }
    //     return iterator.data;
    // }
    
    //リスト要素出力
    public void printList() {
        Node iterator = this.head;
        while(iterator != null) {
            System.out.println(iterator.data);
            iterator = iterator.next;
        }
    }
    
    //リストの先頭へノード追加。O(1)
    public void preappend(Node newNode) {
        Node tempNode = this.head;
        this.head = newNode;
        newNode.next = tempNode;
    }
    
    //リストの末尾へノード追加。末尾を追跡していないので、O(n)
    public void append(Node newNode) {
        Node iterator = this.head;
        while(iterator.next != null) {
            iterator = iterator.next;
        }
        iterator.next = newNode;
    }
    
    //リストの先頭ノード削除O(1)
    public void popFront() {
        this.head = this.head.next;
    }
    
    //リストの要素削除O(n)
    public void delete(int index) {
        if(index == 0) {
            this.popFront();
            return;
        }
        Node iterator = this.head;
        for(int i = 0; i < index-1; i++) {
            if(iterator.next == null) return;
            iterator = iterator.next;
        }
        iterator.next = iterator.next.next;
    }
    
    //リストを逆向きにする。O(n)
    public void reverse() {
        if(this.head == null || this.head.next == null) return;
        
        Node reverse = this.head;
        this.head = this.head.next;
        reverse.next = null;
        
        while(this.head != null) {
            Node tempNode = this.head;
            this.head = this.head.next;
            tempNode.next = reverse;
            reverse = tempNode;
        }
        
        this.head = reverse;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{33,45,46,43,67,49,68,29,11};
        
        SinglyLinkedList list = new SinglyLinkedList(arr);
        
        Node iterator = list.head;
        // int i = 0;
        // while(iterator != null) {
        //     Node currentNode = iterator;
        //     iterator = iterator.next;
        //     if(i % 2 == 0) {
        //         currentNode.addNextNode(new Node(currentNode.data * 2));
        //     }
        //     i++;
        // }
        // list.preappend(new Node(3));
        // list.append(new Node(56));
        // list.popFront();
        // list.delete(4);
        list.reverse();
        list.printList();
        
    }
}
