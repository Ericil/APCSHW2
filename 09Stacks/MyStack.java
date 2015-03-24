import java.util.*;
public class MyStack<T>{
    MyLinkedList<T> list;
    public MyStack(){
	list = new MyLinkedList<T>();
    }
    public void push(T a){
	list.add(0, a);
    }
    public T pop(){
	if(list.size() == 0){
	    throw new EmptyStackException();
	}
	return list.remove(0);
    }
    public T peek(){
	if (list.size() == 0){
	    throw new EmptyStackException();
	}
	return list.get(0);
    }
    
}
