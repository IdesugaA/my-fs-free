package com.free.my.fs.core.domain.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class RoleTableDef extends TableDef {

    public static final RoleTableDef ROLE = new RoleTableDef();

    /**
     * 自增id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 角色code码
     */
    public final QueryColumn ROLE_CODE = new QueryColumn(this, "role_code");

    /**
     * 角色名称
     */
    public final QueryColumn ROLE_NAME = new QueryColumn(this, "role_name");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ROLE_CODE, ROLE_NAME, CREATE_TIME};

    public RoleTableDef() {
        super("", "sys_role");
    }

    private RoleTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public RoleTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new RoleTableDef("", "sys_role", alias));
    }

}
