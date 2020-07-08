/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.khachHangModel;
import View.khachHangView;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC
 */
public class khachHangController {
    
    khachHangModel Model=new khachHangModel();
    public void getKhachHang(JTable table) {
        String[] head=new String[]{"Mã khách hàng","Họ","Tên","SDT","Email","Nơi làm việc","CMND"};
        ArrayList<khachHangModel> list= Model.getKhachHang();
        Object[][] body=new Object[list.size()][7];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((khachHangModel)list.get(i)).makh();
            body[i][1]=((khachHangModel)list.get(i)).ho();
            body[i][2]=((khachHangModel)list.get(i)).ten();
            body[i][3]=((khachHangModel)list.get(i)).sdt();
            body[i][4]=((khachHangModel)list.get(i)).email();
            body[i][5]=((khachHangModel)list.get(i)).noilamviec();
            body[i][6]=((khachHangModel)list.get(i)).cmnd();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(200);
    }
    public void timKhachHang(JTable table, String text) {
        String[] head=new String[]{"Mã khách hàng","Họ", "Tên", "Nơi làm việc","SDT", "Email", "CMND"};
        ArrayList<khachHangModel> list= Model.getKhachHang();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).makh().contains(text) && !list.get(i).ho().equals(text) 
                    && !list.get(i).ten().contains(text) && !list.get(i).noilamviec().contains(text)
                    && !list.get(i).sdt().contains(text)&& !list.get(i).email().contains(text)
                    && !list.get(i).cmnd().contains(text))
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][7];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((khachHangModel)list.get(i)).makh();
            body[i][1]=((khachHangModel)list.get(i)).ho();
            body[i][2]=((khachHangModel)list.get(i)).ten();
            body[i][3]=((khachHangModel)list.get(i)).sdt();
            body[i][4]=((khachHangModel)list.get(i)).email();
            body[i][5]=((khachHangModel)list.get(i)).noilamviec();
            body[i][6]=((khachHangModel)list.get(i)).cmnd();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

//    public void getKhachHang(JTable KHtable) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public boolean themKH(String ho, String ten,String sdt, String email, String noilamviec, String cmnd ) {
        if(ho.equals("")||ten.equals("")||sdt.equals("")||email.equals("")||noilamviec.equals("")||cmnd.equals(""))
            return false;
        return Model.themKH(ho, ten, sdt, email, noilamviec, cmnd);
    }
    public boolean capNhatKH(String makh, String ho, String ten, String sdt, String email, String noilamviec, String cmnd){
        return Model.capNhatKH(makh, ho, ten, sdt, email, noilamviec, cmnd);
    }

    public boolean xoaKH(String makh) {
//        throw new UnsupportedOperationException("Not supported yet."); 
         return Model.xoaKH(makh);
    }
}
