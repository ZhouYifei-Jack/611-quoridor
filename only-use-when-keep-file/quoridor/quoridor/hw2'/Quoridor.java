package ttt;

public class Quoridor extends Generalboardgame{
    private Quoridorboard q_board;
    private int total_N;
    private int total_M;


    public void Init(Player player1,Player player2){
        this.player1=player1;
        this.player2=player2;

        System.out.println("set N,please enter a number(from 3 to 10):");
        this.N=this.CheckSetUp(3,10);
        System.out.println("set M,please enter a number(from 3 to 10):");
        this.M=this.CheckSetUp(3,10);
        this.total_N=2*this.N-1;
        this.total_M=2*this.M-1;



        q_board=new Quoridorboard();
        q_board.set_q_board(this.N,this.M);

        this.StartPlay();
    }
    public void StartPlay(){
        System.out.println("Start play!!");
        q_board.set_p(this.total_N-1,2*((int)Math.ceil(this.M/2)),this.player1.get_piece());
        q_board.set_p(0,(this.total_M-1)-2*((int)Math.ceil(this.M/2)),this.player2.get_piece());
        System.out.println(q_board);
        player1.setPlayer_now_row(this.total_N-1);
        player1.setPlayer_now_col(2*((int)Math.ceil(this.M/2)));
        player2.setPlayer_now_row(0);
        player2.setPlayer_now_col((this.total_M-1)-2*((int)Math.ceil(this.M/2)));


        this.player_now=this.player1;



        System.out.println();
        while(!this.finish){
            System.out.println("hi,"+this.player_now.get_name()+
                    "("+this.player_now.get_piece().getPiece_Ptest()+")"+" enter:" +
                    "\n1 for moving" +
                    "\n2 for putting block");
            int c_a=this.CheckSetUp(1,2);
            if(c_a==2){//put block

                boolean set_p=false;
                int c_p=-1;
                while (!set_p){
                    System.out.println("enter a point");
                    c_p=this.CheckSetUp(1,this.total_M*this.total_N);
                    if(c_p%2==0){
                        set_p=true;
                    }else {
                        System.out.println("invalid");
                    }
                }
                boolean set_another_p=false;
                int c_another_p=-1;
                while (!set_another_p){
                    System.out.println("one point of block is set at "+c_p+" , enter another point");
                    c_another_p=this.CheckSetUp(1,this.total_M*this.total_N);
                    if((c_another_p%2==0)&(Math.abs(  ((c_p - 1) / this.total_M)-((c_another_p - 1) / this.total_M)   )==2)){
                        set_another_p=true;
                    }else if((c_another_p%2==0)&(Math.abs(  ((c_p - 1) % this.total_M)-((c_another_p - 1) % this.total_M)   )==2)){

                        set_another_p=true;
                    }else {
                        System.out.println("invalid");
                    }
                }


                Block b=new Block();
                b.setBlock("|");
                q_board.set_p((c_p - 1) / this.total_M,(c_p - 1) % this.total_M,b);
                System.out.println(q_board);
                Pieces p=new Pieces();
                p.setPtest("|");
                q_board.set_p(((c_another_p - 1) / this.total_M) ,((c_another_p - 1) % this.total_M),p);
                System.out.println(q_board);

            }else {//moving
                boolean is_move=false;
                while (!is_move){
                    System.out.println("hi,"+this.player_now.get_name()+
                            "("+this.player_now.get_piece().getPiece_Ptest()+")"+" enter:" +
                            "\n1 for up" +
                            "\n2 for down" +
                            "\n3 for left" +
                            "\n4 for right");
                    int c_m=this.CheckSetUp(1,4);

                    //if(check_whether_jump)
                    //else..

                    if(this.check_direction(c_m,player_now.getPlayer_now_row(),player_now.getPlayer_now_col())){
                        move(c_m,player_now.getPlayer_now_row(),player_now.getPlayer_now_col());
                        System.out.println(q_board);
                        is_move=true;
                    }else {
                        System.out.println("can not move to that direction,choose,again");
                    }
                }


            }




            //this.CheckWin(row, col,this.player_now.get_piece());
            if(this.finish) {
                System.out.println("player "+this.player_now.get_name()+" win");
                this.player_now.add_win();
                this.player_now.get_win();
                System.out.println(" ");
                System.out.println(" ");
            }else{
                this.player_now=(this.player_now==this.player1)?this.player2:this.player1;
            }





        }






    }

    public boolean check_direction(int i,int now_i,int now_j){
        if (i == 1) {//up
            if (now_i - 2 >= 0){
                return this.q_board.position_info(now_i-1,now_j).equals(" ")
                        &this.q_board.position_info(now_i-2,now_j).equals(" ");
            }else {
                return false;
            }

        } else if (i == 2) {//down
            if (now_i + 2 <= this.total_N - 1){
                return this.q_board.position_info(now_i+1,now_j).equals(" ")
                        &this.q_board.position_info(now_i+2,now_j).equals(" ");
            }else {
                return false;
            }

        } else if (i == 3) {//left
            if (now_j - 2 >= 0){
                return this.q_board.position_info(now_i,now_j-2).equals(" ")
                        &this.q_board.position_info(now_i,now_j-2).equals(" ");
            }else {
                return false;
            }

        } else if (i == 4) {//right
            if (now_j + 2 <= this.total_M - 1){
                return this.q_board.position_info(now_i,now_j+1).equals(" ")
                        &this.q_board.position_info(now_i,now_j+2).equals(" ");
            }else {
                return false;
            }
        }
        return false;
    }


    public void move(int i,int now_i,int now_j){
        if(i==1){//up
            q_board.clear_p(now_i,now_j);
            q_board.set_p(now_i-2,now_j,this.player_now.get_piece());
            this.player_now.setPlayer_now_row(now_i-2);

        }else if(i==2){//down
            q_board.clear_p(now_i,now_j);
            q_board.set_p(now_i+2,now_j,this.player_now.get_piece());
            this.player_now.setPlayer_now_row(now_i+2);


        }else if(i==3){//left
            q_board.clear_p(now_i,now_j);
            q_board.set_p(now_i,now_j-2,this.player_now.get_piece());
            this.player_now.setPlayer_now_col(now_j-2);


        }else if(i==4){//right
            q_board.clear_p(now_i,now_j);
            q_board.set_p(now_i,now_j+2,this.player_now.get_piece());
            this.player_now.setPlayer_now_col(now_j+2);


        }
    }


    public void jump(){}
}
