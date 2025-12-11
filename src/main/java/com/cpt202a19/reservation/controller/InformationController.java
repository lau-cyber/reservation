package com.cpt202a19.reservation.controller;

import com.cpt202a19.reservation.entity.Information;
import com.cpt202a19.reservation.service.IInformationService;
import com.cpt202a19.reservation.until.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("inforamtions")
public class InformationController extends BaseController {

    @Autowired // automatic assembly
    private IInformationService informationService;

    /**
     * The method to add new address
     * @param information data we want to add
     * @param session stores uid and username
     * @return the response by JsonResult
     */
    @RequestMapping("add_new_information")
    public JsonResult<Void> addNewAddress(Information information, HttpSession session) {
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        informationService.addNewInformation(uid, username, information); // Call the method of the business object to execute the business
        System.out.println("uid:"+uid+" username:"+username+" info:"+information.toString());
        return new JsonResult<Void>(OK); // Response succeeded
    }
    
    /**
     * The method to get information by uid
     * @param session stores information of uid
     * @return the JsonResult of corresponding information
     */
    @GetMapping({"", "/"})
    public JsonResult<List<Information>> getByUid(HttpSession session) {
        Integer uid = getuidFromSession(session);
        List<Information> data = informationService.getByUid(uid);
        return new JsonResult<>(OK, data);
    }

    /**
     * The method of default setting
     * @param rid the integer of Pathvariable
     * @param session stores information of uid and username
     * @return the response by JsonResult
     */
    @RequestMapping("{rid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("rid") Integer rid, HttpSession session) {
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        informationService.setDefault(rid, uid, username);
        return new JsonResult<Void>(OK);
    }

    /**
     * The method to delete setted information
     * @param rid the integer of Pathvariable
     * @param session stores information of uid and username
     * @return the response by JsonResult
     */
    @RequestMapping("{rid}/delete")
    public JsonResult<Void> delete(@PathVariable("rid") Integer rid, HttpSession session) {
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        informationService.delete(rid, uid, username);
        return new JsonResult<Void>(OK);
    }

}