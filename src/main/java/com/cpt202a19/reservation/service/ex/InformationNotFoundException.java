package com.cpt202a19.reservation.service.ex;

/**
 * Throw exception when information does not exist
 * @exception/throws ServiceException
 */
public class InformationNotFoundException extends ServiceException{

    public InformationNotFoundException() {
    }

    public InformationNotFoundException(String message) {
        super(message);
    }

    public InformationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InformationNotFoundException(Throwable cause) {
        super(cause);
    }

    public InformationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
