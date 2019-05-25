package filesprocessing;

import java.io.File;
import java.util.regex.Pattern;

public class FileDelegate {

    private static final String DELIMITER = "\\.";

    private File file;

    public FileDelegate( File file ) {
        this.file = file;
    }

    public long getSize() {
        return file.length();
    }

    public String getName() {
        return this.file.getName();
    }
    public boolean Contains(String value) {
        return this.file.getName().contains(value);
    }
    public boolean Prefix (String value  ) {
        return Pattern.matches("^" + value + ".*", this.file.getName());

    }
    public boolean Suffix( String value ){
        return Pattern.matches(".*" + value + "$", this.file.getName());
    }

    public boolean Writable( ) {
        return this.file.canWrite();
    }
    public boolean Executable( ){
        return this.file.canExecute();
    }

    public boolean Hidden( ) {
        return this.file.isHidden();
    }

    public String getPath() {
        return this.file.getAbsolutePath();
    }

    public String getType() {

        String [] splited  = this.file.getName().split(DELIMITER);

        if ( splited.length > 0 ){
            return splited[splited.length-1];
        }
        return "";
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
