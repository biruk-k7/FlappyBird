public class Pipe {

    private double x;
    private double y;
    static final double GAP = 500;

    static final double WIDTH = 45;

    public Pipe(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {

        return x;
    }

    public double getY() {

        return y;
    }

    //Bird doesn't move horizontally just the pipe moves towards the bird :)
    public void move() {
        x -= 4.8;
    }

    public void draw() {

        //we use two rectangles to draw the pipe
        StdDraw.setPenColor(80,220,120);
        StdDraw.enableDoubleBuffering();

        //top
        StdDraw.filledRectangle(x,y+GAP,WIDTH/2,400);


        //bottom
        StdDraw.filledRectangle(x,y-GAP,WIDTH/2,400);

    }


}