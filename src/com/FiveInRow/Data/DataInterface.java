package com.FiveInRow.Data;

public interface DataInterface {

	public void dataInit();

	public int[][] getData();


    public int getPatern();

    /**
     * �жϵ�ǰ�Ƿ�����Ϸʤ�������أ�״̬
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
     * ����ģ�͹�����
     */
    public static class Builder {
        /**
         * ����һ��ָ���������ݵ�����ģ��
         */
        public static DataImp createDataModel(int rowSum, int colSum,DataInterface.DataListener dataListener) {
            return new DataImp(rowSum, colSum, dataListener);
        }
    }



}
