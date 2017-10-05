package com.SearchingModel;

import java.util.LinkedList;
import java.util.List;

public class FifoQueue<E> {

    private List<E> list = new LinkedList<>();

    public FifoQueue() {
    }

    public void put(E e) {
        list.add(e);
    }
    public E pop() {
        if (list.size() > 0) {
            E e = list.get(0);
            list.remove(0);
            return e;
        } else {
            return null;
        }
    }
    
    public E get(int i) {
    	return list.get(i);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public boolean contains(E e) {
        return list.contains(e);
    }
    
    public int size() {
    	return list.size();
    }
}