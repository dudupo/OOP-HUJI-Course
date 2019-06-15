package filesprocessing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class FileDelegate {

    // delimiter for splinting the path to name.type
    private static final String DELIMITER = "\\.";
    // pointer to the file.
    private File file;

    /**
     * construct the delegate.
     * @param file the file object to point on.
     */
    public FileDelegate( File file ) {
        this.file = file;
    }


    /**
     * copy constructor, construct a shallow copy the delegate.
     * @param delegate other delegate to a file.
     */
    public FileDelegate(FileDelegate delegate) {
        this.file = delegate.file;

    }

    /**
     * @return the size of the file
     */
    public long getSize() {
        return file.length();
    }

    /**
     * @return the file name
     */
    public String getName() {
        return this.file.getName();
    }

    /**
     * @param value - the given substring.
     * @return returns true if the the given value is
     *  substring of the filename.
     */
    public boolean Contains(String value) {

        return  Pattern.matches("^.*" + value.replace("-" , "\\-") +
                ".*$", this.file.getName());
    }
    /**
     * @param value - the given prefix.
     * @return returns true if the the given value is
     *  prefix of the filename.
     */
    public boolean Prefix (String value  ) {
        return Pattern.matches("^" + value + ".*", this.file.getName());

    }

    /**
     * @param value - the given suffix.
     * @return returns true if the the given value is
     *  suffix of the filename.
     */
    public boolean Suffix( String value ){
        return Pattern.matches(".*" + value + "$", this.file.getName());
    }
    /**
     * @return returns true if the file is writable,
     *  otherwise returns false.
     */
    public boolean Writable( ) {
        return Files.isWritable(Paths.get(this.file.getPath()));
    }

    /**
     * @return returns true if the file is executable,
     *  otherwise returns false.
     */
    public boolean Executable( )
    {
        return Files.isExecutable(
                Paths.get(this.file.getPath()));
    }

    /**
     * @return returns true if the file is hidden,
     *  otherwise returns false.
     */
    public boolean Hidden( ) {
        try {
            return Files.isHidden(Paths.get(this.file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * @return the path of the file.
     */
    public String getPath() {
        return this.file.getPath();
    }

    /**
     * @return the type of the file.
     */
    public String getType() {

        String [] splited  = this.file.getName().split(DELIMITER);

        if ( splited.length > 0 ){
            return splited[splited.length-1];
        }
        return "";
    }

    /**
     * overide the to String method
     * @return the name of the file.
     */
    @Override
    public String toString() {
        return this.getName();
    }


    /**
     * returns pointer to the file.
     * @return file object.
     */
    public File getFile(){
        return this.file;
    }
}
