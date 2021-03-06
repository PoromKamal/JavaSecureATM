import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

class FrameWindow implements ActionListener{
    private int width;
    private int height;
    private JFrame main_frame;
    private Color MAIN_COLOR = Color.DARK_GRAY;
    private String MAIN_FONT = "Arial";
    private Validation main_validate = new Validation();
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
        motto.setFont(new Font(MAIN_FONT, Font.BOLD, 20));
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
        login.setBackground(MAIN_COLOR);
        login.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Sign-in", TitledBorder.CENTER, TitledBorder.TOP,new Font("Arial", Font.BOLD, 18), Color.WHITE));
        Border border = login.getBorder();
        Border margin = new EmptyBorder(30, 30, 30, 30);
        login.setBorder(new CompoundBorder(margin, border));
        
        //Set username panel
        JPanel userName = new JPanel();
        userName.setBorder(new EmptyBorder(10,10,10,10));
        userName.setMaximumSize(new Dimension(800, 30));
        userName.setBackground(MAIN_COLOR);
        JLabel userNameText = new JLabel();
        userNameText.setFont(new Font(MAIN_FONT, Font.BOLD, 15));
        userNameText.setForeground(Color.WHITE);
        userNameText.setText("Username: ");
        JTextField userNameField = new JTextField(15);
        userNameField.setMaximumSize(userNameField.getPreferredSize());
        userName.add(userNameText);
        userName.add(userNameField);

        //Set password panel
        JPanel password = new JPanel();
        password.setBorder(new EmptyBorder(10,10,10,10));
        password.setBackground(MAIN_COLOR);
        password.setMaximumSize(new Dimension(800, 40));
        JLabel passwordText = new JLabel();
        passwordText.setFont(new Font(MAIN_FONT, Font.BOLD, 15));
        passwordText.setForeground(Color.WHITE);
        passwordText.setText("Password: ");
        JPasswordField passwordField = new JPasswordField(15);
        password.add(passwordText);
        password.add(passwordField);
        
