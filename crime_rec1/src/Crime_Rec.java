import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Crime_Rec {
    private JPanel Main;
    private JLabel Prison_id;
    private JLabel Prison_name;
    private JLabel Prison_address;
    private JLabel Phone_no;
    private JLabel Criminal_id;
    private JTextField textpid;
    private JTextField textname;
    private JTextField textadd;
    private JTextField textphno;
    private JTextField textcid;
    private JButton btnsave;
    private JTable table1;
    private JButton btnupdate;
    private JButton btndelete;
    private JButton btnsearch;
    private JTextField textsearch;
    private JScrollPane prison_table;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Crime_Rec");
        frame.setContentPane(new Crime_Rec().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    // databasq connection

    Connection conn;
    PreparedStatement pst;
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Crime_Record_Management", "root", "Ansh@123");
            System.out.println("Success Mysql connection");
        }
        catch (ClassNotFoundException ex){
            System.out.println(ex);
        }
        catch (SQLException ex){
            System.out.println(ex);
        }

    }

    // method to load the records in GUI table

    void load_table(){
        try{
            pst = conn.prepareStatement("select* from Prison_Info");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs)); // private JTable table1;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    void emptyFields(){
        textpid.setText(" ");
        textname.setText(" ");
        textphno.setText(" ");
        textadd.setText(" ");
        textcid.setText(" ");
        textname.requestFocus();
    }


    public Crime_Rec() {
        connect();
        load_table();
        // action listener for save button
        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // initialize and assign the variables of GUI
                String p_id, p_name, ph_no, p_add, c_id;
                p_id = textpid.getText();
                p_name = textname.getText();
                ph_no = textphno.getText();
                p_add = textadd.getText();
                c_id = textcid.getText();

                // to insert the data into the database table
                try {
                    pst = conn.prepareStatement("insert into Prison_Info(Prison_id, Prison_name, Phone_no, Prison_address, Criminal_id) values(?,?,?,?,?)");
                    pst.setString(1, p_id);
                    pst.setString(2, p_name);
                    pst.setString(3, ph_no);
                    pst.setString(4, p_add);
                    pst.setString(5, c_id);
                    // to add records in db table
                    pst.executeUpdate();
                    //popup msg for added record
                    JOptionPane.showMessageDialog(null, "Record added !");
                    load_table();
                    emptyFields();
                }
                catch(SQLException e1){
                    e1.printStackTrace();
                }

            }
        });
        btnsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String id = textsearch.getText();
                    pst = conn.prepareStatement("select * from Prison_Info where Prison_id = ?");
                    pst.setString(1, id);
                    ResultSet rs = pst.executeQuery();

                    if(rs.next() == true){
                        String Prison_id = rs.getString(1);
                        String Prison_name = rs.getString(2);
                        String Phone_no = rs.getString(3);
                        String Prison_address = rs.getString(4);
                        String Criminal_id = rs.getString(5);

                        //to display the records in text field

                        textpid.setText(Prison_id);
                        textname.setText(Prison_name);
                        textphno.setText(Phone_no);
                        textadd.setText(Prison_address);
                        textcid.setText(Criminal_id);
                    }
                    else{
                        emptyFields();
                        JOptionPane.showMessageDialog(null, "Invalid id selection !");
                    }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        btnupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // initialize and assign the variables of GUI
                String p_id, p_name, ph_no, p_add, c_id;
                p_id = textpid.getText();
                p_name = textname.getText();
                ph_no = textphno.getText();
                p_add = textadd.getText();
                c_id = textcid.getText();

                try{
                    pst = conn.prepareStatement("update Prison_Info set Prison_name = ?, Phone_no = ?, Prison_address = ?, Criminal_id = ? where Prison_id = ?");
                    System.out.println(pst);
                    System.out.println(p_id);
                    pst.setString(1, p_name);
                    pst.setString(2, ph_no);
                    pst.setString(3, p_add);
                    pst.setString(4, c_id);
                    pst.setString(5, p_id);
                    // to add records in db table
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Records updated !");
                    load_table();

                    emptyFields();
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p_id;
                p_id = textpid.getText();

                try{
                    pst = conn.prepareStatement("delete from Prison_info where Prison_id = ?");
                    pst.setString(1, p_id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Reord deleted !");
                    load_table();
                    emptyFields();
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                }

            }
        });
    }
}
