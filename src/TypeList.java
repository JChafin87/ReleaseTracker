import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


public class TypeList {
	public LinkedList<String> types;

	public LinkedList<String> getTypes() {
		return types;
	}

	public void setTypes(LinkedList<String> types) {
		this.types = types;
	}


	public TypeList() {
	
	}

	public void readFile() {
		String fileName = "types.dat";
        String line = null;
        LinkedList<String> testList = new LinkedList<String>();
        try {
            // Reads from types.dat and stores to typeList
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = "";
            while((line = bufferedReader.readLine()) != null) {
            	testList.add(line);
            }
        bufferedReader.close();    
        }
       catch(FileNotFoundException ex) {
           System.out.println("Unable to open file '" + fileName + "'");                
       }
       catch(IOException ex) {
           System.out.println("Error reading file '"+ fileName + "'");
       }
       types = testList; 
		
	}
	
	public void add(String s) {
		this.types.add(s);
	}
	
	public void remove(String s) {
		int index = 0;
		String current = this.types.get(index);
		if(current==null) {
			this.types.remove(index);
		}
		else {
			while(current != null) {
				if(current.equals(s)) {
					this.types.remove(index);
					break;
				}
				else {
					index++;
					current = this.types.get(index);
				}
				
			}
		}
	}
	public void remove(int i) {
		this.types.remove(i);
	}
	
	public void writeFile()  {
		LinkedList<String> s = this.types;
		try{
		PrintWriter writer = new PrintWriter("types.dat", "UTF-8");
		for (int i = 0; i<s.size(); i++) {
			writer.println(s.get(i));
			
		}
		writer.close();
		}
		catch (Exception exc) {
			
		}
	}
	public String[] toStringArray() {
		String[] sA = new String[this.types.size()];
		for (int i = 0; i<this.types.size(); i++) {
			sA[i] = this.types.get(i);
		}
		return sA;
	}
	
}

