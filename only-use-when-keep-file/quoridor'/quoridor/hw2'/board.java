package ttt;
/*
 * usage of this class:
 * provide board for every game
 * achieve function for every board,such as
 * set and print
 * check full
 * return information of cell
 * ...
 *
 * */

public class board {
    protected ttt.cell[][] cell;
    //private int BoardLength;
    protected int N;
    protected int M;


    public void SetBoardSize(int N,int M) {
        this.N=N;
        this.M=M;
        this.cell=new cell[N][M];
        //int test=1;

        for (int row =0;row<this.N;row++) {
            for (int col =0;col<this.M;col++) {
                Pieces a=new Pieces();
                a.setPtest(" ");
                //a.setPtest(""+test);
                //test++;
                ttt.cell c=new cell();
                c.setPtest(a);
                //System.out.println("this ok");
                this.cell[row][col]=c;
                //System.out.println("this ok?");//--------no
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
        //System.out.println(row);
        //System.out.println(col);
        if(row<this.N&&col<this.M&&row>=0&&col>=0) {
           // System.out.println("here");
            //System.out.println(this.BoardLength);

            if(this.cell[row][col].getPtest().equals(" ")) {
                return true;

            }else {
                System.out.println("this cell is filled,pleas enter again");
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

    public int Get_N(){
        return this.N;
    }
    public int Get_M(){
        return this.M;
    }





}
