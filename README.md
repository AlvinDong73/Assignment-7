# What I Learned From the JetBrains article

I learned that you can check if an object is a certain class (or a subclass of that class)
by using the `instanceof` keyword. This can be used while looping over a list of objects
with a shared parent class to have specific behavior occur if an object is a certain
subclass of the parent class.

# What I Changed

I added a main loop to the driver file that continuously processes input until the user is done.
It also saves the results of what the user inputted into a csv file, and when the program is initialized,
the list of games is initialized from data that was saved in the csv file.

I also added methods to VideoGame and its subclasses in order to accommodate for this saving and loading
system, and renamed RPG to SinglePlayerGame to more accurately reflect the class-subclass relationship.

# Overloading and Overrides

I added `serialize()` as an abstract method that returns a String to the VideoGame class.
Both SinglePlayerGame and OnlineGame override this method.
I did this in order to utilize polymorphism and have both SinglePlayerGame and OnlineGame
return differently formatted strings for their save information.

I overloaded the constructors for VideoGame, SinglePlayerGame, and OnlineGame.
I added a constructor that accepts a parameter for hours played,
and I also added the hoursPlayed field to VideoGame.
I overloaded the constructors so that the program can easily initialize the hoursPlayed field
when reconstructing the object from the csv file. The constructor withour the hours parameter
gives games an initial hoursPlayed value of 0.

# Challenges

A significant challenge was finding a spot where overloading would enhance the program.
I ended up adding a field to the parent class and providing 2 different constructors for programmers to call.

# AI Usage Disclosure
No AI was used directly to generate any code or documentation, but I used AI to help brainstorm possible
locations where I could utilize overloading.