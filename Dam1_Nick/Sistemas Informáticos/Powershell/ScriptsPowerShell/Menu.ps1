#26 menú básico
$num=1
$contador=0
clear-host
do{
write-host "###############################################"
write-host ""
write-host "                    Menu"
write-host ""
write-host "1. Ver version"
write-host "2. Ver fecha"
write-host "3. Ver ayuda"
write-host "4. Abrir bloc de notas"
write-host "5. Abrir calculadora"
write-host "6. Salir"
write-host "###############################################"

if($contador -eq 1){
Write-host "Bobo"
$contador=0
}
$opc = Read-Host "Tu opcion: "
write-host ""

write-host "Introduciste [$opc]"
#if(opc != 1 || opc == 6)
if($opc -ne 0 -or $opc -ge 6){

switch($opc){
    1 {write-host "version" -ForegroundColor Cyan
        get-host
    }
    2 {write-host "fecha" -ForegroundColor Cyan
        get-date
    }
    3 {write-host "ayuda" -ForegroundColor Cyan
        get-help
    }
    4 {write-host "bloc de notas" -ForegroundColor Cyan
        notepad
    }
    5 {write-host "calculadora" -ForegroundColor Cyan
        Start-process calc 
    }
    6 {write-host "fin" -ForegroundColor Red
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