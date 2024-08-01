import greenfoot.Greenfoot;
import greenfoot.World;
import java.util.Scanner;

public class Main extends World {

    private Sorter sorter;
    private Scanner scan = new Scanner(System.in);
    private int width;
    private int height;
    private int amountOfBars;
    private int speed;
    private boolean twiceNums;

    public Main() {
        super(0, 0, 1, true);
        width = 1200;
        height = 700;
        amountOfBars = 25;
        speed = 50;
        twiceNums = false;
        sorter = new Sorter(width, height, amountOfBars, speed, twiceNums, this);
        Greenfoot.setWorld(sorter);
        Greenfoot.start();
    }

    public void changeWorld() {
            System.out.println("What would you like to do?");
            System.out.println("To load a preset, type 'preset'.");
            System.out.println("To create a whole new world, type 'new'.");
            System.out.println("To change an attribute, type 'variable'.");
            System.out.print("> ");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("preset")) {
                System.out.println("Which preset would you like to load?");
                System.out.println("To load preset 1 (1200, 500, 25, 63, false), type '1'.");
                System.out.println("To load preset 2 (1200, 500, 25, 63, true), type '2'.");
                System.out.println("To load preset 3 (1200, 500, 50, 100, false), type '3'.");
                System.out.println("To load preset 4 (1200, 500, 25, 50, false33), type '4'.");
                System.out.print("> ");
                int scanner = scan.nextInt();
                if (scanner == 1) {
                    sorter = new Sorter(1200, 500, 25, 63, false, this);
                    Greenfoot.setWorld(sorter);
                    System.out.println("A new World has been created.");
                } else if (scanner == 2) {
                    sorter = new Sorter(1200, 500, 25, 63, true, this);
                    Greenfoot.setWorld(sorter);
                    System.out.println("A new World has been created.");
                } else if (scanner == 4) {
                    sorter = new Sorter(1200, 500, 50, 100, false, this);
                    Greenfoot.setWorld(sorter);
                    System.out.println("A new World has been created.");
                } else if (scanner == 3) {
                    sorter = new Sorter(1200, 500, 25, 50, false, this);
                    Greenfoot.setWorld(sorter);
                    System.out.println("A new World has been created.");
                } else {
                    System.out.println("Please choose a valid option");
                }
            } else if (choice.equalsIgnoreCase("new")) {
                System.out.println("To initiate a new world, type the..");
                System.out.println("..width:");
                System.out.print("> ");
                width = scan.nextInt();
                System.out.println("..height:");
                System.out.print("> ");
                height = scan.nextInt();
                System.out.println("..amount of bars:");
                System.out.print("> ");
                amountOfBars = scan.nextInt();
                System.out.println("..twice numbers:");
                System.out.print("> ");
                twiceNums = scan.nextBoolean();
                System.out.println("..speed:");
                System.out.print("> ");
                speed = scan.nextInt();
                sorter = new Sorter(width, height, amountOfBars, speed, twiceNums, this);
                Greenfoot.setWorld(sorter);
                System.out.println("A new World has been created.");
            } else if (choice.equalsIgnoreCase("variable")) {
                System.out.println("To change a variable, type ..");
                System.out.println("..width:");
                System.out.println("..height:");
                System.out.println("..amount:");
                System.out.println("..twice numbers:");
                System.out.println("..speed:");
                System.out.print("> ");
                {
                    String variable = scan.nextLine();
                    if (variable.equalsIgnoreCase("width")) {
                        System.out.println("Enter the width of the world");
                        System.out.print("> ");
                        width = scan.nextInt();
                    } else if (variable.equalsIgnoreCase("height")) {
                        System.out.println("Enter the height of the world");
                        System.out.print("> ");
                        height = scan.nextInt();
                    } else if (variable.equalsIgnoreCase("amount")) {
                        System.out.println("Enter the amount of data");
                        System.out.print("> ");
                        amountOfBars = scan.nextInt();
                    } else if (variable.equalsIgnoreCase("speed")) {
                        System.out.println("Enter the speed");
                        System.out.print("> ");
                        speed = scan.nextInt();
                    } else if (variable.equalsIgnoreCase("twice numbers")) {
                        System.out.println("Enable twice numbers?");
                        System.out.print("> ");
                        twiceNums = scan.nextBoolean();
                    } else if (variable.equalsIgnoreCase("variable")) {
                        System.out.println("Please choose a valid option!");
                    }
                }
                sorter = new Sorter(width, height, amountOfBars, speed, twiceNums, this);
                Greenfoot.setWorld(sorter);
            }
    }
}