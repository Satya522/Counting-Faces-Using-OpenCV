import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


public class FaceDetection {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String imageFile = "images/test2.png";
        Mat src = Imgcodecs.imread(imageFile);
        String xmlFile = "xml/lbpcascade_frontalface.xml";
        CascadeClassifier cascadeClassifier = new CascadeClassifier(xmlFile);
        MatOfRect faceDetection = new MatOfRect();
        cascadeClassifier.detectMultiScale(src, faceDetection);
        System.out.println(String.format("Detected faces: %d", faceDetection.toArray().length));
        for(Rect rect: faceDetection.toArray()){
            Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width,rect.y + rect.height),
                    new Scalar(0, 0, 255), 3);
        }
        Imgcodecs.imwrite("images/test2_output.png", src);
        System.out.println("Image Detection finished");
    }
}
