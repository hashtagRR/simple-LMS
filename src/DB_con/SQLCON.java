/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_con;

import java.sql.*;
import javax.swing.JOptionPane;

public class SQLCON 
{
    public static Connection connect()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","1234");
            //JOptionPane.showMessageDialog(null,"Connected");
            return con;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    
    }
}
