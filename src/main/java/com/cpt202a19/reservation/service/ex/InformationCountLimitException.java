package com.cpt202a19.reservation.service.ex;

/**
 * The number of exceptions reached the upper limit
 * @exception/throws ServiceException
 */
public class InformationCountLimitException extends ServiceException{

    public InformationCountLimitException() {
        super();
    }

    public InformationCountLimitException(String message) {
        super(message);
    }

    public InformationCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public InformationCountLimitException(Throwable cause) {
        super(cause);
    }

    protected InformationCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
