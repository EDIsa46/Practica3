Feature: Gestión de Libros

  Scenario: Crear un nuevo libro
    Given Se crea un libro con ISBN "978-1234567890", título "El Principito", autor "Antoine de Saint-Exupéry" y editorial "Salamandra"
    Then El ISBN del libro debe ser "978-1234567890"
    And El título del libro debe ser "El Principito"
    And El autor del libro debe ser "Antoine de Saint-Exupéry"
    And La editorial del libro debe ser "Salamandra"
    And Las copias disponibles del libro deben ser 0

  Scenario: Establecer y obtener el número de copias disponibles
    Given Se crea un libro con título "Cien años de soledad"
    When Se establecen las copias disponibles a 5
    Then Las copias disponibles del libro deben ser 5

  Scenario: Obtener los detalles del libro
    Given Se crea un libro con ISBN "978-0987654321", título "Fundación", autor "Isaac Asimov" y editorial "Debolsillo" con 2 copias disponibles
    Then Los detalles del libro deben ser "ISBN: 978-0987654321, Título: Fundación, Autor: Isaac Asimov, Editorial: Debolsillo, Copias disponibles: 2"