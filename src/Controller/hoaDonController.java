/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.gianHangModel;
import Model.hoaDonModel;
import Model.lapPhieuThueModel;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class hoaDonController {
    hoaDonModel Model=new hoaDonModel();
    public void getHoaDon(JTable table) {
        String[] head=new String[]{"Mã hóa đơn","Mã phiếu thuê","Ngày lập","Giá"};
        ArrayList<hoaDonModel> list= Model.getHoaDon();
        Object[][] body=new Object[list.size()][4];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((hoaDonModel)list.get(i)).mahd();
            body[i][1]=((hoaDonModel)list.get(i)).mapt();
            body[i][2]=((hoaDonModel)list.get(i)).ngaylap();
            body[i][3]=((hoaDonModel)list.get(i)).giatri();
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
    }
    public void timHoaDon(JTable table, String text) {
        String[] head=new String[]{"Mã hóa đơn","Mã phiếu thuê", "Ngày lập","Giá"};
        ArrayList<hoaDonModel> list= Model.getHoaDon();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).mahd().contains(text) && !list.get(i).mapt().equals(text) 
                    && !list.get(i).ngaylap().contains(text) && !list.get(i).giatri().contains(text))
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][4];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((hoaDonModel)list.get(i)).mahd();
            body[i][1]=((hoaDonModel)list.get(i)).mapt();
            body[i][2]=((hoaDonModel)list.get(i)).ngaylap();
            body[i][3]=((hoaDonModel)list.get(i)).giatri();
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
    }
    public void loadPhieuThue(JComboBox<String> cbPhieuThue) {
        cbPhieuThue.removeAllItems();
        ArrayList<lapPhieuThueModel>list= (new lapPhieuThueModel()).getPhieuThue();
        for(int i=0;i<list.size();i++)
        {
            cbPhieuThue.addItem(list.get(i).mapt()+":"+list.get(i).gia());
        }
    }
    public boolean themHoaDon(String mapt,String ngaylap,String gia) {
        if(mapt.equals("")||ngaylap.equals("")||gia.equals(""))
            return false;
        return Model.themHoaDon(mapt, ngaylap, gia);
    }
    public boolean xoaHoaDon(String mahd){
        return Model.xoaHoaDon(mahd);
    }
}
