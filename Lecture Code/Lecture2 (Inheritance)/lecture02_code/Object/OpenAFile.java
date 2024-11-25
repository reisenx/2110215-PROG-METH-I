package Object;

import java.io.FileInputStream;

class OpenAFile {
	FileInputStream aFile = null;

	OpenAFile(String filename) {
		try {
			aFile = new FileInputStream(filename);
		} catch (java.io.FileNotFoundException e) {
			System.err.println("Could not open file " + filename);
		}
	}

	protected void finalize() throws Throwable {
		super.finalize();
		if (aFile != null) {
			aFile.close();
			aFile = null;
		}
	}
}
