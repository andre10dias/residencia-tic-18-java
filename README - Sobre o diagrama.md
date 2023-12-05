# residencia-tic-18-java
## Carlos André Dias
#### Repositório das atividades de Instrução Prática Java

# Avaliação Individual

> Sobre o Diagrama

```
Paciente: Armazena informações sobre os pacientes.
AgenteDeSaude: Classe base para Médicos e Enfermeiros.
Medico: Representa médicos no sistema.
Enfermeiro: Representa enfermeiros no sistema.
Procedimento: Representa os procedimentos médicos que podem ser realizados.
Medicamento: Armazena informações sobre os medicamentos disponíveis.
Insumo: Armazena informações sobre os insumos disponíveis.
Triagem: Registra informações sobre triagens realizadas.
Atendimento: Registra informações sobre os atendimentos realizados.
Identificar Relacionamentos:

Paciente realiza Triagem.
Triagem direciona para Atendimento.
Atendimento é realizado por Médico ou Enfermeiro.
Atendimento inclui Procedimentos.
Procedimento pode ser composto por outros Procedimentos.
Procedimento consome Medicamentos e Insumos.
```