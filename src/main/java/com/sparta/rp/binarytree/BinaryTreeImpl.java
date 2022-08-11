package com.sparta.rp.binarytree;
//public methods you can access
//private - implementation
//abstract away the nodes - values

import com.sparta.rp.exceptions.ChildNotFoundException;

import java.util.Arrays;

public class BinaryTreeImpl implements BinaryTree {
    private final Node rootNode;



    public BinaryTreeImpl(int element) {
        rootNode = new Node(element);
    }
    public void addElementToTree(int element){
        addNodeToTree(rootNode,element);
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
      return countNumberOfElements(rootNode);


    }
    private int countNumberOfElements(Node node){
        if(node == null){
            return 0;
        }
        return 1 + countNumberOfElements(node.getLeftChild()) + countNumberOfElements(node.getRightChild());






    }

    @Override
    public void addElement(int element) {
        addNodeToTree(rootNode,element);

    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements){
            addNodeToTree(rootNode,element);
        }

    }

    public boolean findElement(int element){
        Node node = findNode(element);
        return node != null;

    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if (node == null){
            throw new ChildNotFoundException();
        }
        Node leftChild = node.getLeftChild();
        return leftChild.getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if (node == null){
            throw new ChildNotFoundException();
        }
        Node rightChild = node.getRightChild();
        return rightChild.getValue();

    }

    @Override
    public int[] getSortedTreeAsc() {
        int [] sortedAscArray = new int[getNumberOfElements()];
       orderAsc(rootNode, sortedAscArray, 0);


        return sortedAscArray;
    }

    public int orderAsc(Node node, int [] array, int index){
        if(node != null) {
            index = orderAsc(node.getLeftChild(), array, index);
            array[index++] = node.getValue();
            index = orderAsc(node.getRightChild(), array, index);
        }
           return index;

    }
    public int orderDesc(Node node, int [] array, int index){
        if(node != null) {
            index = orderDesc(node.getRightChild(), array, index);
            array[index++] = node.getValue();
            index = orderDesc(node.getLeftChild(), array, index);
        }
        return index;

    }


    @Override
    public int[] getSortedTreeDesc() {
        int [] sortedDescArray = new int[getNumberOfElements()];
        orderDesc(rootNode, sortedDescArray, 0);


        return sortedDescArray;

    }

    private void addNodeToTree(Node node, int element){
        if(element <= node.getValue()){
            addToLeftSideOfNode(node, element);
        }else if(element > node.getValue()) {
            addToRightSideOfNode(node, element);
        }
    }

    private void addToRightSideOfNode(Node node, int element) {
        if(node.isRightChildEmpty()){
            node.setRightChild(new Node(element));
        }else{
            addNodeToTree(node.getRightChild(), element);
        }
    }

    private void addToLeftSideOfNode(Node node, int element) {
        if(node.isLeftChildEmpty()){
            node.setLeftChild(new Node(element));
        }else{
            addNodeToTree(node.getLeftChild(), element);
        }
    }

    private Node findNode(int element){
        Node node = rootNode;
        while(node != null){
            if(element== node.getValue()){
                return node;
            }if(element < node.getValue()){
                node = node.getLeftChild();
            }else if(element > node.getValue()){
                node = node.getRightChild();
            }
        }
        return null;
    }
}
