package com.cpt202a19.reservation.service;

import com.cpt202a19.reservation.entity.Information;

import java.util.List;

/** Business layer interface for processing shipping address data */
public interface IInformationService {

    /** Create a new shipping address */
    void addNewInformation(Integer uid, String username, Information inforamtion);
    
    /** Query a user's information by uid */
    List<Information> getByUid(Integer uid);

    /** Set default information */
    void setDefault(Integer rid, Integer uid, String username);

    /** Delete information */
    void delete(Integer rid, Integer uid, String username);

    /** Query information according to the id of the information */
    Information getByRid(Integer rid, Integer uid);

}
