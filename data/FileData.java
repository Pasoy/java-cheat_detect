package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileData {

	public static final String DESKTOP = System.getProperty("user.home") + "/Desktop/";
	public static final String NEWLINE = System.getProperty("line.separator");
	private File file;

	/**
	 * Constructor for class: FileData.java
	 */
	public FileData(File file) {
		setFile(file);
	}

	/*
	 * ****************** * METHODS * ******************
	 */

	/**
	 * Find all the files in a directory and subdirectories and add them to a list
	 * 
	 * @param dir
	 * @return
	 */
	public List<File> findFiles(File dir) {
		ArrayList<File> result = new ArrayList<>();
		File[] files = dir.listFiles();

		if (dir == null || !dir.isDirectory()) {
			throw new IllegalArgumentException("The file does not exist");
		}
		for (File f : files) {
			if (f.isDirectory()) {
				for (File fil : findFiles(f)) {
					result.add(fil);
				}
			} else if (f.isFile()) {
				result.add(f);
			}
		}
		return result;
	}

	/**
	 * Compares two files with their length and bytes.
	 * If they are different return false.
	 * 
	 * @param f1
	 * @param f2
	 * @return
	 */
	public boolean compare(File f1, File f2) {
		boolean result = false;
		try (FileInputStream fi1 = new FileInputStream(f1); FileInputStream fi2 = new FileInputStream(f2);) {
			if (f1.length() == f2.length()) {
				int n = 0;
				byte[] b1;
				byte[] b2;
				while ((n = fi1.available()) > 0) {
					b1 = new byte[n];
					b2 = new byte[n];
					fi1.read(b1);
					fi2.read(b2);
					if (!(Arrays.equals(b1, b2) == false)) {
						result = true;
					}
				}
			} else {
				result = false;
			}

		} catch (FileNotFoundException fne) {

		} catch (IOException ie) {

		}
		return result;
	}
	
	public void compareAll() {
		List<File> fl = findFiles(getFile());
		for(int i = 0; i < fl.size(); i++) {
			File fs = fl.get(i);
			for(File f : fl) {
				if(!(f.getName().equals(fs.getName()))) {
					if(compare(f, fs)) {
						System.out.println(fs.getName() + " compared to " + f.getName() + ": " + compare(f, fs));
					}
				}
			}
		}
	}

	/*
	 * ****************** * SETTER - GETTER * ******************
	 */

	/**
	 * Returns the File file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Set the File file to the given value
	 */
	public void setFile(File file) {
		if (file == null) {
			throw new IllegalArgumentException("File does not exist!");
		}
		this.file = file;
	}

	/**
	 * Returns the String path of the file
	 */
	public String getPath() {
		return getFile().getPath();
	}

}
