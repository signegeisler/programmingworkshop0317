import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /* 
     * Dette er en to-dimensionel tabel, der repræsenterer "labyrinten" i 
     * spillet. Tabellen er fyldt med "sandt" og "falsk" for hver celle i 
     * verden (11*17 celler). De steder hvor tabellen indeholder "sandt" 
     * svarer til de steder, hvor der er en væg i "labyrinten". 
     */
    boolean[][] labyrinth = 
        {{true, true,  true,  true,  true,  true,  true,  true,  true,  true,  true},
         {true, false, false, false, false, false, false, false, false, false, true}, 
         {true, false, true,  false, true,  false, true,  false, true,  false, true}, 
         {true, false, true,  false, true,  false, true,  false, true,  false, true}, 
         {true, false, true,  true,  true,  true,  true,  true,  true,  false, true},
         {true, false, false, false, false, false, false, false, false, false, true},
         {true, true,  false, true,  true,  false, true,  true,  false, true,  true}, 
         {true, false, false, true,  false, false, false, true,  false, false, true},
         {true, true,  false, true,  true,  true , true,  true,  false, true,  true},
         {true, false, false, false, false, false, false, false, false, false, true}, 
         {true, false, true,  true,  true,  true,  true,  true,  true,  false, true}, 
         {true, false, false, false, false, true,  false, false, false, false, true}, 
         {true, false, true,  true,  false, true,  false, true,  true,  false, true},
         {true, false, false, true,  false, false, false, true,  false, false, true},
         {true, false, true,  true,  true,  false, true,  true,  true,  false, true},
         {true, false, false, false, false, false, false, false, false, false, true},
         {true, true,  true,  true,  true,  true,  true,  true,  true,  true,  true}};   

    private int score = 0;
    String scoreText = "Score : ";

    /*
     * Constructor for verden. Verden består af 11*17 celler, der hver er 
     * 40*40 px. Denne kode bliver kørt når der oprettes en ny verden (når
     * der trykkes på "reset"-knappen). 
     */
    public MyWorld()
    {    
        // Lad denne kode være som den er.
        super(11, 17, 40);
        fillBackground();
        putInWalls();
        putInDots();
        
        // Jeres egen kode kan indsættes efter denne kommentar.
        //showText(scoreText + score, 1, 0);
    }

    /*
     * Sætter baggrundsfarven i verden til sort. 
     */
    private void fillBackground(){
        GreenfootImage pic = new GreenfootImage(440, 680);
        pic.setColor(Color.BLACK);
        pic.fill();
        setBackground(pic);
    }

    public void putInDots(){
        for(int i = 0; i < 17; i++) {
            for(int j = 0; j < 11; j++) {
                if(!labyrinth[i][j]){
                    addObject(new Dot(), j, i);
                }
            }
        }        
    }

    public void putInWalls() {
        for(int i = 0; i < labyrinth.length; i++) {
            for(int j = 0; j < labyrinth[0].length; j++) {
                if(labyrinth[i][j]){
                    addObject(new Wall(), j, i);
                }
            }
        }
        
        int[][] arr = {{1,2},{3,4},{5,6}};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++){ 
        System.out.println(arr[i][j]);
    }
}
    } 

    public void updateScore(){
        score++;
        showText(scoreText + score, 1, 0);
    }
}
