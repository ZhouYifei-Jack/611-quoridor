package ttt;
/*
 * usage of this class:
 * provide Board for every game
 * achieve function for every Board,such as
 * set and print
 * check full
 * return information of Cell
 * */

public class Board {
    protected Cell[][] cell;
    //private int BoardLength;
    protected int N;
    protected int M;

    public void SetBoardSize(int N,int M) {
        this.N=N;
        this.M=M;
        this.cell=new Cell[N][M];

        for (int row =0;row<this.N;row++) {
            for (int col =0;col<this.M;col++) {
                Pieces a=new Pieces();
                a.setPtest(" ");
                Cell c=new Cell(N,M);
                c.setPtest(a);
                this.cell[row][col]=c;
            }
        }
    }
    public void print_with_location(){
        int i=1;
        for (int row =0;row<this.N;row++) {
            for (int col =0;col<this.M;col++) {
                System.out.print("["+this.cell[row][col].getPtest()+"]"+i);
                i++;
            }
            System.out.println();
        }
    }
    public void set_p(int row, int col, Pieces Pieces){
        this.cell[row][col].setPtest(Pieces);
    }
    public void clear_p(int row, int col){
        Pieces p=new Pieces();
        p.setPtest(" ");
        this.cell[row][col].setPtest(p);
    }
    public boolean check_full(int row,int col){
        if(row<this.N&&col<this.M&&row>=0&&col>=0) {
            if(this.cell[row][col].getPtest().equals(" ")) {
                return true;
            }else {
                System.out.println("this Cell is filled,pleas enter again");
                return false;
            }
        }else {

            System.out.println("this location is out of bound,pleas enter again");
            return false;
        }
    }
    public String position_info(int row,int col){
        return cell[row][col].getPtest();
    }

    public int getN(){
        return N;
    }

    public int getM(){
        return M;
    }
}
