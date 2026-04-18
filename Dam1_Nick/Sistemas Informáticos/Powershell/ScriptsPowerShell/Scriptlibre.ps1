 function Obtener-FraseMotivadora {
    $frases = @(
        "¡Hoy es un gran día para aprender algo nuevo!",
        "No te detengas, vas por buen camino.",
        "El éxito es la suma de pequeños esfuerzos diarios.",
        "¡Tu código va a funcionar a la primera! (O a la segunda).",
        "Si puedes imaginarlo, puedes programarlo.",
        "Tómate un café y sigue adelante."
    )
    $frase = $frases | Get-Random
    Write-Host "`n>>> $frase <<<" -ForegroundColor Yellow -BackgroundColor DarkBlue
     Write-Host "Pulsa enter para volver"
    read-host 
}

function Mostrar-GatoProgramador {
    $consejos = @(
        "¿Has probado a reiniciar?",
        "Bebe agua, el café no cuenta como hidratación.",
        "Comenta tu código para tu 'yo' del futuro.",
        "Un break de 5 minutos ahorra 2 horas de bugs.",
        "No borres ese error, ¡es una característica!"
    )
    $consejo = $consejos | Get-Random
    $gato=@(
    '
    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠤⠖⠲⣄⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠞⠉⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⠤⠶⠒⠒⠚⠛⠉⠉⠛⠛⠓⠒⠒⠴⠋⠀⢀⡆⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢀⡴⠒⠒⠒⠲⠶⢤⣄⣀⣠⠴⠚⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠊⠀⠀⠀⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡟⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢸⠀⠀⠀⠈⠙⠒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⡃⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠸⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠘⣆⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⢷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠾⠛⠛⠛⠀⠀⢀⣀⢠⣤⡄⠸⣶⠶⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠘⡇⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⢀⡀⠶⠘⠃⠈⠉⠀⠀⠀⠀⢻⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠹⠂⠀⠀⠀⠀⠐⠋⠉⠀⠈⠉⠑⠀⠀⠀⠀⢰⣾⣿⠆⠀⠀⠀⠤⠒⠈⢀⣀⠀⠤⠤⠀⠒⠒⠒⠂⠀⠈⡇⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⡇⠀⢀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠉⣇⠀⠀⢠⠀⠒⢈⠉⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⡇⠀⠀⠀⠀
⠠⠄⠐⠒⠂⠉⡏⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠤⠄⠐⠒⠀⠃⠀⠀⢿⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡏⠁⠒⠂⠀
⠀⠀⠀⠀⠀⠀⡇⣀⡀⠤⠐⠒⠈⠉⠀⠀⠀⣀⠀⠤⠂⠀⠀⠀⠀⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠃⠀⠀⠀⠀
⠀⢀⠠⠄⠒⠈⢇⠀⠀⠀⢀⠀⠄⠐⠂⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠁⠀⠀⠀⠀
⠉⠀⠀⠀⠀⢀⠸⡔⠂⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠀⠀⠀⠀⠀⠀
⠀⠀⡠⠐⠈⠀⠀⠱⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠋⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠙⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠴⠚⣹⡀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢫⠹⡗⠶⠤⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡔⡁⡸⠙⣄⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠮⠫⡈⡢⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠔⢅⢀⠜⠁⠀⠘⡄⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠏⠀⠀⠈⠢⣄⠟⠲⠤⣀⡀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠤⠖⠋⠡⣠⠔⠁⠀⠀⠀⢀⣹⡆⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠏⠤⢄⠀⣠⠒⠑⡉⠒⠧⢄⣌⡉⢹⠍⠉⡏⠉⢋⢁⣣⣠⠬⠒⠉⠀⠀⠀⠀⠀⠀⢇⠀⢹⡄⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⣆⠀⠑⠃⠀⣰⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠀⠀⠀⢰⠋⢦⠞⢱⠀⠀⠀⠀⠈⠢⡀⣳⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀⠀⠈⠒⠤⢄⡰⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠢⣀⡤⠃⠀⠀⠀⠀⠀⠀⠈⠈⣧⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠤⡀⢀⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⠀
⠀⠀⠀⠀⠀⠀⢠⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣄⠈⢁⣴⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⢀⣹⡀⠀⠀
⠀⠀⠀⠀⠀⠀⡼⠀⠀⠀⢰⠶⡄⣤⡄⠀⠀⠀⠀⠀⠀⠈⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⣤⣤⠀⠀⠀⠀⠀⠀⠀⡏⠙⠶⠋⡽⡇⠀⠀
⠀⠀⠀⠀⠀⢠⠃⠀⠀⠀⢳⠨⠋⢀⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢀⡇⠈⡇⠀⠀⠀⠀⠀⠀⠈⠦⠤⠜⠉⢹⡀⠀
⠀⠀⠀⠀⠀⡞⠀⠀⠀⠀⠀⠓⠒⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠣⣀⣁⣀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
    ')

    Write-Host $gato
    Write-Host "  [ EL GATO PROGRAMADOR DICE: ]" -ForegroundColor Cyan
    Write-Host "  > $consejo <" -ForegroundColor White -BackgroundColor DarkMagenta
     Write-Host "Pulsa enter para volver"
    read-host 
}

function Mostrar-PerroNoProgramador {
   $consejos = @(
        "¿Has probado a reiniciar?",
        "Bebe agua, el café no cuenta como hidratación.",
        "Comenta tu código para tu 'yo' del futuro.",
        "Un break de 5 minutos ahorra 2 horas de bugs.",
        "No borres ese error, ¡es una característica!"
    )
    $consejo = $consejos | Get-Random

    $perro=@(
    '
    ૮ – ﻌ–ა
      ⋆🐾⋆
     |   |
      ⋆🐾⋆
    ')
    Write-Host $perro
    Write-Host "  [ EL PERRO DORMILON ]" -ForegroundColor gray
      Write-Host "  > $consejo <" -ForegroundColor White -BackgroundColor DarkMagenta
     Write-Host "Pulsa enter para volver"
    read-host 
    }

    function Mostrar-GatoNick {
  
    $GatoNick=@(
    '
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢉⣴⣾⣿⣿⣿⣿⣷⣄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠙⢿⡟⠀⠘⣹⡿⣿⡟⣹⣿⡟⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠜⠀⠀⠇⡿⢁⡿⠗⣹⠈⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⢠⠀⡙⢿⣿⣿⡿⢿⡿⠿⣿⠿⡿⡟⠀⡀⠀⠐⠁⡊⢔⣴⢿⡇⠀⡄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠰⠘⠶⠈⠓⠉⠁⠀⢀⠁⠀⠁⠀⢀⠀⠁⠃⢀⡀⠈⣿⣿⣿⢸⣧⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⢤⠀⠀⠀⠋⠃⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⠂⠋⠻⢿⣿⣿⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠁⠀⠂⠛⠓⢦⣾⡆⠀⠀⢆⠈⠺⣅⠀⢀⣤⣷⠖⠛⠉⠉⠉⠓⢆⡙⠽⠀⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠄⠀⠀⠀⠀⠀⠠⠀⠀⠹⣿⠀⠌⣌⣄⣤⣼⢀⢸⡟⠁⠀⠀⠐⠀⠄⠀⢀⡥⠀⠤⠀⠿⠿⠟⡛⢟⣫⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⢴⡀⠂⠀⠀⠀⠀⠀⠀⠋⠀⢸⠻⣷⠶⣿⢿⠈⢁⣀⠤⠤⢐⡂⠀⠀⠉⠀⠀⠀⡀⠄⠉⡀⠼⢳⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡶⠀⠀⠀⠑⠂⠤⠀⣀⠠⠖⠀⠀⠐⠀⠉⠁⢐⠈⠀⢇⠀⡀⠢⠀⠉⢐⡠⢀⠀⠀⢀⠠⢴⣆⠙⣯⣿⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⡀⠀⠠⠀⠀⢀⡀⠀⠂⢀⠀⠀⠀⠶⣤⡟⠁⠀⢈⣿⠗⠀⢠⠴⢁⡠⠤⠛⠛⢹⠛⡛⠃⢠⣴⣐⣨⣥⣾⣋⣽⠿⣿⣿⠛⢿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⢦⣤⠤⠀⠂⠀⠄⠉⢀⠰⢻⣷⣆⠀⠘⠂⠁⠀⣠⣾⠿⠛⠉⢡⡤⠋⠀⢨⣤⣬⣿⡁⠁⠈⣻⠶⣿⣿⣿⣿⣿⣿⣷⠀⣁⣀⢢⢿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠈⠀⠀⠀⠒⣀⠛⠀⠀⠠⢶⣿⣿⣿⣷⣤⡀⠀⢴⢿⣛⡿⣿⣳⣬⣴⣁⢒⣛⣒⣒⡈⠉⢠⡀⠘⣶⡾⣿⡻⣼⣿⣿⠇⡼⣿⣿⣾⣾⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠈⠍⠀⠠⠀⠀⠀⡀⠴⢿⣿⣿⣿⡿⢛⠭⠀⠀⠈⠙⠍⣻⣿⠿⠟⠩⣦⣭⣛⢻⣿⣿⣯⣵⣾⠉⢻⣦⣭⣯⣽⣿⣿⣷⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠠⡀⠄⠀⠊⠡⠔⠲⠂⠀⠀⠚⣛⣿⡇⠂⠃⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣯⣤⣬⣉⠉⠀⣠⣿⣿⣿⣿⢽⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠁⠀⠉⠋⠀⠀⠀⠀⠔⠁⠀⠘⠿⠟⠀⠀⢧⣶⡀⠀⠟⡀⠀⣠⣤⣤⣶⣿⣿⣿⣿⣿⢿⡟⡉⠉⢤⣼⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⡀⣀⠀⣀⡀⢀⣶⣾⣿⣶⣤⣀⡀⠀⠀⠉⠁⠀⣩⣴⣶⣿⣿⣿⣿⣿⣿⡛⠭⠀⠀⣠⣴⣮⣿⣿⡙⣿⣿⣿⣿⣿⣿⣿⡿⢡⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠲⠿⣿⣿⣾⣷⠿⠙⠛⠻⣿⣿⣿⣿⣿⣆⣢⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡒⣾⣿⣿⣿⣿⣿⣿⣿⣥⣿⢛⢻⣿⣿⡟⣠⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠠⣶⣶⣌⠙⠋⣠⣶⣾⠿⢃⡉⠻⣿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡱⣽⢿⣿⠏⣀⡿⣿⣿⣿⣿⣿⠀
⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⠻⣿⡗⣰⣿⣿⣦⣾⠿⠛⣀⠙⠟⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⣷⣯⡼⠋⠸⣿⣿⣿⣿⣿⣿⣿⠀
⡻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡋⣴⡆⠹⣿⣿⣿⣿⣿⣿⣶⠿⠛⣡⣴⠿⠃⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡸⡇⢡⣾⣿⣿⣿⡟⣿⣿⣿⣿⠀
⡁⠀⠀⠉⠙⠛⠻⠿⣿⣿⣿⣿⣿⠀⠉⠛⠀⣿⣿⣿⣿⣿⣿⣿⣶⡿⠟⢁⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣧⢼⠻⠿⠛⠋⠛⠾⣿⣿⣿⠀
⣧⣅⣂⠤⣀⠀⠀⠀⠸⣿⣿⣿⡇⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⠟⢁⣤⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠓⢘⣿⡏⠀⠀⠀⠀⠀⠀⠀⠉⠛⠀
⣿⣿⣿⣿⡶⣾⡥⡀⠐⠿⢿⣿⡃⠀⠀⠘⢿⣿⣿⠿⠛⠋⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⢀⣿⠧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
    ')
    Write-host $GatoNick
    Write-Host "  [ APRUEBAME PORFI , CON UN 10 ]" -ForegroundColor RED -backgroundcolor yellow
    Write-Host "Pulsa enter para volver"
    read-host 
    }

     function Mostrar-67 {
  
    $67=@(
    '
⠀⠀⢀⠤⣂⣤⣬⣭⣭⣭⣔⡠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠔⣵⣾⣿⣿⣿⢿⣿⣿⣿⣿⣎⢂⠀⢲⣤⣤⣤⣤⣀⣒⣒⣒⣒⣂⡠⠤⠤⣄
⠐⣾⣿⣿⣿⡏⣾⡿⢎⣛⣫⣭⣴⣾⠆⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢼
⡇⣿⣿⣿⣿⣟⡿⢀⣐⣻⣛⡩⢁⠀⠀⣘⣛⣛⡛⠿⠿⠿⢿⣿⣿⣿⣿⣿⢟⣾
⡇⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣶⡕⠄⠉⠛⠛⠛⠛⡻⣣⣾⣿⣿⣿⢟⣵⣿⠛
⠃⣿⣿⣿⣿⣿⢋⣥⠭⡻⣿⣿⣿⣿⡌⡄⠀⠀⠀⡐⣼⣿⣿⣿⡿⣣⣾⠏⠀⠀
⠨⢻⣿⣿⣿⣧⢻⠁⠀⠘⢸⣿⣿⣿⡇⣿⠀⠀⠌⣼⣿⣿⣿⡿⢱⣿⠃⠀⠀⠀
⠀⢦⢻⣿⣿⣿⣦⣐⣀⣊⣼⣿⣿⡿⢱⡿⠀⠰⣸⣿⣿⣿⣿⢣⣿⠃⠀⠀⠀⠀
⠀⠀⠣⣙⠿⣿⣿⣿⣿⣿⣿⠿⢛⣵⡿⠃⢀⢃⣿⣿⣿⣿⡟⣾⡇⠀⠀⠀⠀⠀
⠀⠀⠀⠈⠛⠶⣮⣭⣭⣴⣶⡿⠿⠋⠀⠀⢨⣘⣿⡻⠿⠿⢇⣿⠀⠀⠀⠀⠀⠀
⠀⠀⢀⠔⠒⠂⠠⠤⠭⡀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠛⠛⠛⠻⠃⠀⠀⠀⠀⠀⠀
⢀⠆⠁⠀⡄⠀⠀⠀⠀⠈⢂⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠒⠁⠀⠀⠒⢤⡀⠀⠀
⠣⠤⢤⠞⠂⠀⣀⠰⠃⠀⠘⣆⢀⣀⠀⠀⠀⠀⢀⠎⠀⢠⡀⠀⠀⠀⢀⠀⠙⡀
⠀⠀⢸⠀⠈⠭⡀⢈⣡⠔⢶⠁⣹⢩⠃⠀⢀⠀⢸⠀⠀⠀⣑⣠⣤⠀⠙⡦⣀⠜
⠀⠀⠀⠣⠀⢂⠞⠱⠴⣈⡸⠰⢇⠘⠀⠰⡭⠷⢝⡤⣂⣄⠒⢤⡐⠀⠀⡇⠀⠀
⠀⠀⠀⠀⠱⠄⣀⢜⢁⡠⠥⠊⠀⠀⠀⠀⠡⡘⡄⠐⡂⠘⢌⡀⠉⠂⡸⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠄⠹⢅⣀⠹⠒⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
    ')
    Write-host $67
    Write-Host "  [ 6767676767676767 ]" -ForegroundColor RED -backgroundcolor yellow
    Write-Host "Pulsa enter para volver"
    read-host 
    }

# --- MENÚ PRINCIPAL ---
do {
    clear-host
    Write-Host "==============================" 
    Write-Host "      MENÚ DE HERRAMIENTAS"
    Write-Host "==============================" 
    Write-Host "1. Recibir frase motivadora de mi"
    Write-Host "2. Ver al Gato Programador y escuchar su gran sabiduria"
    Write-Host "3. Ver al Perro no Programador y escuchar su gran sabiduria"
    Write-Host "4. Escucha mi gran sabiduria"
    Write-Host "5. Salir"
    Write-Host "------------------------------"
   
    $opcion = Read-Host "Elige una opción (1-5)"

    switch ($opcion) {
        "1" { Obtener-FraseMotivadora }
        "2" { Mostrar-GatoProgramador }
        "3" { Mostrar-PerroNoProgramador }
        "4" { Mostrar-GatoNick }
        "5" { Write-Host "¡Hasta luego! Que tengas un gran día." -ForegroundColor Cyan }
        "67" { Mostrar-67 }
        default { Write-host "Opción no válida, intenta de nuevo." 
          Write-Host "Pulsa enter para volver"
    read-host 
    }
    }

} while ($opcion -ne "5")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               