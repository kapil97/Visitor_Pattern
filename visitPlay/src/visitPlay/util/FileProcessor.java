package visitPlay.util;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

/**
 * FileProcessor Class
 */

public final class FileProcessor{
	private final BufferedReader reader;
	private String line;

	public FileProcessor(String inputFilePath) 
		throws InvalidPathException, SecurityException, IOException {
		
		if (!Files.exists(Paths.get(inputFilePath))) {
			throw new FileNotFoundException("invalid input file or input file in incorrect location");
		}

		reader = new BufferedReader(new FileReader(new File(inputFilePath)));
		line = reader.readLine();
	}

	/**
	 * to pull a line and send it to the driver for further processing
	 * @return
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public String poll() throws NumberFormatException, IOException {
		if (null == line) return null;

		String newValue = (line.trim());
		line = reader.readLine();
		return newValue;
	}

	/**
	 * File close method.
	 * @throws IOException
	 */
	public void close() throws IOException {
		try {
			reader.close();
			line = null;
		} catch (IOException e) {
			throw new IOException("failed to close file", e);
		}
	}
	@Override
	public String toString(){
		String returnValue="File Processor Class which will process file line by line";
		return returnValue;
	}
}
