package com.free.my.fs.core.domain.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class RolePermissionTableDef extends TableDef {

    public static final RolePermissionTableDef ROLE_PERMISSION = new RolePermissionTableDef();

    /**
     * 自增id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 角色id
     */
    public final QueryColumn ROLE_ID = new QueryColumn(this, "role_id");

    /**
     * 权限id
     */
    public final QueryColumn PERMISSION_ID = new QueryColumn(this, "permission_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ROLE_ID, PERMISSION_ID};

    public RolePermissionTableDef() {
        super("", "sys_role_permission");
    }

    private RolePermissionTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public RolePermissionTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new RolePermissionTableDef("", "sys_role_permission", alias));
    }

}
