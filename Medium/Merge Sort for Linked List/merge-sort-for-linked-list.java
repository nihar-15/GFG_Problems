//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
         if(head == null || head.next == null){
            return head;
         }
         Node mid = getMiddle(head);
         Node nextToMid =  mid.next;
         mid.next = null ;


         Node left = mergeSort(head);
         Node right = mergeSort(nextToMid);
     
         ///System.out.println(left.val +"  " + right.val);
        return    sortedMerge(left , right);
    }
   static  Node sortedMerge(Node list1, Node list2) {
     // This is a "method-only" submission. 
     // You only need to complete this method
        Node head =  new Node(-99999);
        Node cur = head;
        
        while(list1 != null && list2 != null){
            if(list1.data <= list2.data){
               cur.next = list1;
               list1 = list1.next;
            }else{
               cur.next = list2;
               list2 = list2.next; 
            }
            cur = cur.next;
        }
        if(list1 != null){
            cur.next = list1;
        }else{
     cur.next = list2;
        }
        
           
        return head.next;
   } 
    static  Node getMiddle(Node head ){
        Node slow=head;
        Node fast=head.next;

		while(fast!=null&&fast.next!=null){

			slow=slow.next;

			fast=fast.next.next;

		}

		return slow;
    }
}


