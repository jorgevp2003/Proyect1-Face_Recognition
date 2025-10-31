JavaFaceRecognition

JavaFaceRecognition es un proyecto personal para aprender, construir y mostrar en el porfolio una aplicación de reconocimiento facial en Java.
📚 Objetivo

Crear una aplicación de escritorio desde cero capaz de detectar y reconocer rostros, aprendiendo sobre procesamiento de imágenes, OpenCV en Java, buenas prácticas de desarrollo y manejo de librerías externas.

🛠️ Tecnologías utilizadas

Aplicación de Escritorio:

Java (JDK 11 o superior)

OpenCV 4.12.0 (Java bindings)

JavaFX (para interfaz gráfica)

SQLite (para almacenar información de usuarios)

Maven (gestión de dependencias y build)

Docker (para empaquetar la aplicación)

Git (control de versiones)
🗂️ Estructura del proyecto (ejemplo con OpenCV)
```bash
facial-recognition-app/
│
├── src/
│   ├── main/java/com/poto/facerecognition/
│   │   ├── Main.java
│   │   ├── FaceTrainer.java
│   │   ├── FaceRecognizer.java
│   │   ├── DatabaseManager.java
│   │   └── UI/
│   │       └── AppGUI.java
│
├── resources/
│   ├── images/
│   │   ├── training/
│   │   │   └── Jorge/
│   │   │       ├── jorge1.jpg
│   │   │       ├── jorge2.jpg
│   │   └── others/
│   └── haarcascade_frontalface_default.xml
│
└── pom.xml  (si usas Maven)
```

🗓️ Plan Inicial

Preparar entorno de desarrollo en Eclipse con OpenCV.

Implementar detección de rostros usando Haar Cascade.

Crear módulo para registrar y almacenar imágenes de usuarios.

Implementar reconocimiento facial con LBPHFaceRecognizer.

Crear una interfaz gráfica simple con JavaFX.

Documentar el código y generar diagramas UML.

Realizar pruebas de detección y reconocimiento con imágenes reales.

Empaquetar la aplicación en un .jar ejecutable.

🤝 Contribuciones

Este proyecto es personal, pero abierto a sugerencias y mejoras.
Se valoran ideas sobre optimización del reconocimiento, mejoras de UI y uso de bases de datos para almacenamiento de usuarios.
