package main;

import hashing.DirectChaining;
import hashing.LinearProbing;

public class Main {
	
	public static void main(String[] args) {
//		DirectChaining dc = new DirectChaining(15);
//		dc.insertHashTable("The");
//		dc.insertHashTable("Quick");
//		dc.insertHashTable("Brown");
//		dc.insertHashTable("String");
//		dc.insertHashTable("Short");
//		dc.insertHashTable("quick");
//		dc.insertHashTable("fox");
//		
//		//dc.displayHashTable();
//		dc.searchHashTable("fox");
//		dc.deleteKeyHashTable("fox");
//		dc.searchHashTable("fox");
		
		
	LinearProbing lp = new LinearProbing(13);
	lp.insert("The");
	lp.insert("Quick");
	lp.insert("Brown");
	lp.insert("String");
	lp.insert("Short");
	lp.insert("quick");
	lp.insert("fox");
	lp.displayHashTable();
	lp.searchHashTable("fox");
	
	lp.deleteKeyHashTable("hd");
	lp.deleteKeyHashTable("fox");
	lp.searchHashTable("fox");
	
	}
	
}
