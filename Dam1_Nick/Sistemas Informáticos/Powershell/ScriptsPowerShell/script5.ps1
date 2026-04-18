#26 menú básico
$num=1
$contador=0
clear-host
do{
write-host "###############################################"
write-host ""
write-host "                    Menu"
write-host ""
write-host "1. Listar Usuarios"
write-host "2. Crear usuarios (pide usuario y contraseña)"
write-host "3. Elimina usuarios (pide usuario)"
write-host "4. Modifica usuarios (pide usuario y nuevo nombre)"
write-host "5. Salir"
write-host "###############################################"

Read-Host "Seleccione opción"
$opc = Read-Host "Tu opcion: "
write-host ""

write-host "Introduciste [$opc]"
#if(opc != 1 || opc == 6)
if($opc -ne 0 -or $opc -ge 6){

switch($opc){
    1 {write-host "Lista de usuarios" -ForegroundColor Cyan
        get-host
    }
    2 {write-host "Creando usuario" -ForegroundColor Cyan
        $user = read-host "Usuario: "
        $contra = read-host "Contraseña: "
    }
    3 {write-host "Eliminando usuario" -ForegroundColor Cyan
        $eliminacion = Read-host "Qué usuario quieres eliminar "
    }
    4 {write-host "Modificando nombre de usuario" -ForegroundColor Cyan
        $nombre = "¿Que usuario quieres cambiar de nombre?"
        $newnombre = "¿Cual es el nombre nuevo?"
    }
  
    5 {write-host "fin" -ForegroundColor Red
        exit
    }
    deafault {
 clear-host
     
$contador+=1
    $num=0
     
    }
}
}
}while( $num -ne 0)