package ${cfg.reqPackage};

import com.fzs.iotcard.common.dto.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ${table.comment!} request
 *
 * @author ${author}
 * @since ${date}
 */
@Data
@EqualsAndHashCode(callSuper = true)
<#if kotlin>
class ${table.controllerName?replace("Controller", "Request")} : BaseRequest
<#else>
public class ${table.controllerName?replace("Controller", "Request")} extends BaseRequest {
}
</#if>