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
		
			ttr(d);   //Aufruf der ttr-Methode mit dem Dracula Text
						//don't know this kinda looks weird
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
	
	public static double ttr(Document document) { //Type-Token-Relation Methode der man ein Dokument übergeben muss
		Set<String> types = new HashSet<>();      //Set-Objekt, unsortiertes HashSet mit einzigartigen Einträgen (Types)
		double tokens = 0;						  //Variable für alle Tokens
		for (String s : document) {				  //for-each Schleife
			types.add(s);						  //jeder einzigartige Eintrag wird in das HashSet eingetragen
			tokens++;							  //bei jedem Durchgang wird die Anzahl der Tokens (alle Wörter) erhöht
		}
		double result = types.size() / tokens;	  //wir müssen die Anzahl der Types durch die Anzahl der Tokens teilen
		
		System.out.println("The Type-Token-Relation is: " + result); //Consolen Ausgabe zur Überprüfung
		
		return result;							  //Ergebnis als dounle-Wert
	}
	
}
