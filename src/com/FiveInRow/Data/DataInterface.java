package com.FiveInRow.Data;

public interface DataInterface {

	public void dataInit();

	public int[][] getData();


    public int getPatern();

    /**
     * 判断当前是否处于游戏胜利（过关）状态
     */
    public GameState getGameState();
    
    public void  AddPiece(int row, int col,boolean player);

    public static enum GameState {

        game,

        win,

    }
    
    public boolean isBlank(int row, int col);

    public static interface DataListener {

        public void PlacePiece(int row, int col, int player);
        
    }
    /**
     * 数据模型构建器
     */
    public static class Builder {
        /**
         * 创建一个指定行列数据的数据模型
         */
        public static DataImp createDataModel(int rowSum, int colSum,DataInterface.DataListener dataListener) {
            return new DataImp(rowSum, colSum, dataListener);
        }
    }



}
