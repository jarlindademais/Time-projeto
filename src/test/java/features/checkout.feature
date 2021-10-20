# language: pt
  # emcoding: utf-8

  Funcionalidade: Login Checkout

    Esquema do Cenario: Preencher o formulario do checkout
      Dado que o usuario faca login e entre na tela de checkout
      Quando preenche os campos firstname <name> e lastname <lastName>
      E preenche o campo postalcode <pCode>
      E clica no botao Checkout
      Entao deve se ver <tipoCenario>

      Exemplos:
        | tipoCenario      | name    | lastName       | pCode      |
        | "lastName vazio" | "Jarla" | ""             | "55023212" |
        | "pCode vazio"    | "Jarla" | "Morais Frota" | ""         |
