package pojo;

/**
 * @author chase
 * @date 2022/12/1 4:45 PM
 */

import lombok.Data;

/**
 * @Author : chase
 * @Description :
 **/
@Data
public class BlogInfo {

    private Integer id;
    private String blogAuthor;
    private String blogUrl;
    private String blogTitle;
    private String blogItem;

}