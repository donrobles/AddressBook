REM Remove the older directories.
rmdir /S /Q out && rmdir /S /Q compiled
REM Create the required directories
mkdir out && mkdir compiled
REM Compile the .Java files to .class files and place them in the "out" directory.
javac -sourcepath src; src\main\java\runner\* -d out\
REM Move into the "out" directory, extract the H2 JAR, and return to project root.
cd out && jar xvf ..\db\h2-1.4.193.jar && cd ..
REM Compile everything in the "out" directory into AddressBook.jar, placing it in the "compiled" directory.
jar cvfm compiled\AddressBook.jar src\META-INF\MANIFEST.MF -C out\ .
REM Run the AddressBook app.
java -jar compiled\AddressBook.jar