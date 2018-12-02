package File_format;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import GIS.GISLayer;
import GIS.GISProject;

/**
 * this class get a path to a folder, it search for all CSV files inside, and builds a project with it.
 * it store it as a local variable, and also returnes it in the builder.
 * @author Shiran.b
 *
 */
public class MultiCSV {
	
	private ArrayList<String> files;
	private GISProject project; 
	
	public GISProject getGISProject()
	{
		return project;
	}
	
	/**
	 * constractor. init the internal files array.
	 */
	public MultiCSV()
	{
		files = new ArrayList<String>();
	}

	/**
	 * this function read the folder path, and recursvly find all files with csv extension.
	 * @param path
	 */
	public void readfiles(String path){
		File file = new File(path);
		for(File file2 : file.listFiles())
		{
			if(file2.isDirectory())
			{
				readfiles(file2.toString());
			}
			else
			{
				if(file2.getName().contains(".csv"))
				{
					this.files.add(file2.getPath());
				}
			}
		}
	}
	
	/**
	 * prints the files array inside the MultiCSV
	 */
	public void printArray()
	{
		System.out.println(files.toString());
	}
	
	/**
	 * this function builds the project, the "reader" function must be run first in order for this function to work properly
	 * @return
	 * @throws IOException
	 */
	public GISProject buildProject() throws IOException{
		this.project = new GISProject();
		GISLayer layer;
		if(this.files.isEmpty() || this.files == null)
		{
			throw new RuntimeException("must run \"readfiles\" function first!");
		}
		Iterator<String> iter = this.files.iterator();
		CSVReader csv_file;
		while(iter.hasNext())
		{
			String s = iter.next();
			csv_file = new CSVReader(s);
			layer = new GISLayer(csv_file.readFromCSV());
			project.add(layer);
		}
		return project;
	}
}
