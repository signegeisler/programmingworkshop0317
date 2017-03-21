import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    public Wall() {
        GreenfootImage img = new GreenfootImage(40,40);
        img.setColor(Color.BLUE);
        img.fill();
        setImage(img);
    }
}
