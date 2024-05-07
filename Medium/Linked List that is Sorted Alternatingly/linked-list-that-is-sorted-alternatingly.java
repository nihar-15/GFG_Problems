//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        
        Node asc = head;
        Node desc = head.next;
        Node first = head;
        Node second = head.next;

        while(first.next != null && second.next != null){
            first.next = first.next.next;
            first =first.next;
            if(second.next.next != null){
                second.next = second.next.next;
                second = second.next;
            }
        }
         first.next = null;
        second.next = null;
        
        Node h = reverse(desc);
        first.next = h;
        return asc;
   }
Node reverse (Node head){
    Node prev =null, next =null;
    while(head != null){
        next = head.next;
        head.next= prev;
        prev= head;
        head= next;
    }
    return prev;
}

}