/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class hoaDonModel {
    private String mahd;
    private String mapt;
    private String ngaylap;
    private String giatri;
    
    public hoaDonModel(){}
    public hoaDonModel(String mahd, String mapt, String ngaylap, String giatri){
        this.mahd=mahd;
        this.mapt=mapt;
        this.ngaylap=ngaylap;
        this.giatri=giatri;
    }
    
    public String mahd(){return mahd;}
    public String mapt(){return mapt;}
    public String ngaylap(){return ngaylap;}
    public String giatri(){return giatri;}
    
    public ArrayList<hoaDonModel> getHoaDon() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<hoaDonModel> list=new ArrayList<>();
        try{
            DBConnection.getInstance().getConn();
            String SQL="select * from hoadon";
            Statement statement =DBConnection.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            hoaDonModel hd;
            while(rs.next())
            {
                hd=new hoaDonModel(rs.getString("mahd"),rs.getString("mapt"),rs.getString("ngaylap"),rs.getString("giatri"));
                list.add(hd);
            }
            DBConnection.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    public boolean themHoaDon(String mapt,String ngaylap, String gia) {
        String SQL="BEGIN PRO_THEMHOADON("+mapt+",'"+ngaylap+"',"+gia+"); END;";
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
    public boolean xoaHoaDon(String mahd){
        String SQL="BEGIN PRO_XOAHOADON("+mahd+"); END;";
        try{
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
        } catch(Exception e){
            return false;
                   
        }
    }
}
