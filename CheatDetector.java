import java.io.File;

import data.FileData;

public class CheatDetector {
	
	/*
	 * A cheat detector is supposed to find duplicate files.
	 * 
	 * For this we need the class File (look it up in the API). 
	 * A file stands for a pathname in your file system, it can be either a directory or a file. 
	 * Important methods: isDirectory(), isFile(), listFiles(), length().
	 * 
	 * First we need a list of all files. 
	 * Create a method List<File> findFiles(File dir) that finds all files in a given directory. 
	 * Note: in a directory there may be files and subdirectories. 
	 * Files are added to the result list, for directories call the same method again (that’s called a recursive call) and add the result of this call to the list (if it isn’t null).
	 * 
	 * Second we need a method to compare files:  boolean compare(File f1, File f2). 
	 * Check first the files’ lengths. 
	 * If they are different return false. 
	 * Otherwise open the files as binary files and read both into a byte array. 
	 * Then compare the bytes.
	 * 
	 * Third we need a for-loop on our list. 
	 * Compare every file with all files behind it in the list (i.e. compare file i with file i+1,i+2 etc. If you find 2 equal files print their filenames.
	 * 
	 * The name of the directory should be a command line parameter.
	 * 
	 * This method obviously only catches the dumbest cheaters. Can you devise a better method?
	 */
	
	public static FileData fd;
	public static File dir, ff1, ff2, ff3, ff4, ff5, ff6;
	
	public static void main(String[] args) {
		for(String s : args) {
			fd = new FileData(new File(s));
		}
		
		fd.compareAll();
	}

}
