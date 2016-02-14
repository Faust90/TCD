package tcd.model;

import java.util.List;
import tcd.utils.AttributeEnum;

public class Role {

    private int roleId;
    private String roleName;
    private String roleDesc;
    private AttributeEnum primaryAttribute;
    private AttributeEnum secondaryAttribute;
    private List<Skill> skillList;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public AttributeEnum getPrimaryAttribute() {
        return primaryAttribute;
    }

    public void setPrimaryAttribute(AttributeEnum primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    public AttributeEnum getSecondaryAttribute() {
        return secondaryAttribute;
    }

    public void setSecondaryAttribute(AttributeEnum secondaryAttribute) {
        this.secondaryAttribute = secondaryAttribute;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }
   
}
