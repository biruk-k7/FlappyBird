public class Bird {
    private double x;
    private double y;
    private double velocity;



    //Constructor
    public Bird(double x, double y) {

        this.x = x;
        this.y = y;
        this.velocity = 0;
    }
    public double getY() {
        return y;
    }
    public double getX() {
        return x;
    }

    //draw the bird
    public void draw() {

        StdDraw.picture(x, y, "bird.png", 35, 32);
    }

    //Gravity
    public void update() {

        velocity -= 0.5;
        y += velocity;
    }

    //Method to increase the velocity when the bird jumps
    public void jump() {

        velocity = 5;
        //SOLVED
        StdAudio.playInBackground("flappy-bird.wav");
    }

}