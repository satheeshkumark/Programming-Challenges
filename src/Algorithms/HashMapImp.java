package Algorithms;

class HashNode{
	private int key;
	private int value;
	
	public HashNode(int key, int value){
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}

class HashTable{
	int table_size = 50;
	HashNode hashTable[];
	
	public HashTable(){
		hashTable = new HashNode[this.table_size];
		for(int i=0;i<this.table_size;i++)
			this.hashTable[i] = null;
	}
	
	public void put(int key, int value){
		int currentIndex = key % this.table_size;
		while(this.hashTable[currentIndex] != null && this.hashTable[currentIndex].getKey() != key){
			currentIndex++;
		}
		hashTable[currentIndex] = new HashNode(key, value);
	}
	
	public int get(int key){
		int currentIndex = key % this.table_size;
		int size = this.table_size;
		while(this.hashTable[currentIndex].getKey() != key && size >= 0){
			currentIndex++;
			size--;
		}
		if(size<0)
			return -1;
		return this.hashTable[currentIndex].getValue();
	}
	
	public void printMap(){
		for(int i=0; i< this.table_size;i++)
			if(hashTable[i] != null)
				System.out.println(i + "\t" + this.hashTable[i].getKey() + "\t" + this.hashTable[i].getValue());
	}
}

public class HashMapImp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable table = new HashTable();
		table.put(10,10);
		table.put(60, 20);
		table.printMap();
	}
}
