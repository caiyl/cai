package es.service;

import es.bean.User;
import es.dto.PageInfo;
import org.springframework.data.domain.Page;

/**
 * @author chase
 * @date 2022/9/26 5:42 PM
 */
public interface UserService {
    Long save(User user);

    Page<User> getPage(PageInfo pageInfo);
}
