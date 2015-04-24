import java.util.*;
public class BTree<T>{
    TreeNode<T> sub;
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    public BTree(){
	sub = new TreeNode<T>(null);
    }
    public void add(T value){
        TreeNode<T> hold = new TreeNode<T>(value);
	System.out.println(hold.getVal());
	add(sub, hold);
    }
    private void add(TreeNode<T> current, TreeNode<T> adding){
	Random rand = new Random(100);
	if (current.getVal() == null){
	    current.setVal(adding.getVal());
	}else if (current.getLeft() == null &&
		  current.getRight() == null){
	    int r = rand.nextInt(2);
	    if (r == 0){
		current.setLeft(adding);
	    }else{
		current.setRight(adding);
	    }
	}else if (current.getLeft() == null){
	    current.setLeft(adding);
	}else if (current.getRight() == null){
	    current.setRight(adding);
	}else{
	    int r = rand.nextInt(2);
	    if (r == 0){
		add(current.getLeft(), adding);
	    }else{
		add(current.getRight(), adding);
	    }
	}
    }
    
    public void traverse(int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( sub );
	else if ( mode == IN_ORDER )
	    inOrder( sub );
	else
	    postOrder( sub );
	System.out.println();
    }
    public void preOrder(TreeNode<T> current){
	if (current != null){
	    System.out.println(current.getVal());
	    preOrder(current.getLeft());
	    preOrder(current.getRight());
	}
    }
    public void inOrder(TreeNode<T> current){
	if (current != null){
	    inOrder(current.getLeft());
	    System.out.println(current.getVal());
	    inOrder(current.getRight());
	}
    }
    public void postOrder(TreeNode<T> current){
	if (current != null){
	    postOrder(current.getLeft());
	    postOrder(current.getRight());
	    System.out.println(current.getVal());
	}
    }
    
    public int getHeight(){
	return getHeight(sub);
    }
    public int getHeight(TreeNode<T> current){
	if (current == null){
	    return -1;
	}
	if (getHeight(current.getLeft()) > getHeight(current.getRight())){
	    return (getHeight(current.getLeft()) + 1);
	}else{
	    return (getHeight(current.getRight())+ 1);
	}
	
	
    }
    

    public String getLevel(TreeNode<T> current, int level, int currentLevel){
	if (current == null){
	return "";
	}
	if (level == currentLevel){
	    return "" + current.getVal();
	}
	return getLevel(current.getLeft(), level, currentLevel + 1) + getLevel(current.getRight(), level, currentLevel + 1);
    }

    public String toString(){
	return "";
    }
    public static void main(String[]args){
	BTree<Integer> t = new BTree<Integer>();
	for (int i = 0; i < 8; i++){
	    t.add(i);
	}
	t.traverse(IN_ORDER);
    }
}
		
    
