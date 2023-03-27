public class Nqueen {
    public static boolean isSafe(char board[][],int row,int col){
        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diag left up
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diag right up
        for(int i=row-1, j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;

    }
    public static void printboard(char board[][]){
        System.out.println("----------CHESS----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();

        }

    }

    public static void nqueens(char board[][],int row){
        //base
        if(row==board.length){
            printboard(board);
            return;
        }
        
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
            nqueens(board,row+1);
            board[row][j]='X';//backtrack
        }
            
}
    }
    public static void main(String args[]){
        
        int n=8;
        char board[][]=new char[n][n];
        //initialize
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        nqueens(board,0);
    }
}
