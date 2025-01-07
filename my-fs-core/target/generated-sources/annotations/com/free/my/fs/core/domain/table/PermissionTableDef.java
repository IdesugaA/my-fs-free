package com.free.my.fs.core.domain.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class PermissionTableDef extends TableDef {

    public static final PermissionTableDef PERMISSION = new PermissionTableDef();

    /**
     * 自增id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 权限标识
     */
    public final QueryColumn PERMISSION_CODE = new QueryColumn(this, "permission_code");

    /**
     * 权限名称
     */
    public final QueryColumn PERMISSION_NAME = new QueryColumn(this, "permission_name");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PERMISSION_CODE, PERMISSION_NAME};

    public PermissionTableDef() {
        super("", "sys_permission");
    }

    private PermissionTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PermissionTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PermissionTableDef("", "sys_permission", alias));
    }

}
