package es.dto;

import lombok.Data;

/**
 * @author chase
 * @date 2022/9/27 2:38 PM
 */
@Data
public class PageInfo {
    private Integer pageNum = 0;
    private Integer pageSize = 10;

}
