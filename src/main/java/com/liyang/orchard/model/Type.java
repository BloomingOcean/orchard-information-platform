package com.liyang.orchard.model;

import javax.persistence.*;

public class Type {
    /**
     * 信息类型ID
     */
    @Id
    @Column(name = "type_id")
    private Integer typeId;

    /**
     * 类型名称
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 获取信息类型ID
     *
     * @return type_id - 信息类型ID
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 设置信息类型ID
     *
     * @param typeId 信息类型ID
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取类型名称
     *
     * @return type_name - 类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置类型名称
     *
     * @param typeName 类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}