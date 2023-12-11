run:	
	java -cp bin/classes app.cervejaApp


compile&run:
	javac -d bin/classes src/estoque/*.java src/app/*.java
	java -cp bin/classes app.cervejaApp


#para Linux	
rm:
	rm -f bin/classes/estoque/*.class
	rm -f bin/classes/app/*.class


#para Windows
del:
	del /Q bin\classes\estoque\*.class
	del /Q bin\classes\app\*.class