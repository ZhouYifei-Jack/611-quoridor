package ttt;

public class Quoridorboard extends board{
    public void set_q_board(int N,int M){
        this.SetBoardSize(2*N-1,2*M-1);

    }
    public void print_quoridor_board(){

    }
    public String toString(){
        String all_t_board="";
        int i=1;
        //int j=1;
        String l_b="\u001B[31m"+"["+"\u001B[0m";
        String r_b="\u001B[31m"+"]"+"\u001B[0m";



        for (int row=0;row<this.N;row++){

            for(int col=0;col<this.M;col++){

                if((row%2==1)|(col%2==1)){
                    //char character=(char)(j+64);
                    if(i<=9){
                        all_t_board=all_t_board+"("+this.cell[row][col].getPtest() +")"+i+"  ";
                    }else if (i<=99){
                        all_t_board=all_t_board+"("+this.cell[row][col].getPtest() +")"+i+" ";
                    }else{
                        all_t_board=all_t_board+"("+this.cell[row][col].getPtest() +")"+i;
                    }
                    //j++;
                }else {
                    if(i<=9){
                        all_t_board=all_t_board+l_b+this.cell[row][col].getPtest() +r_b+"   ";
                    }else if (i<=99){
                        all_t_board=all_t_board+l_b+this.cell[row][col].getPtest() +r_b+"   ";
                    }else{
                        all_t_board=all_t_board+l_b+this.cell[row][col].getPtest() +r_b+"   ";
                    }


                }
                i++;

            }
            all_t_board=all_t_board+"\n";
        }
        return all_t_board;
    }


    public void set_block(){}

}
