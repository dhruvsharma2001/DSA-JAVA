public class sdko {
    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        //column
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        //row
        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }
        //grid
        int Sr=(row/3)*3;
        int Sc=(col/3)*3;
        //3*3
        for(int i=Sr;i<Sr+3;i++){
            for(int j=Sc;j<Sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean solver(int sudoku[][],int row,int col){
        //base case
        if(row==9 && col==0){
            return true;
        }
        
        //recursion
        int nextrow=row ,nextcol=col+1;
        if(col+1==9){
            nextrow=row+1;
            nextcol=0;
        }
        if(sudoku[row][col]!=0){
            return solver(sudoku,nextrow,nextcol);

        }
        for(int digit=1;digit<=9;digit++){
            if (isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(solver(sudoku,nextrow,nextcol)){//soln
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }
    public static void printsudoku(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j] +" ");

            }
            System.out.println();


        }
    }

    public static void main(String args[]){
        int sudoku[][]={ {0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3} };

        if(solver(sudoku,0,0)){
            System.out.println("solution exists");
            printsudoku(sudoku);
        }
        else{
            System.out.println("solution don't exists");

        }
}
}
