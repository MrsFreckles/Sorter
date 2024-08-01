import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class Bar extends Actor{

    private GreenfootImage image;
    int x;
    private Sorter sorter;

    public Bar(int x){
        this.x = x;
    }

    public void changeImage(int i , Color color){
        image.scale(sorter.getWidth()/sorter.getAmountOfBars(), 2*sorter.getHeight());
        image.clear();
        image.setColor(color);
        image.fillRect(0, sorter.getHeight() - (sorter.getHeight()/ sorter.getAmountOfBars())*i, image.getWidth(), (sorter.getHeight()/ sorter.getAmountOfBars())*i);
        image.drawString("#" + x, 0, 0);
        if(color == Color.BLACK || color == Color.BLUE){
            image.setColor(Color.WHITE);
        }else{
            image.setColor(Color.DARK_GRAY);
        }
        image.drawString(i + "", 0, sorter.getHeight());
        setImage(image);
    }

    public void setVars(int i){
        sorter = (Sorter) getWorld();
        image = new GreenfootImage(1,  sorter.getHeight() * 2);
        changeImage(i, Color.GREEN);
    }
}
