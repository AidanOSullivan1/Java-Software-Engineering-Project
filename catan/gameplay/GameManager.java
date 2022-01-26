package gameplay;



import board.Board;
import players.Player;
import players.PlayerList;
import setup.LairResourceMap;
import setup.PlayerSetup;


public class GameManager {
	
    private static GameManager theGM;
    
    // Other variables
    private static boolean    gameOver;
    private PlayerList players;
    
    
    //===========================================================
    // Get Instance of Singleton
    //===========================================================
    /**
     * getInstance singleton method that returns the single instance
     * of the gameManager object.
     * @return The single gameManager object
     */
    public static GameManager getInstance(){
        if(theGM == null){
            theGM = new GameManager();
        }
        return theGM;
    }
    /**
    * The private GameManager constructor
    */
   private GameManager() {
       this.gameOver     = false;
       this.players      = PlayerList.getInstance();
   }
   
   public static void doGameplay() {
       
       boolean    playerWins = false;
       PlayerTurn currentTurn;

       while (!gameOver) { // Main loop for doing PlayerTurns
                      
           for (Player currentPlayer: PlayerList.getInstance().getList()) {

              
                currentTurn = new PlayerTurn(currentPlayer);    // Make a new PlayerTurn
                currentTurn.playerTurn();                            // Let it handle the turn
              //Add function to check if player has won by building 7 pirates’ lairs
               //playerWins  = currentTurn. ; 
                   
                   if (currentPlayer.getLairsBuilt().size() > 6) {              // If Player has won
                       endGame(currentPlayer);
                       break;
               }
           }
       }
      
       
   }
private static void endGame(Player winner) {
    
    
    System.out.println("                                  .''.");
    System.out.println("      .''.      .        *''*    :_\\/_:     .");
    System.out.println("     :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.");
    System.out.println(" .''.: /\\ :    /)\\   ':'* /\\ *  : '..'.  -=:o:=-");
    System.out.println(":_\\/_:'.:::.  | ' *''*    * '.\\'/.'_\\(/_'.':'.'");
    System.out.println(": /\\ : :::::  =  *_\\/_*     -= o =- /)\\    '  *");
    System.out.println(" '..'  ':::' === * /\\ *     .'/.\\'.  ' ._____");
    System.out.println("     *        |   *..*         :       |.   |' .---\"|");
    System.out.println("       *      |     _           .--'|  ||   | _|    |");
    System.out.println("       *      |  .-'|       __  |   |  |    ||      |");
    System.out.println("    .-----.   |  |' |  ||  |  | |   |  |    ||      |");
    System.out.println("___'       ' /\"\\ |  '-.\"\".    '-'   '-.'    '`      |____\\");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   
    System.out.println(winner.getColour() + " has won the game ! " );
    
    gameOver = true;
	
}

public static void main(String args[]) {
	Board.getInstance(); // create instance of the board
	LairResourceMap.createIslands(); //makes all the islands and places on board
	
	PlayerSetup.playerBuilder();
	
	
	
	doGameplay();
	
	Board.getInstance().printBoard();
	


}
   

}
