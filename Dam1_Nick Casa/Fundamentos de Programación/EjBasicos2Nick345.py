def gestion_urgencias(prioridad_del_caballero):
    if prioridad_del_caballero == 1:
        print("Alerta: Se requiere asistencia inmediata para el paciente.")
        return "Atención de emergencia"
    
    print("El paciente ha sido situado en la lista de espera.")
    return "En espera"

def proceso_de_vuelo(asiento_disponible, pago_realizado):
    if pago_realizado == False:
        print("Disculpe, su tarjeta no tiene fondos suficientes.")
        return "Pago fallido"
    
    if asiento_disponible == False:
        print("Hubo un error de consistencia. Le devolveremos su dinero.")
        return "Error de reserva"
        
    print("Su reserva se ha realizado con éxito. Que tenga un buen viaje.")
    return "Reserva completada"

def validar_acceso_al_contenido(estimado_estudiante_tiene_login, estado_suscripcion_del_usuario):
    if estimado_estudiante_tiene_login == False:
        print("Le ruego me disculpe, pero debe iniciar sesión para continuar.")
        return "Acceso denegado"

    if estado_suscripcion_del_usuario == "Expirada":
        print("Estimado usuario, su suscripción ha finalizado. ¿Desea renovarla ahora?")
        return "Redirigiendo a Renovar Suscripción"

    if estado_suscripcion_del_usuario == "Activa":
        print("Es un honor para nosotros. El video comenzará en un instante. ¡Disfrute!")
        return "Reproduciendo contenido"

def subir_aporte_del_instructor(el_respetable_instructor_sube_archivo):
    print("Hemos recibido su valioso contenido. Ahora el Administrador lo revisará.")
    return "En revisión de calidad"

'''
estimado_paciente_prioridad = 1
gestion_urgencias(estimado_paciente_prioridad)

respetable_vuelo_asiento = False
respetable_vuelo_pago = True
proceso_de_vuelo(respetable_vuelo_asiento, respetable_vuelo_pago)
'''
sesion_iniciada = True
estado_actual = "Expirada"

validar_acceso_al_contenido(sesion_iniciada, estado_actual)