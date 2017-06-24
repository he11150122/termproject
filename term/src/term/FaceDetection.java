package term;

import java.net.URL;
import java.awt.*;
import javax.swing.*;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.objdetect.CascadeClassifier;

import com.googlecode.javacv.cpp.opencv_core.IplImage;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class FaceDetection{
	public void faceDetect(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Rect rectCrop;
        CascadeClassifier faceDetector = new CascadeClassifier(FaceDetection.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
        Mat image = Imgcodecs.imread(FaceDetection.class.getResource("face.jpg").getPath().substring(1));
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
 
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
 
        for (Rect rect : faceDetections.toArray()) {
        	//�̹��� �簢�� ǥ��
        	Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        	//�̹��� ũ��
        	rectCrop = new Rect(rect.x,rect.y,rect.width,rect.height);
        	//ũ���̹��� ��Ʈ ���·� ����
        	Mat imageroi= new Mat(image,rectCrop);
        	//�������� ����� ��Ʈ ����
        	Mat resizeImage = new Mat();
        	//��������� �����ü ����
        	Size sz = new Size(1000,1000);
        	//�̹��� ��������
        	Imgproc.resize(imageroi, resizeImage, sz);
        	//��������� �̹��� ����
        	Imgcodecs.imwrite("ouput_face.jpg", resizeImage);
        }
        
        String filename;
        //length>=1�� ����� ���� ���� 
        if(faceDetections.toArray().length >=1)
        	filename = "ouput.jpg";
        else
        	filename = "ouput1.jpg";
        
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);

	}



}

