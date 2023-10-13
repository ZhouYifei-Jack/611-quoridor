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


        System.out.println("how many block every players can use?(from 3 to 10)");
        int s_b=this.CheckSetUp(3,10);
        this.player1.setNumber_of_blocks(s_b);
        this.player2.setNumber_of_blocks(s_b);
        this.StartPlay();
    }

    public void StartPlay(){
        System.out.println("Start play!!");
        q_board.set_p(this.total_N-1,2*((int)Math.ceil(this.M/2)),this.player1.get_piece());
        q_board.set_p(0,(this.total_M-1)-2*((int)Math.ceil(this.M/2)),this.player2.get_piece());
        player1.setFinish_position_for_player(0);
        player2.setFinish_position_for_player(this.total_N-1);

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
                    "\n2 for putting block(you have "+this.player_now.getNumber_of_blocks()+" blocks left)");
            int c_a=this.CheckSetUp(1,2);




            if(c_a==2&this.player_now.getNumber_of_blocks()>0){//put block
                int left_b=this.player_now.getNumber_of_blocks();
                this.player_now.setNumber_of_blocks(left_b-1);

                boolean set_p=false;
                int c_p=-1;
                int c_p_i=-1;
                int c_p_j=-1;
                while (!set_p){
                    System.out.println("enter a point");
                    c_p=this.CheckSetUp(1,this.total_M*this.total_N);
                    if(c_p%2==0){
                        if(this.q_board.check_full(((c_p - 1) / this.total_M),((c_p - 1) % this.total_M))){
                            set_p=true;
                            c_p_i=((c_p - 1) / this.total_M);
                            c_p_j=((c_p - 1) % this.total_M);

                            ////////a point is set find another point
                            boolean set_another_p=false;
                            int c_another_p=-1;
                            while (!set_another_p){
                                System.out.println("one point of block is set at "+c_p+" , enter another point(" +
                                        "enter 0 to back to set first point)");
                                c_another_p=this.CheckSetUp(0,this.total_M*this.total_N);

                                if (c_p_i%2==0){//shu zhe de//abs of rows =2
                                    if((c_another_p%2==0)
                                            &(Math.abs(  ((c_p - 1) / this.total_M)-((c_another_p - 1) / this.total_M)   )==2
                                            & Math.abs(  ((c_p - 1) % this.total_M)-((c_another_p - 1) % this.total_M)   )==0)){

                                        //check no cell is fulled not for block
                                        if(this.q_board.check_full(((c_p - 1) / this.total_M),((c_p - 1) % this.total_M))
                                                &this.q_board.check_full(((c_another_p - 1) / this.total_M),((c_another_p - 1) % this.total_M))
                                                &this.q_board.check_full(((c_p - 1) / this.total_M+((c_another_p - 1) / this.total_M))/2,((c_p - 1) % this.total_M))){


                                            set_another_p=true;
                                            Block b=new Block();
                                            b.setBlock("|");
                                            q_board.set_p((c_p - 1) / this.total_M,(c_p - 1) % this.total_M,b);
                                            q_board.set_p(((c_p - 1) / this.total_M+((c_another_p - 1) / this.total_M))/2,(c_p - 1) % this.total_M,b);
                                            q_board.set_p(((c_another_p - 1) / this.total_M) ,((c_another_p - 1) % this.total_M),b);
                                            System.out.println(q_board);
                                        }




                                    }else if (c_another_p==0){

                                        set_another_p=true;
                                        set_p=false;//back to find point 1
                                    }else {
                                        System.out.println("invalid,don't across cell");
                                    }

                                }else{//heng zhe de
                                    if((c_another_p%2==0)
                                            &(Math.abs(  ((c_p - 1) % this.total_M)-((c_another_p - 1) % this.total_M)   )==2)
                                            & Math.abs(  ((c_p - 1) / this.total_M)-((c_another_p - 1) / this.total_M)   )==0){



                                        if(this.q_board.check_full(((c_p - 1) / this.total_M),((c_p - 1) % this.total_M))
                                                &this.q_board.check_full(((c_another_p - 1) / this.total_M),((c_another_p - 1) % this.total_M))
                                                &this.q_board.check_full((c_p - 1) / this.total_M,((c_p - 1) % this.total_M+((c_another_p - 1) % this.total_M))/2)){




                                            set_another_p=true;
                                            Block b=new Block();
                                            b.setBlock("-");
                                            q_board.set_p((c_p - 1) / this.total_M,(c_p - 1) % this.total_M,b);
                                            q_board.set_p((c_p - 1) / this.total_M,((c_p - 1) % this.total_M+((c_another_p - 1) % this.total_M))/2,b);
                                            q_board.set_p(((c_another_p - 1) / this.total_M) ,((c_another_p - 1) % this.total_M),b);
                                            System.out.println(q_board);
                                        }





                                    }else if (c_another_p==0){
                                        set_another_p=true;
                                        set_p=false;//back to find point 1
                                    }else {
                                        System.out.println("invalid,don't across cell");
                                    }

                                }




                            }
                            ////////



                        }//if point1 is filled ,loop to find another point

                    }else {
                        System.out.println("invalid");
                    }
                }





            }else {//moving
                if (this.player_now.getNumber_of_blocks()==0){
                    System.out.println("you can only to move( because no blocks left )");
                }

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






            this.finish=this.check_win(player_now);
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
        System.out.println("Do you want to play again?");






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
                return this.q_board.position_info(now_i,now_j-1).equals(" ")
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

    public boolean check_win(Player player){
        return player.getFinish_position_for_player()==player.getPlayer_now_row();

    }

    public void jump(){}
}
