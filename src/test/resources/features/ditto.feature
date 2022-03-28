Feature: Pokeapi
  como automatizador de pruebas
  quiero validar el funcionamiento del api
  para obtener respuesta exitosa

  Scenario: informacion poke api
    Given envio el request a la URL definida
    When hago la peticion del servicio
    Then espero la respuesta HTTP 200

  Scenario: informacion desde poke api
    Given envio el request a la URL base
    When hago la peticion de manera incorrecta
    Then espero la respuesta HTTP 404