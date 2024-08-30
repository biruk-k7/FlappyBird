public class Project {
    public static void main(String[] args) {

        
        //setting up the canvas
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(0, 800);
        StdDraw.setYscale(0, 600);
        StdDraw.enableDoubleBuffering();

        //creating Bird and Pipe objects
        Bird bird = new Bird(117, 300);

        //storing the pipe objects in an array of pipes
        //two pipes are created with random y values but predetermined x values
        Pipe[] pipes =new Pipe[2];
        pipes[0] = new Pipe(800, Math.random() * 400 + 100);
        pipes[1] = new Pipe(1150, Math.random() * 400 + 100);

        //initializing the score
        int score = 0;

        //initialize the game
        FlappyBird.game(score,pipes);

    }

}
