[English Version](README.EN.md)

# Protótipo do Sistema de Cadastro de Demandas do PUC Tec

Este repositório contém o protótipo do Back-End Sistema de Cadastro de Demandas do PUC Tec, desenvolvido no [Serviço de Apoio a Startups do PUC Tec (SA PUC Tec)](https://www.pucminas.br/puctec/Paginas/default.aspx) para atender uma demanda interna do PUC Tec.

## Introdução

O PUC Tec é um programa de aceleração de startups desenvolvidas por alunos da Pontifícia Universidade Católica de Minas Gerais. Uma das formas nas quais o PUC Tec auxilia as startups, é por meio do encaminhamento de demandas das empresas para alunos estagiários do programa de estágio do PUC Tec. Esses alunos são orientados por professores de suas respectivas áreas de conhecimento, e devem entregar o que foi requisitado à startup solicitante no prazo especificado.

Uma das dificuldades encontradas pelos funcionários, professores e alunos do PUC Tec é no gerenciamento dessas demandas, resultando em um repetitivo trabalho manual que está propenso a erro. Visando a solucionar essas dificuldades e aumentar a produtividade e eficiência, foi proposto o desenvolvimento de um sistema de software responsável por gerenciar as demandas oriundas das startups do PUC Tec.

## Requisitos

Para o desenvolvimento deste sistema, foram coletados os seguintes requisitos:

### Funcionais

- Permitir acompanhar e modificar o ciclo de vida e status de uma demanda em um quadro
  kanban.
- Permitir as startups criarem demandas.
- Permitir os funcionários do PUC Tec aceitarem, rejeitarem, alterarem (o prazo) ou
  redirecionarem demandas.
- Permitir os professores (no caso de TI) aceitarem, rejeitarem, alterarem (o prazo) ou
  redirecionarem demandas.
- Permitir especificar os tipos de alunos, sem necessidade de alterar o programa.
- Permitir os alunos entregarem diferentes tipos de entrega (links, comentários, relatórios).
- Permitir que startups possam especificar o tipo de entrega desejada.
- O sistema deve ter login e senha.
- Permitir aos funcionários do PUC Tec cadastrarem startups, alunos e professores.

### Não Funcionais

- O site do sistema deve poder ser acessado tanto de navegador web de desktop e mobile.
- O Back-End do sistema deve ser desenvolvido na linguagem de programação Kotlin com o
  framework Spring Boot.
- O Front-End do sistema dever ser desenvolvido utilizando a linguagem de programação TypeScript e os frameworks React e Tailwind CSS.
- O banco de dados utilizado pelo Back-End será definido em breve.

## Projeto

Para o desenvolvimento deste sistema, foi desenvolvido um projeto de banco de dados através do [Diagrama Entidade Relacionamento Estendido (EER)](./docs/Diagrama_Entidade_Relacionamento_Estendido.png), e depois foi construído um projeto [Entidade Relacionamento no MySQL WorkBench](./docs/MySQL_Model.mwb).

## Implementação

Para a implementação deste protótipo, foi utilizado o framework [Spring Boot](https://spring.io/) junto da linguagem de programação [Kotlin](https://kotlinlang.org/). E para o banco de dados, foi utilizado o [MySQL](https://www.mysql.com/). 