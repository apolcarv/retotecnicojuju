# author: AlejandroPolo
# language: es

@viewProduct
Característica: Visualizar la vista de catalogo y carrusel de productos

  Yo como TAE(Test automation engineer)
  Quiero revisar el funcionamiento de catalogo y productos recomendados
  Para comprobar la funcionalidad correctamente de cada uno de ellos

  Antecedentes:
    Dado "alejandro" abre el sitio web juju
    Cuando ingresa hasta la vista del catalogo

  @viewCatalog
  Escenario: Vista catalogo (autenticado)
    Entonces valida que se encuentre dentro de esta

  @viewCarousel
  Escenario: Vista carrusel (autenticado)
    Entonces visualiza la informacion de los productos destacados
