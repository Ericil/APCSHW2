public class LNode{
    private LNode next;
    private int data;

    public LNode(LNode a, int b){
	next = a;
	data = b;
    }
    
    public void setNext(LNode a){
	next = a;
    }
    public LNode getNext(){
	return next;
    }
    public void setData(int a){
	data = a;
    }
    public int getData(){
	return data;
    }
}
