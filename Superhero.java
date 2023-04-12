import java.util.ArrayList;
import java.util.Random;
/**
 * Create the Superhero Object
 * @param size - the size of the object(Superhero)
 * @param inventory - keeps track of objects that were grabbed
 * @param number - is a random number
 * @param actions - keeps track of the actions taken
 * @return a Superhero object
 */
public class Superhero implements Contract {

    public int size;
    public ArrayList<String> inventory;
    public int number;
    public ArrayList<String> actions;

    /**
     * Creates the inventory, and action arraylists and makes the size equal to 6
     */
    public Superhero(){
        size = 6;
        this.inventory = new ArrayList<String>();
        this.actions = new ArrayList<String>();
    }

    /**
     * Adds items to the inventory and prints out a statement
     * @param item - The item being grabbed
     */
    public void grab(String item){
        actions.add("grab");
        System.out.println("I grabbed the " + item + "!");
        inventory.add(item);
    }
    
    /**
     * Removes items from the inventory and prints out a statement, if item is not in inventory it will not remove the item
     * @param item - The item being dropped
     * @return item - the item being dropped
     */
    public String drop(String item){
        actions.add("drop");
        if(inventory.contains(item)){
            System.out.println("I dropped the " + item + "!");
            inventory.remove(item);
        }else{
        System.out.println("Cannot drop this item, since this item is not in my inventory!");
        }
        return item;
    }

    /**
     * Examines an item, gets a random number and gives one of two statements depending on the random  number
     * @param item - the string given to examine
     */
    public void examine(String item){
        actions.add("examine");
        Random randomGenerator=new Random();
        number = (randomGenerator.nextInt(10) + 1);

        System.out.print("Examining " + item + "... ");
        if(number >= 5){
            System.out.println("this is very interesting!");
        }else{
            System.out.println("this is not interesting.");
        }
    }
    /**
     * Checks if the item is in your inventory then prints a statement
     * @param item - the String being used
     */
    public void use(String item){
        actions.add("use");
        if(inventory.contains(item)){
            System.out.println("I am using the " + item + "!");
        }else{
            System.out.println("Cannot use this item, since this item is not in my inventory!");
        }
    }
    
    /**
     * Prints a statement, which shows you are walking in that direction
     * @param direction - the way that you are walking
     * @return True 
     */
    public boolean walk(String direction){
        actions.add("walk");
        System.out.println("I am walking to the " + direction + "!");
        return true;
    }
    /**
     * Prints out a statement, flying to the x and y integers
     * @param int x - the longitude to fly to
     * @param iny y - the latitude to fly to
     * @return True
     */
    public boolean fly(int x, int y){
        actions.add("fly");
        System.out.println("Flying to " + x +" longitude, and "+ y + " latitude... Arrived!");
        return true;
    }
    /**
     * Decreases the number of the size, then prints a statement
     * @return A number
     */
    public Number shrink(){
        actions.add("shrink");
        size = size -1;
        System.out.println("Shrinking... Now I'm " + size + " feet tall!");
        return 1;
    }
    /**
     * Increass the number of the size, then prints a statement
     * @return A number
     */
    public Number grow(){
        actions.add("grow");
        size = size + 1;
        System.out.println("Growing... Now I'm " + size + " feet tall!");
        return 2;
    }
    /**
     * Prints a statement showing the Superhero is resting
     */
    public void rest(){
        actions.add("rest");
        System.out.println("I am now resting!");
    }
    /**
     * Finds which statement was last using an arraylist, and prints out a statement which undos that method
     * The last action on the ArrayList also gets removed
     */
    public void undo(){
        System.out.print("I am undoing my last action...");
        if((actions.get(actions.size()-1).equals("grab"))){
            System.out.println("I dropped that item!");
            inventory.remove(inventory.size()-1);
        }

        if((actions.get(actions.size()-1).equals("drop"))){
            System.out.println("I picked up that item!");
        }

        if((actions.get(actions.size()-1).equals("examine"))){
            System.out.println("I am not going to examine that item!");
        }

        if((actions.get(actions.size()-1).equals("use"))){
            System.out.println("I am not going to use that item!");
        }

        if((actions.get(actions.size()-1).equals("walk"))){
            System.out.println("I am walking back to where I started!");
        }

        if((actions.get(actions.size()-1).equals("fly"))){
            System.out.println("I am flying back to where I started!");
        }

        if((actions.get(actions.size()-1).equals("shrink"))){
            size = size +1;
            System.out.println("Growing... Now I'm " + size + " feet tall!");
        }

        if((actions.get(actions.size()-1).equals("grow"))){
            size = size -1;
            System.out.println("Shrinking... Now I'm " + size + " feet tall!");
        }

        if((actions.get(actions.size()-1).equals("rest"))){
            System.out.println("I am no longer resting!");
            actions.remove(actions.size()-1);
        }
        actions.remove(actions.size()-1);
    }
    /**
     * Calls the different methods
     */
    class Main {
        public static void main(String[] args) {
          Superhero WonderWoman = new Superhero();  // Create a Superhero object
          WonderWoman.grab("book");
          WonderWoman.grab("cookie");
          WonderWoman.drop("cookie");
          WonderWoman.examine("room");
          WonderWoman.use("book");
          WonderWoman.walk("right");
          WonderWoman.fly(10,10);
          WonderWoman.shrink();
          WonderWoman.grow();
          WonderWoman.undo();
          WonderWoman.rest();
          WonderWoman.undo();

        }
    }
}
