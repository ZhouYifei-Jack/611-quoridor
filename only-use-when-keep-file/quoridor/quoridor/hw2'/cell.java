package ttt;
/*
 * usage of this class:
 * storage pieces
 *
 *
 *
 * */
public class cell {
    private Pieces Pieces =new Pieces();


    public String toString(){
        return this.Pieces.getPiece_Ptest();

    };
    public String getPtest() {
        return Pieces.getPiece_Ptest();
    }
    public void setPtest(Pieces Pieces) {
        this.Pieces = Pieces;
    }

}
