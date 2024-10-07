Feature: Teste de consulta de CEP

  Testando end point de consulta de CEP
  Integrado com a ViaCep

  Background:
    Given que faço uma consulta a base URL

  Scenario: Verifica se o retorno da consulta por um cep válido está correta
    Given que faço uma consulta GET ao path: "api/v1/address"
    When realizo a busca de endereço pelo cep: "38425-471"
    Then o end point deve retornar status OK e uma UF válida

  Scenario: Verifica se o retorno da consulta por um cep com formato inválido é um BAD_REQUEST
    Given que faço uma consulta GET ao path: "api/v1/address"
    When realizo a busca de endereço pelo cep: "99999-47199"
    Then o end point deve retornar status BAD_REQUEST ao passar cep com formato inválido

  Scenario: Verifica se o retorno da consulta por um cep com formato válido mas inexistente é um NOT_FOUND
    Given que faço uma consulta GET ao path: "api/v1/address"
    When realizo a busca de endereço pelo cep: "99999-471"
    Then o end point deve retornar status NOT_FOUND ao buscar por cep inexistente
