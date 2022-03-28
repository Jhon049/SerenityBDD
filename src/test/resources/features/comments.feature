Feature: Lista de usuarios
  Como automatizador de pruebas
  Quiero conocer la lista de usuarios validados
  Para validar la existencia en plataforma

  Scenario: Post comments
    Given envio el request a la URL
    When hago la peticion
    Then espero la respuesta ok

  Scenario: Post comments con parametro adicional
    Given envio el request
    When hago la peticion con parametro adicional
    Then espero status 200