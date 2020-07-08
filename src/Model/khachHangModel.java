/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.khachHangController;
import View.khachHangView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC
 */
public class khachHangModel {
    
    private khachHangView View;
    private khachHangController Controller;
    
    public String makh;
    public String ho;
    public String ten;
    public String sdt;
    public String email;
    public String noilamviec;
    public String cmnd;
    
    public khachHangModel(){}
    public khachHangModel(String makh, String ho,String ten,String sdt, String email,
            String noilamviec, String cmnd){
        this.makh=makh;
        this.ho=ho;
        this.ten=ten;
        this.sdt=sdt;
        this.email=email;
        this.noilamviec=noilamviec;
        this.cmnd=cmnd;
    }
    
    public String makh(){return makh;}
    public String ho(){return ho;}
    public String ten(){return ten;}
    public String sdt(){return sdt;}
    public String email(){return email;}
    public String noilamviec(){return noilamviec;}
    public String cmnd(){return cmnd;}
    
    
    public ArrayList<khachHangModel> getKhachHang() {
        ArrayList<khachHangModel> list=new ArrayList<>();
        String SQL="select * from khachhang";
        try{
            DBConnection.getInstance().getConn();
            Statement statement =DBConnection.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            khachHangModel kh;
            while(rs.next())
            {
                kh=new khachHangModel(rs.getString("makh"),rs.getString("ho"),rs.getString("ten"),rs.getString("sdt"),
                        rs.getString("email"),rs.getString("noilamviec"),rs.getString("cmnd"));
                list.add(kh);
            }
            DBConnection.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    public boolean themKH(String ho,String ten,String sdt,String email,String noilamviec,String cmnd) {
        String SQL="BEGIN PRO_THEMkh('"+ho+"','"+ten+"','"+sdt+"','"+email+"','"+noilamviec+"','"+cmnd+"'); END;";
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
    public boolean xoaKH(String makh) {
        String SQL="BEGIN PRO_XOAKH("+makh+");END;";
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

    public boolean capNhatKH(String makh, String ho, String ten, String sdt, String email, String noilamviec, String cmnd) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String SQL="BEGIN PRO_CAPNHATKH("+makh+",'"+ho+"','"+ten+"','"+sdt+"','"+email+"','"+noilamviec+"','"+cmnd+"'); END;";
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
