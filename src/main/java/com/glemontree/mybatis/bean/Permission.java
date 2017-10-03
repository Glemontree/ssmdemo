package com.glemontree.mybatis.bean;

/**
 * 权限
 */
public class Permission {

    private Integer id;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限标识
     */
    private String permissionSign;

    /**
     * 权限描述
     */
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionSign() {
        return permissionSign;
    }

    public void setPermissionSign(String permissionSign) {
        this.permissionSign = permissionSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", permissionSign='" + permissionSign + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
