import java.util.*;
import java.lang.*;
public class MyLinkedList<T> implements Iterable<T>{
    LNode<T> start = new LNode<T>(null, null);
    int location;
    int thesize = 0;
    LNode<T> end;
    public String name(){
	return "li.mingrui";
    }
    public String toString(){
	LNode<T> place = start;
	String data = "[";
	while(place.getNext() != null){
	    data = data + place.getData() + ",";
	    place = place.getNext();
	}
	if (place.getNext() == null){
	    data = data + place.getData() + ",";
	}
	return data.substring(0, data.length() - 1) + "]";
	
    }
    public T get(int index){
	location = 0;
	if (index < 0 || index > thesize){
	    throw new IndexOutOfBoundsException("index under 0 or above the size");
	}
	LNode<T> place = start;
	place = place.getNext();
	location++;
	return place.getData();
    }
    
    public T set(int index, T value){
	location = 0;
	if (index < 0 || index > thesize){
	    throw new IndexOutOfBoundsException("index under 0 or above the size");
	}
	LNode<T> place = start;
	while (location != index){
	    place = place.getNext();
	    location++;
	}
	T returning = place.getData();
	place.setData(value);
	return returning;
    }
    
    public boolean add(T value){
	LNode<T> newnode = new LNode<T>(null, value);
	if(thesize == 0){
	    start = newnode;
	}else{
	    LNode<T> place = start;
	    while (place.getNext() != null){
		place = place.getNext();
	    }
	    place.setNext(newnode);
	}
	thesize++;
	return true;
	    
    }

    public void add(int index, T value){
	location = 0;
	if (index < 0 || index > thesize){
	    throw new IndexOutOfBoundsException("index under 0 or above the size");
	}
	LNode<T> newnode = new LNode<T>(null, value);
	LNode<T> place = start;
	if (index > 0){
	    LNode<T> previous = start;
	    while(location != index){
		if (location == index - 1){
		    previous = place;
		}
		place = place.getNext();
		location++;
	    }
	    previous.setNext(newnode);
	    newnode.setNext(place);
	}else{
	    newnode.setNext(place);
	    start = newnode;
	}
	thesize++;
	if (location == thesize - 1){
	    end = place;
	}
	
    }
    
    public T remove(int index){
	T returning = start.getData();
	if(thesize > 1){
	    location = 0;
	    if (index < 0 || index > thesize){
		throw new IndexOutOfBoundsException("index under 0 or above the size");
	    }
	    if (index > 0){
		LNode<T> place = start;
		while(location != index - 1){
		    place = place.getNext();
		    location++;
		}
		LNode<T> hold = place;
		place = place.getNext();
		returning = place.getData();
		LNode<T> hold2 = place.getNext();
		hold.setNext(hold2);
		thesize--;
		if (hold.getNext() == null){
		    end = hold;
		}
	    }else{
		LNode<T> place = start.getNext();
		start = place;
		thesize--;
	    }
	}else{
	    thesize--;
	    start.setData(null);
	}
	return returning;
    }
    
	
    

    public int size(){
        return thesize;
	    
    }
    
    public int indexOf(T value){
	int returning = -1;
	if(thesize > 0){
	    location = 0;
	    LNode<T> place = start;
	    while(location != thesize - 1 && place.getData() != value){
		place = place.getNext();
	    location++;
	    }
	    if (location <= thesize - 1){
		if (place.getData() == value){
		    returning = location;
		}
	    }
	}
	return returning;
    }
    public Iterator<T> iterator(){
	return new MyLinkedListIterator<T>(start);
    }
    
    private class MyLinkedListIterator<T> implements Iterator<T>{
	LNode<T> start2;
	public MyLinkedListIterator(LNode<T> a){
	    start2 = a;
	}
	public boolean hasNext(){
	    if (start2.getNext() != null){
		return true;
	    }
	    return false;
	}
	public T next(){
	    if (start2.getNext() == null){
		throw new NoSuchElementException();
	    }
	    T hold = start2.getData();
	    start2 = start2.getNext();
	    return hold;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }


    public static void main(String[]args){
	MyLinkedList<Integer> a = new MyLinkedList<Integer>();
	a.add(1);
	System.out.println(a);
	a.add(0, 2);
	System.out.println(a);
	System.out.println(a.get(2));
        a.remove(0);
	System.out.println(a);
	System.out.println(a.indexOf(10));
    }
}
