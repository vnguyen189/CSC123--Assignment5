import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DirectoryAnalyzer {
private String directoryName;

public DirectoryAnalyzer(String directoryName) throws Exception {
	super();
	this.directoryName = directoryName;
	
	File directory = new File(directoryName);
	
	if(!directory.exists()) {
		System.out.printf("The directory \"%s\" does not exist", directory);
		System.exit(0);
	}
	else if(!directory.canRead()) {
		System.out.printf("The directory \"%s\" cannot be read", directory);
		System.exit(0); }
	else if(!directory.isDirectory()) {
		System.out.printf("The directory \"%s\" is not a directory", directory);
		System.exit(0);
	}
	
	File[] files=directory.listFiles();
	int fileCount = 0;
	int sumDigit = 0;
	int sumSpace = 0;
	int sumAlphabet = 0;
	double sumfileSize = 0;
	
	System.out.println("File Name \t\t Size \t\t Alpha Chars \t\t Numeric Chars \t\t\t Spaces");
	
	for(File f:files) {
		fileCount++;
		int digitCounter = countDigit(f);
		int spaceCounter = countSpace(f);
		int alphabetCounter = countAlphabet(f);
		
		sumDigit += digitCounter;
		sumSpace += spaceCounter;
		sumAlphabet += alphabetCounter;
		sumfileSize += f.length();
		System.out.println(f.getName() + "\t\t\t " + f.length() + "\t\t  " + alphabetCounter + "\t\t\t\t" + digitCounter + "\t\t\t  " + spaceCounter);
	}
	System.out.println("Total Files \t\t\t\t\t:" + fileCount);
	System.out.println("Total Alpha Chars \t\t\t\t:" + sumAlphabet);
	System.out.println("Total Numeric Chars \t\t\t\t:" + sumDigit);
	System.out.println("Total Space Chars \t\t\t\t:" + sumSpace + "\n");
	
	if (sumfileSize < 1024)
	System.out.printf("Total Size Disk \t\t\t\t: %.1f bytes \n", sumfileSize);
	
	else if (sumfileSize >= 1024 && sumfileSize < 1024*1000) 
	System.out.printf("Total Size Disk \t\t\t\t: %.1f KBs \n", (sumfileSize/1000));
	
	else if (sumfileSize >= 1024*1000 && sumfileSize < 1024*1000000) 
	System.out.printf("Total Size Disk \t\t\t\t: %.1f MBs \n", (sumfileSize/1000000));
	
	else if (sumfileSize >= 1024*1000000 && sumfileSize < 1024*1000000000)
	System.out.printf("Total Size Disk \t\t\t\t: %.1f GBs \n", (sumfileSize/1000000000));
	
}

	private int countSpace (File f) throws IOException {
		int spaceCounter = 0;
		InputStream in = new FileInputStream(f);
		byte b;
		while ((b = (byte) in.read()) != -1) {	
			if (Character.isSpaceChar((char) b) == true)
				spaceCounter++;
	}
		in.close();
		return spaceCounter;
	}
	private int countAlphabet (File f) throws IOException {
		int alphabetCounter = 0;
		InputStream in = new FileInputStream(f);
		byte b;
		while ((b = (byte) in.read()) != -1) {	
			if (Character.isAlphabetic((char) b) == true)
				alphabetCounter++;
	}
		in.close();
		return alphabetCounter;
	}
	
	private int countDigit (File f) throws IOException {
		int digitCounter = 0;
		InputStream in = new FileInputStream(f);
		byte b;
		while ((b = (byte) in.read()) != -1) {	
			if (Character.isDigit((char) b) == true)
				digitCounter++;
	}
		in.close();
		return digitCounter;
	}
	}