<?php
if($_SERVER["REQUEST_METHOD"]=='GET'){
    require_once 'Conexion.php';

    $codeP=$_GET["codeP"];

    $query="SELECT * FROM producto WHERE codeP = '$codeP'";
    
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