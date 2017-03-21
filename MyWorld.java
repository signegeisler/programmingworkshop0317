import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    boolean[][] maze = 
        {{true, true, true, true, true, true, true, true, true, true, true},
         {true, false,false,false,false,false,false,false,false,false,true}, 
         {true, false,true, false,true, false,true, false,true, false,true}, 
         {true, false,true, false,true, false,true, false,true, false,true}, 
         {true, false,true, true, true, true, true, true, true, false,true},
         {true, false,false,false,false,false,false,false,false,false,true},
         {true, true, false,true, true, false,true, true, false,true, true}, 
         {true, false,false,true, false,false,false,true, false,false,true},
         {true, true, false,true, true, true ,true, true, false,true, true},
         {true, false,false,false,false,false,false,false,false,false,true}, 
         {true, false,true, true, true, true, true, true, true, false,true}, 
         {true, false,false,false,false,true, false,false,false,false,true}, 
         {true, false,true, true, false,true, false,true, true, false,true},
         {true, false,false,true, false,false,false,true, false,false,true},
         {true, false,true, true, true, false,true, true, true, false,true},
         {true, false,false,false,false,false,false,false,false,false,true},
         {true, true, true, true, true, true, true, true, true, true, true}};   
         
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(11, 17, 40);
        fillBackground();
    }
    
    private void fillBackground(){
        GreenfootImage pic = new GreenfootImage(600, 400);
        pic.setColor(Color.BLACK);
        pic.fill();
        setBackground(pic);
    }
    
    public void populateFreeCells(java.lang.Class<Actor> cls){
        try {
            for(int i = 0; i < maze.length; i++) {
                for(int j = 0; j < maze[0].length; j++) {
                    if(!maze[i][j]){
                        Actor actor = cls.newInstance();
                        addObject(actor, j, i);
                    }
                }
            }
            

        } catch (Exception e) {
            
        }
        
        
    }
    
    public void populateWalls() {
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j]){
                    Wall w = new Wall();
                    addObject(w, j, i);
                }
            }
        }
    }    
}
