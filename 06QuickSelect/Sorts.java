import java.util.*;
public class Sorts{
    public String name(){
	return "li.mingrui";
    }
    public static int partition(int[]ary, int si, int ei){
	int ri = si + (int)(Math.random()*(ei - si) + 1);
	int hold = ary[ei];
	ary[ei] = ary[ri];
	ary[ri] = hold;
	for (int a = si; a < ei; a++){
	    if (ary[a] < ary[ei]){
		hold = ary[si];
		ary[si] = ary[a];
		ary[a] = hold;
		si++;
	    }
	}
	hold = ary[ei];
	ary[ei] = ary[si];
	ary[si] = hold;
	return si;
	
    }
   
    public static void QuickSort(int[]ary){
	QuickSort(ary, 0, ary.length - 1);
    }
    public static void QuickSort(int[] ary, int a, int b){
	if (b - a > 1){
	    int pivot = partition(ary, a, b);
	    QuickSort(ary, a, pivot - 1);
	    QuickSort(ary, pivot + 1, b);
	}
    }
 
    public static void main(String[]args){
	int[] tester = {30, 25, 8, 17, 3, 12, 1, 19, 50, 231, -6, 15};
        QuickSort(tester);
	System.out.println(Arrays.toString(tester));
    }
}
