package ${cfg.reqPackage};

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * ${table.comment!} request
 *
 * @author ${author}
 * @since ${date}
 */
@Data
<#if kotlin>
class ${table.controllerName?replace("Controller", "DeleteRequest")}
<#else>
public class ${table.controllerName?replace("Controller", "DeleteRequest")} {

    @Min(value = 1, message = "id不能小于1")
    @NotNull(message = "id不能为空")
    private Long id;

}
</#if>