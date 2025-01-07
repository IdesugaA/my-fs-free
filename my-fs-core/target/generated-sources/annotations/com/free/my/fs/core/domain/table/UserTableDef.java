package com.free.my.fs.core.domain.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class UserTableDef extends TableDef {

    public static final UserTableDef USER = new UserTableDef();

    /**
     * 自增id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 唯一uuid
     */
    public final QueryColumn UUID = new QueryColumn(this, "uuid");

    /**
     * 头像
     */
    public final QueryColumn AVATAR = new QueryColumn(this, "avatar");

    /**
     * 昵称
     */
    public final QueryColumn NICKNAME = new QueryColumn(this, "nickname");

    /**
     * 密码
     */
    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    /**
     * 用户名
     */
    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    /**
     * 注册时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, UUID, AVATAR, NICKNAME, PASSWORD, USERNAME, CREATE_TIME};

    public UserTableDef() {
        super("", "sys_user");
    }

    private UserTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public UserTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new UserTableDef("", "sys_user", alias));
    }

}
