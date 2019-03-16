public class Library {


    // the capacity limits.
    public final int maxBookCapacity ;
    public final int maxBorrowedBooks ;
    public final int maxPatronCapacity ;

    // the current capacity of the arrays.
    public int  currentBookCapacity;
    public int  currentPatronCapacity;




    // the lists of the books and the patrons.
    public Book [] booksCollection;
    public Patron [] patronsCollection;

    // Array which
    public int [] borrowedBooks;



    /**
     * @param  maxBookCapacity - The maximal number of books this library can hold.
     * @param  maxBorrowedBooks - The maximal number of books this library allows a single patron to borrow at the same time.
     * @param  maxPatronCapacity - The maximal number of registered patrons this library can handle.
     */
    public Library(int maxBookCapacity, int maxBorrowedBooks, int maxPatronCapacity){
        this.maxBookCapacity = maxBookCapacity ;
        this.maxBorrowedBooks = maxBorrowedBooks ;
        this.maxPatronCapacity = maxPatronCapacity ;
        this.booksCollection = new Book [ this.maxBookCapacity ];
        this.borrowedBooks = new int [ this.maxPatronCapacity ];
        this.patronsCollection = new Patron[ this.maxPatronCapacity ];

        this.currentBookCapacity  = 0 ;
        this.currentPatronCapacity = 0 ;

        // initialize the borrowed counter.
        for (int i = 0; i < maxPatronCapacity ; i++) {
            this.borrowedBooks[i] = 0;
        }

    }
    /**
     * Adds the given book to this library, if there is place available, and it isn't already in the library.
     * @param  book - The book to add to this library.
     * @return a non-negative id number for the book if there was a spot and the book was successfully added,
     * or if the book was already in the library; a negative number otherwise.
     */
    public int	addBookToLibrary(Book book)
    {

        int bookId =  this.getBookId(book);

        if (bookId >= 0)
            return bookId;

        if (this.currentBookCapacity >= this.maxBookCapacity) {
            return -1;
        }
        else {

            this.booksCollection[ this.currentBookCapacity ] = book;
            bookId = this.currentBookCapacity;
            this.currentBookCapacity++;

            return bookId;
        }
    }

    /**
     * Returns true if the given number is an id of some book in the library, false otherwise.
     * @param bookId - The id to check.
     * @return true if the given number is an id of some book in the library, false othe
     */
    public boolean borrowBook(int bookId, int patronId){
        boolean haveBeenBorrowed = false;

        if ( this.isBookAvailable(bookId) && this.isPatronIdValid(patronId) ) {
            if ( this.borrowedBooks[ patronId ]  < this.maxBorrowedBooks ) {

                this.booksCollection[bookId].setBorrowerId(patronId);
                this.borrowedBooks[patronId]++;

                Patron patron = this.patronsCollection[patronId];
                Book book = this.booksCollection[bookId];

                book.setBorrowerId( patronId );
                haveBeenBorrowed = patron.willEnjoyBook(book);
            }
        }

        return haveBeenBorrowed;
    }

    /**
     * Returns the non-negative id number of the given book if he is owned by this library, -1 otherwise.
     * @param book - The book for which to find the id number.
     * @return a non-negative id number of the given book if he is owned by this library, -1 otherwis
     */
    public int	getBookId(Book book) {
        int bookId = -1;

        for ( int i = 0 ; i < this.currentBookCapacity; i++  ){
            if ( this.booksCollection[i] == book ) {
                bookId = i;
            }
        }
        return bookId;
    }


    /**
     * Returns the non-negative id number of the given patron if he is registered to this library, -1 otherwise.
     * @param patron - The patron for which to find the id number.
     * a non-negative id number of the given patron if he is registered to this library, -1 otherwise.
     */
    public int	getPatronId(Patron patron) {
        int patronId = -1;

        for (int i = 0; i < this.currentPatronCapacity ; i++) {
            if ( patron == this.patronsCollection[i] ) {
                patronId = i;
            }
        }
        return patronId;
    }

    /**
     * Returns true if the book with the given id is available, false otherwise.
     * Parameters:
     * @param  bookId - The id number of the book to check.
     * @return true if the book with the given id is available, false otherwise
     */
    public boolean	isBookAvailable(int bookId) {
        boolean availavle = false;

        if ( this.isBookIdValid(bookId))
            availavle = this.booksCollection[bookId].getCurrentBorrowerId() == Book.AVAILABLE;

        return availavle;
    }

    /**
     * Returns true if the given number is an id of some book in the library, false otherwise.
     * @param bookId - the id of the book.
     * @return returns true if the library contains book with the given id.
     */
    public  boolean isBookIdValid(int bookId) {
        return bookId >= 0 && bookId < this.maxBookCapacity && this.booksCollection[bookId] != null;
    }

    /**
     * Returns true if the given number is an id of a patron in the library, false otherwise.
     * @param patronId - The id to check.
     * @return  true if the given number is an id of a patron in the library, false otherwise.
     */
    public boolean	isPatronIdValid(int patronId) {
        return  patronId >= 0 && patronId < this.maxPatronCapacity && this.patronsCollection[patronId] != null;
    }

    /**
     * Registers the given Patron to this library, if there is a spot available.
     * @param  patron - The patron to register to this library.
     * @return a non-negative id number for the patron if there was a spot and the patron was successfully registered,
     * a negative number otherwise.
     */
    public int	registerPatronToLibrary(Patron patron) {
        int patronId = -1;

        if (this.currentPatronCapacity < this.maxPatronCapacity &&
                this.getPatronId(patron) == -1) {
            this.patronsCollection[this.currentPatronCapacity] = patron;
            patronId = this.currentPatronCapacity;
            this.currentPatronCapacity++;
        }
        return patronId;
    }

    /**
     * Return the given book.
     * @param bookId - The id number of the book to return.
     */

    public  void returnBook(int bookId) {
        if ( this.isBookIdValid(bookId)) {

             Book returnedBook = this.booksCollection[bookId];
             int patronId = returnedBook.getCurrentBorrowerId();
             if ( this.isPatronIdValid(patronId)) {
                this.borrowedBooks[ patronId ]--;
             }
             returnedBook.returnBook();
        }
    }

    /**
     * Suggest the patron with the given id the book he will enjoy the most, out of all available books he will enjoy,
     * if any such exist.
     * @param  patronId - The id number of the patron to suggest the book to.
     * @return The available book the patron with the given will enjoy the most. Null if no book is available.
     */
    public  Book suggestBookToPatron(int patronId) {


        final int firstIndex = 0 , secondIndex = 1;
        Book suggestBook = null;


        if ( this.isPatronIdValid(patronId) ) {

            Patron patron = this.patronsCollection[patronId];
            int maxScore = -1;

            for (int bookId = firstIndex; bookId < this.maxBookCapacity &&
                    this.booksCollection[bookId] != null; bookId++) {

                if (  this.isBookAvailable(bookId) ) {

                    Book book = this.booksCollection[bookId];
                    int tempScore = patron.getBookScore(book);

                    if (tempScore > maxScore) {
                        suggestBook = book;
                        maxScore = tempScore;
                    }
                }
            }
        }

        return suggestBook;
    }

    public Book[] getBooksCollection() {
        return booksCollection;
    }

}
