package com.cpt202a19.reservation.service.ex;

/**
 * Business layer exception base class
 * @exception/throws RuntimeException
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }
    
    /** often used */
    public ServiceException(String message) {
        super(message);
    }

    /** often used */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
