@api
Feature: test apidemo


  Scenario: fetch todos
    * def output = read('todos.json')
    Given url baseUrl
    And path 'todos'
    When method GET
    Then status 200
    And match response == output
