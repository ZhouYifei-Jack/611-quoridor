package ttt;

public class Quoridor extends Generalboardgame {
    private QuoridorBoard q_board;
    private int total_N;
    private int total_M;
    int c_another_p;

    public void Init(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        System.out.println("set N,please enter a number(from 3 to 10):");
        this.N = this.CheckSetUp(3, 10);
        System.out.println("set M,please enter a number(from 3 to 10):");
        this.M = this.CheckSetUp(3, 10);
        this.total_N = 2 * this.N - 1;
        this.total_M = 2 * this.M - 1;


        q_board = new QuoridorBoard();
        q_board.setQuoridorBoard(this.N, this.M);


        System.out.println("how many block every players can use?(from 3 to 10)");
        int total_wall = this.CheckSetUp(3, 10);
        this.player1.setNumber_of_blocks(total_wall);
        this.player2.setNumber_of_blocks(total_wall);
        this.StartPlay();
    }

    public void StartPlay() {
        System.out.println("Start play!!");
        initializePlayers();
        printBoardAndSetFirstPlayer();

        while (!this.finish) {
            int c_a = getPlayerAction();
            if (c_a == 2 & this.current_player.getNumber_of_blocks() > 0) {//put block
                boolean hasPathAfterPlaceWall = handleBlockPlacing();
                if (!hasPathAfterPlaceWall) {

                    continue;
                }
            } else {
                handlePlayerMove();
            }
            checkAndDeclareWinner();
        }
        System.out.println("Do you want to play again?");
    }

    private void checkAndDeclareWinner() {
        this.finish = this.check_win(current_player);
        if (this.finish) {
            System.out.println("Player " + this.current_player.get_name() + " win");
            this.current_player.add_win();
            this.current_player.get_win();
            System.out.println();
        } else {
            this.current_player = (this.current_player == this.player1) ? this.player2 : this.player1;
        }
    }

    private boolean handleBlockPlacing() {
        Player currentPlayer = (current_player == player1) ? player1 : player2;

        int left_b = currentPlayer.getNumber_of_blocks();
        currentPlayer.setNumber_of_blocks(left_b - 1);

        while (true) {
            System.out.println("Enter a point");
            int c_p = CheckSetUp(1, total_M * total_N);

            if (isValidInitialPoint(c_p)) {
                int c_p_i = calCoordinate(c_p, total_M, "i");
                int c_p_j = calCoordinate(c_p, total_M, "j");

                if (setBlockPoints(c_p, c_p_i, c_p_j)) {
                    // Check if there is a path from the current player's position to the bottom-right corner
                    PathFinder pathFinder = new PathFinder();
                    boolean hasPath = pathFinder.hasPath(q_board, player1, player2);

                    if (hasPath) {
                        System.out.println("Path exists!");
                        System.out.println(q_board);
                        return true;
                    } else {
                        System.out.println("Cannot block player, please select move again: ");
                        unsetWall(c_p,c_another_p);
                        currentPlayer.setNumber_of_blocks(left_b);
                        return false;
                    }
                }
            } else {
                System.out.println("Invalid(this point is a intersection of cell,not an edge)");
            }
        }
    }


    private boolean isValidInitialPoint(int c_p) {
        return c_p % 2 == 0 && q_board.check_full(calCoordinate(c_p, total_M, "i"), calCoordinate(c_p, total_M, "j"));
    }

    private boolean setBlockPoints(int c_p, int c_p_i, int c_p_j) {
        while (true) {
            System.out.println("First point of block is set at " + c_p +
                    " , enter second point (enter 0 to back to set new first point)");
            c_another_p = CheckSetUp(0, total_M * total_N);

            if (c_p_i % 2 == 0) {
                if (isWallValid(c_p, c_another_p, c_p_i, c_p_j, "|", "i")) return true;
            } else {
                if (isWallValid(c_p, c_another_p, c_p_i, c_p_j, "-", "j")) return true;
            }

            if (c_another_p == 0) return false;
            else System.out.println("Invalid, wall can't place across Cell");
        }
    }


