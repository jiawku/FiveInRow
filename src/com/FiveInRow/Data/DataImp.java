package com.FiveInRow.Data;

import java.util.ArrayList;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class DataImp implements DataInterface {


    private final int rowSum;

    private final int colSum;

    public final int[][] data;

    private DataListener dataListener;
    
    private GameState gameState = GameState.game;
    
    public Boolean turn;

    public DataImp(int rowSum, int colSum,DataListener dataListener) {
       	turn=true;
        this.rowSum = rowSum;
        this.colSum = colSum;
        this.dataListener=dataListener;
        data = new int[this.rowSum][this.colSum];
    }

    public Boolean NextTurn() {
    	turn= !turn;
    	return turn;
    }
    
    @Override
    public void dataInit() {
        for (int row = 0; row < rowSum; row++) {
            for (int col = 0; col < colSum; col++) {
                data[row][col] = 0;
            }
        }
        gameState = GameState.game;
    }

    @Override
    public int[][] getData() {
        return data;
    }
    
    @Override
    public void AddPiece(int row,int col,boolean player){
    	if(player){
    		data[row][col]=1;
    	} else {
    		data[row][col]=2;
    	}
    }
    
    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public boolean isBlank(int row, int col) {
    	try{
    		return data[row][col] == 0?true:false;
    	} catch(IndexOutOfBoundsException e) {
    		return false;
    	}
    }

    public void Computer_play(){
    	/*ArrayList<String> movelist=Move.GetMove(data.clone(), 2);
    	String move=movelist.get(0);
    	String[] moves = move.split(",");*/
    	String[] feedback=AI.alphaBeta(data, 3, -1000000, +1000000, 2).split(":");
    	String[] moves = feedback[1].split(",");
    	int pick_row=Integer.valueOf(moves[0]);
    	int pick_col=Integer.valueOf(moves[1]);
/*    	Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("model_play",pick_row+","+pick_col);*/
    	if (isBlank(pick_row,pick_col)){
    		AddPiece(pick_row,pick_col,turn);
    		if (dataListener != null) {
        		dataListener.PlacePiece(pick_row, pick_col, 2);
    		}
	    	NextTurn();
    	} 	
    }
    
	@Override
	public int getPatern() {
		// TODO Auto-generated method stub
		return 0;
	}

}
