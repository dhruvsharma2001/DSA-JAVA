public class multiplein {
    public static void main(String args[]){
        Queen q= new Queen();
        q.moves();
        

    }
}

interface Chessplayer{
    void moves();
}
class Queen implements Chessplayer{
   public void moves(){
        System.out.println("up,down,left,right,diagonal");
    }

}

class Rook implements Chessplayer{
    public void moves(){
         System.out.println("up,down,left,right");
     }
 
 }

 class king implements Chessplayer{
    public void moves(){
         System.out.println("up,down,left,right,diagonal(by 1)");
     }
 
 }
 
 
