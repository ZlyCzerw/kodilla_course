package com.kodilla.jdbc;

import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException{
        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        //when
        String sqlProcedureCall  =  "Call UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

    }
}
