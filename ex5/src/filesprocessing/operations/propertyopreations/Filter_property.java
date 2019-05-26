package filesprocessing.operations.propertyopreations;

import filesprocessing.FileDelegate;
import filesprocessing.operations.FilterOperation;

public abstract class Filter_property  extends FilterOperation {

    private static final String YESFLAG  = "YES";
    private static final String NOFLAG   = "NO";

    public Filter_property(String[] command) {
        super(command);


        if ( this.isturnOn(YESFLAG )  || this.isturnOn( NOFLAG ))
            this.positive =  this.positive && this.isturnOn( YESFLAG );


    }
}
