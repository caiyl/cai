package es.dao;

import es.bean.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chase
 * @date 2022/9/26 5:40 PM
 */
@Repository
public interface UserDao extends ElasticsearchRepository<User, Long> {

}

