package com.sparta.rp.binarytree;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

       BinaryTreeImpl tree = new BinaryTreeImpl(5);
       tree.addElementToTree(1);
       tree.addElementToTree(5);
       tree.addElementToTree(4);
       tree.addElementToTree(6);
       tree.addElementToTree(15);
       tree.addElementToTree(9);
        System.out.println(tree.findElement(11));
        try
        System.out.println(Arrays.toString(tree.getSortedTreeAsc()));
       ;

    }
}
