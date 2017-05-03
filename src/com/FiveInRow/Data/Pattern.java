package com.FiveInRow.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class Pattern {
	private static final Map<String, Integer> Knowpattern;
	static{  
		Map<String, Integer> aMap= new HashMap<String, Integer>();
		aMap.put("11111", 100000);  
		aMap.put("011110", 10000);
		aMap.put("011112",500);
		aMap.put("0101110",500);
		aMap.put("0110110",500);
		aMap.put("001110",200);
		aMap.put("010110",200);
		aMap.put("001112",50);
		aMap.put("010112",50);
		aMap.put("011012",50);
		aMap.put("10011",50);
		aMap.put("10101",50);
		aMap.put("2011102",50);
		aMap.put("00110",10);
		aMap.put("01010",10);
		aMap.put("010010",10);
		aMap.put("000112",5);
		aMap.put("001012",5);
		aMap.put("010012",5);
		aMap.put("10001",5);
		aMap.put("2010102",5);
		aMap.put("2011002",5);
		aMap.put("211112",-5);
		aMap.put("21112",-5);
		aMap.put("2112",-5);
		Knowpattern=Collections.unmodifiableMap(aMap);
	 };  
	
	public static int[][] position = {
			 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			 { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			 { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0 },
			 { 0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 0 },
			 { 0, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1, 0 },
			 { 0, 1, 2, 3, 4, 5, 5, 5, 5, 5, 4, 3, 2, 1, 0 },
			 { 0, 1, 2, 3, 4, 5, 6, 6, 6, 5, 4, 3, 2, 1, 0 },
			 { 0, 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1, 0 },
			 { 0, 1, 2, 3, 4, 5, 6, 6, 6, 5, 4, 3, 2, 1, 0 },
			 { 0, 1, 2, 3, 4, 5, 5, 5, 5, 5, 4, 3, 2, 1, 0 },
			 { 0, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1, 0 },
			 { 0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 0 },
			 { 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0 },
			 { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			 { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	 
	public static int GetEval(int[][] Array, int player) {  
		ArrayList<Integer> out= new ArrayList<Integer>();
		ArrayList<String> InputString = new ArrayList<String>();
		int max=10;
		String h,v;
		
		for(int i=0;i<=14;i++){
			if (player==1){
				h=GetHorizon(Array,i);
				v=GetVertical(Array,i);
			} else{
				h=GetCounterSight(GetHorizon(Array,i));
				v=GetCounterSight(GetVertical(Array,i));
			}
			InputString.add(h);
			InputString.add(v);			
		}
		
		ArrayList<String> Left = GetLeftSling(Array);
		for(String i:Left){
			if (player!=1){
				i=GetCounterSight(i);
			}
			InputString.add(i);
			
		}
		ArrayList<String> Right = GetRightSling(Array);
		for(String i:Right){
			if (player!=1){
				i=GetCounterSight(i);
			}
			InputString.add(i);
		}
		for(String i:InputString){
			
		out.add(PatternScan(i));
		}
		
		for(int i : out){
			if (i>max){
				max=i;
			}
		}
		return max;
	}  
	
	public static String GetHorizon(int[][] Array,int y){
		String output ="";
		int start=0;
		int end=14;
		for (int i=start;i<=end;i++){
			output=output+Array[i][y];
		}
		return output;
	}
	
	public static String GetVertical(int[][] Array, int x){
		String output ="";
		int start=0;
		int end=14;
		for (int i=start;i<=end;i++){
			output=output+Array[x][i];
		}
		return output;
	}
	
	public static ArrayList<String> GetLeftSling(int[][] Array){
		ArrayList<String> outputList= new ArrayList<String>();
	    for( int k = 0 ; k < Array.length * 2 ; k++ ) {
	    	String output ="";
	        for( int j = 0 ; j <= k ; j++ ) {
	            int i = k - j;
	            if( i < Array.length && j < Array.length ) {
	                output=output+Array[i][j];
	            }
	        }
	        outputList.add(output);
	    }
		return outputList;
	}
	
	public static ArrayList<String> GetRightSling(int[][] Array){
		ArrayList<String> outputList= new ArrayList<String>();
	    for( int k = Array.length-1 ; k >= -(Array.length-1) ; k=k-1 ) {
	    	String output ="";
	        for( int j = 0 ; j <= (Array.length-1)-k ; j++ ) {
	            int i = k + j;
	            if( i >=0 && i < Array.length && j < Array.length ) {
	            	
	                output=output+Array[j][i];
	            }
	        }
	        outputList.add(output);
	    }
		return outputList;
	}

	public static String ReverseString(String input){
		return new StringBuilder(input).reverse().toString();
	}
	
	public static String GetCounterSight(String input){
		String temp;
		temp=input.replace("1", "3");
		temp=temp.replace("2", "1");
		temp=temp.replace("3", "2");
		return temp;
	}
	
	public static int PatternScan(String input){
	    int max=-10;
		for (String pattern : Knowpattern.keySet()) { 
			  if (java.util.regex.Pattern.matches(".*"+pattern+".*", input)){
				 if (max <Knowpattern.get(pattern)){
	    	    	 max=Knowpattern.get(pattern);
	    	     };
			  }  
		}  
		return max;
	}
	
	public static boolean CheckWin(int[][] Array){
		return GetEval(Array, 1) >=100000 || GetEval(Array, 2) >=100000;
	}
}
