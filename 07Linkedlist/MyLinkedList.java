import java.util.*;
import java.lang.*;
public class MyLinkedList{
    LNode start = new LNode(null, 0);
    int location;
    int thesize = 0;
    public String toString(){
	LNode place = start;
	String data = "";
	while(place.getNext() != null){
	    data = data + place.getData() + ",";
	    place = place.getNext();
	}
	if (place.getNext() == null){
	    data = data + place.getData() + ",";
	}
	return data;
	
    }
    public int get(int index){
	location = 0;
	if (index < 0 || index > thesize){
	    throw new IndexOutOfBoundsException("index under 0 or above the size");
	}
	LNode place = start;
	place = place.getNext();
	location++;
	
	return place.getData();
    }
    
    public int set(int index, int value){
	location = 0;
	if (index < 0 || index > thesize){
	    throw new IndexOutOfBoundsException("index under 0 or above the size");
	}
	LNode place = start;
	while (location != index){
	    place = place.getNext();
	    location++;
	}
	int returning = place.getData();
	place.setData(value);
	return returning;
    }
    
    public boolean add(int value){
	LNode newnode = new LNode(null, value);
	if(thesize == 0){
	    start = newnode;
	}else{
	    LNode place = start;
	    while (place.getNext() != null){
		place = place.getNext();
	    }
	    place.setNext(newnode);
	}
	thesize++;
	return true;
	    
    }

    public void add(int index, int value){
	location = 0;
	if (index < 0 || index > thesize){
	    throw new IndexOutOfBoundsException("index under 0 or above the size");
	}
	LNode newnode = new LNode(null, value);
	LNode place = start;
	while(location != index - 1){
	    place = place.getNext();
	    location++;
	}
	LNode place2 = place.getNext();
	place.setNext(newnode);
	place = place.getNext();
	place.setNext(place2);
	thesize++;
	
    }

    public void remove(int index){
	if (index < 0 || index > thesize){
	    throw new IndexOutOfBoundsException("index under 0 or above the size");
	}
	
    }

    public int size(){
	LNode place = start;
	int thesize = 0;
	if (place.getNext() != null){
	    while (place.getNext() != null){
		place = place.getNext();
		thesize++;
	    }
	}
	return thesize;
	    
    }
    /*
    public int indexOf(int value){
    }
    */
    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	a.add(1);
	a.add(2);
	a.add(3);
	System.out.println(a);
	a.add(3, 4);
        a.set(2, 5);
	System.out.println(a);
	
    }
}
