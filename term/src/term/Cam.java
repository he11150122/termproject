package term;

import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.RenderedImage;
import java.io.*;
import javax.imageio.*;
public class Cam implements Runnable {

	FaceDetection FD = new FaceDetection();
    IplImage image;
    CanvasFrame canvas = new CanvasFrame("æÛ±º∞À√‚¿ª ¿ß«— √‘øµ");
    public Cam() {
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    public void run() {
        FrameGrabber grabber = new VideoInputFrameGrabber(0);
        try {
            grabber.start();
            IplImage img;
            while (true){
            	img = grabber.grab();
            	if (img != null) {
            	cvFlip(img, img, 3);
                cvSaveImage("./bin/term/face.jpg", img);
                FD.faceDetect();
                canvas.showImage(img);
                }
            }               
        } catch (Exception e) {}

    }
    public static void main(String[] args) {
        Cam c = new Cam();
        Thread th = new Thread(c);
        th.start();
        
    }    
    
}






