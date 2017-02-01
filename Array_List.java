package com.company;

public class ArrList<T> {

    private final int STANDART_SIZE = 16;
    private T[] mas;
    private int size = 0;
    private int index = 0;

    ArrList(){
        mas = (T[]) new Object[STANDART_SIZE];
    }

    ArrList(final int size){
        mas = (T[]) new Object[size];
    }

    private void resize(T[] mas){
        T[] ptr = (T[]) new Object[size*2];
        System.arraycopy(mas,0,ptr,0,this.index-1);
        mas = ptr;
    }

    private void Check_index(int index){
        if(index < 0 || index >= this.index){
            throw new IllegalArgumentException();
        }
    }

    public void add(T element){
        if(index == mas.length){
            resize(mas);
        }
        else{
            mas[index] = element;
            index++;
            size++;
        }
    }

    public void add(int index,T element){
        if(index == mas.length){
            resize(mas);
        }
        else{
            System.arraycopy(mas,index,mas,index+1,this.index-index);
            mas[index] = element;
            this.index++;
            size++;
        }
    }

    public void remove(int index){
        Check_index(index);
        System.arraycopy(mas,index+1,mas,index,this.index-index);
        size--;
        this.index--;
    }

    public int get_size(){
        return size;
    }

    public T get(int index){
        Check_index(index);
        return mas[index];
    }

    public void set(int index,T element){
        Check_index(index);
        mas[index] = element;
    }

    public T[] subList(int first,int last){
        Check_index(first);
        Check_index(last);
        if(first <= last){
            T[] ptr = (T[]) new Object[(last-first)+1];
            System.arraycopy(mas,first,ptr,0,last-first);
            return ptr;
        }
        return (T[]) new Object[1];
    }
}
