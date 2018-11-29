package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class KmlWriter {

	private final BufferedWriter writer;

	public KmlWriter(String output)throws IOException
	{
		writer = new BufferedWriter(new FileWriter(output));
	}
}
