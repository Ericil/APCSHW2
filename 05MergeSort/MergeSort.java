import java.util.*;
public class MergeSort{
    
    public static int[] merge(int a[], int b[]){
	int[] merged = new int[a.length + b.length];
	int c = 0;
	int d = 0;
        while (c < a.length && d < b.length){
	    if(a[c] < b[d]){
		merged[c + d] = a[c];
		c++;
	    }else{
		merged[c + d] = b[d];
		d++;
	    }
	}
	if (a.length == c){
	    for (int e = d; e < b.length; e++){
		merged[c + e] = b[e];
	    }
	}
	if (b.length == d){
	    for (int e = c; e < a.length; e++){
		merged[d + e] = a[e];
	    }
	}
	return merged;
    }
    public static void mergesort(int[] a){
	int[] b = sort(a);
	for(int c = 0; c < b.length - 1; c++){
	    a[c] = b[c];
	}
    }
    public static int[] sort(int[] a) {
	if (a.length == 1) {
	    return a;
	}
	int[] b = Arrays.copyOfRange(a, 0, a.length / 2);
	int[] c = Arrays.copyOfRange(a, a.length / 2, a.length);
	return merge(sort(b), sort(c));
    }
    public static void main(String[]args){
     int[] a = {-12, 3, 15, 11, 1, 5, 7, 19};
     mergesort(a);
     System.out.println(Arrays.toString(a));
    }
}
