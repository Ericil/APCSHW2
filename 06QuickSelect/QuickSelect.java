import java.util.*;
public class QuickSelect{
    public static int partition(int[]ary, int si, int ei){
	int ri = si + (int)(Math.random()*(ei - si) + 1);
	int pivot = ary[ri];
	int end = ei;
	int a = si;
	int start = si;
	boolean trigger = false;
	System.out.println(pivot);
	while(a <= ei && end != start){
	    System.out.println(Arrays.toString(ary));
	    if(end == ri){
		ary[ri] = ary[ri - 1];
		ary[ri - 1] = pivot;
		ri--;
	    }
	    if(start == ri){
		ary[ri] = ary[ri + 1];
		ary[ri + 1] = pivot;
		ri++;
	    }
	    if (a < ri){
		if(ary[a] > pivot){
		    if (ary[end] < pivot){
			int hold = ary[end];
			ary[end] = ary[a];
			ary[a] = hold;
		    }
		    end--;
		}else{
		    a++;
		}
	    }else if (a == ri){
		a++;
	    }else{
		if(ary[a] < pivot){
		    if (ary[start] > pivot){
			int hold = ary[start];
			ary[start] = ary[a];
			ary[a] = hold;
		    }
		    start++;
		}else{
		    a++;
		}
	    }
	}
	System.out.println(Arrays.toString(ary));
	return ri;
    }
    /*
    public static int partition(int[] ary,int si, int ei){
	int[] D = new int[ary.length];
	for(int a = 0; a < ary.length; a++){
	    if (a < si && a > ei){
		D[a] = ary[a];
	    }
	}
	int ri = si + (int)(Math.random()*(Math.abs(ei - si) + 1));
	int pivot = ary[ri];
	int end = ei;
	System.out.println(pivot);
	for(int a = si; a <= ei; a++){
	    System.out.println(Arrays.toString(D));
	    if (ary[a] < pivot){
		D[si] = ary[a];
		si++;
	    }else if (ary[a] > pivot){
		D[end] = ary[a];
		end--;
	    }
	}
	D[si] = pivot;
	
	  if(ri - 1 >= 1){
	  partition(D, 0, ri - 1);
	  }
	  if(D.length - 1 - (ri + 1) >= 1){
	  partition(D, ri +1, D.length - 1);
	}
       
	System.out.println(Arrays.toString(D));
	return si;
    }
    */
    public static void quickSort(int[]ary){
	quickSort(ary, 0, ary.length - 1);
    }
    public static void quickSort(int[] ary, int a, int b){
	if (b - a > 1){
	    int pivot = partition(ary, a, b);
	    quickSort(ary, a, pivot - 1);
	    quickSort(ary, pivot + 1, b);
	}
    }
    public static int quickSelect(int[] ary, int n){
	return quickSelect(ary, 0, ary.length - 1, n);
    }
    public static int quickSelect(int[]ary, int a, int b, int n){
	int place = partition(ary, a, b);
        while (place != n && a != place && place != b){
	    if (place > n){
		b--;
		place = partition(ary, place, b);
	    }else{
		a++;
		place = partition(ary, a, place);
	    }
	}
	return place;
    }
    public static void main(String[]args){
	int[] tester = {30, 25, 8, 17, 3, 12, 1, 19};
        quickSort(tester);
    }
}
