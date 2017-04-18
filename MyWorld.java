import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    /* 
     * Dette er en to-dimensionel tabel, der repræsenterer "labyrinten" i 
     * spillet. Tabellen er fyldt med "sandt" og "falsk" for hver celle i 
     * verden (17*11 celler). De steder hvor tabellen indeholder "sandt" 
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

    /*
     * Constructor for verden. Verden består af 17*11 celler, der hver er 
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

    }

    public void putInDots(){
        for(int i = 0; i < labyrinth.length; i++) {
            for(int j = 0; j < labyrinth[0].length; j++) {
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
}
