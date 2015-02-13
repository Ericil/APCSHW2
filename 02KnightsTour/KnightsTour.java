import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    public String name(){
	return "li.mingrui";
    }
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	for(int a = 0; a < board.length; a++){
	    for (int b = 0; b < board[0].length; b++){
		ans = ans + board[a][b] + "\t";
	    }
	    ans = ans + "\n";
	}
	//build your knights tour here...
	return clear + hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
	for (int a = 0; a < board.length; a++){
	    for (int b = 0; b < board[0].length; b++){
		board[a][b] = 0;
	    }
	}
	
				
    }

    
    public boolean solve(){
	return solve(0, 0);
    }

    public boolean solve(int startx, int starty){
	return solve(startx, starty, 1);
    }
    public boolean solve(int x,int y,int currentMoveNumber){
	/*
	System.out.println(this);
	wait(20);
	*/
	if (x >= 0 && x < board.length && y >= 0 && y < board.length){
	    if (board[x][y] == 0){
		board[x][y] = currentMoveNumber;
		if (currentMoveNumber == board.length * board.length ||
		    solve(x+1, y+2, currentMoveNumber+1) || solve(x+1, y-2, currentMoveNumber+1) ||
		    solve(x-1, y+2, currentMoveNumber+1) || solve(x-1, y-2, currentMoveNumber+1) ||
		    solve(x+2, y+1, currentMoveNumber+1) || solve(x+2, y-1, currentMoveNumber+1) ||
		    solve(x-2, y+1, currentMoveNumber+1) || solve(x-2, y-1, currentMoveNumber+1)){
		    return true;
		}else{
		    board[x][y] = 0;
		}
	    }
	}
	return false;
    }
}
