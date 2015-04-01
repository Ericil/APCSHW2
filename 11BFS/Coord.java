public class Coord{
    int x;
    int y;
    int num;
    int xbefore;
    int ybefore;
    public Coord(int isx, int isy, int isnum, int isxbef, int isybef){
	x = isx;
	y = isy;
	num = isnum;
	xbefore = isxbef;
	ybefore = isybef;
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
    public int getxbef(){
	return xbefore;
    }
    public int getybef(){
	return ybefore;
    }
}
