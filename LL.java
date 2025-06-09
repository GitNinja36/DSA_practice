import java.util.*;

import org.w3c.dom.Node;
public class LL {

    private Node head;
    private Node tail; 
    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size += 1;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size -= 1;
        return val;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp; 
        }
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public void duplicates(){
        Node node = head;
        while(node.next != null){
            if(node.next == null && node.next.value == node.value){
                node.next = node.next.next;
                size--;
            }else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null; 
    }

    // public ListNode middleNode(ListNode head){
    //     ListNode f = head;
    //     ListNode s = head;
    //     while(f != null && s != null){
    //         f = f.next.next;
    //         s = s.next;
    //     }
    //     return s;
    // }

    // public ListNode sortList(ListNode head) {
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     ListNode mid = getMid(head);
    //     ListNode left = sortList(head);
    //     ListNode right = sortList(mid);
    //     return merge(left, right);
    // } 

    // ListNode merge(ListNode list1, ListNode list2){
    //     ListNode dummyHead = new ListNode();
    //     ListNode tail = dummyHead;
    //     while(list1 != null && list2 != null){
    //         if(list1.val < list2.val){
    //             tail.next = list1;
    //             list1 = list1.next;
    //             tail = tail.next;
    //         }
    //     }
    //     tail.next = (list1 != null) ? list1 : list2;
    //     return dummyHead.next;
    // }
    // ListNode getMid(ListNode head){
    //     ListNode midPrev = null;
    //     while(head != null && head.next != null){
    //         midPrev = (midPrev == null) ? head : midPrev.next;
    //         head= head.next.next;
    //     }
    //     ListNode mid = midPrev.next;
    //     midPrev.next = null;
    //     return mid;
    // }

    //reverse linked-list
    public void reverse(Node node){
        if( node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //reverse linked-list without tail
    public void rev(Node node){
        if(size < 2){
            return;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
    }



    private class Node{
        private int value;
        private Node next;

        private Node (int value){
            this.value = value;
        }
        
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
