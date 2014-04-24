JFLAGS = -g -cp $(BIN) -d $(BIN)
JC = javac
BIN = bin
SRC = src

ScrollerGame : $(BIN)/Skeleton.class $(BIN)/Board.class $(BIN)/Character.class
	echo "java -cp bin Skeleton" > ScrollerGame
	chmod 755 ScrollerGame

$(BIN)/Skeleton.class : $(SRC)/Skeleton.java $(BIN)/Board.class $(BIN)/Character.class
	$(JC) $(JFLAGS) $(SRC)/Skeleton.java

$(BIN)/Board.class : $(SRC)/Board.java $(BIN)/Character.class
	$(JC) $(JFLAGS) $(SRC)/Board.java

$(BIN)/Character.class : $(SRC)/Character.java
	$(JC) $(JFLAGS) $(SRC)/Character.java

clean:
	        $(RM) $(BIN)/*.class
		rm ScrollerGame
