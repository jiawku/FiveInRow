package com.FiveInRow.Data;

import java.util.ArrayList;

public class AI {
	public static String alphaBeta(int[][] Array, int depth, int alpha, int beta,int player)
	{	
	    if( depth == 0 || Pattern.CheckWin(Array))
	    {
	         int value = Pattern.GetEval(Array,2);
	         return value+":";
	    }
	    int Best;
	    String[] feedback;
	    int feedbackScore;
	    String returnMove="";
	    if (player==2){
	    	Best=-1000000;
	    	ArrayList<String> ChildNode= Move.GetMove(Array, player);
	    	for (String moveString: ChildNode){
	    		if (Pattern.GetEval(Move.PlayMove(Array, moveString, player),player)>=10000){
	    			feedbackScore=1000000;
	    		} else {
	    		feedback=alphaBeta(Move.PlayMove(Array, moveString, player),depth-1,alpha,beta,1).split(":");
	    		feedbackScore=Integer.parseInt(feedback[0]);
	    		}
	    		if (feedbackScore>Best){
	    			Best=feedbackScore;
	    			returnMove=moveString;
	    		}
	    		if (Best>alpha){
	    			alpha=Best;
	    		}
				if (beta<=alpha){
	    			break;
	    		}
	    	}
	    	return Best+":"+returnMove;
	    } else {
	    	Best=1000000;
	    	ArrayList<String> ChildNode= Move.GetMove(Array, player);
	    	for (String moveString: ChildNode){
	    		if (Pattern.GetEval(Move.PlayMove(Array, moveString, player),player)>=10000){
	    			feedbackScore=1000000;
	    		} else {
	    		feedback=alphaBeta(Move.PlayMove(Array, moveString, player),depth-1,alpha,beta,2).split(":");
	    		feedbackScore=Integer.parseInt(feedback[0]);
	    		}
	    		if (feedbackScore<Best){
	    			Best=feedbackScore;
	    			returnMove=moveString;
	    		}
	    		if (Best<beta){
	    			beta=Best;
	    		}
				if (beta<=alpha){
	    			break;
	    		}
	    	}
	    	return Best+":"+returnMove;
	    }
	}
}
