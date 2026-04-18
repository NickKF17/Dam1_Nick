function mostrarmenu{
    clear-host
    Write-Host "============MENU============"
    Write-Host "1) Crear carpeta"
    Write-Host "2) Crear fichero"
    Write-Host "3) Listar contenido"
    Write-Host "4) Borrar fichero o carpeta"
    Write-Host "5) Salir"
    Write-Host "============================"
}

do {
mostrarmenu
   
    $opcion = Read-Host "Elige una opción"

    switch ($opcion) {

        "1" {
            $ruta = Read-Host "Introduce el nombre o ruta de la carpeta"
            New-Item -ItemType Directory -Path $ruta -Force
            Write-Host "Carpeta creada."
           
        }

        "2" {
            $ruta = Read-Host "Introduce el nombre o ruta del fichero"
            New-Item -ItemType File -Path $ruta -Force
            Write-Host "Fichero creado."
            
        }

        "3" {
            $ruta = Read-Host "Introduce la ruta a listar"
            Get-ChildItem -Path $ruta
            
        }

        "4" {
            $ruta = Read-Host "Introduce la ruta del fichero o carpeta a borrar"
            Remove-Item -Path $ruta -Recurse -Force
            Write-Host "Elemento borrado."
            
        }

        "5" {
            Write-Host "Saliendo..."
            break
        }

        Default {
            Write-Host "Opción no válida. Pulsa una tecla para continuar."
           
        }
    }


} while ($opcion -ne "5")