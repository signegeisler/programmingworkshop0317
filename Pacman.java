import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pacman extends Actor
{
    /*
     * Samling af retninger, som figuren kan have. 
     */
    private enum Direction {
        NORTH, WEST, EAST, SOUTH
    }

    // Figurens retning
    private Direction direction;
    
    // Figurens hastighed
    private int speed;

    /*
     * Constructor for pacman. Bliver kaldt, når der laves en ny Pacman. 
     * Sætter start-retningen til øst/højre, og start-hastigheden til 1. 
     */
    public Pacman() { 
        direction = Direction.EAST;
        speed = 1;
        getImage().scale(30,30);
    }

    /**
     * Her skrives koden som hele tiden udføres. 
     */
    public void act() {
        detectKeyPressed();
        if(canMove(direction)){
            move(speed);
            eat();
        }
    }

    /**
     * Detekter hvis en af piletasterne bliver trykket på.
     */
    private void detectKeyPressed() {
        if(Greenfoot.isKeyDown("up")) {
            if(canMove(Direction.NORTH)) {
                turnNorth();
            }
        }
        
        if (Greenfoot.isKeyDown("left")) {
            if(canMove(Direction.WEST)) {
                turnWest();
            }
        }
        
        if (Greenfoot.isKeyDown("right")) {
           if(canMove(Direction.EAST)) {
                turnEast();
            }
        } 
        
        if (Greenfoot.isKeyDown("down")) {
            if(canMove(Direction.SOUTH)) {
                turnSouth();
            }
        }
    }

    /**
     * Få pacman til at spise en af prikkerne. 
     */
    private void eat(){
        Dot dot = (Dot) getOneIntersectingObject(Dot.class);
        if(dot != null) {
            getWorld().removeObject(dot);
        }
    }
    
    
    //// HERUNDER LIGGER DE "INDBYGGEDE" METODER, SOM I IKKE SKAL ÆNDRE I ////
    
     /*
     * Tjek om det er muligt at flytte sig i en bestemt retning. Hvis ja, resulterer metoden 
     * i "true", og ellers i "false".
     */
    private boolean canMove(Direction dir) {
        switch(dir) {
            case NORTH : if(getOneObjectAtOffset(0, -1, Wall.class) == null) return true; break;
            case WEST  : if(getOneObjectAtOffset(-1, 0, Wall.class) == null) return true; break;
            case EAST  : if(getOneObjectAtOffset(1, 0,  Wall.class) == null) return true; break;
            case SOUTH : if(getOneObjectAtOffset(0, 1,  Wall.class) == null) return true; break;
        }
        return false;
    }

    /*
     * Drej opad. Hastighed, ratation og spejling af billedet håndteres. 
     */
    private void turnNorth() {
        if(direction == Direction.WEST) {
            turn(-90);
            speed = 1;
            getImage().mirrorHorizontally();
        } else if (direction == Direction.EAST) {
            turn(-90);
        } else if (direction == Direction.SOUTH) {
            speed = 1;
            getImage().mirrorHorizontally();
        }
        direction = Direction.NORTH;
    }

     /*
     * Drej til venstre. Hastighed, ratation og spejling af billedet håndteres. 
     */
    private void turnWest() {
        if(direction == Direction.NORTH) {
            turn(90);
            speed = -1;
            getImage().mirrorHorizontally();
        } else if (direction == Direction.EAST) {
            speed = -1;
            getImage().mirrorHorizontally();
        } else if (direction == Direction.SOUTH) {
            turn(90);
        }
        direction = Direction.WEST;
    }

     /*
     * Drej til højre. Hastighed, ratation og spejling af billedet håndteres. 
     */
    private void turnEast() {
        if(direction == Direction.NORTH) {
            turn(90);
        } else if (direction == Direction.WEST) {
            speed = 1;
            getImage().mirrorHorizontally();
        } else if (direction == Direction.SOUTH) {
            turn(90);
            speed = 1;
            getImage().mirrorHorizontally();
        }
        direction = Direction.EAST;
    }

     /*
     * Drej nedad. Hastighed, ratation og spejling af billedet håndteres. 
     */
    private void turnSouth() {
        if(direction == Direction.NORTH) {
            speed = -1;
            getImage().mirrorHorizontally();
        } else if (direction == Direction.WEST) {
            turn(-90);
        } else if (direction == Direction.EAST) {
            turn(-90);
            speed = -1;
            getImage().mirrorHorizontally();
        }
        direction = Direction.SOUTH;
    }
}


