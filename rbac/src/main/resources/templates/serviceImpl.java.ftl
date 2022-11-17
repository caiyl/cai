package ${cfg.serviceImplPackage};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${cfg.servicePackage}.${table.serviceName};
import ${cfg.reqPackage}.${table.controllerName?replace("Controller", "Request")};
import ${cfg.reqPackage}.${table.controllerName?replace("Controller", "Response")};
import org.rbac.exception.BizException;
import org.rbac.exception.BizCode;
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import javax.annotation.Resource;

/**
 * ${table.comment!} Service实现类
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

    }
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Resource
    private ${table.mapperName} ${(table.mapperName)?uncap_first};

    @Override
    public IPage<${table.controllerName?replace("Controller", "Response")}> findListByPage(${table.controllerName?replace("Controller", "Request")} ${table.controllerName?replace("Controller", "Request")?uncap_first}) {
        //TODO
        return null;
    }

    @Override
    public void add(${entity} ${entity?uncap_first}) {
        baseMapper.insert(${entity?uncap_first});
    }

    @Override
    public void delete(Long id) {
        ${entity} databaseRecord = baseMapper.selectById(id);
        if (databaseRecord == null) {
            throw new BizException(BizCode.RECORD_NOT_EXISTS);
        }
        baseMapper.deleteById(id);
    }

    @Override
    public void updateData(${entity} ${entity?uncap_first}) {
        ${entity} databaseRecord = baseMapper.selectById(${entity?uncap_first}.getId());
        if (databaseRecord == null) {
            throw new BizException(BizCode.RECORD_NOT_EXISTS);
        }
        baseMapper.updateById(${entity?uncap_first});
    }

    @Override
    public ${table.controllerName?replace("Controller", "Response")} findById(Long id) {
        ${entity} ${entity?uncap_first} = baseMapper.selectById(id);
        if (${entity?uncap_first} == null) {
            throw new BizException(BizCode.RECORD_NOT_EXISTS);
        }
        ${table.controllerName?replace("Controller", "Response")} vo = new ${table.controllerName?replace("Controller", "Response")}();
        BeanUtils.copyProperties(${entity?uncap_first}, vo);
        return vo;
    }
}
</#if>