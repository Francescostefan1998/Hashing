package hashing;

import java.util.ArrayList;

public class DoubleHashing {

	String[] hashTable;
	int noOfCellsUsedInHashTable;
	
	public DoubleHashing(int size) {
		hashTable = new String[size];
		noOfCellsUsedInHashTable =  0;
	}
	
	public int simpleASCIIHashFunction(String x, int M) {
		char ch[];
		ch = x.toCharArray();
		int i, sum;
		for(sum = 0, i = 0; i<x.length(); i++) {
			sum = sum + ch[i];
		}
		return sum % M;
	}
	
	

	public void rehashKeys(String word) {
		noOfCellsUsedInHashTable = 0;
		ArrayList<String> data = new ArrayList<String>();
		for(String s: hashTable) {
			if(s != null)
				data.add(s);
		}
		data.add(word);
		hashTable = new String[hashTable.length * 2];
		for(String s: data) {
			insert(s);
		}
	}
	

	public void insert(String word) {
		return;
	}
	

	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("Hash Table does not exists!");
			return;
		} else {
			System.out.println("------Hash Table-------");
			for(int i = 0; i < hashTable.length; i++) {
				System.out.println("index " + i + ", key: " + hashTable[i]);
			}
		}
	}
	
	
	
	
}
