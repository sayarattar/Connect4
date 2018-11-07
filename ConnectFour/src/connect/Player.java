package connect;

public class Player {
	private String name;
	
	public Player(String name) {
		this.name=name;
	}

	public String getName() {
		return this.name;
	}
	
	public Disk playDisk() {
		String color;
		if(this.name.equals("Player 1")) color="Red";
		else color="Blue";
		Disk disk = new Disk(color);
		return disk;
	}
	
}
