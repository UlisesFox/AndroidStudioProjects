<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $nombreT =$_POST["nombreT"];
    $contraT=$_POST["contraT"];
    $bin=$_POST["bin"];
    $entidad=$_POST["entidad"];
    $tipoT=$_POST["tipoT"];
    $cvv=$_POST["cvv"];
    $caducidad=$_POST["caducidad"];

    $query="UPDATE tarjeta SET contraT='$contraT', bin='$bin', entidad='$entidad', tipoT='$tipoT', cvv='$cvv', caducidad='$caducidad' WHERE nombreT='$nombreT'";
    
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