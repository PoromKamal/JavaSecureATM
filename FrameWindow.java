import javax.swing.*;

class FrameWindow{
    private int width;
    private int height;
    private JFrame main_frame;
    public FrameWindow(int sizex, int sizey){
        this.width = sizex;
        this.height = sizey;
    }
    public void initWindow(){
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setSize(width, height);
    }
}
