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
    private int speed = 1;

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
        move(speed);
        detectKeyPressed();
    }

    private void detectKeyPressed(){
        if(Greenfoot.isKeyDown("up")) {
            moveDir(Dir.NORTH);
        } else if (Greenfoot.isKeyDown("left")) {
            moveDir(Dir.WEST);
        } else if (Greenfoot.isKeyDown("right")) {
            moveDir(Dir.EAST);
        } else if (Greenfoot.isKeyDown("down")) {
            moveDir(Dir.SOUTH);
        }
    }

    private void moveDir(Dir desiredDir) {
        if(canMove(desiredDir)) {
            switch (desiredDir) {
                case NORTH : turnNorth(); break;
                case WEST :  turnWest();  break;
                case EAST :  turnEast();  break;
                case SOUTH : turnSouth(); break;

            }
        }
    }

    private void turnNorth() {
        if(direction == Dir.WEST) {
            turn(-90);
            speed = 1;
        } else if (direction == Dir.EAST) {
            turn(-90);
        } else if (direction == Dir.SOUTH) {
            speed = 1;
        }
        direction = Dir.NORTH;
    }
    
        private void turnWest() {
        if(direction == Dir.NORTH) {
            turn(90);
            speed = -1;
        } else if (direction == Dir.EAST) {
            speed = -1;
        } else if (direction == Dir.SOUTH) {
            turn(90);
        }
        direction = Dir.WEST;
    }
    
    private void turnEast() {
        if(direction == Dir.NORTH) {
            turn(90);
        } else if (direction == Dir.WEST) {
            speed = 1;
        } else if (direction == Dir.SOUTH) {
            turn(90);
            speed = 1;
        }
        direction = Dir.EAST;
    }
    
        private void turnSouth() {
        if(direction == Dir.NORTH) {
            speed = -1;
        } else if (direction == Dir.WEST) {
            turn(-90);
        } else if (direction == Dir.EAST) {
            turn(-90);
            speed = -1;
        }
        direction = Dir.SOUTH;
    }
    private boolean canMove(Dir dir) {
        return true;
    }
}
