package com.glemontree.mybatis.bean;

/**
 * 角色
 */
public class Role {
    private int id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色标识
     */
    private String roleSign;

    /**
     * 角色描述
     */
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSign() {
        return roleSign;
    }

    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleSign='" + roleSign + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
