package ${cfg.servicePackage};

import ${package.Entity}.${entity};
import ${cfg.reqPackage}.${table.controllerName?replace("Controller", "Request")};
import ${cfg.reqPackage}.${table.controllerName?replace("Controller", "Response")};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * ${table.comment!} Service
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询${table.comment!}分页数据
     *
     * @param ${table.controllerName?replace("Controller", "Request")?uncap_first} 信息封装类
     * @return IPage<${table.controllerName?replace("Controller", "Response")}>
     */
    IPage<${table.controllerName?replace("Controller", "Response")}> findListByPage(${table.controllerName?replace("Controller", "Request")} ${table.controllerName?replace("Controller", "Request")?uncap_first});

    /**
     * 添加${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     */
    void add(${entity} ${entity?uncap_first});

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     */
    void delete(Long id);

    /**
      * 修改${table.comment!}
      *
      * @param ${entity?uncap_first} ${table.comment!}
      */
    void updateData(${entity} ${entity?uncap_first});

    /**
     * id查询数据
     *
     * @param id id
     * @return ${table.controllerName?replace("Controller", "Response")}
     */
    ${table.controllerName?replace("Controller", "Response")} findById(Long id);
    }
</#if>