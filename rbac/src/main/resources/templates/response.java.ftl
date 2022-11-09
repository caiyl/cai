package ${cfg.reqPackage};

import ${package.Entity}.${entity};
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ${table.comment!} response
 *
 * @author ${author}
 * @since ${date}
 */
@Data
@EqualsAndHashCode(callSuper = true)
<#if kotlin>
class ${table.controllerName?replace("Controller", "Response")} : ${entity}
<#else>
public class ${table.controllerName?replace("Controller", "Response")} extends ${entity} {
}
</#if>