    private boolean isWallValid(int c_p, int c_another_p, int c_p_i, int c_p_j, String blockType, String coordinateType) {
        int diff_i = Math.abs(calCoordinate(c_p, total_M, "i") - calCoordinate(c_another_p, total_M, "i"));
        int diff_j = Math.abs(calCoordinate(c_p, total_M, "j") - calCoordinate(c_another_p, total_M, "j"));

        boolean isVerticalCondition = "i".equals(coordinateType) ? diff_i == 2 && diff_j == 0 : diff_i == 0 && diff_j == 2;

        if (c_another_p % 2 == 0 && isVerticalCondition && checkCellForWall(c_p, c_another_p, c_p_i, c_p_j, coordinateType)) {
            Block b = new Block();
            b.setBlock(blockType);
            setWallOnBoard(c_p, c_another_p, c_p_i, c_p_j, b);
            return true;
        }
        return false;
    }

    private boolean checkCellForWall(int c_p, int c_another_p, int c_p_i, int c_p_j, String coordinateType) {
        int middle_i = (calCoordinate(c_p, total_M, "i") + calCoordinate(c_another_p, total_M, "i")) / 2;
        int middle_j = (calCoordinate(c_p, total_M, "j") + calCoordinate(c_another_p, total_M, "j")) / 2;

        return q_board.check_full(calCoordinate(c_p, total_M, "i"), calCoordinate(c_p, total_M, "j"))
                && q_board.check_full(calCoordinate(c_another_p, total_M, "i"), calCoordinate(c_another_p, total_M, "j"))
                && q_board.check_full("i".equals(coordinateType) ? middle_i : calCoordinate(c_p, total_M, "i"),
                "j".equals(coordinateType) ? middle_j : calCoordinate(c_p, total_M, "j"));
    }

    private void setWallOnBoard(int c_p, int c_another_p, int c_p_i, int c_p_j, Block b) {
        q_board.set_p(calCoordinate(c_p, total_M, "i"), calCoordinate(c_p, total_M, "j"), b);
        q_board.set_p(calCoordinate(c_another_p, total_M, "i"), calCoordinate(c_another_p, total_M, "j"), b);
        q_board.set_p((calCoordinate(c_p, total_M, "i") + calCoordinate(c_another_p, total_M, "i")) / 2,
                (calCoordinate(c_p, total_M, "j") + calCoordinate(c_another_p, total_M, "j")) / 2, b);
    }

    private void unsetWall(int c_p, int c_another_p){
        q_board.clear_p(calCoordinate(c_p, total_M, "i"), calCoordinate(c_p, total_M, "j"));
        q_board.clear_p(calCoordinate(c_another_p, total_M, "i"), calCoordinate(c_another_p, total_M, "j"));
        q_board.clear_p((calCoordinate(c_p, total_M, "i") + calCoordinate(c_another_p, total_M, "i")) / 2,
                (calCoordinate(c_p, total_M, "j") + calCoordinate(c_another_p, total_M, "j")) / 2);
    }

    // calculate the coordinate
    private int calCoordinate(int c_p, int total_M, String type) {
        return "i".equals(type) ? (c_p - 1) / total_M : (c_p - 1) % total_M;
    }

    private void handlePlayerMove() {
        if (this.current_player.getNumber_of_blocks() == 0) {
            System.out.println("You can only to move (no blocks left)");
        }

        boolean is_move = false;
        while (!is_move) {
            System.out.println("hi," + this.current_player.get_name() +
                    "(" + this.current_player.get_piece().getPiece_Ptest() + ")" + " enter:" +
                    "\n1 for up" +
                    "\n2 for down" +
                    "\n3 for left" +
                    "\n4 for right");
            int c_m = this.CheckSetUp(1, 4);

            //if(check_whether_jump)
            //else..

            if (this.check_direction(c_m, current_player.getPlayer_current_row(), current_player.getPlayer_current_col())) {
                move(c_m, current_player.getPlayer_current_row(), current_player.getPlayer_current_col());
                System.out.println(q_board);
                is_move = true;
            } else {
                System.out.println("Can not move to that direction, please choose,again");
            }
        }
    }

