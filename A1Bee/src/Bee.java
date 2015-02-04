// The Javadoc output was checked to be okay.
/** An instance (i.e. object) maintains information about a bee. */
public class Bee {
	private String nickname; // name of this Bee. length > 0
	private int year; // year of hatching this Bee. >=2000
	private int month; // month of hatching this Bee. 1..12
	private char gender; // gender of this Bee. "M" or "F"
	private Bee mother; // Bee object that is the mother. Bee object or null
	private Bee father; // Bee object that is the father. Bee object or null
	private int children; // number of children of this Bee. >=0
	
	/** Constructor: an instance with nickname n, gender g, birth year y, 
	 and birth month m. Its parents are unknown, and it has no children.
	 
	Precondition: n has at least 1 character, y >= 2000, m is in 1..12,
	 and g is 'M' for male or 'F' for female. */
	public Bee(String n, char g, int y, int m) {
		assert n.length() > 0;
		assert y >= 2000;
		assert 1 <= m && m <= 12;
		assert g == 'M' || g == 'F';
		
		nickname = n;
		gender = g;
		year = y;
		month = m;
		mother = null;
		father = null;
		children = 0;
	}
	/** Return this Bee's nickname */	
	public String getNickname() {
		return nickname;
	}
	
	/** Return the year this Bee hatched from its egg */
	public int getYear() {
		return year;
	}
	
	/** Return the month this Bee hatched from its egg  */
	public int getMonth() {
		return month;
	}
	
	/** Return the value of "This Bee is male.” */
	public boolean isMale() {		
		return gender == 'M';
	}
	
	/** Return this Bee's mother (null if unknown) */
	public Bee getMom() {
		return mother;
	}
	
	/** Return this Bee's father (null if unknown) */
	public Bee getDad() {
		return father;
	}

	/** Return the number of children of this Bee */
	public int getNumChildren() {
		return children;
	}
	
	/** Add e as this Bee's mother. 
	 
	Precondition: this Bee’s mother is unknown and e is female. */
	public void addMom(Bee e) {
		assert mother == null && e!= null && e.gender == 'F';
		mother = e;
	}
	
	/** Add e as this Bee's father.
	
	Precondition: This Bee's father is unknown,
	 this Bee is female, and e is male. */
	public void addDad(Bee e) {
		assert father == null && e != null && e.gender == 'M';
		father = e;
	}
	
	/** Constructor: a male Bee with nickname n, hatch year y,
	 hatch month m, and mother ma. 
	
	Precondition: n has at least 1 character, y >= 2000,
	 m is in 1..12, and ma is a female. */
	public Bee(String n, int y, int m, Bee ma) {
		assert n.length() > 0;
		assert y >= 2000;
		assert m <= 12 && m >= 1;
		assert ma.gender == 'F';
		
		nickname = n;
		year = y;
		month = m;
		mother = ma;
		gender = 'M';
		ma.children += 1;
	}
	
	/** Constructor: a female Bee with nickname n, hatch year y,
	 hatch month m, mother ma, and father pa.
	 
	Precondition: n has at least 1 character, y >= 2000, 
	 m is in 1..12, ma is a female, and pa is a male. */
	public Bee(String n, int y, int m, Bee ma, Bee pa) {
		assert n.length() > 0;
		assert y >= 2000;
		assert m <= 12 && m >= 1;
		assert ma.gender == 'F';
		assert pa.gender == 'M';
		
		nickname = n;
		year = y;
		month = m;
		mother = ma ;
		father = pa;
		gender = 'F';
		pa.children += 1;
		ma.children += 1;
	}

	/** Return value of "this Bee is younger than e." (note: same month
	 and same year does not mean younger)
	
	Precondition: e is not null. */
	public boolean isYounger(Bee e) {
		assert e != null;		
		return year > e.year || (year == e.year && month > e.month);
	}
	
	/** Return value of "this Bee and e are siblings.” (note: if e is
	null they can't be siblings, so false should be returned). */
	public boolean isSibling(Bee e) {
		return e != null && mother != null && e.mother != null && 
				this != e && (e.father == father || e.mother == mother);
	}
}

