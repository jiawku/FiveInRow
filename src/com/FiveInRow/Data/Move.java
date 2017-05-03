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
	
	public static int PositionValue(int[][] Array,int x, int y){
		int[][] temp_1=new int[15][15];
		int[][] temp_2=new int[15][15];
		for(int n = 0; n <=14; n++){
		    temp_1[n] = Array[n].clone();
		    temp_2[n] = Array[n].clone();
		}
		temp_1[x][y]=1;
		temp_2[x][y]=2;
		/*Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.log("PositionValue: ",x+","+y+" Player1 "+Pattern.GetEval(temp_1,1)+" Player21 "+Pattern.GetEval(temp_2,2)+" Position "+Pattern.position[x][y]);*/
		return Pattern.GetEval(temp_1,1)+Pattern.GetEval(temp_2, 2)+Pattern.position[x][y]; 
	}
	
	public static ArrayList<String> GetMove(int[][] Array,int player){
		ArrayList<String> output = new ArrayList<String>();
		Map<Integer, String> map = new TreeMap<Integer, String>(Collections.reverseOrder());
		int TopBound=-1,BottomBound=-1,LeftBound=Array.length,RightBound=0;
		
		
		for (int i=0;i<=14;i++){
			for (int j=0;j<=14;j++){
				if(Array[i][j]!=0){
					if(TopBound != -1){TopBound=i;}
					if(LeftBound>j){LeftBound=j;}
					if(RightBound<j){RightBound=j;}
					if(BottomBound<i){BottomBound=i;}
				}
			}
		}
		TopBound=TopBound-4>0?TopBound-4:0;
		LeftBound=LeftBound-4>0?LeftBound-4:0;
		RightBound=RightBound+4<14?RightBound+4:14;
		BottomBound=BottomBound+4<14?BottomBound+4:14;
		
		
		for (int i=TopBound;i<=BottomBound;i++){
			for (int j=LeftBound;j<=RightBound;j++){
				if (Array[i][j]==0){
					
					int [][] temp = new int[15][15];
					for(int n = 0; n < 15; n++){
					    temp[n] = Array[n].clone();
					}
					map.put(PositionValue(temp,i,j),i+","+j);
				}
			}
		}

	   Set<Integer> keys = map.keySet();
	   Iterator<Integer> k = keys.iterator();
	   for (int i=0;i<=5 && k.hasNext();i++){
		   Integer key = (Integer) k.next();
		   String value = (String) map.get(key);
		   
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
