# Descrição do problema 

```sh
Este projeto oferece um serviço de backend para cadastrar cidade e clientes
Acesse o site :

https://customers-challenge.herokuapp.com

e teste as rotas descritas abaixo...

caso deseje baixe o projeto para executar com  o postgres ou o H2 na porta localhot:8080
```
 
## 1. Dependências

Instalar as seguintes ferramentas:

    1. JDK 1.8
    2. Maven
    3. Docker compose
    4. H2
    
O projeto utiliza um banco embarcado (Postgres) e H2 para desenvolvimento.
mude o arquivo application.properties caso deseje mudar de banco
 
## 2. Executando o Projeto
 IDEA Intellij pode ser recomendado
Após baixar o projeto, para executá-lo é necessário rodar os seguintes comandos dentro da pasta raiz.

```sh
$ docker-compose up   // cria a tabela xy-inc e realiza 7 insert para começar a testar os serviços de forma automatizada.
$ mvn clean install   
$ mvn spring-boot:run 
```
## 3. Testando os serviços
Realizar a chamada dos serviços. 
Para testar os serviços utilize um browser ou o postman


GET / - Lista as cidades
```sh
$ curl https://customers-challenge.herokuapp.com/cities
{
    "_embedded": {
        "cities": [
            {
                "name": "Uberlândia",
                "_links": {
                    "self": {
                        "href": "https://customers-challenge.herokuapp.com/cities/1"
                    },
                    "city": {
                        "href": "https://customers-challenge.herokuapp.com/cities/1"
                    }
                }
            },
            {
                "name": "Uberaba",
                "_links": {
                    "self": {
                        "href": "https://customers-challenge.herokuapp.com/cities/2"
                    },
                    "city": {
                        "href": "https://customers-challenge.herokuapp.com/cities/2"
                    }
                }
            },
            {
                "name": "Itumbiara",
                "_links": {
                    "self": {
                        "href": "https://customers-challenge.herokuapp.com/cities/3"
                    },
                    "city": {
                        "href": "https://customers-challenge.herokuapp.com/cities/3"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "https://customers-challenge.herokuapp.com/cities{?page,size,sort}",
            "templated": true
        },
        "profile": {
            "href": "https://customers-challenge.herokuapp.com/profile/cities"
        },
        "search": {
            "href": "https://customers-challenge.herokuapp.com/cities/search"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 3,
        "totalPages": 1,
        "number": 0
    }
}
```

GET - Lista os customers
```sh
O Postman pode ser recomendado:
$ curl https://customers-challenge.herokuapp.com/customers
{
    "_embedded": {
        "customers": [
            {
                "name": "Jose",
                "_links": {
                    "self": {
                        "href": "https://customers-challenge.herokuapp.com/customers/4"
                    },
                    "customer": {
                        "href": "https://customers-challenge.herokuapp.com/customers/4"
                    },
                    "city": {
                        "href": "https://customers-challenge.herokuapp.com/customers/4/city"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "https://customers-challenge.herokuapp.com/customers{?page,size,sort}",
            "templated": true
        },
        "profile": {
            "href": "https://customers-challenge.herokuapp.com/profile/customers"
        },
        "search": {
            "href": "https://customers-challenge.herokuapp.com/customers/search"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 1,
        "totalPages": 1,
        "number": 0
    }
}
```

POST - Cria uma cidade
O Postman pode ser recomendado:
```sh
$ curl -H "Content-Type: application/json" -X POST -d '

https://customers-challenge.herokuapp.com/cities

{"name":"Araguari"}

```


POST - Cria um Customer
O Postman pode ser recomendado:
```sh
$ curl -H "Content-Type: application/json" -X POST -d '

https://customers-challenge.herokuapp.com/customers

{
	"name":"Jose",
    "city":"https://customers-challenge.herokuapp.com/cities/1"
    	
}

```


PUT - Altera um Customer
O Postman pode ser recomendado:
```sh
$ curl -H "Content-Type: application/json" -X POST -d '

https://customers-challenge.herokuapp.com/customers

{
    "name": "Noe",
    "city": "https://customers-challenge.herokuapp.com/cities/1"
}

```
