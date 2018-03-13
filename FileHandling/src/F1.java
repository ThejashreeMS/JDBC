import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class F1 {
public static void main(String[] args) {
	File f=new File("D:/FileHandling/java.txt");
	FileWriter fw=null;
	try {
		fw=new FileWriter(f);
		fw.write("Hello");
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	finally
	{
		try {
			fw.flush();
			fw.close();
			System.out.println("File written");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		boolean z=false;
		try {
			z = f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("File created="+z);
		
	}

}
