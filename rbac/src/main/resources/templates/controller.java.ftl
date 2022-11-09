package ${cfg.controllerPackage};

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ${cfg.servicePackage}.${table.serviceName};
import ${cfg.reqPackage}.${table.controllerName?replace("Controller", "Request")};
import ${cfg.reqPackage}.${table.controllerName?replace("Controller", "Response")};
import ${cfg.reqPackage}.${table.controllerName?replace("Controller", "DeleteRequest")};
import ${package.Entity}.${entity};
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.extern.slf4j.Slf4j;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
 * ${table.comment!}  Controller
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Validated
@Slf4j
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass} {
<#else>public class ${table.controllerName} {
</#if>

    @Resource
    private ${table.serviceName} ${(table.serviceName)?uncap_first};

    @PostMapping("/add")
    public void add(@RequestBody @Valid ${entity} ${entity?uncap_first}) {
        ${(table.serviceName)?uncap_first}.add(${entity?uncap_first});
    }

    @PostMapping("/delete")
    public void delete(@RequestBody @Valid ${table.controllerName?replace("Controller", "DeleteRequest")} ${table.controllerName?replace("Controller", "DeleteRequest")?uncap_first}) {
        ${(table.serviceName)?uncap_first}.delete(${table.controllerName?replace("Controller", "DeleteRequest")?uncap_first}.getId());
    }

    @PostMapping("/update")
    public void update(@RequestBody @Valid ${entity} ${entity?uncap_first}) {
        ${(table.serviceName)?uncap_first}.updateData(${entity?uncap_first});
    }

    @GetMapping("/detail")
    public ${table.controllerName?replace("Controller", "Response")} findById(@Min(value = 1, message = "id不能小于1") @NotNull(message = "id不能为空") Long id) {
        return ${(table.serviceName)?uncap_first}.findById(id);
    }

    @PostMapping("/list-page")
    public IPage<${table.controllerName?replace("Controller", "Response")}> findListByPage(@RequestBody @Valid ${table.controllerName?replace("Controller", "Request")} ${table.controllerName?replace("Controller", "Request")?uncap_first}) {
        return ${(table.serviceName)?uncap_first}.findListByPage(${table.controllerName?replace("Controller", "Request")?uncap_first});
    }

}
</#if>