# Drop-and-Catch-game

Simple "drop and catch" game.. The goal is to collect as many fruits as you can in the basket. If you miss a fruit, the game is over. <br>
Programing language: Java.

--------------
Requirements : 
--------------

Java Development Kit (JDK): https://www.oracle.com/java/technologies/javase-jdk16-downloads.html <br>
Eclipse IDE: https://www.eclipse.org/downloads/ <br>
(or other Integrated Development Environment (IDE), such like IntelliJ IDEA) <br> 

----------
Execution: 
----------

After extracting a Drop-and-Catch-game file and opening an Eclipse IDE, you should import a project from file system to  Project Explorer. Go to File->Open Project From File System and click on the Directory button next to import source text field. Then find a folder where you extracted he file, select folder DropGame and click Finish.  

In Project Explorer go to DropGame->src->default package->Main.java. To run a java file click on a run button(green circle with an arrow in toolbar) and enjoy the game.

----------------
Java code guide: 
----------------

Source code contains six classes: 

Ball class contains a constructor with three arguments (x and y positions and ball diameter). Move method increases the y coordinate by 2 pixels at the beginning of the game. The number of pixels will change through out the game by one after every fifth ball.  

Collector class contains constructor with four arguments (x and y position and width and height). Methods keyPressed and keyReleased change x coordinate of collector. They will be called in GamePanel class whenever the left or right arrow key is pressed by user.

Score class contains a constructor with two arguments (x and y coordinates). Current score is instantiated to zero, but it will increase through out the game whenever the ball intersects constructor. 
 
GamePanel runs on a thread. While thread is active, run method checks collisions (ball hit bottom of the screen or ball intersects collector), updates all variables and object’s positions (move method) and repaint everything to the screen (60 frames per second). Thread is active while boolean value running is equal to TRUE. This value will change to FALSE when a ball miss the collector and hit a bottom of the panel. In that case the game thread will no longer be active and the game is over. 
-newBall method creates a new Ball object on the top of the panel with a random x coordinate value. 
-newCollector method creates a new Collector object on the bottom of the panel.