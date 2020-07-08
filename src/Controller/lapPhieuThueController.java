/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.gianHangModel;
import Model.khachHangModel;
import Model.lapPhieuThueModel;
import Model.nhanVienModel;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC
 */
public class lapPhieuThueController {
    lapPhieuThueModel Model=new lapPhieuThueModel();
     public void getPhieuThue(JTable table) {
        String[] head=new String[]{"Mã phiếu thuê","Mã nhân viên","Mã gian hàng","Mã khách hàng","Giá"};
        ArrayList<lapPhieuThueModel> list= Model.getPhieuThue();
        Object[][] body=new Object[list.size()][5];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((lapPhieuThueModel)list.get(i)).mapt();
            body[i][1]=((lapPhieuThueModel)list.get(i)).mans();
            body[i][2]=((lapPhieuThueModel)list.get(i)).magh();
            body[i][3]=((lapPhieuThueModel)list.get(i)).makh();
            body[i][4]=((lapPhieuThueModel)list.get(i)).gia();
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
    }
    public void timPhieuThue(JTable table, String text) {
        String[] head=new String[]{"Mã phiếu thuê","Mã nhân viên", "Mã gian hàng", "Mã khách hàng","Giá"};
        ArrayList<lapPhieuThueModel> list= Model.getPhieuThue();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).mapt().contains(text) && !list.get(i).mans().equals(text) 
                    && !list.get(i).magh().contains(text) && !list.get(i).makh().contains(text)
                    && !list.get(i).gia().contains(text))
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][5];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((lapPhieuThueModel)list.get(i)).mapt();
            body[i][1]=((lapPhieuThueModel)list.get(i)).mans();
            body[i][2]=((lapPhieuThueModel)list.get(i)).magh();
            body[i][3]=((lapPhieuThueModel)list.get(i)).makh();
            body[i][4]=((lapPhieuThueModel)list.get(i)).gia();
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
    }

    public void loadNhanVien(JComboBox<String> cbNhanVien) {
        cbNhanVien.removeAllItems();
        ArrayList<nhanVienModel>list= (new nhanVienModel()).getNhanVien();
        for(int i=0;i<list.size();i++)
        {
            cbNhanVien.addItem(list.get(i).ten()+":"+list.get(i).mans());
        }
    }
    public void loadGianHang(JComboBox<String> cbGianHang) {
        cbGianHang.removeAllItems();
        ArrayList<gianHangModel>list= (new gianHangModel()).getGianHang();
        for(int i=0;i<list.size();i++)
        {
            cbGianHang.addItem(list.get(i).magh()+":"+list.get(i).tinhtrang() + ":"+list.get(i).gia());
        }
    }
    public void loadKhachHang(JComboBox<String> cbKhachHang) {
        cbKhachHang.removeAllItems();
        ArrayList<khachHangModel>list= (new khachHangModel()).getKhachHang();
        for(int i=0;i<list.size();i++)
        {
            cbKhachHang.addItem(list.get(i).ten()+":"+list.get(i).makh());
        }
    }
    public boolean themCTPhieuThue(String mans,String magh,String makh, String ngaylap, String gia) {
        if(mans.equals("")||magh.equals("")||makh.equals("")||ngaylap.equals("")||gia.equals(""))
            return false;
        return Model.themCTPhieuThue(mans, magh, makh, ngaylap,gia);
    }
    public boolean xoaCTPhieuThue(String mapt){
        return Model.xoaCTPhieuThue(mapt);
    }
    public boolean capNhatPhieuThue(String mapt, String mans, String magh,String makh,String gia){
        return Model.capNhatPhieuThue(mapt, mans, magh, makh, gia);
    }
}
