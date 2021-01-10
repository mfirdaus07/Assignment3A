package assignment3a;

public class Documentary extends Genre {
	
	String title,genre,date;
	
	
	public void info() {
		setTitle("National Geography : World Climate");
		setGenre("Documentary");
		setDate("19-December-2020");
		setDesc("National Geographic is the long-lived official monthly magazine of the National Geographic Society. It is one of the most widely read magazines of all time.");
	
		
		System.out.println("\nName : " + getTitle());
		System.out.println("Description : " + getDesc());
		System.out.println("Genre : " + getGenre());
		System.out.println("Date Release : " + getDate());
		
		
	}
	
}
