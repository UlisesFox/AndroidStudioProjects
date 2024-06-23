<?php
if($_SERVER["REQUEST_METHOD"]=='GET'){
    require_once 'Conexion.php';

    $nombreT =$_GET["nombreT"];

    $query="SELECT * FROM tarjeta WHERE nombreT = '$nombreT'";
    
    $resultado=$conexion->query($query);
    
    if($conexion->affected_rows > 0){
        while($row = $resultado->fetch_assoc()){
            $array=$row;
        }
        echo json_encode($array);
    }else{
        echo "error no hay consultas";
    }

    $resultado->close();
    $conexion->close();
}
?>