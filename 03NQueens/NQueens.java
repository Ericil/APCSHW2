import java.util.*;
import java.io.*;

public class NQueens{
    
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    private boolean returning = false;
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

    public NQueens(int size){
	board = new int[size][size];
	for (int a = 0; a < board.length; a++){
	    for (int b = 0; b < board[0].length; b++){
		board[a][b] = 0;
	    }
	}
    }

    public boolean solve(){
	return solve(0);
    }
    public boolean solve(int startx){
	return solve(startx, 0, 1);
    }
    public void eliminatingareas(int x, int y){
	
	for(int a = 0; a < board.length; a++){
	    if (board[x][a] == 0){
		board[x][a] = -1;
	    }
	    if (board[a][y] == 0){
		board[a][y] = -1;
	    }
	}
	
	boolean trigger = false;
	for(int a = 1; a < board.length && trigger == false; a++){
	    if (x - a >= 0 && y - a >= 0){
		if (board[x - a][y - a] == 0){
		    board[x - a][y - a] = -1;
		}
	    }else{
		trigger = true;
	    }
	}
	trigger = false;
	for (int a = 0; a < board.length && trigger == false; a++){
	    if (x - a >= 0 && y + a < board.length){
		if(board[x - a][y + a] == 0){
		   board[x - a][y + a] = -1;
		}
	    }else{
		trigger = true;
	    }
	}
	trigger = false;
	for (int a = 0; a < board.length && trigger == false; a++){
	    if (x + a < board.length && y - a >= 0){
		if(board[x + a][y - a] == 0){
		    board[x + a][y - a] = -1;
		}
	    }else{
		trigger = true;
	    }
	}
	trigger = false;
	for (int a = 0; a < board.length && trigger == false; a++){
	    if (x + a < board.length && y + a < board.length){
		if (board[x + a][y + a] == 0){
		    board[x + a][y + a] = -1;
		}
	    }else{
		trigger = true;
	    }
	}
    }
    public boolean solve(int x, int y, int numqueens){
	/*
	System.out.println(this);
	wait(10);
	*/
	if (x >= 0 && x < board.length && y >= 0 && y < board.length){
	    if(board[x][y] == 0){
		if (numqueens == board.length){
		    returning = true;
		}
		board[x][y] = numqueens;
		eliminatingareas(x, y);
		System.out.println(numqueens == board.length);
		
		for(int a = 0; a < board.length; a++){
		    for(int b = 0; b < board[a].length; b++){
			solve(a, b, numqueens+1);
		    }
		}
	    }
	}
	return returning;
    }
    
}
