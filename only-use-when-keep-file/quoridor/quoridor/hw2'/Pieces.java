package ttt;
/*
 * usage of this class:
 * create pieces
 * keep information such as color
 *
 *
 *
 * */
import java.util.Scanner;

public class Pieces {


    private String Ptest;
    private String p_without_c;
    private int c_c=-1;
    private String reset = "\u001B[0m";
    private boolean is_v;

    public String getPiece_Ptest(){
        return this.Ptest;
    }
    public String get_o_p(){return this.p_without_c;}
    public void setPtest(String ptest) {
        Ptest = ptest;
    }
    public void createPtest() {
        System.out.print("enter a symbol as a piece(pieces should be a symbol,enter a char):  ");
        this.is_v=false;
        while (!this.is_v){
            Scanner sc = new Scanner(System.in);
            String p = sc.next();

            if (p.length() == 1) {
                this.Ptest = p;
                this.p_without_c= p;
                this.is_v=true;
            } else {
                System.out.print("invalid,enter again:  ");
                this.is_v=false;
                //Ptest = ptest;
            }

        }

    }
    public void set_color(int c_c){
        this.c_c=c_c;
        if (c_c==0){
            this.Ptest="\u001B[31m"+this.Ptest+this.reset;
        }else if(c_c==1){
            this.Ptest="\u001B[33m"+this.Ptest+this.reset;
        }else if (c_c==2){
            this.Ptest="\u001B[34m"+this.Ptest+this.reset;
        }

    }
}
