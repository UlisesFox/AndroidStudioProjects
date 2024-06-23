<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $code=$_POST["code"];
    $nombre=$_POST["nombre"];
    $costo=$_POST["costo"];
    $correo=$_POST["correo"];
    $categoria=$_POST["categoria"];
    $entrega=$_POST["entrega"];

    $query="UPDATE proveedor SET nombre='$nombre', costo='$costo', correo='$correo', categoria='$categoria', entrega='$entrega' WHERE code='$code'";
    
    $resultado=$conexion->query($query);
    
    if($conexion->affected_rows > 0){
        if ($resultado === TRUE){

        }else{
            
        }
    }else{
        echo "error no hay consultas";
    }

    $conexion->close();
}
?>