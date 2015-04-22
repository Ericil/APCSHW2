public class TreeNode<T>{
    TreeNode<T> left;
    TreeNode<T> right;
    T value;

    public TreeNode(TreeNode<T> a, TreeNode<T> b, T c){
	left = a;
	right = b;
    }

    public void setLeft(TreeNode<T> a){
	left = a;
    }
    public void setRight(TreeNode<T> a){
	right = a;
    }
    public void setVal(T a){
	value = a;
    }

    public TreeNode<T> getLeft(){
	return left;
    }
    public TreeNode<T> getRight(){
	return right;
    }
    public T getVal(){
	return value;
    }
}
