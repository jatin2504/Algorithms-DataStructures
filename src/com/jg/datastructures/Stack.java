package com.jg.datastructures;

import java.util.Arrays;

public class Stack<T> {
    private Object[] arr;
    private int t = -1;

    public Stack() {
        arr = new Object[50];
    }

    public T top() {
        if (!isEmpty()) {
            return (T) arr[t];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        if (t == -1)
            return true;
        else
            return false;
    }

    public void push(T item) {
        if (t == arr.length) {
            Object[] arrTemp = new Object[2 * arr.length];
            for (int i = 0; i < this.arr.length; i++) {
                arrTemp[i] = this.arr[i];
            }
            this.arr = arrTemp;
        }
        t++;
        arr[t] = item;

    }

    public T pop() {
        @SuppressWarnings("unchecked")
        T item = null;
        if (!isEmpty()) {
            item = (T) arr[t];
            t--;
        }
        return item;
    }

    @Override
    public String toString() {
        Object[] arrTemp = new Object[t];
        for (int i = 0; i < t; i++) {
            arrTemp[i] = this.arr[i];
        }
        return Arrays.toString(arrTemp);
    }
}
