package com.free.my.fs.common.domain;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

// EqualsAndHashCode可以自动生成equals和hashCode方法的实现
// 这样就可以实现内容不同，对象就不同

@Data
@EqualsAndHashCode(callSuper = true)
public class Dtree extends FileBo {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * dtree自定义图标
     */
    private String iconClass;

    /**
     * dtree开启复选框
     */
    private String checkArr = "0";

    /**
     * dtree节点名称
     */
    private String title;

    /**
     * 是否展开节点
     */
    private Boolean spread = true;

    /**
     * 子集合
     */
    private List<Dtree> children;

}
