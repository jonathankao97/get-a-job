import java.io.*;
import java.util.*;

public class Queue {

    public int[] arr;
    public int head;
    public int tail;

    public Queue() {
        this.arr = new int[1];
        this.head = 0;
        this.tail = 0;
    }

    public int size() {
        return (head + arr.length - tail) % arr.length;
    }

    public void resize() {
        int[] newArr = new int[this.arr.length * 2];
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(i + tail) % arr.length];
        }
        arr = newArr;
        tail = 0;
        head = size;
    }

    public void push(int elem) {
        arr[head] = elem;
        head = (head + 1) % arr.length;
        if (head == tail) {
            resize();
        }
    }

    public int pop() {
        int ret = arr[tail];
        tail = (tail + 1) % arr.length;
        return ret;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 0; i < 10; i++) {
            q.push(i);
            if (i % 2 == 0) {
                System.out.println(i + " " + q.size() + " " + q.pop());
            }
        }
    }
}