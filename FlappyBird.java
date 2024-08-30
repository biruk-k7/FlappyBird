//GAME Scene
import java.awt.*;
public class FlappyBird {
    private static boolean gameover =false;
    private static int highScore = 0;

    public static void game(int score, Pipe[] pipes) {
        Bird bird = new Bird(117, 300);

        //new pipes
        Pipe pipe = pipes[0];
        Pipe pipe1 = pipes[1];

        //the game should be in an infinite loop until the bird hits the pipe
        while (true) {

            StdDraw.clear(StdDraw.CYAN);
            StdDraw.enableDoubleBuffering();

            //bird is updating or falling as a result of gravity
            bird.update();

            //pipe moves toward the bird
            //remember bird doesn't move horizontally
            pipe.move();

            //new pipe
            pipe1.move();


            bird.draw();
            pipe.draw();
            pipe1.draw();

            //pipe should also be drawn, but we need to figure out how to draw it
            if (StdDraw.isKeyPressed(32)) {

                // Space bar key
                //as the bird jumps an audio also plays
                bird.jump();


            }

            if (checkCollision(bird, pipe, pipe1)) {

                //the checkCollision method is not complete but the condition is as follows
                //we might need to adjust some functions depending on how the checkCollision method turns out
                gameOver(score);
            }

            //this condition checks as a player successfully passes the pipe obstacle
            //or as the bird passes between the gap
            if (pipe.getX() < bird.getX()-100) {

                //increase score and create new pipe with random x and y values
                score++;
                pipe = new Pipe(800, Math.random() * 400 + 100);
            }

            if (pipe1.getX() < bird.getX() - 100) {

                //score increase by 1
                score++;

                //new pipe
                pipe1 = new Pipe(pipe.getX() + 450, Math.random() * 400 + 100);
            }


            //score is always displayed at the top of the screen
            StdDraw.setPenColor(0,255,0);
            StdDraw.text(700, 550, "Score: " + score);

            StdDraw.show();
            StdDraw.pause(20);
        }
    }


    private static boolean checkCollision(Bird bird, Pipe pipe,Pipe pipe1) {

        //store all the values of bird, pipe, and pipe1 for easier computation
        double birdY = bird.getY();
        double birdX = 150;
        double pipeX = pipe.getX();
        double pipeY = pipe.getY();
        double pipe1X = pipe1.getX();
        double pipe1Y = pipe1.getY();
        double gap = Pipe.GAP;
        double pipeWidth = Pipe.WIDTH;

        //the following logic takes care of when the player looses
        //essentially, it encompasses what to do when they goes outside the playing canvas, gravity wins against them, or when the player bumps into the pipe
        return (birdY > 600 || birdY < 16 || (birdX > pipeX && birdX < pipeX + pipeWidth &&
                !(birdY > pipeY-gap+400 && birdY < pipeY + gap-400))||((birdX > pipe1X && birdX < pipe1X + pipeWidth &&
                !(birdY > pipe1Y-gap+400 && birdY < pipe1Y + gap-400))));

    }


    private static void gameOver(int score) {

        gameover =true;

        StdDraw.pause(20);
        StdDraw.setPenColor(StdDraw.RED);
        Font font = new Font("Arial", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.text(400, 350, "Game Over!");

        Font font1 = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font1);
        StdDraw.text(400, 320, "Score: " + score);
        StdDraw.text(400,290,"High Score: " + highScore(score));




        StdDraw.show();

        StdAudio.play("gameover.wav");
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.text(400,200,"Press 'R' to restart :) ");
        StdDraw.show();

        //creating the new pipes when the player restarts
        Pipe[] pipes =new Pipe[2];
        pipes[0] = new Pipe(800, Math.random() * 400 + 100);
        pipes[1] = new Pipe(1150, Math.random() * 400 + 100);

        while (true){

            //we use 'R' to restart the game when it's game over
            if(StdDraw.isKeyPressed(82)&&gameover) {

                game(0,pipes);

                //set game over  to false
                gameover=false;

            }


        }

    }
    private static int highScore(int score){

        if(score >highScore){
            highScore = score;

        }
        return highScore;

    }
}

