package main;

import hashing.DirectChaining;

public class Main {
	
	public static void main(String[] args) {
		DirectChaining dc = new DirectChaining(15);
		dc.insertHashTable("The");
		dc.insertHashTable("Quick");
		dc.insertHashTable("Brown");
		dc.insertHashTable("String");
		dc.insertHashTable("Short");
		dc.insertHashTable("quick");
		dc.insertHashTable("fox");
		
		//dc.displayHashTable();
		dc.searchHashTable("fox");
		dc.deleteKeyHashTable("fox");
		dc.searchHashTable("fox");
		
		
	
	
	
	}
	
}
