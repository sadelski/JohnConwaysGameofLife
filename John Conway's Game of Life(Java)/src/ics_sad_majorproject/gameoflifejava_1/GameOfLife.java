// code here is used to design the Jframe
package ics_sad_majorproject.gameoflifejava_1;
//imports used by the the program
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.SwingUtilities;

public class GameOfLife extends javax.swing.JFrame {
    //Global variables
    Timer time = new Timer();
    TimerTask task;
    int timelength = 100;
   Image offScrImage;
   Graphics offScrGraphics;
   int intGridsWidth = 50, intGridsHeight = 50;
   boolean[][] cellscurrentposistion = new boolean[intGridsHeight][intGridsWidth], cellsnextposistion = new boolean[intGridsHeight][intGridsWidth];
   boolean gamelaunced;
  int intGeneration = 0;
  int[][] intcellpopulation = new int[intGridsHeight][intGridsWidth];
  int inttotalcells = 0;
  int intgridcolor = 1;
  int intlinecolor = 1;
  int intcellcolor = 1;
 
   public GameOfLife() {
       initComponents(); //activates the method and creates jpanel and sets up all the things like sliders, labels and textfields on the the jframe. 
        offScrImage = createImage(jPanel2.getWidth(), jPanel2.getHeight());
        offScrGraphics = offScrImage.getGraphics();
        this.restartTimerTask();
        repain();
   }
        
        private void restartTimerTask() {
        if (task != null) {
            task.cancel();
        }
        task = new TimerTask(){
          public void run() {
              if(gamelaunced == true){
                  intGeneration++;
               jLabel6.setText( "Generation: " + intGeneration );
              for(int intGridYpt = 0; intGridYpt < intGridsHeight; intGridYpt++){
                  for(int intGridXpt = 0; intGridXpt < intGridsWidth; intGridXpt++){
                      cellsnextposistion[intGridYpt][intGridXpt] = decide(intGridYpt,intGridXpt);
                  }   
                  }
               for(int intGridYpt = 0; intGridYpt < intGridsHeight; intGridYpt++){
                  for (int intGridXpt = 0; intGridXpt < intGridsWidth; intGridXpt++){
                  cellscurrentposistion[intGridYpt][intGridXpt] = cellsnextposistion[intGridYpt][intGridXpt];
                  }   
                  }
               repain();
                  }
          }
            };
        time.scheduleAtFixedRate(task, 0, timelength);
        repain();
        }
    
   
private boolean decide(int intGridYpt, int intGridXpt){
    int intadjcells = 0; 
      if (intGridXpt > 0) {
            if (cellscurrentposistion[intGridYpt][intGridXpt-1]) {
                intadjcells++;
            }
            if (intGridYpt> 0) {
                if (cellscurrentposistion[intGridYpt- 1][intGridXpt-1]) {
                    intadjcells++;
                }
            }
            if (intGridYpt < intGridsHeight - 1) {
                if (cellscurrentposistion[intGridYpt + 1][intGridXpt- 1]) {
                    intadjcells++;
                }
            }
        }
        if (intGridXpt < intGridsWidth - 1) {
            if (cellscurrentposistion[intGridYpt][intGridXpt+ 1]) {
                 intadjcells++;
            }
            if (intGridYpt > 0) {
                if (cellscurrentposistion[intGridYpt- 1][intGridXpt + 1]) {
                     intadjcells++;
                }
            }
            if (intGridYpt< intGridsHeight - 1) {
                if (cellscurrentposistion[intGridYpt + 1][intGridXpt + 1]) {
                     intadjcells++;
                }
            }
        }
        if (intGridYpt > 0) {
            if (cellscurrentposistion[intGridYpt - 1][intGridXpt]) {
                 intadjcells++;
            }
        }
        if (intGridYpt < intGridsHeight - 1) {
            if (cellscurrentposistion[intGridYpt + 1][intGridXpt]) {
                 intadjcells++;
            }
        }
        if (cellscurrentposistion[intGridYpt][intGridXpt] && intadjcells == 3) {
            intcellpopulation[intGridYpt][intGridXpt]--;
        }
       if (cellscurrentposistion[intGridYpt][intGridXpt] && intadjcells > 3) {
            intcellpopulation[intGridYpt][intGridXpt]--;
        }
        if (cellscurrentposistion[intGridYpt][intGridXpt] && intadjcells < 2) {
            intcellpopulation[intGridYpt][intGridXpt]--;
        }
       if (cellscurrentposistion[intGridYpt][intGridXpt] && intadjcells == 2) {
            return true;
        }
        if (intadjcells == 3) {
            intcellpopulation[intGridYpt][intGridXpt]++;
            return true;
        }
        for(int intpopulationXpt = 0; intpopulationXpt < intGridsHeight; intpopulationXpt++){
                  for(int intpopulationYpt = 0; intpopulationYpt < intGridsWidth; intpopulationYpt++){
                    inttotalcells = inttotalcells + intcellpopulation[intpopulationXpt][intpopulationYpt]; 
                  }
                  }
        jLabel7.setText("Population: " + Integer.toString(inttotalcells));
        inttotalcells = 0;
        return false;
     }
    
