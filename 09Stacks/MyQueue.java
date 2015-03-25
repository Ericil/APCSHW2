import java.util.*;
public class MyQueue<T>{
    MyLinkedList<T> list = new MyLinkedList<T>();
    public void enqueue(T a){
	list.add(a);
    }
    public T dequeue(){
	if (list.size() == 0){
	    throw new IndexOutOfBoundsException();
	}
	return list.remove(0);
    }
    public T peek(){
	if (list.size() == 0){
	    throw new IndexOutOfBoundsException();
	}
	return list.get(0);
    }
}
