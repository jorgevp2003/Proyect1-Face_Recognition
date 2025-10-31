package faceRecognition;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.core.Point;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;


public class RealTimeDetector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); //Traigo las librerias de opencv
		
		VideoCapture webCam = new VideoCapture(0); // Creamos camara webCam, con la camara n0.
		
		if(!webCam.isOpened()) { // Si la camara esta cerrada o no hay.
			System.out.println("Error: No se detecta camara.");
			return;
		} else System.out.println("Camara conectada.");
		
		//Creamos el metodo de reconocimiento facial.
		CascadeClassifier reconocimientoCara = new CascadeClassifier("Resources/haarcascades/haarcascade_frontalface_default.xml");
		
		if (reconocimientoCara.empty()) {
		    System.out.println("ERROR: No se pudo cargar el XML");
		} else {
		    System.out.println("XML cargado correctamente");
		}
		
		Mat img = new Mat(); //Creo matriz para guardar imagenes.
		Mat imgGray = new Mat(); // Creo matriz para guardar imagenes en escala de grises.
		MatOfRect faces = new MatOfRect(); //?
		
		
		if (!img.empty()) {
		    System.out.println("ERROR: img vacío, la cámara no devolvió imagen.");
		}
		
		//ventana para ver la img de webcam.
		JFrame ventanaImagen = new JFrame("Deteccion facial en tiempo real");
		System.out.println("Abriendo ventana de dteccion.");
		ventanaImagen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//?
		JLabel labelImagen = new JLabel();
		
		ventanaImagen.getContentPane().add(labelImagen); //Creamos ventana
		ventanaImagen.setSize(640,480); //Asignamos tamaño
		ventanaImagen.setVisible(true); //Hacemos visible
		
		while(true) {
			if(!webCam.read(img)) { //Comprueba si puede ver la img y si no se termina.
				System.out.println("ERROR: No se pudo capturar frame.");
				break;
			}
			//Convierte la imagen a grises.
		Imgproc.cvtColor(img, imgGray, Imgproc.COLOR_BGR2GRAY);
			
		reconocimientoCara.detectMultiScale(imgGray, faces,1.1, 4, 0, new Size(30,30), new Size());
		
		  for(Rect rect :faces.toArray()) {
          	Imgproc.rectangle(img, new Point(rect.x,rect.y),
          			new Point(rect.x + rect.width, rect.y + rect.height), //Definimos la localizacion del point.
          			new Scalar(0,255,0),2); //Seleccion de color
          } 
			
			
		  //Convertimos la matriz a bufferedImg para swing
		  labelImagen.setIcon(new ImageIcon(matToBufferedImage(img)));
		  labelImagen.repaint(); //Muestra la img
		}
		webCam.release();
		
		
		
	}
	
	//Cambio de tipo de imagen generada.
	private static BufferedImage matToBufferedImage(Mat original) {
	    int width = original.width();
	    int height = original.height();
	    int channels = original.channels();
	    byte[] sourcePixels = new byte[width * height * channels];
	    original.get(0, 0, sourcePixels);

	    BufferedImage image;
	    if (original.channels() == 3) {
	        image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	    } else {
	        image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
	    }
	    final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	    System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);
	    return image;
	}

}
