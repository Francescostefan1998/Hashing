package hashing;

import java.util.ArrayList;

public class QuadraticProbing {

	String[] hashTable;
	int usedCellNumber;
	
	public QuadraticProbing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}
	
	public int modASCIIHashFunction(String word, int M){
		char ch[];
		ch = word.toCharArray();
		int i, sum;
		for(sum = 0, i = 0; i < word.length(); i++) {
			sum = sum + ch[i];			
		}
		return sum % M;
	}
	
	public double getLoadFactor() {
		double loadFactor = usedCellNumber * 1.0/hashTable.length;
		return loadFactor;
	}
	
	public void rehashKeys(String word) {
		ArrayList<String> data = new ArrayList<String>();
		for(String s: hashTable) {
			data.add(s);
		}
		data.add(word);
		hashTable = new String[hashTable.length * 2];
		for(String s: data) {
			insert(s);
		}
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
	
	public void insert(String word) {
		double loadFactor = getLoadFactor();
		if(loadFactor >= 0.75) {
			rehashKeys(word);
		} else {
			int index = modASCIIHashFunction(word, hashTable.length);
			int counter = 0;
			for(int i = index; i < index + hashTable.length; i++) {
				int newIndex = (index + (counter * counter)) % hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println(word + " has been inserted successfully!!");
				
					break;
				} else {
					System.out.println(newIndex + " is already occupied. Trying next one..");
				}
				counter++;
			}
		}
	}
	

}
