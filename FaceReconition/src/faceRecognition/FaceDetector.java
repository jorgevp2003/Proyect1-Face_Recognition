package faceRecognition;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetector {

	public static void main(String[] args) {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture webCam = new VideoCapture(0); //0 es la primera camara.
		
		if(!webCam.isOpened()) { //Comprobamos que este si no esta activa.
			System.out.println("ERROR: Camara no detectada.");
			return;
		}
		//Cargamos el archivo .xml de opencv con los datos de reconocimiento facial.
		CascadeClassifier faceCascade = new CascadeClassifier("Resources/haarcascades/haarcascade_frontalface_default.xml");
		
		if (faceCascade.empty()) {
		    System.out.println("ERROR: No se pudo cargar el XML");
		} else {
		    System.out.println("XML cargado correctamente");
		}
		
		
		
		if (faceCascade.empty()) { 
            System.out.println("ERROR: No se pudo cargar el modelo Haar Cascade");
            return;
        }
		
		Mat frame = new Mat(); //Matriz para almacenar imagenes.
		Mat gray = new Mat(); //Matriz para almacenar img en escala de grises.
        MatOfRect faces = new MatOfRect(); //Matriz de rectangulos para guardar las caras detectadas.
		
        
        
        boolean running = true;
        while (running) {
            //Capturamos frame de la camara.
            if (!webCam.read(frame)) { //captura el frame y lo guarda en Mat frame
                System.out.println("Error al capturar frame");
                break;
            }
            //Convertimos a escala de grises. Ya que funciona mas rapido el reconocimiento.
            Imgproc.cvtColor(frame, gray, Imgproc.COLOR_BGR2GRAY); 
            
            //Intenta detectar un rostro.
            faceCascade.detectMultiScale(
            	    gray, faces,
            	    1.1,    // scaleFactor: reducción por cada pasada
            	    4,      // minNeighbors: cuántos vecinos para validar detección
            	    0,      // flags
            	    new Size(30, 30),  // tamaño mínimo de rostro
            	    new Size()         // tamaño máximo (0 = sin límite)
            	);
            
            System.out.println("Rostros detectados: " + faces.toArray().length); //Imprime 0 no detecta nada y 1 si detecta una cara
            
            //Dibuja el rectangulo al rededor del rostro 
            
            for(Rect rect :faces.toArray()) {
            	Imgproc.rectangle(frame, new Point(rect.y,rect.x),
            			new Point(rect.x + rect.width, rect.y + rect.height), //Definimos la localizacion del point.
            			new Scalar(0,255,0),2); //Seleccion de color
            } 
            
            if(!faces.empty()) {
            	Imgcodecs.imwrite("Resources/output_webcam.jpg", frame); //Guardamos la imagen
                System.out.println("Imagen guardada en resources/output_webcam.jpg");
                running = false;
            }
            
        }   
        
        
        //Convertimos la matriz a array y mostramos su longitud, para saber cuantas caras tenemos
        System.out.println("Rostros detectados: " + faces.toArray().length);
        
        if(!faces.empty()) {
        	Imgcodecs.imwrite("Resources/output_webcam.jpg", frame); //Guardamos la imagen
            System.out.println("Imagen guardada en resources/output_webcam.jpg");
            running = false;
        }
        //Cerramos la camara.
        webCam.release();
        System.out.println("Cámara cerrada.");
        
	}

}

