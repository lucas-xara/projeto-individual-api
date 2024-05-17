# projeto-individual-api

## Descrição
Esta API permite gerenciar uma biblioteca de mangás, incluindo operações de criação, leitura, atualização e exclusão (CRUD). Optei por fazer uma biblioteca de mangás por ter mais conhecimento sobre.

## Endpoints

### Listar todos os Mangás
**GET** `/mangas`

### Buscar Mangá por ID
**GET** `/mangas/{id}`

### Criar um Novo Mangá
**POST** `/mangas`

### Atualizar um Mangá
**PUT** `/mangas/{id}`

### Excluir um Mangá
**DELETE** `/mangas/{id}`

#### Corpo da Requisição
```json
{
    "titulo": "Nome do Mangá",
    "volume": 1,
    "informacaoPublicacao": {
        "autor": "Nome do Autor",
        "dataPublicacao": "YYYY-MM-DD",
        "editora": "Nome da Editora"
    }
}
```
