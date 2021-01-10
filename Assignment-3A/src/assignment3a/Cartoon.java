package assignment3a;

public class Cartoon extends Genre{
	
	String title;
	
	public void info() {
		//System.out.println("Larva" + title);
		
		setTitle("Larva");
		setDesc("Two larva who live in a gutter under a busy street, play with objects that fall from above.");
		setGenre("Cartoon");
		setDate("20-December-2020");
		
		System.out.println("\nName : " + getTitle());
		System.out.println("Description : " + getDesc());
		System.out.println("Genre : " + getGenre());
		System.out.println("Date Release : " + getDate());
	}

}
