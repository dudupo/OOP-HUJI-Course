public class Library {

    /**
     * @param  maxBookCapacity - The maximal number of books this library can hold.
     * @param  maxBorrowedBooks - The maximal number of books this library allows a single patron to borrow at the same time.
     * @param  maxPatronCapacity - The maximal number of registered patrons this library can handle.
     */
    public Library(int maxBookCapacity, int maxBorrowedBooks, int maxPatronCapacity){

    }

    /**
     * Adds the given book to this library, if there is place available, and it isn't already in the library.
     * @param  book - The book to add to this library.
     * @return a non-negative id number for the book if there was a spot and the book was successfully added,
     * or if the book was already in the library; a negative number otherwise.
     */
    protected int	addBookToLibrary(Book book)
    {
        return -1;
    }

    /**
     * Returns true if the given number is an id of some book in the library, false otherwise.
     * @param bookId - The id to check.
     * @return true if the given number is an id of some book in the library, false othe
     */
    protected boolean borrowBook(int bookId, int patronId){

    }

    /**
     * Returns the non-negative id number of the given book if he is owned by this library, -1 otherwise.
     * @param book - The book for which to find the id number.
     * @return a non-negative id number of the given book if he is owned by this library, -1 otherwis
     */
    protected int	getBookId(Book book) {
        return -1;
    }


    /**
     * Returns the non-negative id number of the given patron if he is registered to this library, -1 otherwise.
     * @param patron - The patron for which to find the id number.
     * a non-negative id number of the given patron if he is registered to this library, -1 otherwise.
     */
    protected int	getPatronId(Patron patron) {
        return  -1;
    }

    /**
     * Returns true if the book with the given id is available, false otherwise.
     * Parameters:
     * @param  bookId - The id number of the book to check.
     * @return true if the book with the given id is available, false otherwise
     */
    protected boolean	isBookAvailable(int bookId) {
        return  false;
    }
    //Returns true if the given number is an id of some book in the library, false otherwise.
    protected  boolean	isBookIdValid(int bookId) {
        return  false;
    }

    /**
     * Returns true if the given number is an id of a patron in the library, false otherwise.
     * @param patronId - The id to check.
     * @return  true if the given number is an id of a patron in the library, false otherwise.
     */
    protected boolean	isPatronIdValid(int patronId) {
        return  false;
    }

    /**
     * Registers the given Patron to this library, if there is a spot available.
     * @param  patron - The patron to register to this library.
     * @return a non-negative id number for the patron if there was a spot and the patron was successfully registered,
     * a negative number otherwise.
     */
    protected  int	registerPatronToLibrary(Patron patron) {

    }

    /**
     * Return the given book.
     * @param bookId - The id number of the book to return.
     */
    protected  void	returnBook(int bookId) {

    }

    /**
     * Suggest the patron with the given id the book he will enjoy the most, out of all available books he will enjoy,
     * if any such exist.
     * @param  patronId - The id number of the patron to suggest the book to.
     * @return The available book the patron with the given will enjoy the most. Null if no book is available.
     */
    protected  Book	suggestBookToPatron(int patronId) {
        return null;
    }

}
