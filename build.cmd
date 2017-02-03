rmdir /S /Q out
rmdir /S /Q compiled
mkdir out
mkdir compiled
javac -d out -sourcepath src; src\addressbook\*
jar cvfm compiled\AddressBook.jar META-INF\MANIFEST.MF -C out\ .
java -jar compiled\AddressBook.jar