//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/
class Solution{
     static Node removeLeadingZeros(Node head) {
        // Initialize a dummy node to handle edge cases
        Node dummy = new Node(0);
        dummy.next = head;
        // Traverse the list to find the first non-zero node
        Node current = dummy;
        while (current.next != null && current.next.data == 0) {
            current = current.next;
        }
        // Update the head to the first non-zero node
        if (current.next == null) {
        current.next = new Node(0); // Store zero in the next node
        head = current.next;
    } else {
        head = current.next;
    }
        
        return head;}
    static Node reverseList(Node head){
      Node curr=head;
      Node prev=null;
      Node next=head;
      while(curr!=null){
          next=curr.next;
          curr.next=prev;
          prev=curr;
          curr=next;
      }
      return prev;
    }
    static Node addTwoLists(Node num1, Node num2){
      Node dummy=new Node(-1);
        Node temp=dummy;
        int carry=0;
       Node l1= reverseList(num1);
       Node l2= reverseList(num2);
        while(l1!=null ||l2!=null ||carry!=0){
            int data1=0;
            int data2=0;
          if(l1!=null) data1= l1.data;
          if(l2!=null) data2= l2.data;
          int ans=data1+data2+carry;
          carry=ans/10;
          Node sum=new Node(ans%10);
          temp.next=sum;
          temp=temp.next;
          if(l1!=null) l1=l1.next;
          if(l2!=null) l2=l2.next;
        }
        Node result=dummy.next;
       Node anss= reverseList(result);
       Node sol=removeLeadingZeros(anss);
     return sol;
    }
}