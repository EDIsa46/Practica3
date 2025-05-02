Feature: Renovar Préstamo

  Scenario: Renovación exitosa de un préstamo no vencido
    Given un préstamo con ID 1 y fecha de fin "2025-05-10"
    When se intenta renovar el préstamo
    Then la renovación debería ser "true"
    And el estado de renovación del préstamo debería ser "true"
    And el número de renovaciones realizadas debería ser 1

  Scenario: Intento de renovación de un préstamo vencido
    Given un préstamo vencido con ID 2 y fecha de fin "2025-05-01"
    When se intenta renovar el préstamo
    Then la renovación debería ser "false"
    And el estado de renovación del préstamo debería ser "false"
    And el número de renovaciones realizadas debería ser 0

  Scenario: Intento de renovación de un préstamo ya renovado
    Given un préstamo ya renovado con ID 3 y fecha de fin "2025-05-15"
    When se intenta renovar el préstamo
    Then la renovación debería ser "false"
    And el estado de renovación del préstamo debería ser "true"
    And el número de renovaciones realizadas debería ser 1
