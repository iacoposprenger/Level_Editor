

public class File {
char memory[][][] = new char[1000][50][50];	

	public File(){
	}
	
	public void setMemory(int x, int y, int t, char c){
		
		memory[x][y][t] = c;
		
	}
	
	public char getMemory(int x, int y, int t){
		
		char c = memory[x][y][t];
		return c;
		
	}


}
