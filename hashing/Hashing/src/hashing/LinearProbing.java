package hashing;
import java.util.*;

public class LinearProbing {

	String[] hashTable;
	int usedCellNumber;
	
	public LinearProbing(int size) {
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
	
	public void insert(String word) {
		double loadFactor = getLoadFactor();
		if(loadFactor >= 0.75) {
			rehashKeys(word);
		} else {
			int index = modASCIIHashFunction(word, hashTable.length);
			for(int i = index; i < index +hashTable.length; i++) {
				int newIndex = i %  hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("The "+ word + " successfully inserted at location: " + newIndex);
					break;
				} else {
					System.out.println(newIndex + " is already occupied. Trying next empty cell");
				}
			}
		}
		usedCellNumber++;
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
	
	public boolean searchHashTable(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for(int i = index; i<index+hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println(word + " found at location: " + newIndex);
				return true;
			}
		}
		System.out.println(word + " not found in hashTable" );
		return false;
	}
	
	public void deleteKeyHashTable(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for(int i = index; i<index+hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println(word + " has been deleted from hashTable");
				return;
			}
			
		}
		System.out.println(word + " not found in hashTable!" );
	}
}
