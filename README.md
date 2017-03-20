## NuPack for Nulogy

### Brief Description

This is part of a coding exercise for Nulogy. The goal is to create a simple library called NuPack to calculate packing costs for different packages.

### To Build and Run

This project consists of application source code and test code. The NuPack source for the utility is found in `src/main` while the test code is found in `src/test`. There is a single application class and a single associated test class. I tried to keep things as conventional as possible.

Generally speaking I used Eclipse as both the writing environment for writing code and building the application and running tests. 

You can also use ant to execute tests built via Eclipse running the command `ant tests` in the project root. 

### Technical Requirements

I've written this in Java 8 (and it's highly likely to be compatible with Java 7). In particular I used the Oracle JDK version 1.8.0\_45 with JRE 1.8.0\_121. I also used Eclipse Neon Java IDE with JUnit 4.12 included. 

You can get Eclipse Neon [here](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/marsr) if needed. 
You can get the JUnit 4 jar [here](https://github.com/junit-team/junit4/wiki/Download-and-Install) if you need it to be added to your libraries/sourcepath. 

I also included an ant build file using the latest version of ant (1.10.1). You can get this version of ant from [here](https://ant.apache.org/bindownload.cgi)