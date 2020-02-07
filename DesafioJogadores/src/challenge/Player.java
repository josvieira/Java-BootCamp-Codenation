package challenge;

public class Player {
	private String id; //col 0 do arquivo
	private String name; //col 1 do arquivo
	private String full_name;//col 2 do arquivo
	private String club; //col 3 do arquivo
	private String age;//col 6 do arquivo
	private String birth_date;//col 8 do arquivo
	private String nationality;//col 14 do arquivo
	private String eurwage;//col 17 do arquivo
	private String eur_release;//col 18 do arquivo

	 //id 0, name 1, full_name 2, club 3, age 6, birth_Date 8, 
	//nationality 14, eurwage 17, eur_release 18
	
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getFull_name() {
		return full_name;
	}
	public final void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public final String getClub() {
		return club;
	}
	public final void setClub(String club) {
		this.club = club;
	}
	public final Integer getAge() {
		return Integer.parseInt(age);
	}
	public final void setAge(String age) {
		this.age = age;
	}
	public final String getBirth_date() {
		return birth_date;
	}
	public final void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public final String getNationality() {
		return nationality;
	}
	public final void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public final String getEurwage() {
		return eurwage;
	}
	public final void setEurwage(String eurwage) {
		this.eurwage = eurwage;
	}
	public final String getEur_release() {
		return eur_release;
	}
	public final void setEur_release(String eur_release) {
		this.eur_release = eur_release;
	}
	
}
