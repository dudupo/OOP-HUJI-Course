/**
 * This class represents a book, which has a title, author, year of publication and different literary aspects.
 */
class Book {

    /** The title of this book. */
    final String title;

    /** The name of the author of this book. */
    final String author;

    /** The year this book was published. */
    final int yearOfPublication;

    /** The comic value of this book. */
    private int comicValue;

    /** The dramatic value of this book. */
    private int dramaticValue;

    /** The educational value of this book. */
    private int educationalValue;


    /** will be setted as borrowerId in case no one has borrowered  the book */
    public static final int AVAILABLE = -1;

    /** the id number of the borrower */
    private int borrowerId;

    /**
     * returns the title of the book.
     * @return the Title of the Book.
     */
    public String getTitle() {
        return title;
    }

    /**
     *  returns the Author of the book.
     * @return the Aouthr of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * returns the publication year of the book.
     * @return the publication year of the book.
     */
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    /**
     * returns the comic value of the book.
     * @return the comic value of the book.
     */
    public int getComicValue() {
        return comicValue;
    }

    /**
     * returns the dramatic value of the book.
     * @return the dramatic value of the book.
     */
    public int getDramaticValue() {
        return dramaticValue;
    }

    /**
     * returns the educational value of the book
     * @return the educational value of the book
     */
    public int getEducationalValue() {
        return educationalValue;
    }



    /** The id of the current borrowe of this book. */
    int currentBorrowerId = -1;

    /*----=  Constructors  =-----*/

    /**
     * Creates a new book with the given characteristic.
     * @param bookTitle The title of the book.
     * @param bookAuthor The name of the author of the book.
     * @param bookYearOfPublication The year the book was published.
     * @param bookComicValue The comic value of the book.
     * @param bookDramaticValue The dramatic value of the book.
     * @param bookEducationalValue The educational value of the book.
     */
    Book(String bookTitle, String bookAuthor, int bookYearOfPublication, int bookComicValue, int bookDramaticValue,
         int bookEducationalValue){
        //your code goes here
        this.title = bookTitle;
        this.author = bookAuthor;
        this.yearOfPublication = bookYearOfPublication;
        this.comicValue = bookComicValue;
        this.dramaticValue = bookDramaticValue;
        this.educationalValue = bookEducationalValue;

        this.setBorrowerId( Book.AVAILABLE);

    }

    /*----=  Instance Methods  =-----*/

    /**
     * Returns a string representation of the book, which is a sequence
     * of the title, author, year of publication and the total literary value of the book, separated by
     * commas, inclosed in square brackets. For example, if the book is
     * titled "Monkey Feet", was written by Ernie Douglas, published in 1987 and has a comic value of 7,
     * dramatic value of 3 and an educational value of 1, this method will return the string:
     * "[MonkeyFeet,Ernie Douglas,1987,11]"
     * @return the String representation of this book.
     */
    String stringRepresentation(){
        return "[" +
                this.title+ "," +
                this.author + "," +
                this.yearOfPublication + "," +
                this.getLiteraryValue()+ "]" ;
    }

    /**
     * @return the literary value of this book, which is defined as the sum of its comic value, its dramatic
     * value and its educational value.
     */
    int getLiteraryValue(){
        return this.getComicValue() +
                this.getDramaticValue() +
                this.getEducationalValue();
    }

    /**
     * Sets the given id as the id of the current borrower of this book, -1 if no patron is currently borrowing
     * it.
     * @param borrowerId
     */
    void setBorrowerId(int borrowerId){
        this.borrowerId = borrowerId;
    }

    /**
     * @return the id of the current borrower of this book.
     */
    int getCurrentBorrowerId(){
        return this.borrowerId;
    }

    /**
     * Marks this book as returned.
     */
    void returnBook(){
        this.setBorrowerId( Book.AVAILABLE);
    }

}