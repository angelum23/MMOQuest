# MMOQuest

## O que é?
MMOQuest é uma api para criação e execução de tarefas e eventos.<br>
As tarefas e eventos criados podem e devem ser datadas para conclusão dentro da data.<br>
As tarefas concluídas são classíficadas por dificuldade, dependendo do clima na data da conclusão da tarefa

## Api externa
Usei uma api gratuita de previsão do tempo, usada para determinar a dificuldade da tarefa ou evento que está sendo concluída na request de concluir

## Funcionalidades

### Tarefas
- Criação de tarefas
- Edição de tarefas
- Remoção de tarefas
- Consulta de tarefas
- Conclusão de tarefas


### Eventos
- Criação de eventos
- Edição de eventos
- Remoção de eventos
- Consulta de eventos
- Conclusão de eventos


## Endpoints :D

### Evento

>curl --location 'http://localhost:9090/Evento/salvar' \
--header 'Content-Type: application/json' \
--data '{"nome": "teste4","descricao": "teste4","tipoEvento": 0} 

>curl --location 'http://localhost:9090/Evento/RecuperarTodos'

>curl --location 'http://localhost:9090/Evento/salvar' \
--header 'Content-Type: application/json' \
--data '{
"id": 2,
"nome": "teste",
"descricao": "teste",
"tipoEvento": 2
}'

>curl --location --request DELETE 'http://localhost:9090/Evento/remover?id=5'

>curl --location --request POST 'http://localhost:9090/Evento/ConcluirEvento?id=1'


### Tarefa

>curl --location 'http://localhost:9090/Tarefa/salvar' \
--header 'Content-Type: application/json' \
--data '{
"nome": "teste4",
"descricao": "teste4",
"tipoEvento": 0
}'

>curl --location 'http://localhost:9090/Tarefa/ConcluirTarefa?id=1' \
--header 'Content-Type: application/json' \
--data '{
"nome": "teste4",
"descricao": "teste4",
"tipoEvento": 0
}'

>curl --location 'http://localhost:9090/Tarefa/Recuperar?id=1'

>curl --location --request DELETE 'http://localhost:9090/Tarefa/remover?id=1'
