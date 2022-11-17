package org.rbac.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.sun.istack.internal.NotNull;
import org.rbac.entity.BaseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author chase
 * @date 2022/11/9 9:06 AM
 */
public class CodeGenerator {
    public static void main(String[] args) {
        //分类,即创建文件夹 (例: 创建controller文件,路径又/controller改为/controller/{type})
        String type = "user";
        //作者,即创建该文件的人,会标注在每个类注释前
        String author = "chase";
        //模块名称,目前有bill, business, flowsync, task-scheduler
        String moduleName = "rbac";
        //表名
        String[] tableName = {"t_rbac_user"};
        com.p6spy.engine.spy.P6SpyDriver a = null;
        /*
          生成的范围
          1: 全部生成 (controller,service,mapper,entity)
          2: 只生成到service(service,mapper,entity)
          3: 只生成到mapper(mapper,entity)
          4: 只生成entity
         */
        String range = "1";
        //是否覆盖原先文件(注意: 如果发现已有的文件,会直接覆盖原先的文件,非特殊需要切勿修改)
        boolean isFileOverride = false;
        codeGenerator(type, author, moduleName, tableName, range, isFileOverride);
    }

    private static final String CONTROLLER = "Controller";

    private static final String SERVICE = "Service";

    private static final String SERVICE_IMPL = "ServiceImpl";

    private static void codeGenerator(String type, String author, String moduleName, String[] tableName, String range, boolean isFileOverride) {
        // 创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/rbac/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(isFileOverride); //重新生成时文件是否覆盖
        /*
         * mp生成service层代码，默认接口名称第一个字母有 I
         *
         */
        gc.setServiceName(moduleName.substring(0, 1).toUpperCase() +moduleName.substring(1) + "%sService");//去掉Service接口的首字母I
        gc.setServiceImplName(moduleName.substring(0, 1).toUpperCase() +moduleName.substring(1) + "%sServiceImpl");//去掉Service接口的首字母I
        gc.setIdType(IdType.AUTO);//主键策略,IdType.AUTO对应的策略为主键自增
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/rbac?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8");
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent("org");
        pc.setController("controller." + type);
        pc.setEntity("entity." + type);
        pc.setService("service." + type);
        pc.setMapper("mapper." + type);
        pc.setServiceImpl("service." + type + ".impl");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                String name = this.getConfig().getPackageInfo().get("ModuleName");
                String target = ".common";
                map.put("controllerPackage", this.getConfig().getPackageInfo().get(CONTROLLER).replace(target, ""));
                map.put("servicePackage", this.getConfig().getPackageInfo().get(SERVICE).replace(target, ""));
                map.put("serviceImplPackage", this.getConfig().getPackageInfo().get(SERVICE_IMPL).replace(target, ""));
                map.put("reqPackage", this.getConfig().getPackageInfo()
                        .get(SERVICE)
                        .replace(name + ".service", name + ".dto")
                        .replace(target, ""));
                this.setMap(map);
            }
        };

        // 设置输出路径
        String xmlTemplatePath = "/templates/mapper.xml.ftl";
        String mapperTemplatePath = "/templates/mapper.java.ftl";
        String controllerTemplatePath = "/templates/controller.java.ftl";
        String javaTemplatePath = "/templates/req.java.ftl";
        String deleteTemplatePath = "/templates/deleteReq.java.ftl";
        String responseTemplatePath = "/templates/response.java.ftl";
        String serviceTemplatePath = "/templates/service.java.ftl";
        String serviceImplTemplatePath = "/templates/serviceImpl.java.ftl";
        final String s = "/src/main/java/org/";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        if (range.equals("1") || range.equals("2") || range.equals("3")) {
            //java文件
            focList.add(new FileOutConfig(mapperTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return projectPath + "/rbac/src/main/java/org/" + moduleName
                            + "/mapper/" + type + "/" +tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
                }
            });

            //mapper文件
            focList.add(new FileOutConfig(xmlTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return projectPath + "/rbac/src/main/resources/mapper/" + moduleName
                            + "/" + type + "/" +tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
        }

        String path = s;

        final String finalPath = path;

        if (range.equals("1")) {
            //controller
            focList.add(new FileOutConfig(controllerTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {

                        return projectPath + "/" + moduleName + finalPath +  pc.getModuleName()
                                + "/controller/" + type + "/" + tableInfo.getEntityName() + CONTROLLER + StringPool.DOT_JAVA;
                }
            });
        }

        if (range.equals("1") || range.equals("2")) {

            //response类
            focList.add(new FileOutConfig(responseTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名
                    return getString(tableInfo, moduleName, projectPath, type, "Response", s);
                }
            });

            //request封装类
            focList.add(new FileOutConfig(javaTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名
                    return getString(tableInfo, moduleName, projectPath, type, "Request", s);
                }
            });

            //deleteRequest封装类
            focList.add(new FileOutConfig(deleteTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名
                    return getString(tableInfo, moduleName, projectPath, type, "DeleteRequest", s);
                }
            });

            //service
            final String service = "/service/";
            focList.add(new FileOutConfig(serviceTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名

                        return projectPath + "/" + moduleName + finalPath +  pc.getModuleName()
                                + service + type + "/" + moduleName.substring(0, 1).toUpperCase() +moduleName.substring(1) + tableInfo.getEntityName()
                                + SERVICE + StringPool.DOT_JAVA;

                }
            });

            //serviceImpl
            focList.add(new FileOutConfig(serviceImplTemplatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {

                        return projectPath + "/" + moduleName + finalPath +  pc.getModuleName() + "/"
                                + service + type + "/impl/" + moduleName.substring(0, 1).toUpperCase() +moduleName.substring(1) + tableInfo.getEntityName()
                                + SERVICE_IMPL + StringPool.DOT_JAVA;

                }
            });
        }

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setMapper(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(tableName); // 表名字，注意一定要大写！大写！否则识别不出来！
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix("T_"); //生成实体时去掉表前缀
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true);// lombok 模型 @Accessors(chain true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        strategy.setSuperEntityClass(BaseEntity.class);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    @NotNull
    private static String getString(TableInfo tableInfo, String moduleName, String projectPath, String type, String s2, String s) {

            return projectPath + "/"+ moduleName + s + moduleName +
                    "/dto/" + type + "/" + tableInfo.getEntityName() + s2 + StringPool.DOT_JAVA;

    }
}
