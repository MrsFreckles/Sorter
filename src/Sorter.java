import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.World;

public class Sorter extends World{

    private int[] nums;
    private int amountOfBars;
    private boolean twiceNums = false;
    private int speed;
    private Main main;

    public Sorter(int width, int height, int amountOfBars, int speed, boolean twiceNums, Main main){
        super(width, height, 1, false);
        this.main = main;
        this.amountOfBars = amountOfBars;
        this.speed = speed;
        this.twiceNums = twiceNums;
        nums = new int[amountOfBars];
        for (int i = 0; i < nums.length; i++) {
            if(twiceNums){
                int temp = (Greenfoot.getRandomNumber(amountOfBars)+1);
                nums[i] = temp;
            }else{
                nums[i] = i + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            Bar bar = new Bar(i);
            addObject(bar, (getWidth()/amountOfBars)/2 + (i*getWidth()/amountOfBars), getHeight());
            bar.setVars(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                if(isSorted()) {
                    showDone();
                    break;
                }
            }
        }
        if (isSorted()){
            showDone();
        }
        Greenfoot.setSpeed(speed);
        Greenfoot.start();
        if (isSorted()) {
            showDone();
        }
    }

    public void act() {
        if(Greenfoot.isKeyDown("1")) {
            shuffle();
        }else if(Greenfoot.isKeyDown("2")) {
            bubbleSort();
        } else if(Greenfoot.isKeyDown("3")) {
            minSort();
        } else if(Greenfoot.isKeyDown("0")){
            main.changeWorld();
        } else if(Greenfoot.isKeyDown("4")){
            cocktailSort();
        } else if(Greenfoot.isKeyDown("5")){
            selectionSort();
        } else if(Greenfoot.isKeyDown("6")){
            insertionSort();
        } else if(Greenfoot.isKeyDown("7")){
            pancakeSort();
        } else if(Greenfoot.isKeyDown("9")){
            goofyahh();
        }
    }

    public int getAmountOfBars(){
        return amountOfBars;
    }

    public void changeImages(){
        for (int i = 0; i < nums.length ; i++) {
            getObjects(Bar.class).get(i).changeImage(nums[i], Color.BLACK);
        }
    }

    public void showDone(){
        for (int i = 0; i < nums.length ; i++) {
            getObjects(Bar.class).get(i).changeImage(nums[i], Color.GREEN);
        }
    }

    public void shuffle(){
        for (int i = 0; i < nums.length ; i++) {
            int randomIndexToSwap = Greenfoot.getRandomNumber(nums.length);
            swap(i, randomIndexToSwap);
        }
    }

    public void bubbleSort(){
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < (nums.length - i); j++){
                changeImages();
                getObjects(Bar.class).get(j - 1).changeImage(nums[j - 1], Color.BLUE);
                getObjects(Bar.class).get(j).changeImage(nums[j], Color.BLUE);
                Greenfoot.delay(1);
                if(nums[j - 1] > nums[j]){
                    swap(j - 1, j);
                }
                if(isSorted()){
                    showDone();
                    break;
                }
                Greenfoot.delay(1);
            }
        }
        if(isSorted()){
            showDone();
        }
    }

    public void goofyahh(){
        nums = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,20,10,10,10,10,10,10,10,10};
        changeImages();
        showDone();
    }

    public void cocktailSort(){
        for(int i = 0; i < nums.length-i; i++){
            for(int j = i + 1; j < (nums.length - i); j++){
                getObjects(Bar.class).get(j-1).changeImage(nums[j-1], Color.BLUE);
                getObjects(Bar.class).get(j).changeImage(nums[j], Color.BLUE);
                Greenfoot.delay(1);
                changeImages();
                if(nums[j - 1] > nums[j]){
                    swap(j - 1, j);
                }
            }
            for(int j = (nums.length-1)-i; j > i; j--){
                getObjects(Bar.class).get(j-1).changeImage(nums[j-1], Color.BLUE);
                getObjects(Bar.class).get(j).changeImage(nums[j], Color.BLUE);
                Greenfoot.delay(1);
                changeImages();
                if(nums[j - 1] > nums[j]){
                    swap(j - 1, j);
                }
            }
        }
        if(isSorted()){
            showDone();
        }
    }

    public void selectionSort(){
        for (int i = 0; i < nums.length - 1; i++) {
            int maxIndex = 0;
            for (int j = 1; j < nums.length - i; j++) {
                getObjects(Bar.class).get(j).changeImage(nums[j], Color.BLUE);
                getObjects(Bar.class).get(maxIndex).changeImage(nums[maxIndex], Color.BLUE);
                Greenfoot.delay(1);
                changeImages();
                if (nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
            }
            swap(nums.length - 1 - i, maxIndex);
        }
        if(isSorted()){
            showDone();
        }
    }

    public void minSort(){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                changeImages();
                getObjects(Bar.class).get(i).changeImage(nums[i], Color.BLUE);
                getObjects(Bar.class).get(j).changeImage(nums[j], Color.BLUE);
                Greenfoot.delay(1);
                if (nums[j] < nums[i]) {
                    swap(j, i);
                }
                if(isSorted()) {
                    showDone();
                    break;
                }
            }
        }
        if (isSorted()){
            showDone();
        }
    }

    public void insertionSort() {
        int temp;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                changeImages();
                getObjects(Bar.class).get(j - 1).changeImage(nums[j-1], Color.BLUE);
                Greenfoot.delay(1);
                changeImages();
                getObjects(Bar.class).get(j).changeImage(nums[j-1], Color.RED);
                getObjects(Bar.class).get(j-1).changeImage(nums[j-1], Color.RED);
                nums[j] = nums[j - 1];
                j--;
                Greenfoot.delay(1);
            }
            getObjects(Bar.class).get(i).changeImage(nums[j], Color.RED);
            getObjects(Bar.class).get(j).changeImage(temp, Color.RED);
            nums[j] = temp;
            Greenfoot.delay(1);
            changeImages();
        }
        if(isSorted()){
            showDone();
        }
    }

    public void pancakeSort(){
        int n = nums.length;
        for(int i = n; i > 1; i--){
            changeImages();
            int maxIndex = findMaxIndex(i);
            getObjects(Bar.class).get(maxIndex).changeImage(nums[maxIndex], Color.BLUE);
            getObjects(Bar.class).get(i-1).changeImage(nums[i-1], Color.BLUE);
            Greenfoot.delay(1);
            if(maxIndex != i - 1){
                flip(maxIndex);
                flip(i - 1);
            }
        }
        if(isSorted()){
            showDone();
        }
    }

    public int findMaxIndex(int n){
        int maxIndex = 0;
        for(int i = 0; i < n; i++){
            changeImages();
            getObjects(Bar.class).get(i).changeImage(nums[i], Color.BLUE);
            if(nums[i] > nums[maxIndex]){
                getObjects(Bar.class).get(maxIndex).changeImage(nums[maxIndex], Color.YELLOW);
                maxIndex = i;
            }
            Greenfoot.delay(1);
        }
        return maxIndex;
    }

    public void flip(int i){
        changeImages();
        int start = 0;
        while(start < i){
            swap(start, i);
            start++;
            i--;
        }
    }


    public void swap(int a, int b){
        getObjects(Bar.class).get(a).changeImage(nums[a], Color.RED);
        getObjects(Bar.class).get(b).changeImage(nums[b], Color.RED);
        //playSound();
        Greenfoot.delay(1);
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        getObjects(Bar.class).get(a).changeImage(nums[a], Color.RED);
        getObjects(Bar.class).get(b).changeImage(nums[b], Color.RED);
        //playSound();
        Greenfoot.delay(1);
        changeImages();
    }

    public void playSound(){
        if(speed <= 50) Greenfoot.playSound("ah.wav");
    }

    public boolean isSorted() {
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
