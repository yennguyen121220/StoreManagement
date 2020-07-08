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
public class lapPhieuThueModel {
    private String mapt;
    private String mans;
    private String magh;
    private String makh;
    private String ngaylap;
    private String gia;
    
    public lapPhieuThueModel(){}
    
    public lapPhieuThueModel(String mapt, String mans, String magh, String makh, String gia){
        this.mapt=mapt;
        this.mans=mans;
        this.magh=magh;
        this.makh=makh;
        this.gia=gia;
    }
    
    public lapPhieuThueModel(String mapt, String mans, String magh, String makh,String ngaylap, String gia){
        this.mapt=mapt;
        this.mans=mans;
        this.magh=magh;
        this.makh=makh;
        this.ngaylap=ngaylap;
        this.gia=gia;
    }
    public String mapt(){return mapt;}
    public String mans(){return mans;}
    public String magh(){return magh;}
    public String makh(){return makh;}
    public String ngaylap(){return ngaylap;}
    public String gia(){return gia;}
    
    public ArrayList<lapPhieuThueModel> getPhieuThue() {
        ArrayList<lapPhieuThueModel> list=new ArrayList<>();
        String SQL="select * from thue";
        try{
            DBConnection.getInstance().getConn();
            Statement statement =DBConnection.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            lapPhieuThueModel pt;
            while(rs.next())
            {
                pt=new lapPhieuThueModel(rs.getString("mapt"),rs.getString("mans"),rs.getString("magh"),rs.getString("makh"),rs.getString("gia"));
                list.add(pt);
            }
            DBConnection.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    
    public boolean themCTPhieuThue(String mans,String magh, String makh,String ngaylap, String gia) {
        String SQL="BEGIN PRO_THEMCHITIETPHIEUTHUE("+mans+","+magh+","+makh+",'"+ngaylap+"',"+gia+"); END;";
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
    public boolean xoaCTPhieuThue(String mapt){
        String SQL="begin pro_xoachitietphieuthue("+mapt+"); end;";
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
    public boolean capNhatPhieuThue(String mapt, String mans,String magh, String makh,String gia ){
        String SQL="BEGIN PRO_CAPNHATPHIEUTHUE("+mapt+",'"+mans+"','"+magh+"',"+makh+","+gia+"); END;";
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
