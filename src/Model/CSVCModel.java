/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CSVCController;
import View.CSVCView;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CSVCModel {
    private CSVCView View;
    private CSVCController Controller;
    
    public String macsvc;
    public String tencsvc;
    public String tinhtrang;  
    public CSVCModel(){}
    public CSVCModel(String macsvc, String tencsvc,String tinhtrang){
        this.macsvc=macsvc;
        this.tencsvc=tencsvc;
        this.tinhtrang=tinhtrang;
    }
    
    public String macsvc(){return macsvc;}
    public String tencsvc(){return tencsvc;}
    public String tinhtrang(){return tinhtrang;}
    

    public ArrayList<CSVCModel> getCSVC() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<CSVCModel> list=new ArrayList<>();
        try{
            DBConnection.getInstance().getConn();
            String SQL="select * from csvc";
            Statement statement =DBConnection.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            CSVCModel csvc;
            while(rs.next())
            {
                csvc=new CSVCModel(rs.getString("macsvc"),rs.getString("tencsvc"),rs.getString("tinhtrang"));
                list.add(csvc);
            }
            DBConnection.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    public boolean themCSVC(String tencsvc,String tinhtrang) {
        String SQL="BEGIN PRO_THEMCSVC('"+tencsvc+"','"+tinhtrang+"'); END;";
            try{
            DBConnection.getInstance().getConn();
            Statement sta =DBConnection.getInstance().conn.createStatement();
            int rs1=sta.executeUpdate(SQL);
            if(rs1>0)
            {
                DBConnection.getInstance().getClose();
                return true;
            }
            else
            {
                DBConnection.getInstance().getClose();
                return false;
            }
        } catch (Exception e) {return false;}
    }
    public boolean xoaCSVC(String macsvc) {
        String SQL="BEGIN PRO_XOACSVC("+macsvc+"); END;";
        try {
            DBConnection.getInstance().getConn();
            Statement sta=DBConnection.getInstance().conn.createStatement();
            int rs=sta.executeUpdate(SQL);
            if(rs>0)
            {
                DBConnection.getInstance().getClose();
                return true;
            }
            else{
                DBConnection.getInstance().getClose();
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public boolean capNhatCSVC(String macsvc, String tencsvc, String tinhtrang) {
        String SQL="BEGIN PRO_CAPNHATCSVC("+macsvc+",'"+tencsvc+"','"+tinhtrang+"'); END;";
        try{
            DBConnection.getInstance().getConn();
            Statement st=DBConnection.getInstance().conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
            {
                DBConnection.getInstance().getClose();
                return true;
            }
            else{
                DBConnection.getInstance().getClose();
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }

}
