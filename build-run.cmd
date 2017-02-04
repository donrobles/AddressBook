rmdir /S /Q out
rmdir /S /Q compiled
mkdir out
mkdir compiled
REM For the life of me, I cannot figure out what I'm doing wrong with compiling the app.
javac -sourcepath src; src\addressbook\* -d out\
REM I cannot get the H2 DB to compile correctly such that the Java classes will see it.
REM Right now, it's working in IDEA, but IDEA is doing something differently from what I am in this script.
REM When compiled by IDEA, the AddresBook.jar file has H2 decompressed in a org\h2\{Classes} file setup.
REM When this script comiles, it simply places the H2-1.4.193.jar file in the root directory of AddressBook.jar.
jar cvfm compiled\AddressBook.jar src\META-INF\MANIFEST.MF -C out\ . -C db\ .
java -jar compiled\AddressBook.jar