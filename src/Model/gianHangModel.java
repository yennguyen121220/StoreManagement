/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.gianHangController;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class gianHangModel {
    private gianHangController Controller;
    private String magh;
    private String vitri;
    private String kichthuoc;
    private String gia;
    private String tinhtrang;
    
    public gianHangModel(){}
    public gianHangModel(String magh,String vitri, String kichthuoc,String gia,String tinhtrang){
        this.magh=magh;
        this.vitri=vitri;
        this.kichthuoc=kichthuoc;
        this.gia=gia;
        this.tinhtrang=tinhtrang;
    }
    public String magh(){ return magh;}
    public String vitri(){ return vitri;}
    public String kichthuoc(){ return kichthuoc;}
    public String gia(){ return gia;}
    public String tinhtrang(){return tinhtrang;}
    
    public ArrayList<gianHangModel> getGianHang() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<gianHangModel> list=new ArrayList<>();
        try{
            DBConnection.getInstance().getConn();
            String SQL="select * from gianhang";
            Statement statement =DBConnection.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            gianHangModel gh;
            while(rs.next())
            {
                gh=new gianHangModel(rs.getString("magh"),rs.getString("vitri"),rs.getString("kichthuoc"),rs.getString("gia"),rs.getString("tinhtrang"));
                list.add(gh);
            }
            DBConnection.getInstance().getClose();
        } catch (Exception e) {}
        return list;
        
    }
    
    public boolean themGH(String vitri,String kichthuoc,String gia,String tinhtrang) {
        String SQL="BEGIN PRO_THEMGH('"+vitri+"','"+kichthuoc+"',"+gia+","+tinhtrang+"); END;";
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
    public boolean xoaGH(String magh){
        String SQL="BEGIN PRO_XOAGH("+magh+");END;";
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
    public boolean capNhatGH(String magh, String vitri,String kichthuoc, String gia,String tinhtrang ){
        String SQL="BEGIN PRO_CAPNHATGH("+magh+",'"+vitri+"','"+kichthuoc+"',"+gia+","+tinhtrang+"); END;";
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
