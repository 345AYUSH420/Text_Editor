import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class findflag {
    public static int fflag = 0;

}
class open
{
    public static int oflag = 0;
}
class WindowCloseerayush extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        Window w = e.getWindow();
        w.setVisible(false);
        w.dispose();
    }
}

public class menubar implements ActionListener {
    String path, st;

    FileDialog fd;
    TextField tf, tf1;
    Button findnxtbtn, replacebtn, replaceallbtn, closebtn, ultsave, ultdontsave;
    MenuBar mb;
    Menu m1, m2;
    MenuItem nw, sv, svs, ext, fin, finreps, op;
    int group, x, y;
    Frame f, f2,f3;
    TextArea ta;
    String t, s, textarea;
    FileInputStream fis;
    FileOutputStream fos;
    String outstring = "",title = "",ayush="";
    Label l;
    public  void ultpane()
    {
        f3  = new Frame();
        UIManager.put("OptionPane.yesButtonText", "Save");
        UIManager.put("OptionPane.noButtonText", "don't Save");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        int res = JOptionPane.showConfirmDialog(f3, "Do you want to save ?");

        if (res == JOptionPane.YES_OPTION)
        {
            FileDialog fd = new FileDialog(f, "Save", FileDialog.SAVE);
            fd.setVisible(true);
            try {
                path = fd.getDirectory() + fd.getFile();
                fos = new FileOutputStream(path);
                String st = ta.getText();
                byte[] b = st.getBytes();
                fos.write(b);
            } catch (Exception ex) {
                System.out.println("something went wrong");
            }
            System.exit(0);
        }
        else if(res == JOptionPane.CANCEL_OPTION)
        {
            JOptionPane.getRootFrame().setVisible(false);
        }
        else
        {
            System.exit(0);
        }
//        f3.setVisible(false);
    }


    class WindowCloser extends WindowAdapter {

        public void windowClosing(WindowEvent e) {

            Window w = e.getWindow();

            if ((ta.getText().equals("")) && (f.getTitle().equals(""))) {

                System.exit(1);
            }
            if (ta.getText().equals(outstring)) {
                System.exit(0);
            }
            else if (!ta.getText().equals(outstring))
            {
                if (!f.getTitle().equals(""))
                {
                f3 = new Frame();
                UIManager.put("OptionPane.yesButtonText", "Save");
                UIManager.put("OptionPane.noButtonText", "don't Save");
                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                int res = JOptionPane.showConfirmDialog(f3, "Do you want to save ?");

                if (res == JOptionPane.YES_OPTION) {
                    fd = new FileDialog(f, "Save", FileDialog.SAVE);
                    try {
                        fos = new FileOutputStream(path);
                        st = ta.getText();
                        byte[] b = st.getBytes();
                        fos.write(b);
                    } catch (Exception ex) {
                        System.out.println("something went wrong");

                    }
                    System.exit(0);
                } else if (res == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.getRootFrame().setVisible(false);
                } else {
                    System.exit(0);
                }
            }
                else
                {
                    f3  = new Frame();
                    UIManager.put("OptionPane.yesButtonText", "Save");
                    UIManager.put("OptionPane.noButtonText", "don't Save");
                    UIManager.put("OptionPane.cancelButtonText", "Cancel");
                    int res = JOptionPane.showConfirmDialog(f3, "Do you want to save ?");

                    if (res == JOptionPane.YES_OPTION)
                    {
                        FileDialog fd = new FileDialog(f, "Save", FileDialog.SAVE);
                        fd.setVisible(true);
                        WindowCloseerayush wo = new WindowCloseerayush();
                        fd.addWindowListener(wo);
                        path = fd.getDirectory() + fd.getFile();
                        if(path.equals(""))
                        {
                            ta.setText(ta.getText());
                        }
                        try {
                            fos = new FileOutputStream(path);
                            String st = ta.getText();
                            byte[] b = st.getBytes();
                            fos.write(b);
                        } catch (Exception ex) {
                            System.out.println("something went wrong");
                        }

                    fd.dispose();
                    }
                    else if(res == JOptionPane.CANCEL_OPTION)
                    {
                        JOptionPane.getRootFrame().setVisible(false);
                    }
                    else if(res == JOptionPane.NO_OPTION)
                    {
                        w.dispose();
                    }
                }
        }
        }
    }

