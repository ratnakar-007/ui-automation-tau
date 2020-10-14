package com.ratn.company;

import java.awt.*;
import java.util.*;
import java.util.List;

class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data=data;
        this.next = null;
    }
}

public class Runner {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(print(1));
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        System.out.println(removeDuplicates("ratnakar"));

    }
    static Exception print(int i) {
        if (i>0) {
            return new Exception();
        } else {
            throw new RuntimeException();
        }
    }

    public static boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length()/2 ; i++) {
            sb.append(s.charAt(i));
            String pattern = s.replaceAll(sb.toString(), "");
            if (pattern.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static String removeDuplicates(String input){
        int[] table= new int[256];
        char[] output = new char[input.length()];
        int endIndex = 0;
        for(int i = 0 ; i<input.length(); ++i) {
            if (table[input.charAt(i)] == 0) {
                table[input.charAt(i)] = -1;
                output[endIndex++] = input.charAt(i);
            }
        }
        for (char ch : output) {
            System.out.print(ch);
        }
        output = Arrays.copyOfRange(output, 0, endIndex);
        String ans = new String(output);
        System.out.println(output.length + " " +ans.length());
        return ans;
    }

    public static LinkedListNode<Integer> input() {
        int data = s.nextInt();

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        while (data!=-1) {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void print(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static int GCD(int n, int m) {
        if (m == 0) return n;
        else
            return GCD(m, n%m);
    }
}

class Solution {
    public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> evnHd = null;
        LinkedListNode<Integer> evnTl = null;
        LinkedListNode<Integer> oddHd = null;
        LinkedListNode<Integer> oddTl = null;

        if (head == null || head.next ==null)
            return head;

        while(head!=null){
            if (head.data%2 == 0){
                if(evnHd==null){
                    evnHd = head;
                    evnTl = head;
                }else{
                    evnTl.next = head;
                    evnTl = evnTl.next;
                }
                head = head.next;
            } else {
                if(oddHd==null){
                    oddHd = head;
                    oddTl = head;
                }else{
                    oddTl.next = head;
                    oddTl = oddTl.next;
                }
                head = head.next;
            }
        }
        evnTl.next = null;
        if (oddHd == null)
            return evnHd;
        else
            oddTl.next = evnHd;

        return oddHd;
    }
}