package com.cpt202a19.reservation.controller.ex;

/** 
 * Throw exception when file type is wrong
 * @exception/throws FileUploadException
 */
public class FileTypeException extends FileUploadException{

    public FileTypeException() {
        super();
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
