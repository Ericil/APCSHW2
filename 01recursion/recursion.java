import java.lang.Math;
public class recursion{
    
    public String name(){
	return "Li,Mingrui";
    }

    public int fact(int n){
	return fact2(n, 1);
    }
    public int fact2(int a, int b){
        if(a != 1){
	   return fact2 (a - 1, b*a);
	}else{
	    return b;
	}
    }

    public int fib(int n){
	return fib2(n, 0, 1);
    }
    public int fib2(int a, int b, int c){
	if (a!= 1){
	    return fib2(a - 1, c, b + c);
	}else{
	    return b;
	}
    }

    public double sqrt(double n){
	System.out.println("trigger");
	return sqrt2(n, 1);
    }
    public double sqrt2(double a,double b){
        if ((int)Math.round(b) != (int)Math.round(((a/b + b)/2))){
	    return sqrt2(a, (a/b + b)/2);
	}else{
	    return b;
	}
    }

    
    public static void main(String[]args){
	recursion a = new recursion();
	System.out.println(a.fact(3));
	System.out.println(a.fib(7));
	System.out.println(a.sqrt(100));
    }
}
