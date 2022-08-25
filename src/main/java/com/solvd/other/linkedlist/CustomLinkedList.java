package com.solvd.other.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomLinkedList {
    private static final Logger logger = LogManager.getLogger(CustomLinkedList.class);

    private Node head;

    public CustomLinkedList(){

    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            head = newNode;
        }else{
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public void insertHead(int data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    public void insertAt(int index, int data){
        Node nodeToBeInserted = new Node(data);
        Node node = head;
        for(int i = 0; i < index - 1; i++){
            node = node.getNextNode();
        }
        nodeToBeInserted.setNextNode(node.getNextNode());
        node.setNextNode(nodeToBeInserted);
    }

    public void deleteNodeAt(int index){
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
    }

    public void display(){
        if(head != null){
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                logger.info(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            logger.info(currentNode.getData());
        }
    }

    public Node reverse(){
        Node previous = null;
        Node current = head;
        Node next;
        while (current != null){
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        return previous;
    }

    public boolean checkLoop(){
        boolean loopExists = false;
        Map<Node, Integer> map = new HashMap<>();
        Node tempNode = head;
        while (tempNode != null){
            if(map.get(tempNode) == null){
                map.put(tempNode, 1);
            }else {
                map.put(tempNode, 2);
                loopExists = true;
                break;
            }
            tempNode = tempNode.getNextNode();
        }
        return loopExists;
    }
}
