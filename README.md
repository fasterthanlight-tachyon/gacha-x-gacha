# gacha-x-gacha
A (gacha) meme project

## Running the application
### Prerequisites:
 - Java 11 (at least), and
 - Maven (optional; it needs to support your version of Java)

Once you have Java 11 installed, make sure your `JAVA_HOME` system environment variable points to your installation of Java 11.

### Instructions
Go to command prompt or some other equivalent terminal (I personally like command prompt/PowerShell since it's easy to stop the application as needed) and navigate to the project folder.  
Once there, type `.\mvnw exec:java` and press enter. (If you have Maven installed on your computer, then replace `.\mvnw` with `mvn`.) A _lot_ of text will appear on screen, but don't worry. It's there for logging purposes in case something blows up.  
Navigate to `localhost:8080` in your favorite browser to find the main page of this application.

If you want to stop the program, press `Ctrl + C` and answer `Y` to `Terminate batch job (Y/N)?` ~~to prevent it from ruining your life later. It's happened to me. I'm still recovering~~ just for good measure.