   //creating the graphics on jframe for the grid, gridlines and cell
      private void repain(){
      //Grid created  
        if(intgridcolor == 1)
        {
            offScrGraphics.setColor(Color.WHITE);
            jLabel8.setText("Grid: white");
        }
        if(intgridcolor == 2)
        {
            offScrGraphics.setColor(Color.BLACK);
            jLabel8.setText("Grid: black");
        }
        if(intgridcolor == 3)
        {
            offScrGraphics.setColor(Color.CYAN);
            jLabel8.setText("Grid: cyan");
        }
        if(intgridcolor == 4)
        {
            offScrGraphics.setColor(Color.DARK_GRAY);
            jLabel8.setText("Grid: darkgrey");
        }
        if(intgridcolor == 5)
        {
         offScrGraphics.setColor(Color.GRAY);   
         jLabel8.setText("Grid: gray");
        }
        if(intgridcolor == 6)
        {
           offScrGraphics.setColor(Color.GREEN);
           jLabel8.setText("Grid: green");
        }
       if(intgridcolor == 7)
        {
           offScrGraphics.setColor(Color.LIGHT_GRAY);
           jLabel8.setText("Grid: lightgrey");
        }
        if(intgridcolor == 8)
        {
           offScrGraphics.setColor(Color.MAGENTA);
           jLabel8.setText("Grid: magenta");
        }
        if(intgridcolor == 9)
        {
           offScrGraphics.setColor(Color.ORANGE);
           jLabel8.setText("Grid: orange");
        }
        if(intgridcolor == 10)
        {
           offScrGraphics.setColor(Color.PINK);
           jLabel8.setText("Grid: pink");
           }
        if(intgridcolor == 11)
        {
           offScrGraphics.setColor(Color.RED); 
           jLabel8.setText("Grid: red");
        }
        if(intgridcolor == 12)
        {
           offScrGraphics.setColor(Color.YELLOW); 
           jLabel8.setText("Grid: yellow");
        }
        if(intgridcolor == 13)
        {
           offScrGraphics.setColor(Color.getHSBColor((float) Math.random(), .8f, .8f));
           jLabel8.setText("Grid: rainbow");
        }
         if(intgridcolor == 14)
        {
           offScrGraphics.setColor(Color.BLUE);
           jLabel8.setText("Grid: Blue");
        }
        offScrGraphics.fillRect(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
        //alive cells created on grid
        for (int intGridYpt = 0; intGridYpt < intGridsHeight; intGridYpt++){
            for (int intGridXpt = 0; intGridXpt < intGridsWidth; intGridXpt++){
                if(cellscurrentposistion[intGridYpt][intGridXpt])
                {
           if(intcellcolor == 1)
        {
           offScrGraphics.setColor(Color.getHSBColor((float) Math.random(), .8f, .8f));
           jLabel10.setText("cells: rainbow");
        }
        if(intcellcolor == 2)
        {
            offScrGraphics.setColor(Color.BLACK);
            jLabel10.setText("cells: black");
        }
        if(intcellcolor == 3)
        {
            offScrGraphics.setColor(Color.CYAN);
            jLabel10.setText("cells: cyan");
        }
        if(intcellcolor == 4)
        {
            offScrGraphics.setColor(Color.DARK_GRAY);
            jLabel10.setText("cells: darkgrey");
        }
        if(intcellcolor == 5)
        {
         offScrGraphics.setColor(Color.GRAY);   
         jLabel10.setText("cells: gray");
        }
        if(intcellcolor == 6)
        {
           offScrGraphics.setColor(Color.GREEN);
           jLabel10.setText("cells: green");
        }
       if(intcellcolor == 7)
        {
           offScrGraphics.setColor(Color.LIGHT_GRAY);
           jLabel10.setText("cells: lightgrey");
        }
        if(intcellcolor == 8)
        {
           offScrGraphics.setColor(Color.MAGENTA);
           jLabel10.setText("cells: magenta");
        }
        if(intcellcolor == 9)
        {
           offScrGraphics.setColor(Color.ORANGE);
           jLabel10.setText("cells: orange");
        }
        if(intcellcolor == 10)
        {
           offScrGraphics.setColor(Color.PINK);
           jLabel10.setText("cells: pink");
           }
        if(intcellcolor == 11)
        {
           offScrGraphics.setColor(Color.RED); 
           jLabel10.setText("cells: red");
        }
        if(intcellcolor == 12)
        {
           offScrGraphics.setColor(Color.YELLOW); 
           jLabel10.setText("cells: yellow");
        }
        if(intcellcolor == 13)
        {
           offScrGraphics.setColor(Color.WHITE);
            jLabel10.setText("cells: white");
        }
        if(intcellcolor == 14)
        {
           offScrGraphics.setColor(Color.BLUE);
           jLabel10.setText("cells: Blue");
        }
                int x  = intGridXpt * jPanel2.getWidth()/intGridsWidth;
                int y = intGridYpt * jPanel2.getHeight()/intGridsHeight;
             offScrGraphics.fillRect(x, y, jPanel2.getWidth()/intGridsWidth, jPanel2.getHeight()/intGridsHeight);
                 }
        }
        }
               //grid lines created 
               if(intlinecolor == 1)
        {
            offScrGraphics.setColor(Color.WHITE);
            jLabel9.setText("lines: white");
        }
        if(intlinecolor == 2)
        {
            offScrGraphics.setColor(Color.BLACK);
            jLabel9.setText("lines: black");
        }
        if(intlinecolor == 3)
        {
            offScrGraphics.setColor(Color.CYAN);
            jLabel9.setText("lines: cyan");
        }
        if(intlinecolor == 4)
        {
            offScrGraphics.setColor(Color.DARK_GRAY);
            jLabel9.setText("lines: darkgrey");
        }
        if(intlinecolor == 5)
        {
         offScrGraphics.setColor(Color.GRAY);   
         jLabel9.setText("lines: gray");
        }
        if(intlinecolor == 6)
        {
           offScrGraphics.setColor(Color.GREEN);
           jLabel9.setText("lines: green");
        }
       if(intlinecolor == 7)
        {
           offScrGraphics.setColor(Color.LIGHT_GRAY);
           jLabel9.setText("lines: lightgrey");
        }
        if(intlinecolor == 8)
        {
           offScrGraphics.setColor(Color.MAGENTA);
           jLabel9.setText("lines: magenta");
        }
        if(intlinecolor == 9)
        {
           offScrGraphics.setColor(Color.ORANGE);
           jLabel9.setText("lines: orange");
        }
        if(intlinecolor == 10)
        {
           offScrGraphics.setColor(Color.PINK);
           jLabel9.setText("lines: pink");
           }
        if(intlinecolor == 11)
        {
           offScrGraphics.setColor(Color.RED); 
           jLabel9.setText("lines: red");
        }
        if(intlinecolor == 12)
        {
           offScrGraphics.setColor(Color.YELLOW); 
           jLabel9.setText("lines: yellow");
        }
        if(intlinecolor == 13)
        {
           offScrGraphics.setColor(Color.getHSBColor((float) Math.random(), .8f, .8f));
           jLabel9.setText("lines: rainbow");
        }
        if(intlinecolor == 14)
        {
           offScrGraphics.setColor(Color.BLUE);
           jLabel9.setText("lines: Blue");
        }
        for (int intgridYpt = 1; intgridYpt < intGridsHeight; intgridYpt++){
            int y = intgridYpt * jPanel2.getHeight()/intGridsHeight;
            offScrGraphics.drawLine(0, y, jPanel2.getWidth(), y);
        }
        for (int intgridXpt = 1; intgridXpt < intGridsWidth; intgridXpt++){
            int x  = intgridXpt * jPanel2.getWidth()/intGridsWidth;
            offScrGraphics.drawLine(x, 0, x, jPanel2.getHeight());
        }
         jPanel2.getGraphics().drawImage(offScrImage, 0, 0, jPanel2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jSlider3 = new javax.swing.JSlider();
        jSlider4 = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("play");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Time Slider");

        jLabel3.setText("Grid: ");

        jTextField1.setText("width:50");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField4.setText("height: 50");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(4000);
        jSlider1.setMinimum(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(100);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel4.setText("100 milisecounds");

        jLabel6.setText("Generation: 0");

        jLabel7.setText("Population: 0");

        jSlider2.setMajorTickSpacing(1);
        jSlider2.setMaximum(14);
        jSlider2.setMinimum(1);
        jSlider2.setPaintTicks(true);
        jSlider2.setValue(1);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        jSlider3.setMajorTickSpacing(1);
        jSlider3.setMaximum(14);
        jSlider3.setMinimum(1);
        jSlider3.setPaintTicks(true);
        jSlider3.setValue(1);
        jSlider3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });

        jSlider4.setMajorTickSpacing(1);
        jSlider4.setMaximum(14);
        jSlider4.setMinimum(1);
        jSlider4.setPaintTicks(true);
        jSlider4.setValue(1);
        jSlider4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider4StateChanged(evt);
            }
        });

        jLabel8.setText("Grid: white");

        jLabel9.setText("lines: white");

        jLabel10.setText("cells: rainbow");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel9)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jLabel2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton2)
                                    .addComponent(jLabel7)))
                            .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cellscurrentposistion = new boolean[intGridsHeight][intGridsWidth];
       cellsnextposistion = new boolean[intGridsHeight][intGridsWidth];
        intGeneration = 0;
        intcellpopulation = new int[intGridsHeight][intGridsWidth];
         jLabel6.setText( "Generation: " + intGeneration );
         jLabel7.setText( "population: 0" );
          gamelaunced = false;
        if(gamelaunced) jButton3.setText("Pause");
        else jButton3.setText("play");
        repain();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        int intgridXpt = intGridsWidth * evt.getX()/ jPanel2.getWidth();
        int intgridYpt = intGridsHeight * evt.getY() / jPanel2.getHeight();
        if(SwingUtilities.isLeftMouseButton(evt)){
        cellscurrentposistion[intgridYpt][intgridXpt] = true;
       if(cellscurrentposistion[intgridYpt][intgridXpt] = true)
        {
          intcellpopulation[intgridYpt][intgridXpt]++;
          if(intcellpopulation[intgridYpt][intgridXpt] > 1)
          {
           intcellpopulation[intgridYpt][intgridXpt]--;   
          }
        }
        }
        if(SwingUtilities.isRightMouseButton(evt)){
       if(cellscurrentposistion[intgridYpt][intgridXpt] = true)
        {
          cellscurrentposistion[intgridYpt][intgridXpt] = false;
            intcellpopulation[intgridYpt][intgridXpt]--;
          if(intcellpopulation[intgridYpt][intgridXpt] < 0)
          {
           intcellpopulation[intgridYpt][intgridXpt]++;   
          }
        }
        }
        for(int intpopulationXpt = 0; intpopulationXpt < intGridsHeight; intpopulationXpt++){
                  for(int intpopulationYpt = 0; intpopulationYpt < intGridsWidth; intpopulationYpt++){
                    inttotalcells = inttotalcells + intcellpopulation[intpopulationXpt][intpopulationYpt]; 
                  }
                  }
         jLabel7.setText("Population: " + Integer.toString(inttotalcells));
        inttotalcells = 0;
        repain();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentResized
        offScrImage = createImage(jPanel2.getWidth(), jPanel2.getHeight());
        offScrGraphics = offScrImage.getGraphics();
        repain();
    }//GEN-LAST:event_jPanel2ComponentResized

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int intgridXpt= intGridsWidth * evt.getX() / jPanel2.getWidth();
        int intgridYpt = intGridsHeight * evt.getY() / jPanel2.getHeight();
        if(SwingUtilities.isLeftMouseButton(evt)){
        cellscurrentposistion[intgridYpt][intgridXpt] = true;
        if(cellscurrentposistion[intgridYpt][intgridXpt] = true)
        {
          intcellpopulation[intgridYpt][intgridXpt]++;
          if(intcellpopulation[intgridYpt][intgridXpt] > 1)
          {
           intcellpopulation[intgridYpt][intgridXpt]--;   
          }
        }
        }else cellscurrentposistion[intgridYpt][intgridXpt] = false;
        if(SwingUtilities.isRightMouseButton(evt)){
        if(cellscurrentposistion[intgridYpt][intgridXpt] = true)
        {
          cellscurrentposistion[intgridYpt][intgridXpt] = false;
            intcellpopulation[intgridYpt][intgridXpt]--;
          if(intcellpopulation[intgridYpt][intgridXpt] < 0)
          {
           intcellpopulation[intgridYpt][intgridXpt]++;   
          }
        }
        }else cellscurrentposistion[intgridYpt][intgridXpt] = true; 
        for(int x = 0; x < intGridsHeight; x++){
                  for(int y = 0; y < intGridsWidth; y++){
                    inttotalcells = inttotalcells + intcellpopulation[x][y]; 
                  }
                  }
        jLabel7.setText("Population: " + Integer.toString(inttotalcells));
        inttotalcells = 0;
        repain();
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        gamelaunced = !gamelaunced;
        if(gamelaunced == true) jButton3.setText("Pause");
        else jButton3.setText("play");
        repain();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
       String text = jTextField4.getText();
            intGridsHeight = Integer.valueOf(text);
           jTextField4.setText("Height: "+ Integer.toString(intGridsHeight));
            cellscurrentposistion = new boolean[intGridsHeight][intGridsWidth];
            cellsnextposistion = new boolean[intGridsHeight][intGridsWidth];
            intGeneration = 0;
        intcellpopulation = new int[intGridsHeight][intGridsWidth];
         jLabel6.setText( "Generation: " + intGeneration );
         jLabel7.setText( "population: 0" );
          gamelaunced = false;
        if(gamelaunced) jButton3.setText("Pause");
        else jButton3.setText("play");
            repain();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
            String text = jTextField1.getText();
            intGridsWidth = Integer.valueOf(text);
            jTextField1.setText("width: "+ Integer.toString(intGridsWidth));
            cellscurrentposistion = new boolean[intGridsHeight][intGridsWidth];
            cellsnextposistion = new boolean[intGridsHeight][intGridsWidth];
            intGeneration = 0;
        intcellpopulation = new int[intGridsHeight][intGridsWidth];
         jLabel6.setText( "Generation: " + intGeneration );
         jLabel7.setText( "population: 0" );
          gamelaunced = false;
        if(gamelaunced) jButton3.setText("Pause");
        else jButton3.setText("play");
            repain();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
         jLabel4.setText(Integer.toString(jSlider1.getValue()) + " milisecounds");
         timelength = jSlider1.getValue(); 
         this.restartTimerTask();
         repain();
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        intgridcolor = jSlider2.getValue();
        repain();
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        intlinecolor = jSlider3.getValue();
        repain();
    }//GEN-LAST:event_jSlider3StateChanged

    private void jSlider4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider4StateChanged
        intcellcolor = jSlider4.getValue();
        repain();
    }//GEN-LAST:event_jSlider4StateChanged
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOfLife().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JSlider jSlider4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}


    
