# author: AlejandroPolo
# language: es
# se procede a crear la estructura, prosa y gramatica del gherkin en español, por buenas practicas.
# esto depende mucho de nuestro cliente

Característica: Flujo de autenticacion exitosa y fallida

  Yo como TAE(Test automation engineer)
  Quiero realizar una prueba de autenticación al sitio web
  Para comprobar la robustes y control de errores del aplicativo web, funcionen correctamente

  # Se toma la prosa del reto tecnico y se transforma en una mas diciente para los ""stakeholder""
  # Se crea Gherkin declarativo - ya que esta orientado a obtener el resultado deseado y es mucho mas claro
  # y asi evitamos el gherkin imperactivo, donde no es buena practica tener detalles tecnico
  # recodar que es una prosa donse se de claridad para personas tecnicas(dev) y no tenicas(user)

  @authenticationSuccess
  Escenario: Autenticación de usuario exitosa.
    Dado "alejandro" desea realizar una autenticacion al sitio web de prueba juju
    Cuando ingresa las credenciales
    Entonces visualizara el home y espera una confirmación "User" para cerrar la sesion