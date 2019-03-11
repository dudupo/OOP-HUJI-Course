public class Patron {

    public Patron(){

    }


    /**
     * Returns a string representation of the patron, which is a sequence of its first and last name,
     * separated by a single white space. For example, if the patron's first name is "Ricky" and his last name is "Bobby",
     * this method will return the String "Ricky Bobby".
     * @return the String representation of this patron;
    */
    protected String stringRepresentation() {
        return "";
    }

    /**
     * Returns the literary value this patron assigns to the given book.
     * @param book - The book to asses.
     * @return the literary value this patron assigns to the given book.
     */
    protected int getBookScore(Book book) {
        return  -1;
    }

    /**
     * Returns true of this patron will enjoy the given book, false otherwise.
     * @param book - The book to asses.
     * @return true of this patron will enjoy the given book, false otherwise.
     */
    protected boolean willEnjoyBook(Book book) {

    }


}
