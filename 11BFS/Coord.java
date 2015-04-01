public class Coord{
    int x;
    int y;
    int num;
    Coord prev;
    public Coord(int isx, int isy, int isnum, Coord x){
	x = isx;
	y = isy;
	num = isnum;
	prev = x;
    }
    
    public int getx(){
	return x;
    }
    public int gety(){
	return y;
    }
    public int getnum(){
	return num;
    }
    public Coord getprev(){
	return prev;
    }
}