        //Add login button
        JPanel signinButton = new JPanel();
        signinButton.setBackground(MAIN_COLOR);
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
        signup.setBackground(MAIN_COLOR);

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
        main_frame.getContentPane().setBackground(MAIN_COLOR);
        main_frame.pack();
        JPanel main_content = (JPanel)main_frame.getContentPane();
        //Button actionlistener
        signupButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                signupPage(main_content);
            }});

        main_frame.setVisible(true);
    }

    public void signupPage(JPanel main_content){
        /*
        Signup page will contain the following data fields:
            - First Name
            - Last Name
            - Date of Birth (Drop down menu)
            - Username
            - Password
            - confirm password
        */
        JPanel signupPage = new JPanel();
        signupPage.setLayout(null);
        signupPage.setBackground(MAIN_COLOR);
        signupPage.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Sign Up", TitledBorder.CENTER, TitledBorder.TOP,new Font("Arial", Font.BOLD, 20), Color.WHITE));

        //Buttons (back, and signup)
        JPanel buttons = new JPanel();
        buttons.setBackground(MAIN_COLOR);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.setMaximumSize(new Dimension(500, 100));
        JButton backButton = new JButton("back");
        JButton signupButton = new JButton("Register");
        backButton.setBounds(0,0,80,30); 
        signupButton.setBounds(20,20,80,30);
        buttons.add(backButton);
        buttons.add(signupButton);
        
        //First name field
        JPanel firstNamePanel = new JPanel();
        firstNamePanel.setBackground(MAIN_COLOR);
        firstNamePanel.setMaximumSize(new Dimension(700, 80));
        JLabel firstNameText = new JLabel();
        firstNameText.setFont(new Font(MAIN_FONT, Font.PLAIN, 13));
        firstNameText.setForeground(Color.WHITE);
        firstNameText.setText("First Name: ");
        JTextField firstNameInput = new JTextField(15);
        firstNamePanel.add(firstNameText);
        firstNamePanel.add(firstNameInput);
        
        //Last name field
        JPanel lastNamePanel = new JPanel();
        lastNamePanel.setBackground(MAIN_COLOR);
        lastNamePanel.setMaximumSize(new Dimension(700, 80));
        JLabel lastNameText = new JLabel();
        lastNameText.setFont(new Font(MAIN_FONT, Font.PLAIN, 13));
        lastNameText.setForeground(Color.WHITE);
        lastNameText.setText("Last Name: ");
        JTextField lastNameInput = new JTextField(15);
        lastNamePanel.add(lastNameText);
        lastNamePanel.add(lastNameInput);

        //Date of birth field
        JPanel dateOfBirth = new JPanel();
        dateOfBirth.setBackground(MAIN_COLOR);
        dateOfBirth.setMaximumSize(new Dimension(700, 80));
        JLabel dateOfBirthText = new JLabel();
        dateOfBirthText.setFont(new Font(MAIN_FONT, Font.PLAIN, 13));
        dateOfBirthText.setForeground(Color.WHITE);
        dateOfBirthText.setText("Date of Birth: ");
        Integer[] days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        String[] months = {"January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"};
        JComboBox<Integer> daysDropDown = new JComboBox<Integer>(days);
        JComboBox<String> monthDropDown = new JComboBox<String>(months);
        JTextField yearInput = new JTextField("Year", 8);

        dateOfBirth.add(dateOfBirthText);
        dateOfBirth.add(daysDropDown);
        dateOfBirth.add(monthDropDown);
        dateOfBirth.add(yearInput);

        // Username Field
        JPanel userNamePanel = new JPanel();
        userNamePanel.setBackground(MAIN_COLOR);
        userNamePanel.setMaximumSize(new Dimension(700, 80));
        JLabel userNameText = new JLabel();
        userNameText.setFont(new Font(MAIN_FONT, Font.PLAIN, 13));
        userNameText.setForeground(Color.WHITE);
        userNameText.setText("Username: ");
        JTextField userNameInput = new JTextField(15);
        userNamePanel.add(userNameText);
        userNamePanel.add(userNameInput);

        //Password field
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(MAIN_COLOR);
        passwordPanel.setMaximumSize(new Dimension(700, 80));
        JLabel passwordText = new JLabel();
        passwordText.setFont(new Font(MAIN_FONT, Font.PLAIN, 13));
        passwordText.setForeground(Color.WHITE);
        passwordText.setText("Password: ");
        JPasswordField passwordInput = new JPasswordField(15);
        passwordPanel.add(passwordText);
        passwordPanel.add(passwordInput);

        //Confirm password field
        JPanel confirmPasswordPanel = new JPanel();
        confirmPasswordPanel.setBackground(MAIN_COLOR);
        confirmPasswordPanel.setMaximumSize(new Dimension(700, 80));
        JLabel confirmPasswordText = new JLabel();
        confirmPasswordText.setFont(new Font(MAIN_FONT, Font.PLAIN, 13));
        confirmPasswordText.setForeground(Color.WHITE);
        confirmPasswordText.setText("Confirm Password: ");
        JPasswordField confirmPasswordInput = new JPasswordField(15);
        confirmPasswordPanel.add(confirmPasswordText);
        confirmPasswordPanel.add(confirmPasswordInput);

        //Add in all the fields to the signup page panel
        signupPage.setLayout(new BoxLayout(signupPage, BoxLayout.Y_AXIS));
        signupPage.add(firstNamePanel);
        signupPage.add(lastNamePanel);
        signupPage.add(dateOfBirth);
        signupPage.add(userNamePanel);
        signupPage.add(passwordPanel);
        signupPage.add(confirmPasswordPanel);
        

        signupPage.add(buttons);

        //Signup validation protocols:
        signupButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get all data from fields, and input them into a string:
                String firstName = firstNameInput.getText();
                String lastName = lastNameInput.getText();
                String username = userNameInput.getText();
                String day = String.valueOf(daysDropDown.getSelectedItem());
                String month = (String)monthDropDown.getSelectedItem();
                String year = yearInput.getText();
                String password = String.valueOf(passwordInput.getPassword());
                String confirmPassword = String.valueOf(confirmPasswordInput.getPassword());


                String userData = "/" + firstName + "/" + lastName + "/" + username + "/" + day + "/" + month + "/" + year +"/" + password + "/";
                String errorMessage = Validation.validateSignupFields(userData, password, confirmPassword);
                System.out.println(errorMessage);

                //Check if the input fields are valid
                // *** Username Must be unique ***
                // *** Password must be more than 10 characters ***
                // *** All fields must be filled in ***
                

                //If they are valid then add them into the users database with encryption.
            }
        });


        //Set the main_frame content
        main_frame.setContentPane(signupPage);
        main_frame.validate();
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                main_frame.setContentPane(main_content);
                main_frame.validate();
            }});
            
    }

    

    @Override
    public void actionPerformed(ActionEvent e){}
}
