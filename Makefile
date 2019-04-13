all:
	javac ArrayLineBreakStrategy.java Component.java Composition.java LineBreakStrategy.java Main.java SimpleLineBreakStrategy.java TexLineBreakStrategy.java

clean:
	rm -f *.class
