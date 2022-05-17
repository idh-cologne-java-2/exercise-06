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
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			if (i > 100)
				break;
		}
		System.out.println("TTR: " + d.ttr());
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
	
	private double ttr() throws IOException {
		//String wird in Set gespeichert 
		Set<String> set = new HashSet<String>(); 
		//benötigen das Dokument
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		//eine Zählervariable
		double counter = 0;
		//Größe zunächst 0
		double si = 0; 
		//für jedes token in der Datei d...(token kann überall verwendet werden)
		for (String token : d) {
			//füge dem Set das token hinzu, wenn es nicht schon in dem Set existiert 
			set.add(token);
			//zähle weiter
			counter++;
		}
		//Größe von dem Set
		si = set.size();
		
		//zuletzt müssen alle Elemte die hinzugefügt wurden durch die Anzahl vom Counter geteilt werden.
		//Hinzugefügt wurden nur Elemente die es noch nicht gibt, Counter hat jedoch alle Elemte gezählt, auch wenn es das schon gibt.
		return si / counter;
		
	}
	
	
}
