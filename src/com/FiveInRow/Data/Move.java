package com.FiveInRow.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
public class Move {

	
	/*public static ArrayList<String> GetRange(int[][] Array){
		ArrayList<String> output = null;
		int startX=0,startY=0,endX=14,endY=14;
		for (int i=0;i<=14;i++){
			for (int j=0;j<=14;j++){
				if (Array[i][j]==0){
					startX=startX>i?i:startX;
					startY=startY>j?j:startY;
				}
			}
		}
		
		return output;		
	}*/
	
	public static ArrayList<String> GetMove(int[][] Array,int player){
		ArrayList<String> output = new ArrayList<String>();
		Map<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
		int temp_score;
		for (int i=0;i<=14;i++){
			for (int j=0;j<=14;j++){
				if (Array[i][j]==0){
					
					int [][] temp = new int[15][15];
					for(int n = 0; n < 15; n++){
					    temp[n] = Array[n].clone();
					}
					
					temp[i][j]=player;					
					temp_score=Pattern.GetEval(temp,player)+Pattern.position[i][j];
					temp[i][j]=CounterPlayer(player);
					temp_score=temp_score+Pattern.GetEval(temp,CounterPlayer(player));
   	    	
					map.put(temp_score,i+","+j);					
				}
			}
		}

	   Set<Integer> keys = map.keySet();
	   Iterator<Integer> k = keys.iterator();
	   for (int i=0;i<=5 && k.hasNext();i++){
		   Integer key = (Integer) k.next();
		   String value = (String) map.get(key);

/*		   Gdx.app.setLogLevel(Application.LOG_DEBUG);
		   Gdx.app.log("model_play_addmove",key+":"+value);*/
		   
		   output.add(value);
	   }
	   
	   
		return output;		
	}
	
	public static int CounterPlayer(int player){
		return player==1?2:1;
	}

	public static int[][] PlayMove(int[][] Array,String move,int player){
		int [][] temp = new int[15][15];
		for(int n = 0; n < 15; n++){
		    temp[n] = Array[n].clone();
		}
		String[] moves = move.split(",");
    	int pick_row=Integer.valueOf(moves[0]);
    	int pick_col=Integer.valueOf(moves[1]);
    	temp[pick_row][pick_col]=player;
    	return temp;
	}
	
}
