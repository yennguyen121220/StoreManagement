/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CSVCModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class CSVCController {
    CSVCModel Model=new CSVCModel();
    public void getCSVC(JTable table) {
        String[] head=new String[]{"Mã CSVC","Tên CSVC","Tình trạng"};
        ArrayList<CSVCModel> list= Model.getCSVC();
        Object[][] body=new Object[list.size()][3];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((CSVCModel)list.get(i)).macsvc();
            body[i][1]=((CSVCModel)list.get(i)).tencsvc();
            body[i][2]=((CSVCModel)list.get(i)).tinhtrang();
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
    }
    public void timCSVC(JTable table, String text) {
        String[] head=new String[]{"Mã CSVC","Tên CSVC", "Tình trạng"};
        ArrayList<CSVCModel> list= Model.getCSVC();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).macsvc().contains(text) && !list.get(i).tencsvc().equals(text) 
                    && !list.get(i).tinhtrang().contains(text) )
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][3];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=((CSVCModel)list.get(i)).macsvc();
            body[i][1]=((CSVCModel)list.get(i)).tencsvc();
            body[i][2]=((CSVCModel)list.get(i)).tinhtrang();
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
    }
    public boolean themCSVC(String tencsvc, String tinhtrang) {
        if(tencsvc.equals("")||tinhtrang.equals(""))
            return false;
        return Model.themCSVC(tencsvc, tinhtrang);
    }
    public boolean xoaCSVC(String macsvc) {
        return Model.xoaCSVC(macsvc);
    }
//    public boolean capNhatCSVC(String macsvc, String tencsvc, String tinhtrang){
//    }

    public boolean capNhatCSVC(String macsvc, String tencsvc, String tinhtrang) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        return Model.capNhatCSVC(macsvc,tencsvc,tinhtrang);
    }

}
