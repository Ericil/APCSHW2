import java.util.*;
public class MyDeque<T>{
    int head;
    int tail;
    Object[] list;
    int size;
    public MyDeque(){
	list = new Object[10];
	head = 49;
	tail = 50;
	size = 0;
    }
    public void meow(){
	if (size == list.length){
	    Object[] list2 = new Object[size * 2];
	    int trigger = 0;
	    int place = head + 1;
	    for (int a = (size * 2)/4;trigger < 0; trigger++){
		if (place == list.length - 1){
		    place = 0;
		}
	        list2[a] = list[place];
		place++;
		a++;
	    }
	    list = list2;
	}
    }
    public static void main(String[]args){
	MyDeque<Integer> a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	a.size = 10;
	a.meow();
       
	System.out.println(Arrays.toString(a));
    }
}
	
    
