import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private enum Dir {
        NORTH, WEST, EAST, SOUTH
    }

    private Dir direction;

    public Pacman() { 
        getImage().scale(20,20);
        direction = Dir.EAST;
    }

    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        detectKeyPressed();
    }

    private void detectKeyPressed(){
        if(Greenfoot.isKeyDown("up")) {
            moveUp();
        } else if (Greenfoot.isKeyDown("left")) {
            moveLeft();
        } else if (Greenfoot.isKeyDown("right")) {
            moveRight();
        } else if (Greenfoot.isKeyDown("down")) {
            moveDown();
        }
    }

    private void moveUp() {

    }

    private void moveLeft() {

    }

    private void moveRight() {

    }

    private void moveDown() {

    }
}
