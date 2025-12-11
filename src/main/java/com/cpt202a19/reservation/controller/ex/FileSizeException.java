package com.cpt202a19.reservation.controller.ex;

/**
 * Throw exception when file size is not within the specified range
 * @exception/throws FileUploadException
 */
public class FileSizeException extends FileUploadException {

    public FileSizeException() {
        super();
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
