import javax.swing.*;

class Frame{
    private int width;
    private int height;
    private JFrame main_frame;
    public Frame(int sizex, int sizey){
        this.width = sizex;
        this.height = sizey;
    }
    public void initWindow(){
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
