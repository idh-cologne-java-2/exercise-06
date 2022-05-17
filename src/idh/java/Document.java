package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Document implements Iterable<String> {
	String documentText;

	public static Document readFromFile(File f) throws IOException {
		
		
		FileReader fileReader = new FileReader(f);
		int ch;
		StringBuilder b = new StringBuilder();
		while( (ch = fileReader.read()) != -1 ) {
			b.append((char) ch);
		}
		fileReader.close();
		Document doc = new Document();
		doc.documentText = b.toString();
		
		
		
		return doc;
	}
	
	public String getDocumentText() {
		return documentText;
		
	}

	public void setDocumentText(String documentText) {
		this.documentText = documentText;
	}
	
	
	public static final void main(String[] args) throws IOException {   // Hier wird die ttr Methode für das Dracula Dokument aufgerufen
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		for (String token : d) {
//			System.out.println(i++ + ": " + token + " ");
			i++;
//			if (i > 100)
//				break;
		}
		System.out.println(i);
		System.out.println(d.ttr(d));
	}
	
	
	
	public double ttr(Document document) {  		// dies ist die Methode die dem Dokument übergeben werden muss
		Set<String> types = new HashSet<String>();
		double ratio = 0;
		double tokens = 0;
		for (String s : document) {
			types.add(s);
			tokens++;  				////bei jedem Durchgang wird die Anzahl der Token erhöht
		}
		ratio = types.size() / tokens;
		return ratio;
	}
	
	

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			
			
			

			StringTokenizer tokenizer = new StringTokenizer(documentText);
			
			@Override
			public boolean hasNext() {
				return tokenizer.hasMoreTokens();
			}

			@Override
			public String next() {
				return tokenizer.nextToken();
			}
			
		};
	}
	

	
	
}