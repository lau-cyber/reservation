package com.cpt202a19.reservation.service.impl;

import com.cpt202a19.reservation.entity.Information;
import com.cpt202a19.reservation.mapper.InformationMapper;
import com.cpt202a19.reservation.service.IInformationService;
import com.cpt202a19.reservation.service.IDmgService;
import com.cpt202a19.reservation.service.ex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/** Add reservation information implementation class */
@Service
public class InformationServiceImpl implements IInformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Autowired
    private IDmgService dmgService;

    @Value("${user.information.max-count}")
    private int maxCount;

    /**
     * Method to add new information
     * @param uid Integer used to get data
     * @param username String of user's name
     * @param information Information user want to add
     * @return the updated state of new information added
     * @exception/throws ServiceException
     */
    @Override
    public void addNewInformation(Integer uid, String username, Information information) {

        /* Count the number of data created by the current user */
        Integer count = informationMapper.countByUid(uid);

        /* Determine whether the number reaches the upper limit */
        if (count > maxCount) { throw new InformationCountLimitException("创建信息数量已经达到上限(" + maxCount + ")！"); }

        /* Completion data: the names of d, m, g */
        String departmentCode = dmgService.getCodeByName(information.getDepartmentName());
        String majorCode = dmgService.getCodeByName(information.getMajorName());
        int gCode=Integer.parseInt(majorCode);
        for(int i=1;i<=4;i++){
            String tmpCode=""+(gCode+i);

            if(dmgService.getNameByCode(tmpCode).equals(information.getGradeName())){
                gCode+=i;
                break;
            }
        }

        //String gradeCode = dmgService.getCodeByName(information.getGradeName());
        information.setDepartmentCode(departmentCode);
        information.setMajorCode(majorCode);
        //information.setGradeCode(gradeCode);
        information.setGradeCode(""+gCode);

        /* Completion data: encapsulate the parameter uid into the parameter information */
        information.setUid(uid);

        /* Completion data: According to the above statistics, get the correct isDefault value (whether it is default: 0-no default, 1-default), and encapsulate it */
        Integer isDefault = count == 0 ? 1 : 0;
        information.setIsDefault(isDefault);

        /* Completion data: 4 logs */
        Date now = new Date();
        information.setCreatedUser(username);
        information.setCreatedTime(now);
        information.setModifiedUser(username);
        information.setModifiedTime(now);

        /* Insert shipping address data and get the number of affected rows returned */
        Integer rows = informationMapper.insert(information);

        /* Determine whether the number of affected rows is not 1 */
        if (rows != 1) { throw new InsertException("插入收货地址数据时出现未知错误，请联系系统管理员！"); }
    }

    @Override
    public List<Information> getByUid(Integer uid) {
        List<Information> list = informationMapper.findByUid(uid);

        for (Information information : list) {
            information.setUid(null);
            information.setDepartmentCode(null);
            information.setMajorCode(null);
            information.setGradeCode(null);
            information.setCreatedUser(null);
            information.setCreatedTime(null);
            information.setModifiedUser(null);
            information.setModifiedTime(null);
        }

        return list;
    }

    /**
     * The information of the specified rid is set to the default
     * @param rid Integer used to query information
     * @param uid Integer used to check the current information belongs to user
     * @param username String of user's name
     * @return the updated state of default setting
     * @exception/throws ServiceException
     */
    @Transactional
    @Override
    public void setDefault(Integer rid, Integer uid, String username) {

        /* According to the parameter rid query information */
        Information result = informationMapper.findByRid(rid);

        /* Determine if the query result is null */
        if (result == null) { throw new InformationNotFoundException("尝试访问的信息数据不存在"); }

        /* Determine whether the uid in the query result is inconsistent with the parameter uid */
        if (!result.getUid().equals(uid)) { throw new AccessDeniedException("非法访问的异常"); }

        /* Set all information data of the user to non-default, and get and return the number of affected rows */
        Integer rows = informationMapper.updateNonDefaultByUid(uid);

        /* Determine whether the number of affected rows is less than 1 */
        if (rows < 1) {
            throw new UpdateException("设置默认添加信息数据时出现未知错误[1]");
        }

        /* Set the information data of the specified rid as default, and get the number of affected rows returned */
        rows = informationMapper.updateDefaultByRid(rid, username, new Date());

        /* Determine whether the number of affected rows is not 1 */
        if (rows != 1) { throw new UpdateException("设置默认信息数据时出现未知错误[2]"); }
    }

    /**
     * Method to delete information
     * @param rid Integer used to query the data of information
     * @param uid Integer used to count how many users there are currently
     * @param username String of user's name
     * @return the updated the state of deletion
     * @exception/throws ServiceException
     */
    @Transactional
    @Override
    public void delete(Integer rid, Integer uid, String username) {

        /* According to the parameter rid, query the information data */
        Information result = informationMapper.findByRid(rid);

        /* Determine if the query result is null */
        if (result == null) { throw new InformationNotFoundException("尝试访问的用户信息不存在"); }
  
        /* Determine whether the uid in the query result is inconsistent with the parameter uid */
        if (!result.getUid().equals(uid)) { throw new AccessDeniedException("非法访问"); }
  
        /* According to the parameter rid, call deleteByRid() to delete */
        Integer rows1 = informationMapper.deleteByRid(rid);
        if (rows1 != 1) { throw new DeleteException("删除用户信息时出现未知错误，请联系系统管理员"); }
  
        /* Determine whether isDefault in the query result is 0 */
        if (result.getIsDefault() == 0) { return; }
  
        /* Count how many user information there is currently */
        Integer count = informationMapper.countByUid(uid);

        /* Determine if the current number of users is 0 */
        if (count == 0) { return; }
  
        /* Find out the most recently modified information by the user */
        Information lastModified = informationMapper.findLastModified(uid);

        /* Find the value of the rid attribute from the above query results */
        Integer lastModifiedRid = lastModified.getRid();

        /* Set the default user information and get the number of affected rows returned */
        Integer rows2 = informationMapper.updateDefaultByRid(lastModifiedRid, username, new Date());

        /* Determine whether the number of affected rows is not 1 */
        if (rows2 != 1) { throw new UpdateException("更新用户信息时出现未知错误，请联系系统管理员"); }
    }

     /**
     * According to the information data id, query the details of the information
     * @param rid Integer used to get information
     * @param uid Integer to check whether current information belong to this uid
     * @return the detail information of the reservation information
     * @exception/throws ServiceException
     */
    @Override
    public Information getByRid(Integer rid, Integer uid) {
        Information information = informationMapper.findByRid(rid);
  
        if (information == null) {
            throw new InformationNotFoundException("尝试访问的信息数据不存在");
        }

        if (!information.getUid().equals(uid)) {
            throw new AccessDeniedException("非法访问");
        }

        information.setDepartmentCode(null);
        information.setMajorCode(null);
        information.setGradeCode(null);
        information.setCreatedUser(null);
        information.setCreatedTime(null);
        information.setModifiedUser(null);
        information.setModifiedTime(null);

        return information;
    }

}
