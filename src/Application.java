import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//to keep it simple, you created test.txt right in the project folder
//normally, you'd use a full path to find an existing file somewhere
//most of this lesson is not about reading the file
//but handling exceptions

public class Application {

	public static void main(String[] args) {

		File file1 = new File("test.txt");
		// when the file is in the program, you don't need anything except its name
		// don't forget to import the java.io stuff

		// what's coming next was not typed in the order you see it here.
		// you had to add code by clicking the error warning button
		// then typing other stuff
		
		BufferedReader br = null;
		//you can declare an new object (like here)
		//and initialize it later (see a couple lines down, starting "br")
		//or of course you can do it all on one line like you're used to
		//LATER: it's now initialized here, so that you can make the close method work below
		//teacher doesn't say whether initialing stuff to null is best practice or not.

		try {
			FileReader fr = new FileReader(file1);
			br = new BufferedReader(fr);
			// import java.io

			String line;

			while ( (line = br.readLine()) != null) {
				System.out.println(line);
			}
			// the line=br part also gave an error button
			// selected "add catch" option (it goes below)
			
			//after typing it, you put it inside a while loop
			//note the cool thing you can do here:
			//that loop means, so long as there is something on a line to read
			//print it out.
			//stop when there is nothing (null)
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("File not found: " + file1.toString());
		}
		
		// two-letter variables is usually bad practice
		// but for something as quick as FileReader, it's OK
		// don't forget to import the java.io stuff
		// your code still gave an error, so you selected
		// the surround with try-catch option
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Unable to read file: " + file1.toString());
		}
		
		finally {
			//remember that finally blocks always execute
			//whether exceptions are thrown or not
			//you could put the whole CLOSE stuff into this block.
			//even the try catch parts
			
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Cannot close the file: " + file1.toString());
			}
			catch (NullPointerException ex) {
				System.out.println("This file was never opened: " + file1.toString());
			}
		}
		
		//I missed why, but you want to close the file when you're done reading it
		//probably to save memory (most files are longer than 3 lines!)
		//the most elementary is:
		//br.close();
		//but that alone gives an error. so...
		
		//try it and select try-catch from error menu
		//but you get another error at "br"
		//to fix it, select "initialize variable" option
		//that will turn the declared line up above
		//into an initialized line, initialized at null
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Cannot close the file: " + file1.toString());
		}
		catch (NullPointerException ex) {
			System.out.println("This file was never opened: " + file1.toString());
		}
	
	}

}

//that's a lot of notes!
