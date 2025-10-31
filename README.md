JavaFaceRecognition

JavaFaceRecognition es un proyecto personal para aprender, construir y mostrar en el porfolio una aplicación de reconocimiento facial en Java.
📚 Objetivo

Crear una aplicación de escritorio desde cero capaz de detectar y reconocer rostros, aprendiendo sobre procesamiento de imágenes, OpenCV en Java, buenas prácticas de desarrollo y manejo de librerías externas.

🛠️ Tecnologías utilizadas

Aplicación de Escritorio:

Java (JDK 11 o superior)

OpenCV 4.12.0 (Java bindings)

JavaFX (opcional, para interfaz gráfica)

SQLite (opcional, para almacenar información de usuarios)

Maven (gestión de dependencias y build)

Extras opcionales:

Docker (para empaquetar la aplicación)

Git (control de versiones)

📂 Estructura Inicial del Repositorio
JavaFaceRecognition/
├── README.md
├── src/
│   └── main/java/com/poto/facerecognition/
│       ├── Main.java
│       ├── FaceDetector.java
│       ├── FaceRecognizer.java
│       └── UI/
│           └── AppGUI.java
├── resources/
│   ├── images/
│   │   ├── training/       # Fotos de usuarios
│   │   └── haarcascade_frontalface_default.xml
└── docs/                  # Documentación y diagramas

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
