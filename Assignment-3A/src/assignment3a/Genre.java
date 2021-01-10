package assignment3a;

public class Genre {
	
	public static void Title() {
		System.out.println("Title");
	}
	
	String title,genre,date,desc;
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	
	public String getDate() {
		return this.date;
	}
}
