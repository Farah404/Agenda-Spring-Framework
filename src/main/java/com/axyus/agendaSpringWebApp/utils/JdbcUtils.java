/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.axyus.agendaSpringWebApp.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author farah.gauduin
 */
public class JdbcUtils extends com.axyus.jdbc.JdbcUtils {

    public static String getStringColumnIfExists(ResultSet resultSet, String columnName) throws SQLException {
        return columnExists(resultSet, columnName) ? resultSet.getString(columnName) : null;
    }
    
    public static Integer getIntIfColumnExists(ResultSet resultSet, String columnName)throws SQLException{
         return columnExists(resultSet, columnName) ? resultSet.getInt(columnName) : null;
    }

    public static boolean columnExists(ResultSet resultSet, String columnName) {
        try {
            return resultSet.findColumn(columnName) >= 0;
        } catch (SQLException ex) {
            return false;
        }
    }

}
