# pointSistema

Rodar comando docker para subir imagem POSTGRES
    docker run -p 5432:5432 --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=noticias -d postgres
    
Rodar comando postgres dentro da imagem docker 
    docker exec -it postgres psql -U postgres
    
Criar database 'noticias' dentro da imagem docker    
    create database noticias;
   
Imagem docker postgres rodando, subir o projeto java
    mvn clean install
