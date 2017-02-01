package com.company;

public class Linked_List<T> {
private class Node<T>{
    T element;
    Node<T> next;
    Node<T> prev;
    Node(T element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}

private Node<T> head;
private Node<T> current;

Linked_List(T element){
    head = new Node<T>(element);
    current = head;
}

Linked_List(){
    head = null;
    current = null;
}

private void initial(Node<T> ptr){
    head = ptr;
    current = head;
}

public void push_back(T element){
    Node<T> ptr = new Node<T>(element);
    if(head == null){
        initial(ptr);
        return;
    }
    current.next = ptr;
    ptr.prev = current;
    current = ptr;
}

public void push_front(T element){
    Node<T> ptr = new Node<T>(element);
    if(head == null){
        initial(ptr);
        return;
    }
    head.prev = ptr;
    ptr.next = head;
    head = ptr;
}

public void remove_end(){
    if(head == null) return;
    if(current.prev != null) {
        current = current.prev;
        current.next = null;
    }
    else{
        head = null;
        current = null;
    }
}

public void remove_begin(){
    if(head == null) return;
    if(head.next != null) {
        head = head.next;
        head.prev = null;
    }
    else{
        current = null;
        head = null;
    }
}

public void print_begin(){
    if(head != null) {
        Node<T> ptr = head;
        while (ptr != null) {
            System.out.print(ptr.element);
            System.out.print(' ');
            ptr = ptr.next;
        }
    }
}

public void print_end(){
    if(current != null) {
        Node<T> ptr = current;
        while (ptr != null) {
            System.out.print(ptr.element);
            System.out.print(' ');
            ptr = ptr.prev;
        }
    }
}

public T get_first(){
    return head.element;
}

public T get_last(){
    return current.element;
}

}
