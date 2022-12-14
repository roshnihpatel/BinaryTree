package com.sparta.rp.binarytree;

import com.sparta.rp.exceptions.ChildNotFoundException;

public interface BinaryTree {

        int getRootElement();

        int getNumberOfElements();

        void addElement(int element);

        void addElements(final int[] elements);

        boolean findElement(int value);

        int getLeftChild(int element) throws ChildNotFoundException;

        int getRightChild(int element) throws ChildNotFoundException;

        int[] getSortedTreeAsc();

        int[] getSortedTreeDesc();

}
