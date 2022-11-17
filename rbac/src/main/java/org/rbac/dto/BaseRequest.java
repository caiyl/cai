package org.rbac.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 基础请求信息封装
 */
@Data
@Accessors(chain = true)
public abstract class BaseRequest {

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码不能小于1")
    @Max(value = 5000, message = "页码不能超过5000")
    private Integer pageNo = 1;

    /**
     * 每页大小
     */
    @NotNull(message = "每页大小不能为空")
    @Min(value = 1, message = "每页大小不能小于1")
    @Max(value = 5000, message = "每页大小不能超过5000")
    private Integer pageSize = 10;
}
