package com.fjuarez.clapp.config;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
class MongoDbConfig extends AbstractMongoClientConfiguration {

    @Override
    public MongoClient mongoClient() {
        //TODO agregar un secret para user y pass de la BD
        String connectionString = "mongodb+srv://chano:chanogod@cluster0.zbihtrt.mongodb.net/resultados_diarios?retryWrites=true&w=majority";

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build();

        return MongoClients.create(settings);
    }

    @Override
    protected String getDatabaseName() {
        return "resultados_diarios";
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}

