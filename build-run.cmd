rmdir /S /Q out
rmdir /S /Q compiled
mkdir out
mkdir compiled
javac -sourcepath src; src\addressbook\* -d out\
cd out
jar xvf ..\db\h2-1.4.193.jar
cd ..
jar cvfm compiled\AddressBook.jar src\META-INF\MANIFEST.MF -C out\ .
java -jar compiled\AddressBook.jar