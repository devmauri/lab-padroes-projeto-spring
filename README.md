# Explorando Padrões de Projetos na Prática com Java

## Além dos padrões Singleton, Strategy/Repository e Facade, foi implementado o padrão Command entre o controller e o service já existentes.
Como esse padrão transformou as requisições em objetos independentes. Agora temos um histórico de comandos que foram aplicados a API e podemos escolher quando e de que forma eles serão executados (individuais, lotes de insert, etc).

## Foi adicionado também um DTO genério para trafegar as informações dentro da API.

## Em nenhum momento as alterações quebram o codigo e para remove-las basta alterar uma linha no controller.

### Para rodar a aplicação basta executar o arquivo Aplicattion.java, abrir um browser na pagina http://localhost:8080/swagger-ui.html
### Os dados de inserção serão do tipo jason da forma id,nome,endereço->cep.
{
  "id": 1,
  "nome": "usuario1",
  "endereco": {
    "cep": "97060480"
  }
}

### Demais comentarios em cada arquivo.

