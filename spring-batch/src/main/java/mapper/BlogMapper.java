package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import pojo.BlogInfo;

import java.util.List;
import java.util.Map;

/**
 * @author chase
 * @date 2022/12/1 4:47 PM
 */
@Mapper
public interface BlogMapper {
    @Insert("INSERT INTO bloginfo ( blogAuthor, blogUrl, blogTitle, blogItem )   VALUES ( #{blogAuthor}, #{blogUrl},#{blogTitle},#{blogItem}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(BlogInfo bloginfo);


    @Select("select blogAuthor, blogUrl, blogTitle, blogItem from bloginfo where blogAuthor < #{authorId}")
    List<BlogInfo> queryInfoById(Map<String , Integer> map);
}
