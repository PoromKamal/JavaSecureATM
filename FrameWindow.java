import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyleConstants.FontConstants;

class FrameWindow{
    private int width;
    private int height;
    private JFrame main_frame;
    public FrameWindow(int sizex, int sizey){
        this.width = sizex;
        this.height = sizey;
    }
    public void init(){
        main_frame = new JFrame("ATMSecure");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setSize(width, height);
        main_frame.setResizable(false);
        
        //Set boxlayout on contentPane.
        main_frame.getContentPane().setLayout(new BoxLayout(main_frame.getContentPane(), BoxLayout.Y_AXIS));

        //Get logo
        ImageIcon im = new ImageIcon("SecureATMLogo.png");
        JLabel logoLabel = new JLabel(im);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Get motto
        JLabel motto = new JLabel();
        motto.setFont(new Font("Arial", Font.BOLD, 20));
        motto.setForeground(Color.WHITE);
        motto.setText("Confidence Through Security");
        motto.setAlignmentX(Component.CENTER_ALIGNMENT);
        motto.setBorder(new EmptyBorder(20, 20, 20, 20));

        //Create the panel for logo and motto
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setBorder(BorderFactory.createMatteBorder(3, 3, 2, 2, Color.BLACK));
        //Add logo and motto
        panel.add(logoLabel);
        panel.add(motto);  
        

        //Create loginpanel
        JPanel login = new JPanel();
        login.setMaximumSize(new Dimension(750, 300));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.setLayout(new BoxLayout(login, BoxLayout.Y_AXIS));
        login.setBackground(Color.DARK_GRAY);
        login.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Sign-in", TitledBorder.CENTER, TitledBorder.TOP,new Font("Arial", Font.BOLD, 18), Color.WHITE));
        Border border = login.getBorder();
        Border margin = new EmptyBorder(30, 30, 30, 30);
        login.setBorder(new CompoundBorder(margin, border));
        
        //Set username panel
        JPanel userName = new JPanel();
        userName.setBorder(new EmptyBorder(10,10,10,10));
        userName.setMaximumSize(new Dimension(800, 30));
        userName.setBackground(Color.DARK_GRAY);
        JLabel userNameText = new JLabel();
        userNameText.setFont(new Font("Arial", Font.BOLD, 15));
        userNameText.setForeground(Color.WHITE);
        userNameText.setText("Username: ");
        JTextField userNameField = new JTextField(15);
        userNameField.setMaximumSize(userNameField.getPreferredSize());
        userName.add(userNameText);
        userName.add(userNameField);

        //Set password panel
        JPanel password = new JPanel();
        password.setBorder(new EmptyBorder(10,10,10,10));
        password.setBackground(Color.DARK_GRAY);
        password.setMaximumSize(new Dimension(800, 40));
        JLabel passwordText = new JLabel();
        passwordText.setFont(new Font("Arial", Font.BOLD, 15));
        passwordText.setForeground(Color.WHITE);
        passwordText.setText("Password: ");
        JPasswordField passwordField = new JPasswordField(15);
        password.add(passwordText);
        password.add(passwordField);
        
        //Add login button
        JPanel signinButton = new JPanel();
        signinButton.setBackground(Color.DARK_GRAY);
        signinButton.setBorder(new EmptyBorder(10, 10, 10, 10));
        JButton signin = new JButton("Login");
        signin.setAlignmentX(Component.CENTER_ALIGNMENT);
        signinButton.add(signin);
        //Add components to login panel
        login.add(userName);
        login.add(password);
        login.add(signinButton);

        //Add sign up portion
        JPanel signup = new JPanel();
        signup.setMaximumSize(new Dimension(750, 200));
        signup.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Sign-up", TitledBorder.CENTER, TitledBorder.TOP,new Font("Arial", Font.BOLD, 18), Color.WHITE));
        Border signupBorder = signup.getBorder();
        Border signupMargin = new EmptyBorder(30, 30, 30, 30);
        signup.setBorder(new CompoundBorder(signupMargin, signupBorder));
        signup.setBackground(Color.DARK_GRAY);

        JLabel signupText = new JLabel();
        signupText.setFont(new Font("Times New Roman", Font.BOLD, 17));
        signupText.setForeground(Color.WHITE);
        signupText.setText("Don't have an account? Sign-up here: ");
        JButton signupButton = new JButton("Sign-up");
        signup.add(signupText);
        signup.add(signupButton);

        //Add panels to main content pane
        main_frame.getContentPane().setPreferredSize(new Dimension(800, 800));
        main_frame.getContentPane().add(panel);
        main_frame.getContentPane().add(login);
        main_frame.getContentPane().add(signup);
        //set background color
        main_frame.getContentPane().setBackground(Color.DARK_GRAY);
        main_frame.pack();
        main_frame.setVisible(true);
        
    }
}
