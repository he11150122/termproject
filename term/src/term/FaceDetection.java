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
        	//이미지 사각형 표시
        	Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        	//이미지 크롭
        	rectCrop = new Rect(rect.x,rect.y,rect.width,rect.height);
        	//크롭이미지 매트 형태로 저장
        	Mat imageroi= new Mat(image,rectCrop);
        	//리사이즈 저장용 매트 선언
        	Mat resizeImage = new Mat();
        	//리사이즈용 사이즈객체 선언
        	Size sz = new Size(1000,1000);
        	//이미지 리사이즈
        	Imgproc.resize(imageroi, resizeImage, sz);
        	//리사이즈된 이미지 저장
        	Imgcodecs.imwrite("ouput_face.jpg", resizeImage);
        }
        
        String filename;
        //length>=1이 검출된 얼굴이 있음 
        if(faceDetections.toArray().length >=1)
        	filename = "ouput.jpg";
        else
        	filename = "ouput1.jpg";
        
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);

	}



}

