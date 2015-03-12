public class LNode{
    private LNode next;
    private int data;

    public LNode(LNode a, int b){
	next = a;
	data = b;
    }
    
    public void setnext(LNode a){
	next = a;
    }
    public LNode getnext(){
	return next;
    }
    public void setdata(int a){
	data = a;
    }
    public int getdata(){
	return data;
    }
}
