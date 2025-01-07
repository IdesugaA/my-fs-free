package com.free.my.fs.core.domain.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class FileInfoTableDef extends TableDef {

    public static final FileInfoTableDef FILE_INFO = new FileInfoTableDef();

    /**
     * 自增id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 文件路径
     */
    public final QueryColumn URL = new QueryColumn(this, "url");

    /**
     * 文件名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 文件大小
     */
    public final QueryColumn SIZE = new QueryColumn(this, "size");

    /**
     * 文件展示类型
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 是否文件夹 0否 1是
     */
    public final QueryColumn IS_DIR = new QueryColumn(this, "is_dir");

    /**
     * 是否图片 0否 1是
     */
    public final QueryColumn IS_IMG = new QueryColumn(this, "is_img");

    /**
     * 来源
     */
    public final QueryColumn SOURCE = new QueryColumn(this, "source");

    /**
     * 文件后缀名
     */
    public final QueryColumn SUFFIX = new QueryColumn(this, "suffix");

    /**
     * 用户id
     */
    public final QueryColumn USER_ID = new QueryColumn(this, "user_id");

    /**
     * 上传时间
     */
    public final QueryColumn PUT_TIME = new QueryColumn(this, "put_time");

    /**
     * 文件uuid后的新名称
     */
    public final QueryColumn FILE_NAME = new QueryColumn(this, "file_name");

    /**
     * 父id
     */
    public final QueryColumn PARENT_ID = new QueryColumn(this, "parent_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, URL, NAME, SIZE, TYPE, IS_DIR, IS_IMG, SOURCE, SUFFIX, USER_ID, PUT_TIME, FILE_NAME, PARENT_ID};

    public FileInfoTableDef() {
        super("", "file_info");
    }

    private FileInfoTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public FileInfoTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new FileInfoTableDef("", "file_info", alias));
    }

}
