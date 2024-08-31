##Flappy Bird game

![flappy-bird](https://github.com/user-attachments/assets/e7014234-63a4-429e-af5c-bed9a29b2b51)

Guide to the player:

Navigate the flappy bird through a series of pipes using the space bar key to make the bird jump; and achieve the highest score possible by avoiding obstacles. Incase you bump against the pipe and lose the game, press 'R' to restart. Good luck and Have Fun :)


How the game works:

It will have two classes for the two objects: the Bird and the Pipe.(I will make use of array of pipes to store the pipes involved in the game). The above classes will also take care of creating the objects, their components, sounds, drawing them, changing their positions and also updating them when necessary. I will make use of StdDraw to draw the Bird and Pipe object and StdAudio to make sounds as the bird jumps or the player looses.

The "Project.java" class contains the main class and the "Flappy Bird" class will contain different calls of methods in the Bird and pipe object with in an infinite while loop, pipes will be drawn with random value of 'y' so that they have random gap of course with a predetermined range. Additionally, It will also contain other methods of its own to restart the game, check for collision, and also keep track of the current and high scores.

The pictures of the bird will be included in a jpeg file. However, for the pipe I will be using two rectangles to make the top and bottom of the pipe. As for the sound, I will be using selected external sounds. I think this simplifies and enhances the drawing and sound effects of the game.

Look at the comments in each of the classes for specific details.

No command line arguments are required for this game.

TO CONTROL THE BIRD: the player uses the space bar key.
To RESTART THE GAME: the player uses the 'R' key. 



 
