package com.solvd.other.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.insert(60);
        customLinkedList.insert(10);
        customLinkedList.insert(70);
        customLinkedList.insert(20);
        customLinkedList.display();
        customLinkedList.deleteNodeAt(2);
        System.out.println("----------------");
        customLinkedList.display();
        customLinkedList.insertHead(100);
        System.out.println("----------------");
        customLinkedList.display();
    }
}
