import java.lang.Math;
public class Recursion implements hw1{
    
    public String name(){
	return "Li,Mingrui";
    }

    public int fact(int n){
	if (n >= 0){
	    return fact2(n, 1);
	}else{
	    throw new IllegalArgumentException();
	}
    }
    public int fact2(int a, int b){
        if(a != 1){
	   return fact2 (a - 1, b*a);
	}else{
	    return b;
	}
    }

    public int fib(int n){
	if (n >= 0){
	    return fib2(n, 0, 1);
	}else{
	    throw new IllegalArgumentException();
	}
    }
    public int fib2(int a, int b, int c){
	if (a!= 1){
	    return fib2(a - 1, c, b + c);
	}else{
	    return b;
	}
    }

    public double sqrt(double n){
	if (n > 0){
	    return sqrt2(n, 1);
	}else if (n == 0){
	    return 0;
	}else{
	    throw new IllegalArgumentException();
	}
    }
    public double sqrt2(double a,double b){
        if (Math.abs(a - b*b) > .000000000000001){
	    return sqrt2(a, (a/b + b)/2);
	}else{
	    return b;
	}
    }
}
