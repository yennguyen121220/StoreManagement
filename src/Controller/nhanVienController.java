/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.nhanVienModel;
import View.nhanVienView;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class nhanVienController {
    nhanVienModel Model=new nhanVienModel();
    public void getNhanVien(JTable table) {
        String[] head=new String[]{"Mã nhân viên","Họ","Tên","Ngày sinh","SDT","Email","Địa chỉ","Lương","Ngày vào làm","Mô tả","Username","Password","Role"};
        ArrayList<nhanVienModel> list= Model.getNhanVien();
        Object[][] body=new Object[list.size()][13];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((nhanVienModel)list.get(i)).mans();
            body[i][1]=((nhanVienModel)list.get(i)).ho();
            body[i][2]=((nhanVienModel)list.get(i)).ten();
            body[i][3]=((nhanVienModel)list.get(i)).ngaysinh();
            body[i][4]=((nhanVienModel)list.get(i)).sdt();
            body[i][5]=((nhanVienModel)list.get(i)).email();
            body[i][6]=((nhanVienModel)list.get(i)).diachi();
            body[i][7]=((nhanVienModel)list.get(i)).luong();
            body[i][8]=((nhanVienModel)list.get(i)).ngayvaolam();
            body[i][9]=((nhanVienModel)list.get(i)).mota();
            body[i][10]=((nhanVienModel)list.get(i)).username();
            body[i][11]=((nhanVienModel)list.get(i)).password();
            body[i][12]=((nhanVienModel)list.get(i)).role();
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
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        table.getColumnModel().getColumn(8).setPreferredWidth(200);
        table.getColumnModel().getColumn(9).setPreferredWidth(200);
        table.getColumnModel().getColumn(10).setPreferredWidth(200);
        table.getColumnModel().getColumn(11).setPreferredWidth(200);
        table.getColumnModel().getColumn(12).setPreferredWidth(200);
    }
    public void timNhanVien(JTable table, String text) {
        String[] head=new String[]{"Mã nhân viên","Họ","Tên","Ngày sinh","SDT","Email","Địa chỉ","Lương","Ngày vào làm","Mô tả","Username","Password","Role"};
        ArrayList<nhanVienModel> list= Model.getNhanVien();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).mans().contains(text) && !list.get(i).ho().equals(text) 
                    && !list.get(i).ten().contains(text) && !list.get(i).ngaysinh().contains(text)
                    && !list.get(i).sdt().contains(text)&& !list.get(i).email().contains(text)
                    && !list.get(i).diachi().contains(text)&& !list.get(i).luong().contains(text)
                    && !list.get(i).ngayvaolam().contains(text)&& !list.get(i).mota().contains(text)
                    && !list.get(i).username().contains(text)&& !list.get(i).password().contains(text)
                    && !list.get(i).role().contains(text))
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][13];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((nhanVienModel)list.get(i)).mans();
            body[i][1]=((nhanVienModel)list.get(i)).ho();
            body[i][2]=((nhanVienModel)list.get(i)).ten();
            body[i][3]=((nhanVienModel)list.get(i)).ngaysinh();
            body[i][4]=((nhanVienModel)list.get(i)).sdt();
            body[i][5]=((nhanVienModel)list.get(i)).email();
            body[i][6]=((nhanVienModel)list.get(i)).diachi();
            body[i][7]=((nhanVienModel)list.get(i)).luong();
            body[i][8]=((nhanVienModel)list.get(i)).ngayvaolam();
            body[i][9]=((nhanVienModel)list.get(i)).mota();
            body[i][10]=((nhanVienModel)list.get(i)).username();
            body[i][11]=((nhanVienModel)list.get(i)).password();
            body[i][12]=((nhanVienModel)list.get(i)).role();
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
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        table.getColumnModel().getColumn(8).setPreferredWidth(200);
        table.getColumnModel().getColumn(9).setPreferredWidth(200);
        table.getColumnModel().getColumn(10).setPreferredWidth(200);
        table.getColumnModel().getColumn(11).setPreferredWidth(200);
        table.getColumnModel().getColumn(12).setPreferredWidth(200);
    }
    public boolean themNV(String ho, String ten,String ngaysinh, String sdt, String email, String diachi, 
            String luong,String ngayvaolam,String mota, String username, String password, String role ) {
        if(ho.equals("")||ten.equals("")||ngaysinh.equals("")||sdt.equals("")||email.equals("")||diachi.equals("")
                ||luong.equals("")||ngayvaolam.equals("")||username.equals("")||password.equals("")||role.equals(""))
            return false;
        return Model.themNV(ho, ten, ngaysinh, sdt, email, diachi, luong, ngayvaolam, mota, username, password, role);
    }
    public boolean xoaNV(String manv){
        return Model.xoaNV(manv);
    }
    public boolean capNhatNV(String manv, String ho, String ten,String ngaysinh, String sdt, String email, String diachi, String luong,
            String ngayvaolam,String mota, String username, String password, String role){
        return Model.capNhatNV(manv, ho, ten, ngaysinh, sdt, email, diachi, luong, ngayvaolam, mota, username, password, role);
    }
    public boolean dangNhap(String p_username, String p_password){
        return Model.dangNhap(p_username, p_password);
    }
}
