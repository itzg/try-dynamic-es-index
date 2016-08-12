package me.itzg.repos;

import me.itzg.model.UserDoc;
import org.springframework.context.annotation.Scope;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * Get at UserDoc instances
 */
@Scope("prototype")
public interface UserRepository extends ElasticsearchCrudRepository<UserDoc, String> {
}