    public menubar()  {
        WindowCloser w = new WindowCloser();
        f = new Frame();
        f.addWindowListener(w);
        f.setSize(500, 500);
        ta = new TextArea();
        mb = new MenuBar();
        m1 = new Menu("File");
        m2 = new Menu("Edit");
        nw = new MenuItem("New");
        nw.addActionListener(this);
        sv = new MenuItem("Save");
        sv.addActionListener(this);
        svs = new MenuItem("saveAs");
        svs.addActionListener(this);
        ext = new MenuItem("Exit");
        ext.addActionListener(this);
        fin = new MenuItem("Find");
        fin.addActionListener(this);
        finreps = new MenuItem("Find & Replace");
        finreps.addActionListener(this);
        op = new MenuItem("Open");
        op.addActionListener(this);
        m1.add(nw);
        m1.add(op);
        m1.add(sv);
        m1.add(svs);
        m1.addSeparator();
        m1.add(ext);
        m2.add(fin);
        m2.add(finreps);
        mb.add(m1);
        mb.add(m2);

        f.setMenuBar(mb);
        f.add(ta);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s = e.getActionCommand();
            
        if (e.getSource() == nw)
        {

            WindowCloseerayush w = new WindowCloseerayush();


            if (ta.getText().equals("") && f.getTitle().equals(""))
            {
//                fd = new FileDialog(f, "create new file", FileDialog.LOAD);
//                fd.addWindowListener(w);
//                fd.setVisible(true);
//                st = ta.getText();
//                path = fd.getDirectory() + fd.getFile();
//                try {
//                    FileOutputStream fos = new FileOutputStream(path);
//                    byte[] b = st.getBytes();
//                    fos.write(b);
//                    ta.setText("");
//                    ayush = ta.getText();
//                    f.setTitle(fd.getFile());
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
                ta.setText("");
                f.setTitle("");
            }
            else if(f.getTitle().equals(""))
            {
                UIManager.put("OptionPane.yesButtonText", "Save");
                UIManager.put("OptionPane.noButtonText", "don't Save");
                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                int res = JOptionPane.showConfirmDialog(f3, "Do you want to save ?");

                if (res == JOptionPane.YES_OPTION)
                {

                    FileDialog fd = new FileDialog(f, "Save", FileDialog.SAVE);
                    fd.setVisible(true);
                    WindowCloseerayush wo = new WindowCloseerayush();
                    fd.addWindowListener(wo);
                    path = fd.getDirectory() + fd.getFile();
                    if(fd.getFile().equals(""))
                    {
                        ta.setText(ayush);
                        f.setTitle("");
                    }
                    try {
                        fos = new FileOutputStream(path);
                        String st = ta.getText();
                        byte[] b = st.getBytes();
                        fos.write(b);
                    } catch (Exception ex) {
                        System.out.println("something went wrong");
                    }
                    ta.setText("");
                    f.setTitle("");
                }
                else if (res == JOptionPane.CANCEL_OPTION)
                {
                    JOptionPane.getRootFrame().setVisible(false);
                }
                else if (res == JOptionPane.NO_OPTION)
                {
                    ta.setText("");
                    f.setTitle("");
                }
            }
            else if(ta.getText().equals("") && !f.getTitle().equals(""))
            {
                fd = new FileDialog(f, "create new file", FileDialog.LOAD);
                fd.addWindowListener(w);
                fd.setVisible(true);
                st = ta.getText();
                path = fd.getDirectory() + fd.getFile();
                try {
                    FileOutputStream fos = new FileOutputStream(path);
                    byte[] b = st.getBytes();
                    fos.write(b);
                    ta.setText("");
                    f.setTitle(fd.getFile());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else
            {
                if(!ta.getText().equals(outstring))
                {
                    UIManager.put("OptionPane.yesButtonText", "Save");
                    UIManager.put("OptionPane.noButtonText", "don't Save");
                    UIManager.put("OptionPane.cancelButtonText", "Cancel");
                    int res = JOptionPane.showConfirmDialog(f3, "Do you want to save ?");

                    if (res == JOptionPane.YES_OPTION)
                    {
                        fd = new FileDialog(f, "Save", FileDialog.SAVE);
                        try {
                            fos = new FileOutputStream(path);
                            st = ta.getText();
                            byte[] b = st.getBytes();
                            fos.write(b);
                        } catch (Exception ex) {
                            System.out.println("something went wrong");

                        }
                        ta.setText("");
                        f.setTitle("");
                    }
                    else if (res == JOptionPane.CANCEL_OPTION)
                    {
                        JOptionPane.getRootFrame().setVisible(false);
                    }
                    else if (res == JOptionPane.NO_OPTION)
                    {
                        ta.setText("");
                        f.setTitle("");
                    }
                }
                else
                {
                    ta.setText("");
                    f.setTitle("");
                }

            }
        }

//        &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

        if (e.getSource() == fin) {
            class WindowClose extends WindowAdapter {
                public void windowClosing(WindowEvent e) {
                    Window w = e.getWindow();
                    findflag.fflag = 0;
                    w.setVisible(false);
                    w.dispose();
                }
            }
            WindowClose w = new WindowClose();
            if (findflag.fflag == 0) {
                f2 = new Frame();
                f2.addWindowListener(w);
                f2.setLocation(300, 200);
                f2.setLayout(new BorderLayout());
                f2.setSize(200, 100);
                Label l = new Label("Find");
                tf = new TextField();
                findnxtbtn = new Button("Find Next");
                findnxtbtn.addActionListener(this);
                f2.add(l, BorderLayout.NORTH);
                f2.add(tf, BorderLayout.CENTER);
                f2.add(findnxtbtn, BorderLayout.SOUTH);
                f2.setVisible(true);

            }
            findflag.fflag = 1;
        } else if (e.getSource() == findnxtbtn) {


            String str = tf.getText();
            textarea = ta.getText();
            Pattern p = Pattern.compile(str);
            textarea = textarea.replace("\n", " ");
            textarea = textarea.replace("\r", "");
            Matcher m = p.matcher(textarea);


            while (m.find()) {
                if (group < m.end()) {
                    x = m.start();
                    y = m.end();
                    ta.select(x, y);
                    group = m.end();
                    break;
                }
            }
            if (m.find() == false) {
                m.reset();
                group = 0;
            }
            f.setVisible(true);

        } else if (e.getSource() == finreps) {
            class WindowClosed extends WindowAdapter {
                public void windowClosing(WindowEvent e) {
                    Window w = e.getWindow();
                    findflag.fflag = 0;
                    w.setVisible(false);
                    w.dispose();
                }
            }
            if (findflag.fflag == 0) {
                WindowClosed w = new WindowClosed();
                Frame f2 = new Frame();
                f2.addWindowListener(w);
                f2.setLocation(300, 200);
                f2.setLayout(new BorderLayout());
                f2.setSize(300, 300);
                Panel p1 = new Panel();
                p1.setLayout(new GridLayout());
                p1.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                Label l1 = new Label("Find");
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                p1.add(l1, gbc);
                tf = new TextField();
                gbc.gridx = 1;
                gbc.gridy = 0;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.ipadx = 50;
                p1.add(tf, gbc);
                Label l2 = new Label("ReplaceWith");
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                p1.add(l2, gbc);

                tf1 = new TextField();
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.ipadx = 50;
                p1.add(tf1, gbc);


                Panel p2 = new Panel();
                p2.setLayout(new FlowLayout());
                replacebtn = new Button("Replace");
                findnxtbtn = new Button("Find Next");
                replaceallbtn = new Button("ReplaceAll");
                closebtn = new Button("close");
                p2.add(findnxtbtn);
                p2.add(replacebtn);
                p2.add(replaceallbtn);
                p2.add(closebtn);
                f2.add(p1, BorderLayout.CENTER);
                f2.add(p2, BorderLayout.SOUTH);
                f2.setVisible(true);
                findnxtbtn.addActionListener(this);
                replacebtn.addActionListener(this);
                replaceallbtn.addActionListener(this);
            }
            findflag.fflag = 1;
        }
        if (e.getSource() == replacebtn) {
            String str = tf.getText();
            textarea = ta.getText();
            Pattern p = Pattern.compile(str);
            textarea = textarea.replace("\n", " ");
            textarea = textarea.replace("\r", "");
            Matcher m = p.matcher(textarea);


            while (m.find()) {
                if (group < m.end()) {
                    x = m.start();
                    y = m.end();
                    ta.select(x, y);
                    group = m.end();
                    break;
                }
            }
            if (m.find() == false) {
                m.reset();
                group = 0;
            }
            f.setVisible(true);
            String a = tf1.getText();
            ta.replaceText(a, x, y);
            if (m.find() == false) {
                System.out.println("no more String to display");
            }
        }
        if (e.getSource() == replaceallbtn) {
            String str = tf.getText();
            textarea = ta.getText();
            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(textarea);
            ta.setText(m.replaceAll(tf1.getText()));

        }
//        ***************************************
        if (e.getSource() == ext) {


            if ((ta.getText().equals("")) && (f.getTitle().equals(""))) {

                System.exit(1);
            }
            if (ta.getText().equals(outstring)) {
                System.exit(0);
            }
            else if (!ta.getText().equals(outstring))
            {
                if (!f.getTitle().equals(""))
                {
                    f3 = new Frame();
                    UIManager.put("OptionPane.yesButtonText", "Save");
                    UIManager.put("OptionPane.noButtonText", "don't Save");
                    UIManager.put("OptionPane.cancelButtonText", "Cancel");
                    int res = JOptionPane.showConfirmDialog(f3, "Do you want to save ?");

                    if (res == JOptionPane.YES_OPTION) {
                        fd = new FileDialog(f, "Save", FileDialog.SAVE);
                        try {
                            fos = new FileOutputStream(path);
                            st = ta.getText();
                            byte[] b = st.getBytes();
                            fos.write(b);
                        } catch (Exception ex) {
                            System.out.println("something went wrong");

                        }
                        System.exit(0);
                    } else if (res == JOptionPane.CANCEL_OPTION) {
                        JOptionPane.getRootFrame().setVisible(false);
                    } else {
                        System.exit(0);
                    }
                }
                else
                {
                    f3  = new Frame();
                    UIManager.put("OptionPane.yesButtonText", "Save");
                    UIManager.put("OptionPane.noButtonText", "don't Save");
                    UIManager.put("OptionPane.cancelButtonText", "Cancel");
                    int res = JOptionPane.showConfirmDialog(f3, "Do you want to save ?");

                    if (res == JOptionPane.YES_OPTION)
                    {
                        FileDialog fd = new FileDialog(f, "Save", FileDialog.SAVE);
                        fd.setVisible(true);
                        WindowCloseerayush wo = new WindowCloseerayush();
                        fd.addWindowListener(wo);
                        path = fd.getDirectory() + fd.getFile();
                        if(path.equals(""))
                        {
                            ta.setText(ta.getText());
                        }
                        try {
                            fos = new FileOutputStream(path);
                            String st = ta.getText();
                            byte[] b = st.getBytes();
                            fos.write(b);
                        } catch (Exception ex) {
                            System.out.println("something went wrong");
                        }

                        fd.dispose();
                    }
                    else if(res == JOptionPane.CANCEL_OPTION)
                    {
                        JOptionPane.getRootFrame().setVisible(false);
                    }
                    else if(res == JOptionPane.NO_OPTION)
                    {
                        System.exit(0);
                    }
                }
            }
            ultpane();
        }
//        *******************************************

//    @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        if (e.getSource() == op) {
            if (ta.getText().equals(""))
            {
                FileDialog fd = new FileDialog(f, "Open", FileDialog.LOAD);
                fd.setVisible(true);
                f.setTitle(fd.getFile());
                title = fd.getTitle();
                path = fd.getDirectory() + fd.getFile();
                try {

                    fis = new FileInputStream(path);

                    byte[] b = new byte[fis.available()];
                    fis.read(b);
                    String str = new String(b);
                    ta.setText(str);
                    title = f.getTitle();
                     ayush = ta.getText();
                    outstring = str;
                    fis.close();
                } catch (Exception ex) {
                    System.out.println("Something went wrong");
                }

            }
            else if (ta.getText().equals(outstring))
            {
                FileDialog fd = new FileDialog(f, "Open", FileDialog.LOAD);
                fd.setVisible(true);
                path = fd.getDirectory() + fd.getFile();
                if(fd.getFile().equals(""))
                {
                    try{
                        ta.setText(ayush);
                        f.setTitle(title);
                    }
                    catch (Exception ash)
                    {
                        System.out.println("");
                    }

                }
                f.setTitle(fd.getFile());
                try {

                    fis = new FileInputStream(path);

                    byte[] b = new byte[fis.available()];
                    fis.read(b);
                    String str = new String(b);
                    ta.setText(str);
                    outstring = str;
                    fis.close();
                } catch (Exception ex) {
                    System.out.println("Something went wrong");
                }
            }
            else
            {
                if(ta.getText().equals(outstring)  && f.getTitle().equals(title))
                {
                    FileDialog fd = new FileDialog(f, "Open", FileDialog.LOAD);
                    fd.setVisible(true);
                    f.setTitle(fd.getFile());
                    title = fd.getTitle();
                    path = fd.getDirectory() + fd.getFile();
                    try {

                        fis = new FileInputStream(path);

                        byte[] b = new byte[fis.available()];
                        fis.read(b);
                        String str = new String(b);
                        ta.setText(str);
                        title = f.getTitle();
                        ayush = ta.getText();
                        outstring = str;
                        fis.close();
                    } catch (Exception ex) {
                        System.out.println("Something went wrong");
                    }

                }
                UIManager.put("OptionPane.yesButtonText", "Save");
                UIManager.put("OptionPane.noButtonText", "don't Save");
                UIManager.put("OptionPane.cancelButtonText", "Cancel");
                int res = JOptionPane.showConfirmDialog(f3, "Do you want to save ?");
                if (res == JOptionPane.YES_OPTION)
                {
                    try {
                        fos = new FileOutputStream(path);
                        st = ta.getText();
                        byte[] b = st.getBytes();
                        fos.write(b);
                        ayush = ta.getText();
                        title = f.getTitle();
                    } catch (Exception ex) {
                        System.out.println("something went wrong");

                    }
                    FileDialog fd = new FileDialog(f, "Open", FileDialog.LOAD);
                    fd.setVisible(true);
                    path = fd.getDirectory() + fd.getFile();

                    try {
                        if(fd.getFile().equals(""))
                        {
                            ta.setText(ayush);
                            f.setTitle(title);
                        }

                        f.setTitle(fd.getTitle());
                        fis = new FileInputStream(path);

                        byte[] b = new byte[fis.available()];
                        fis.read(b);
                        String str = new String(b);
                        ta.setText(str);
                        outstring = str;
                        fis.close();
                    } catch (Exception ex) {
                        System.out.println("Something went wrong");
                    }

                }
                else if(res == JOptionPane.NO_OPTION)
                {
                    FileDialog fd = new FileDialog(f, "Open", FileDialog.LOAD);
                    fd.setVisible(true);
                    f.setTitle(fd.getFile());
                    path = fd.getDirectory() + fd.getFile();
                    try {

                        fis = new FileInputStream(path);

                        byte[] b = new byte[fis.available()];
                        fis.read(b);
                        String str = new String(b);
                        ta.setText(str);
                        outstring = str;
                        fis.close();
                    } catch (Exception ex) {
                        System.out.println("Something went wrong");
                    }
                }
                else if (res == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.getRootFrame().setVisible(false);
                }


            }
        }

//        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2

//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11
        if (e.getSource() == svs) {

            FileDialog fd = new FileDialog(f, "Save", FileDialog.SAVE);
            fd.setVisible(true);
            WindowCloseerayush wo = new WindowCloseerayush();
            fd.addWindowListener(wo);
            path = fd.getDirectory() + fd.getFile();
            try {
                fos = new FileOutputStream(path);
                String st = ta.getText();
                byte[] b = st.getBytes();
                fos.write(b);
            } catch (Exception ex) {
                System.out.println("something went wrong");
            }
        }
//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1111111

//        ############################################
        if (e.getSource() == sv) {
            if (f.getTitle().equals("")) {
                FileDialog fd = new FileDialog(f, "Save", FileDialog.SAVE);
                fd.setVisible(true);
                path = fd.getDirectory() + fd.getFile();
                try {

                    fos = new FileOutputStream(path);
                    String st = ta.getText();
                    byte[] b = st.getBytes();
                    fos.write(b);
                    outstring = st;
                    System.out.println(outstring);
                    f.setTitle(fd.getFile());
                } catch (Exception ex) {
                    System.out.println("something went wrong");

                }
            }
            fd = new FileDialog(f, "Save", FileDialog.SAVE);
            try {
                fos = new FileOutputStream(path);
                st = ta.getText();
                byte[] b = st.getBytes();
                fos.write(b);
                outstring = st;
                System.out.println(outstring);
            } catch (Exception ex) {
                System.out.println("something went wrong");

            }

        }
//        ##############################################3
    }

    public static void main(String[] args) throws FileNotFoundException {
        menubar mbr = new menubar();
    }
}

