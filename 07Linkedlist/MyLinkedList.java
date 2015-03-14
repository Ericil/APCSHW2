import java.util.*;
import java.lang.*;
public class MyLinkedList{
    LNode start = new LNode(null, 0);
    int location;
    int thesize = 0;
    LNode end;
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
	if (index > 0){
	    LNode previous = start;
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
    
    public int remove(int index){
	location = 0;
	int returning = start.getData();
	if (index < 0 || index > thesize){
	    throw new IndexOutOfBoundsException("index under 0 or above the size");
	}
	if (index > 0){
	    LNode place = start;
	    while(location != index - 1){
		place = place.getNext();
		location++;
	    }
	    LNode hold = place;
	    place = place.getNext();
	    returning = place.getData();
	    LNode hold2 = place.getNext();
	    hold.setNext(hold2);
	    thesize--;
	    if (hold.getNext() == null){
	    end = hold;
	    }
	}else{
	    LNode place = start.getNext();
	    start = place;
	    thesize--;
	}
	return returning;
    }
    
	
    

    public int size(){
        return thesize;
	    
    }
    
    public int indexOf(int value){
	int returning = -1;
	location = 0;
	LNode place = start;
	while(location != thesize - 1 && place.getData() != value){
	    place = place.getNext();
	    location++;
	}
	if (location <= thesize - 1){
	    if (place.getData() == value){
		returning = location;
	    }
	}
	return returning;
    }
    
    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	a.add(1);
	System.out.println(a);
	a.add(0, 4);
	System.out.println(a);
	a.add(5);
	System.out.println(a);
        a.remove(0);
	System.out.println(a);
	System.out.println(a.indexOf(10));
    }
}
