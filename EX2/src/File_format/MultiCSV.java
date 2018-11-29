package File_format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import GIS.GISLayer;
import GIS.GISProject;

public class MultiCSV {
	
	private ArrayList<String> files;
	private BufferedWriter writer;
	private BufferedReader reader;
	private GISProject project; 
	
	public GISProject getGISProject()
	{
		return project;
	}

	public MultiCSV()
	{
		files = new ArrayList<String>();
	}

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

	public void printArray()
	{
		System.out.println(files.toString());
	}
	
	public GISProject buildProject() throws IOException{
		this.project = new GISProject();
		GISLayer layer;
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
