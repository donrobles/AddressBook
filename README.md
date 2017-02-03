#Address Book Search
This is basic command line Java application that will let you create an in memory address 
book record, and allow you to search the address book by first/last name, displaying any
matching records.

##Test Inputs
The application should be able to fulfill the following command...

```
input>add John, Doe1, 503-555-1212, 503-555-1234, jdoe@mailinator.com, john@mailinator.com
output>added John Doe1
```

```
input>add John, Doe2, 503-555-1212, jdoe1@mailinator.com
output>added John Doe2
```

```
input>search John
outpt>John Doe1
output>John Doe2
```

##Build/Running the App

####Clone the project
In order to run the application, `clone` the repo into a directory of your choice, such as...

```
cd C:\{your_directory}

git init

git clone https://github.com/readTheLine/java_command_line_app.git
```
  
####Run the build-run script
Next, `cd` into the project directory, and simply run the `build-run.cmd` script. It'll automatically 
compile the .java files into .class files, compile the .class files into a JAR, and then run the app
from JAR file.
```
build-run.cmd
```

####You're done
There's nothing more you need to do in order to get this application running. Hope it helps you out!
 
##Credits
I used this [BaristaMatic](https://github.com/gregsandell/CoffeeShop) project as a guide on how to read 
the inputs from the Command Line, but most everything else I either changed, or did it myself. 