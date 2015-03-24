public class LNode<T>{
    private LNode<T> next;
    private T data;

    public LNode(LNode<T> a, T b){
	next = a;
	data = b;
    }
    public LNode(T a){
	data = a;
    }
    
    public void setNext(LNode<T> a){
	next = a;
    }
    public LNode<T> getNext(){
	return next;
    }
    public void setData(T a){
	data = a;
    }
    public T getData(){
	return data;
    }
}
