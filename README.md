# Loja-Ecommerce

Este projeto é uma aplicação de e-commerce desenvolvida em Java utilizando Spring Boot. A aplicação permite a criação, atualização, listagem e exclusão de lojas, produtos e vendas.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Lombok

## Estrutura do Projeto

### Pacote Controller
Este pacote contém os controladores responsáveis por gerenciar as requisições HTTP.

#### LojaController
```java
package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.LojaModel;
import com.example.Ecommerce.Service.LojaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("loja")
public class LojaController {

    private final LojaService lojaService;

    @PostMapping("/criar")
    public ResponseEntity<LojaModel> criar(@RequestBody LojaModel loja){
        LojaModel lojaModel = lojaService.criar(loja);
        return ResponseEntity.status(HttpStatus.CREATED).body(lojaModel);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletar(@PathVariable("id") int id){
        boolean delete = lojaService.deletar(id);
        if(delete){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loja nao encontrada");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable("id") int id, @RequestBody LojaModel loja){
        boolean atualiza = lojaService.atualizar(id, loja);
        if(atualiza){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loja nao encontrada");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LojaModel>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(lojaService.listar());
    }
}
```

#### ProdutoController
```java
package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.ProdutoModel;
import com.example.Ecommerce.Service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/criar")
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produto){
        ProdutoModel produtoModel = produtoService.criar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoModel);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletar(@PathVariable("id") int id){
        boolean delete = produtoService.deletar(id);
        if (delete){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable("id") int id , @RequestBody ProdutoModel produto){
        boolean atualize = produtoService.atualizar(id, produto);
        if(atualize){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto nao encontrado");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoModel>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listar());
    }
}
```

#### VendasController
```java
package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.VendasModel;
import com.example.Ecommerce.Service.VendasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("vendas")
public class VendasController {

    private final VendasService vendasService;

    @PostMapping("/criar")
    public ResponseEntity<VendasModel> criar(@RequestBody VendasModel vendas){
        VendasModel vendasModel = vendasService.criar(vendas);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendasModel);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletar (@PathVariable("id") int id){
        boolean delete = vendasService.deletar(id);
        if(delete){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id da venda nao encontrado, nao foi possivel deletar");
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Object> atualizar(@PathVariable("id") int id, @RequestBody VendasModel vendas){
        boolean atualiza = vendasService.atualizar(id, vendas);
        if(atualiza){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("venda não encontrada, não foi possivel atualizar");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<VendasModel>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.listar());
    }
}
```

### Como Funciona os Endpoints

#### LojaController
- **POST /loja/criar**: Cria uma nova loja.
- **DELETE /loja/deletar/{id}**: Deleta uma loja pelo ID.
- **PUT /loja/atualizar/{id}**: Atualiza uma loja pelo ID.
- **GET /loja/listar**: Lista todas as lojas.

#### ProdutoController
- **POST /produto/criar**: Cria um novo produto.
- **DELETE /produto/deletar/{id}**: Deleta um produto pelo ID.
- **PUT /produto/atualizar/{id}**: Atualiza um produto pelo ID.
- **GET /produto/listar**: Lista todos os produtos.

#### VendasController
- **POST /vendas/criar**: Cria uma nova venda.
- **DELETE /vendas/deletar/{id}**: Deleta uma venda pelo ID.
- **PUT /vendas/atualizar/{id}**: Atualiza uma venda pelo ID.
- **GET /vendas/listar**: Lista todas as vendas.

## Como Rodar o Projeto

1. **Clone o repositório**:
```bash
git clone https://github.com/usuario/loja-ecommerce.git
```

2. **Navegue até o diretório do projeto**:
```bash
cd loja-ecommerce
```

3. **Instale as dependências**:
```bash
mvn install
```

4. **Execute a aplicação**:
```bash
mvn spring-boot:run
```

## Como Contribuir

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/fooBar`)
3. Faça commit das suas alterações (`git commit -am 'Add some fooBar'`)
4. Faça push para a branch (`git push origin feature/fooBar`)
5. Crie um novo Pull Request

## Licença
Este projeto é licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

```
Espero que isso ajude! Se precisar de mais alguma coisa, é só falar. 🙂