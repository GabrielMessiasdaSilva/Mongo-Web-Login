package github.fatec.com.spring.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import github.fatec.com.spring.repository.orm.OrmMongoLogin;


public interface LoginRepositoryWithMongoDB extends MongoRepository<OrmMongoLogin, String> {}