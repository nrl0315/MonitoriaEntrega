<?php

include 'conexion_backend.php';

$nombre_completo= $_POST['nombre_completo'];
$correo= $_POST['correo'];
$usuario= $_POST['usuario'];
$contraseña= $_POST['contrasena'];

$query= "INSERT INTO usuarios(nombre_completo, correo, usuario, contrasena) 
         VALUES('$nombre_completo', '$correo','$usuario', '$contraseña' )";

$ejecutar= mysqli_query($conexion, $query);

if($ejecutar){
    echo '
          <script>
             alert("usuario almacenado exitosamente");
             window.location = "../index.php";
          </script>
    
    ';
}else{
    echo '
          <script>
             alert("intentalo de nuevo, usuario NO almacenado exitosamente");
             window.location = "../index.php";
          </script>
    
    ';

}

mysqli_close($conexion);

?>