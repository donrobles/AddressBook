rmdir /S /Q out
rmdir /S /Q compiled
mkdir out
mkdir compiled
javac -sourcepath src; src\addressbook\* -d out\
jar cvfm compiled\AddressBook.jar src\META-INF\MANIFEST.MF -C out\ .
java -jar compiled\AddressBook.jar