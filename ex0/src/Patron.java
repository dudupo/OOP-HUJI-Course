public class Patron {

    /** The weight of comic ganere. */
    public  final int comicWeight;

    /** The weight of dramatic genere. */
    public  final int dramaticWeight;

    /** The weight of educational genere. */
    public  final int educationalWeight;

    /** the first name of the Patron */
    public final String firstName;

    /** the last name of the Patron */
    public final String lastName;

    /** the minmal score which book reburied to over for been liked */
    public final int minmalScore;


    public Patron(String firstName, String lastName, int comicWeight,
                  int dramaticValue, int educationalWeight, int minmalScore){
        this.comicWeight = comicWeight;
        this.dramaticWeight = dramaticValue;
        this.educationalWeight = educationalWeight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.minmalScore = minmalScore;
    }

    /**
     * Returns a string representation of the patron, which is a sequence of its first and last name,
     * separated by a single white space. For example, if the patron's first name is "Ricky" and his last name is "Bobby",
     * this method will return the String "Ricky Bobby".
     * @return the String representation of this patron;
    */
    public String stringRepresentation() {
        return  this.firstName +  " " + this.lastName;
    }

    /**
     * Returns the literary value this patron assigns to the given book.
     * @param book - The book to asses.
     * @return the literary value this patron assigns to the given book.
     */
    public int getBookScore(Book book) {
        return  this.comicWeight * book.getComicValue() + this.dramaticWeight * book.getDramaticValue() +
                this.educationalWeight * book.getEducationalValue();
    }


    /**
     * Returns true of this patron will enjoy the given book, false otherwise.
     * @param book - The book to asses.
     * @return true of this patron will enjoy the given book, false otherwise.
     */
    public boolean willEnjoyBook(Book book) {
        return this.getBookScore(book) >= this.minmalScore;
    }


}
