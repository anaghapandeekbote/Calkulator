Feature: Calculator Testing 

  Scenario Outline: Operations  on two numbers
    Given Opening calculator 
    When Enter'<operand1>' in the calculator
    And Enter operator '<op>' in the calculator
    And Enter '<operand2>' in the calculator
    Then Check result as per '<result>'

    Examples: 
      | operand1 | op | operand2        | result |
      | -234234 | +  |    345345 |   111111 |
      |  234823 | -  | -23094823 | 23329646 |
      |    4000 | /  |       200 |       20 |
      |     423 | *  |       525 |   222075 |