import java.util.*;
public class MyDeque<T>{
    int head;
    int tail;
    Object[] list;
    int size;
    public MyDeque(){
	list = new Object[10];
	head = 0;
	tail = 1;
	size = 0;
    }
    public void resize(){
	Object[] list2 = new Object[size * 2];
	int a = 0;
	for(int size1 = 0; size1 < list.length; size1++,head++){
	    if (head == list.length - 1){
		head = 0;
	    }
	    list2[size1] = list[head];
	}
	head = 0;
	tail = list.length - 1;
	list = list2;
	
    }

    public void addFirst(T value){
	if (size == list.length){
	    resize();
	}
	if (head == 0){
	    head = list.length - 1;
	}else{
	    head = head - 1;
	}
	list[head] = value;
    }

    public void addLast(T value){
	if (size == list.length){
	    resize();
	}
	if (tail == list.length - 1){
	    tail = 0;
	}else{
	    tail = tail + 1;
	}
	list[tail] = value;
    }


    public static void main(String[]args){
    }
}
	
    
