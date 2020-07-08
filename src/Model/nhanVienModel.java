/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.nhanVienController;
import View.nhanVienView;
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
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
/**
 *
 * @author PC
 */
public class nhanVienModel {
    
    private nhanVienView View;
    private nhanVienController Controller;
    private String mans;
    private String ho;
    private String ten;
    private String ngaysinh;
    private String sdt;
    private String email;
    private String diachi;
    private String luong;
    private String ngayvaolam;
    private String mota;
    private String username;
    private String password;
    private String role;
    
    public nhanVienModel(){}
    public nhanVienModel(String mans, String ho,String ten,String ngaysinh, String sdt,
            String email, String diachi, String luong,String ngayvaolam,String mota,
            String username, String password, String role){
        this.mans=mans;
        this.ho=ho;
        this.ten=ten;
        this.ngaysinh=ngaysinh;
        this.sdt=sdt;
        this.email=email;
        this.diachi=diachi;
        this.luong=luong;
        this.ngayvaolam=ngayvaolam;
        this.mota=mota;
        this.username=username;
        this.password=password;
        this.role=role;
    }
    
    public String mans(){return mans;}
    public String ho(){return ho;}
    public String ten(){return ten;}
    public String sdt(){return sdt;}
    public String email(){return email;}
    public String diachi(){return diachi;}
    public String luong(){return luong;}
    public String mota(){return mota;}
    public String ngayvaolam(){return ngayvaolam;}
    public String ngaysinh(){return ngaysinh;}
    public String username(){return username;}
    public String password(){return password;}
    public String role(){return role;}
    
    public ArrayList<nhanVienModel> getNhanVien() {
        ArrayList<nhanVienModel> list=new ArrayList<>();
        String SQL="select * from nhansu";
        try{
            DBConnection.getInstance().getConn();
            Statement statement =DBConnection.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            nhanVienModel nv;
            while(rs.next())
            {
                nv=new nhanVienModel(rs.getString("mans"),rs.getString("ho"),rs.getString("ten"),rs.getString("ngaysinh"),
                        rs.getString("sdt"),rs.getString("email"),rs.getString("diachi"),rs.getString("luong"),rs.getString("ngayvaolam"),rs.getString("mota"),
                        rs.getString("username"), rs.getString("password"),rs.getString("role"));
                list.add(nv);
            }
            DBConnection.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    
    public boolean themNV(String ho,String ten,String ngaysinh,String sdt,String email,String diachi,String luong,String ngayvaolam,String mota,String username, String password,String role) {
        String SQL="BEGIN PRO_THEMNV('"+ho+"','"+ten+"','"+ngaysinh+"','"+sdt+"','"+email+"','"+diachi+"',"+luong+",'"+ngayvaolam+"','"+mota+"','"+username+"','"+password+"',"+role+"); END;";
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
        } catch (SQLException e) {
            System.out.println(e);
            return false;}
    }
    public boolean xoaNV(String manv){
        String SQL="BEGIN PRO_XOANV("+manv+");END;";
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
        } catch (SQLException e) {
            return false;
        }
    }
    public boolean capNhatNV(String manv, String ho,String ten, String ngaysinh , String sdt, String email, String diachi, 
            String luong, String ngayvaolam, String mota, String username, String password, String role){
        String SQL="BEGIN PRO_CAPNHATNV("+manv+",'"+ho+"','"+ten+"','"+ngaysinh+"','"+sdt+"','"+email+"','"+diachi+"',"+luong+",'"+ngayvaolam+"','"+mota+"','"+username+"','"+password+"',"+role+"); END;";
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
        }catch(SQLException e){
            return false;
        }
    }
    public boolean dangNhap(String p_username, String p_password ){
        String sql = "Select * from NhanSu where username=? and password =?";
        try{
            DBConnection.getInstance().getConn();
//            Statement stm = DBConnection.getInstance().conn.createStatement();
//            ResultSet rs = stm.executeQuery(sql);
               OraclePreparedStatement pst = null;
               OracleResultSet rs = null;
               pst = (OraclePreparedStatement) DBConnection.getInstance().conn.prepareStatement(sql);
               pst.setString(1, p_username);
               pst.setString(2, p_password);
               rs = (OracleResultSet) pst.executeQuery();
            while(rs.next())
                return true;
            return false; 
        }catch(SQLException e){
            return false;
        }
    }
    public nhanVienModel getNhanVienByUsername(String p_username){
        String sql = "Select * from NhanSu where username=?";
        nhanVienModel nv_rs = null;
        try{
            DBConnection.getInstance().getConn();
//            Statement stm = DBConnection.getInstance().conn.createStatement();
//            ResultSet rs = stm.executeQuery(sql);
               OraclePreparedStatement pst = null;
               OracleResultSet rs = null;
               pst = (OraclePreparedStatement) DBConnection.getInstance().conn.prepareStatement(sql);
               pst.setString(1, p_username);
               rs = (OracleResultSet) pst.executeQuery();
            while(rs.next()){
                nv_rs = new nhanVienModel(rs.getString("mans"),rs.getString("ho"),rs.getString("ten"),rs.getString("ngaysinh"),
                        rs.getString("sdt"),rs.getString("email"),rs.getString("diachi"),rs.getString("luong"),rs.getString("ngayvaolam"),rs.getString("mota"),
                        rs.getString("username"), rs.getString("password"),rs.getString("role"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return nv_rs;
    }
}