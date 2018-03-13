import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class F2 {
public static void main(String[] args) {
	File f=new File("d:/FileHandling/java.txt");
	try {
		FileReader fr=new FileReader(f);
		try {
			int ff=fr.read();
			while(ff!=-1)
			{
			System.out.print((char)ff);
			ff=fr.read();
			}
			} catch (IOException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
}
