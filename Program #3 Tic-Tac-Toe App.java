//Programmer: Javan Graber
//Date: 11/18/26

package javanproject;
import java.util.Scanner;


class TTT{
	static Scanner userinput = new Scanner(System.in);
	char[][] board = {{'.','.','.'},{'.','.','.'},{'.','.','.'}};
	int turn = 1;
	char player = 'X';

	public void printBoard (){
		int i,j;
		System.out.println("");
		for (i=0;i<=2;i++)
		{
			for (j=0;j<=2;j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");	
		}
	}
	public void move(int i, int j){
		board[i][j] = player;
		turn++;
	}
	public void unDoMove(int i, int j){
		board[i][j] = '.';
		turn--;
	}
	public void switchPlayers (){
		if (player == 'X') {player = 'O';}
		else player = 'X';
	}
	
	public boolean isLegal(int i, int j){
		if (board[i][j] == '.') return true;
		else return false;
	}
	
	public boolean winner(){
		int i;
		boolean test = false;
		for (i = 0; i<=2;i++)
		{
			if ((board[i][0]==board[i][1]) && (board[i][1]==board[i][2]) &&
					(board[i][0]!='.'))
			{test = true;}
			if ((board[0][i]==board[1][i]) && (board[1][i]==board[2][i]) &&
				(board[0][i]!='.'))
			{test = true;}
		}
		if ((board[0][0]==board[1][1]) && (board[1][1]==board[2][2]) &&
				(board[0][0]!='.'))
		    {test = true;}
		
		if ((board[2][0]==board[1][1]) && (board[1][1]==board[0][2]) &&
				(board[2][0]!='.'))
		    {test = true;}
		return test;
	}
	
	public void human() {
		int i,j;

		boolean test = false;  //have I found a place to go
		while (test == false)
		{
			System.out.println("\nEnter Coordinates Where To Go Separated By A Space...");
			i = userinput.nextInt();
			j = userinput.nextInt();
			userinput.nextLine();
			if (isLegal(i-1,j-1) == true) {test = true; move(i-1,j-1);} 
		}
	}
	public void ai(){
		int i,j;
		//random
		boolean test = false;  //have I found a place to go
		while (test == false)
		{
			
			//*****************************************************************************************
			//*****************************************************************************************
			//Check all AI (Circle) moves for any wins before you check the player (X) moves
			for (i = 0; i<=2; i++) {
				//Check all the rows for any current groups of 2 for an AI win
				if ((board[i][0]==board[i][1]) && (board[i][0]!='.')) {
					if (board[i][0] == player) {
						if (isLegal(i,2) == true) {test = true; move(i,2);break;}
					}
				}
				if ((board[i][2]==board[i][1]) && (board[i][2]!='.')) {
					if (board[i][2] == player) {
						if (isLegal(i,0) == true) {test = true; move(i,0);break;}
					}
				}
				if ((board[i][0]==board[i][2]) && (board[i][0]!='.')) {
					if (board[i][0] == player) {
						if (isLegal(i,1) == true) {test = true; move(i,1);break;}
					}
				}
				//Check all the columns for any current groups of 2 for an AI win
				if ((board[0][i]==board[1][i]) && (board[0][i]!='.')) {
					if (board[0][i] == player) {
						if (isLegal(2,i) == true) {test = true; move(2,i);break;}
					}
				}
				if ((board[2][i]==board[1][i]) && (board[2][i]!='.')) {
					if (board[2][i] == player) {
						if (isLegal(0,i) == true) {test = true; move(0,i);break;}
					}
				}
				if ((board[0][i]==board[2][i]) && (board[0][i]!='.')) {
					if (board[0][i] == player) {
						if (isLegal(1,i) == true) {test = true; move(1,i);break;}
					}
				}
				//Check the diagonals from the top left and bottom right for an AI win
				if ((board[0][0]==board[1][1]) && (board[0][0]!='.')) {
					if (board[0][0] == player) {
						if (isLegal(2,2) == true) {test = true; move(2,2);break;}
					}
				}
				if ((board[2][2]==board[1][1]) && (board[2][2]!='.')) {
					if (board[2][2] == player) {
						if (isLegal(0,0) == true) {test = true; move(0,0);break;}
					}
				}
				//Check if the diagonal could be completed through the middle
				if ((board[0][0]==board[2][2]) && (board[0][0]!='.')) {
					if (board[0][0] == player) {
						if (isLegal(1,1) == true) {test = true; move(1,1);break;}
					}
				}
				//Check the diagonals from the bottom left and the top right
				if ((board[2][0]==board[1][1]) && (board[2][0]!='.')) {
					if (board[2][0] == player) {
						if (isLegal(0,2) == true) {test = true; move(0,2);break;}
					}
				}
				if ((board[0][2]==board[1][1]) && (board[0][2]!='.')) {
					if (board[0][2] == player) {
						if (isLegal(2,0) == true) {test = true; move(2,0);break;}
					}
				}
				//Check if the diagonal could be completed through the middle
				if ((board[2][0]==board[0][2]) && (board[2][0]!='.')) {
					if (board[2][0] == player) {
						if (isLegal(1,1) == true) {test = true; move(1,1);break;}
					}
				}
			}
			//If a move was found, get out of the loop
			if (test == true) {
				break;
			}
			
			//*****************************************************************************************
			//*****************************************************************************************
			//Check all of the opponent's places for any potential completions after scanning for AI wins
			for (i = 0; i<=2; i++) {	
				//Check all the rows for any current groups of 2
				if ((board[i][0]==board[i][1]) && (board[i][0]!='.')) {
					if (isLegal(i,2) == true) {test = true; move(i,2);break;}
				}
				if ((board[i][2]==board[i][1]) && (board[i][2]!='.')) {
					if (isLegal(i,0) == true) {test = true; move(i,0);break;}
				}
				if ((board[i][0]==board[i][2]) && (board[i][0]!='.')) {
					if (isLegal(i,1) == true) {test = true; move(i,1);break;}	
				}
				
				//Check all the columns for any current groups of 2
				if ((board[0][i]==board[1][i]) && (board[0][i]!='.')) {
					if (isLegal(2,i) == true) {test = true; move(2,i);break;}
				}
				if ((board[2][i]==board[1][i]) && (board[2][i]!='.')) {
					if (isLegal(0,i) == true) {test = true; move(0,i);break;}
				}
				if ((board[0][i]==board[2][i]) && (board[0][i]!='.')) {
					if (isLegal(1,i) == true) {test = true; move(1,i);break;}
				}
				//Check the diagonals from the top left and bottom right
				if ((board[0][0]==board[1][1]) && (board[0][0]!='.')) {
					if (isLegal(2,2) == true) {test = true; move(2,2);break;}
				}
				if ((board[2][2]==board[1][1]) && (board[2][2]!='.')) {
					if (isLegal(0,0) == true) {test = true; move(0,0);break;}
				}
				//Check if the diagonal could be completed through the middle
				if ((board[0][0]==board[2][2]) && (board[0][0]!='.')) {
					if (isLegal(1,1) == true) {test = true; move(1,1);break;}
				}
				
				//Check the diagonals from the bottom left and the top right
				if ((board[2][0]==board[1][1]) && (board[2][0]!='.')) {
					if (isLegal(0,2) == true) {test = true; move(0,2);break;}
				}
				if ((board[0][2]==board[1][1]) && (board[0][2]!='.')) {
					if (isLegal(2,0) == true) {test = true; move(2,0);break;}
				}
				//Check if the diagonal could be completed through the middle
				if ((board[2][0]==board[0][2]) && (board[2][0]!='.')) {
					if (isLegal(1,1) == true) {test = true; move(1,1);break;}
				}	
			}
			
			//If the scan was not able to find any possible streaks...
			
			if (test == false) {
				//Check if the middle is open. If it is, go there
				if (isLegal(1,1) == true) {test = true;move(1,1);break;}
				
				//If the middle was not open, select a random move
				else {
					i = (int) (Math.random()*3.0);
					j = (int) (Math.random()*3.0);
					if (isLegal(i,j) == true) {test = true; move(i,j);break;} 
				}

			}
		}
		System.out.println("AI is moving ... ");
	
	}
}

//Create the main class containing the mainline
public class MyProject {   
    static Scanner userinput = new Scanner(System.in); 
	
	//Create the mainline
	public static void main (String[] args){
		try {
			TTT game = new TTT();
			game.printBoard();
			for (int i = 1;i<=5; i++)
			{
	            game.human();
				game.printBoard();
				if ((game.winner() == true) || (i == 5)) {break;}
				game.switchPlayers();
				game.ai();
				game.printBoard();
				if ((game.winner() == true) || (i == 5)) {break;}
				game.switchPlayers();
			}
			
			if (game.winner() == true) {System.out.println("\nThe winner is " + game.player);}
			else {System.out.println("\nCat Game.");}
		//Catch any exceptions
		} catch (Exception e) {
			System.out.println("Something you entered was not valid. Make sure you enter valid information!");
		}
	}
		
}
