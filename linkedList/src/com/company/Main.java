package com.company;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Node list1 = buildList(5);

        System.out.println("### Printing after rearranging odd and even together ###");
        Node rearrange = rearrangeOddEven(list1);
        printList(rearrange);

        Node list2 = buildList(5);

        System.out.println("### Printing the sorted merge List content ###");
        list1 = sortedMerge(list1,list2);
        printList(list1);

        //Checking for duplicate
        if (findDuplicate(list1)) {
            System.out.println("There is duplicte entry");
        } else{
            System.out.println("No duplicate entry");
        }

        System.out.println("### Printing after deleteing middle element ###");
        printList(deleteMiddle(list1));


        System.out.println("### Printing reversed List content ###");
        Node revList = reverseList(list1);
        printList(revList);
        System.out.println("### Printing recursive reversed List ###");
        revList = recursiveReverse(revList);
        printList(revList);

        System.out.println("### Printing after deleting List content ###");
        Node deletedList = deleteNode(revList,5);
        printList(deletedList);


    }

    public static Node buildList(int size){
        int count = 0;
        Node head = null;
        System.out.println("Enter "+size+" integers for populating the list:");
        Scanner scanner = new Scanner(System.in);
        while (count < size){
            int data = scanner.nextInt();
            head = sortedAdd(head,data);
            count++;
        }
        //head = sortedAdd(null,1); for testing

        return head;
    }

    public static Node addNode(Node head, int data){
        if (head == null){
            return (new Node(data));
        }
        Node current = head;
        while (current.next !=null){
            current = current.next;
        }
        current.next = new Node(data);
        return head;
    }

    public static void printList(Node head){
        if(head==null){
            System.out.println("List is empty");
        }
        Node current = head;
        while (current !=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static Node reverseList(Node head){
        Node current = head;
        Node result = null;
        Node next;

        while (current != null) {

            next = current.next;
            current.next = result;
            result= current;
            current = next;
        }
        return result;
    }

    public static Node recursiveReverse(Node head){
        if(head==null || head.next == null)
            return head;

        //get second node
        Node second = head.next;
        //set first's next to be null
        head.next = null;

        Node rest = reverseList(second);
        second.next = head;

        return rest;
    }

    public static Node sortedAdd(Node head, int data){
        Node newNode = new Node(data);
        if ((head == null) || (head.data > data)){
            newNode.next = head;
            return newNode;
        }
        Node current = head;
        while (current.next != null){
            if (current.next.data > data){
                Node temp = current.next;
                current.next = newNode;
                newNode.next = temp;
                return head;
            } else{
                current = current.next;
            }
        }
        current.next = newNode;
        return head;
    }

    public static Node deleteNode(Node head, int key){
        if (head==null){
            return head;
        }
        if(head.data == key){
            return head.next;
        }
        Node current = head;
        while (current.next!=null){
            if (current.next.data != key){
                current = current.next;
            } else{
                current.next = current.next.next;
                return head;
            }
        }
        System.out.println("Key to be deleted from list could not be found");
        return head;
    }

    //Assuming the that the list passedinside are sorted.
    public static Node sortedMerge(Node list1, Node list2){
        Node result = null;
        if (list1 == null){
            return list2;
        }else if (list2==null){
            return list1;
        }

        if (list1.data <= list2.data){
            result = list1;
            result.next = sortedMerge(list1.next,list2);
        } else {
            result = list2;
            result.next = sortedMerge(list1,list2.next);
        }
        return result;
    }

    public static boolean findDuplicate(Node head){
        Hashtable hashtable = new Hashtable();
        Node current = head;
        while (current!=null){
            if (hashtable.containsKey(current.data)){
                return true;
            }else {
                hashtable.put(current.data,true);
                current = current.next;
            }
        }
        return false;
    }

    public static Node deleteMiddle(Node head){
        if (head == null){
            return null;
        }
        if ((head.next == null)||(head.next.next == null)){
            return head;
        }
        Node ptr1 = head;
        Node ptr2 = head;
        Node previous = null;
        while ((ptr2.next!=null)&&(ptr2.next.next != null)){
            previous = ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        previous.next = ptr1.next;
        return head;
    }

    public static Node rearrangeOddEven(Node head){

        if ((head==null)||(head.next==null)){
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenFirst = even;

        while (true){
            if ((even.next==null)){
                odd.next = evenFirst;
                break;
            }
            odd.next = even.next;
            odd = even.next;

            if (odd.next==null){
                even.next = null;
                odd.next = evenFirst;
                break;
            }
            even.next = odd.next;
            even = odd.next;
        }

        return head;
    }



}





























