import java.util.*;
public class BTree<T>{
    private TreeNode<T> sub = new TreeNode<T>(null);

    public void add(T value){
	if (sub.getVal() == null){
	    sub.setVal(value);
	}else{
	    TreeNode<T> hold = new TreeNode<T>(value);
	    if (sub.getLeft() == null){
	        sub.setLeft(hold);
	    }else if (sub.getRight() == null){
		sub.setRight(hold);
	    }
	}
    }
}
		
    
