package viewgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author iXeon
 */
public class PanelFactory extends JFrame {

    public PanelFactory() {}

    public void initsCreate(){
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

    }

    public void initsSet1(){

        jLabel6.setText("jLabel6.text"); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setBackground(Color.WHITE); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("jLabel7.text"); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setOpaque(true);

        jLabel2.setText("jLabel2.text"); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setBackground(Color.WHITE); // NOI18N
        jLabel3.setText("jLabel3.text"); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setName("jLabel3"); // NOI18N
        jLabel3.setOpaque(true);

        jLabel4.setText("jLabel4.text"); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setBackground(Color.WHITE); // NOI18N
        jLabel5.setText("jLabel5.text"); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        jLabel5.setOpaque(true);

        jLabel8.setBackground(Color.WHITE); // NOI18N
        jLabel8.setText("jLabel8"); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        jLabel8.setOpaque(true);
        //jLabel8.setHorizontalTextPosition(JLabel.CENTER);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setBackground(new Color(204, 204, 255)); // NOI18N
        jLabel9.setText("jLabel9.text"); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setName("jLabel9"); // NOI18N
        jLabel9.setOpaque(true);

        jLabel10.setBackground(Color.WHITE); // NOI18N
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        //jLabel10.setFont(resourceMap.getFont("jLabel10.font"); // NOI18N
        jLabel10.setText("jLabel10.text"); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setOpaque(true);
    }

    public void initsSet2(){
        jLabel1.setText("jLabel1.text"); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        //jScrollPane1.setViewportView(jLabel1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.setName("panelCatInfo"); // NOI18N

        jLabel6.setText("jLabel6.text"); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setBackground(Color.WHITE); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("jLabel7.text"); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setOpaque(true);

        jLabel2.setText("jLabel2.text"); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setBackground(Color.WHITE); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3.text"); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setName("jLabel3"); // NOI18N
        jLabel3.setOpaque(true);

        jLabel4.setText("jLabel4.text"); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setBackground(Color.WHITE); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel5.text"); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        jLabel5.setOpaque(true);

        jLabel8.setBackground(Color.WHITE); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("jLabel8.text"); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new Color(204, 204, 255)); // NOI18N
        jLabel9.setText("CatDescription.text"); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setName("CatDescription"); // NOI18N
        jLabel9.setOpaque(true);

        jLabel10.setBackground(new Color(204, 204, 255)); // NOI18N
        //jLabel10.setFont(resourceMap.getFont("jLabel10.font"); // NOI18N
        jLabel10.setText("jLabel10.text"); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setOpaque(true);
    }

    public JPanel getCatPanel(){
        jPanel1 = new JPanel();
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))))
                .addGap(7, 7, 7)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        

        System.out.println("Panel: " + jPanel1);
        return jPanel1;
    }

    public static void main(String[] args){
        PanelFactory pf = new PanelFactory();
        
        pf.initsCreate();
        pf.initsSet2();

        JPanel jp = pf.getCatPanel();
        pf.getContentPane().add(pf.jPanel1);

        Container con= pf.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(pf.jPanel1, BorderLayout.CENTER);

        pf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pf.setSize(750, 500);
        pf.pack();
        pf.setVisible(true);
    }


    //Variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10; //titleLabel
    private javax.swing.JLabel jLabel2; //lblTotalSubCat
    private javax.swing.JLabel jLabel3; //TotalSubCat
    private javax.swing.JLabel jLabel4; //lblTotalArticles
    private javax.swing.JLabel jLabel5; //TotalArticles
    private javax.swing.JLabel jLabel6; //lblCummTotalArticles
    private javax.swing.JLabel jLabel7; //CatDescription
    private javax.swing.JLabel jLabel8; //CummTotalArticles
    private javax.swing.JLabel jLabel9; //lblCatDescription
    private JPanel jPanel1;


}
