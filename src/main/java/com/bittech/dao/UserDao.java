package com.bittech.dao;

import com.bittech.po.User;
import com.bittech.tools.DbManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // access database to query data
    public List<User> queryUserDAO(){
        List<User> userList = null;
        try {
            String strSql = "select * from user";
            ResultSet rs = new DbManager().executeQueryForUser(strSql);
            userList = new ArrayList<User>();
            while(rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserAddr(rs.getString("userAddr"));
                userList.add(user);
            }
            return userList;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return userList;
    }
}
