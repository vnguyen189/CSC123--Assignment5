import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
public class FileCopy {
	private String sourceTXT;
	private String targetTXT;

	public FileCopy(String sourceTXT, String targetTXT) throws IOException {
		super();
		this.sourceTXT = sourceTXT;
		this.targetTXT = targetTXT;
		
		File sourceFile = new File (sourceTXT);
		Scanner inputFile = new Scanner(sourceFile);
		InputStream in = new FileInputStream(sourceTXT);
		
		File f = new File(targetTXT);
		FileOutputStream out=null;
		out= new FileOutputStream(f);
		
		if (!sourceFile.exists()) {
			System.out.println("File not found!");
			System.exit(0);
		}
		else if (!sourceFile.isFile() || !f.isFile()) {
			System.out.println("Either source file or target file or both files are not files!");
			System.exit(0);
		}
		else if (f.isDirectory() || sourceFile.isDirectory()) {
			System.out.println("Target file is a directory!");
			System.exit(0);
		}
		else if (f.exists()) {
			System.out.println("Target file already existed!");
			System.exit(0);
		}
		
		byte[] bytes= in.readAllBytes();
			out.write(bytes);
		
		System.out.println(in.read(bytes) + " bytes successfully copied from " + sourceTXT + " to " + targetTXT);
		
		out.flush();
	

		out.close();
		in.close();
		inputFile.close();
	}

}