    private void initializePlayers() {
        q_board.set_p(this.total_N - 1, 2 * ((int) Math.ceil(this.M / 2)), this.player1.get_piece());
        q_board.set_p(0, (this.total_M - 1) - 2 * ((int) Math.ceil(this.M / 2)), this.player2.get_piece());
        player1.setFinish_position_for_player(0);
        player2.setFinish_position_for_player(this.total_N - 1);
    }

    private void printBoardAndSetFirstPlayer() {
        System.out.println(q_board);
        player1.setPlayer_current_row(this.total_N - 1);
        player1.setPlayer_current_col(2 * ((int) Math.ceil(this.M / 2)));
        player2.setPlayer_current_row(0);
        player2.setPlayer_current_col((this.total_M - 1) - 2 * ((int) Math.ceil(this.M / 2)));
        this.current_player = this.player1;
    }

    private int getPlayerAction() {
        System.out.println("hi," + this.current_player.get_name() +
                "(" + this.current_player.get_piece().getPiece_Ptest() + ")" + " enter:" +
                "\n1 for moving" +
                "\n2 for putting block(you have " + this.current_player.getNumber_of_blocks() + " blocks left)");
        return this.CheckSetUp(1, 2);
    }

    public boolean check_direction(int i, int now_i, int now_j) {
        if (i == 1) {//up
            if (now_i - 2 >= 0) {
                return this.q_board.position_info(now_i - 1, now_j).equals(" ")
                        & this.q_board.position_info(now_i - 2, now_j).equals(" ");
            } else {
                return false;
            }

        } else if (i == 2) {//down
            if (now_i + 2 <= this.total_N - 1) {
                return this.q_board.position_info(now_i + 1, now_j).equals(" ")
                        & this.q_board.position_info(now_i + 2, now_j).equals(" ");
            } else {
                return false;
            }

        } else if (i == 3) {//left
            if (now_j - 2 >= 0) {
                return this.q_board.position_info(now_i, now_j - 1).equals(" ")
                        & this.q_board.position_info(now_i, now_j - 2).equals(" ");
            } else {
                return false;
            }

        } else if (i == 4) {//right
            if (now_j + 2 <= this.total_M - 1) {
                return this.q_board.position_info(now_i, now_j + 1).equals(" ")
                        & this.q_board.position_info(now_i, now_j + 2).equals(" ");
            } else {
                return false;
            }
        }
        return false;
    }

    public void move(int i, int now_i, int now_j) {
        if (i == 1) {//up
            q_board.clear_p(now_i, now_j);
            q_board.set_p(now_i - 2, now_j, this.current_player.get_piece());
            this.current_player.setPlayer_current_row(now_i - 2);
        } else if (i == 2) {//down
            q_board.clear_p(now_i, now_j);
            q_board.set_p(now_i + 2, now_j, this.current_player.get_piece());
            this.current_player.setPlayer_current_row(now_i + 2);
        } else if (i == 3) {//left
            q_board.clear_p(now_i, now_j);
            q_board.set_p(now_i, now_j - 2, this.current_player.get_piece());
            this.current_player.setPlayer_current_col(now_j - 2);
        } else if (i == 4) {//right
            q_board.clear_p(now_i, now_j);
            q_board.set_p(now_i, now_j + 2, this.current_player.get_piece());
            this.current_player.setPlayer_current_col(now_j + 2);
        }
    }

    public boolean check_win(Player player) {
        return player.getFinish_position_for_player() == player.getPlayer_current_row();
    }

    public void jump() {
    }
}
