/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.gianHangModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class gianHangController {
    gianHangModel Model=new gianHangModel();
    public void getGianHang(JTable table) {
        String[] head=new String[]{"Mã gian hàng","Vị trí","Kích thước","Giá","Tình trạng"};
        ArrayList<gianHangModel> list= Model.getGianHang();
        Object[][] body=new Object[list.size()][5];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((gianHangModel)list.get(i)).magh();
            body[i][1]=((gianHangModel)list.get(i)).vitri();
            body[i][2]=((gianHangModel)list.get(i)).kichthuoc();
            body[i][3]=((gianHangModel)list.get(i)).gia();
            body[i][4]=((gianHangModel)list.get(i)).tinhtrang();
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
    public void timGianHang(JTable table, String text) {
        String[] head=new String[]{"Mã gian hàng","Vị trí", "Kích thước","Giá","Tình trạng"};
        ArrayList<gianHangModel> list= Model.getGianHang();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).magh().contains(text) && !list.get(i).vitri().equals(text) 
                    && !list.get(i).kichthuoc().contains(text) && !list.get(i).gia().contains(text)
                    && !list.get(i).tinhtrang().contains(text))
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][5];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((gianHangModel)list.get(i)).magh();
            body[i][1]=((gianHangModel)list.get(i)).vitri();
            body[i][2]=((gianHangModel)list.get(i)).kichthuoc();
            body[i][3]=((gianHangModel)list.get(i)).gia();
            body[i][4]=((gianHangModel)list.get(i)).tinhtrang();
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
    
    public boolean themGH(String vitri, String kichthuoc,String gia,String tinhtrang) {
        if(vitri.equals("")||kichthuoc.equals("")||gia.equals("")||tinhtrang.equals(""))
            return false;
        return Model.themGH(vitri, kichthuoc, gia, tinhtrang);
    }
    public boolean xoaGH(String magh){
        return Model.xoaGH(magh);
    }
    public boolean capNhatGH(String magh, String vitri, String kichthuoc,String gia,String tinhtrang){
        return Model.capNhatGH(magh, vitri, kichthuoc, gia, tinhtrang);
    }
}
