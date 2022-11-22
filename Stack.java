import java.util.*;

class Item {
    public int data;
    public Item next;
    
    public Item(int data) {
        this.data = data;
    }
}

class Stack {
    public Item head;
    
    public Stack() {
        this.head = null;
    }
    
    //スタックへ要素追加
    public void push(int data) {
        Item temp = this.head;
        this.head = new Item(data);
        this.head.next = temp;
    }
    //スタックから要素取得
    public Integer pop() {
        if(this.head == null) return null;
        Item temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }
    
    //スタックの頂上の要素を返す。（popはしない
    public Integer peek() {
        if(this.head == null) return null;
        return this.head.data;
    }
}

class Main {
    public static void main(String[] args)  {
        // Stack stack = new Stack();
        // stack.push(45);
        // stack.push(475);
        // stack.push(42);
        // stack.push(77);
        // stack.pop();
        // stack.pop();
        int[] subArr = consecutiveWalk(new int[]{3,4,20,45,56,6,4,3,2,3,9});
        
        System.out.println(Arrays.toString(subArr));
    }
    
    public static int[] consecutiveWalk(int[] arr) {
        if(arr.length <= 0) return new int[0];
        Stack stack = new Stack();
        ArrayList<Integer> nums = new ArrayList<Integer>();  
        stack.push(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            if(stack.peek() > arr[i]) {
                while(stack.pop() != null);
            }
            stack.push(arr[i]);
        }
        
        while(stack.peek() != null) {
            nums.add(stack.pop());
        }
        
        int[] res = new int[nums.size()];
        
        for(int i = 0; i < res.length; i++) {
            res[i] = nums.get(i);
        }
        
        return res;
    } 
}
