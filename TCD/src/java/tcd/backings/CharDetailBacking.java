package tcd.backings;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import tcd.model.Role;
import tcd.services.TCDServiceLocal;
import tcd.utils.OriginEnum;

@ManagedBean(name ="charDetailBacking")
@SessionScoped
public class CharDetailBacking implements Serializable{ 

    private int strenghtValue;
    private int agilityValue;
    private int toughnessValue;
    private int mindValue;
    private int unassignedAttributePoints;
    private int roleSelectedValue;
    private int originSelectedValue;
    private int mediumHpValue;
    private String nameValue;    
    
    private Character character;
    
    private List<Role> roleList;
    private List<OriginEnum> originList;
    
    @ManagedProperty("#{tcdService}")
    private TCDServiceLocal tcdService;
    
    @PostConstruct
    public void init(){
        
    }
    
    public void saveCharacter() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void deleteCharacter() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void addToStrenght() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void addToAgility() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void addToToughness() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void addToMind() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void subtractToStrenght() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void subtractToAgility() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void subtractToToughness() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void subtractToMind() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public void calculateMediumHp() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public int getAttack() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public int getDefense() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public int getBlock() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public int getEnergySlots() {
            throw new UnsupportedOperationException("The method is not implemented yet.");
    }

    public int getStrenghtValue() {
        return strenghtValue;
    }

    public void setStrenghtValue(int strenghtValue) {
        this.strenghtValue = strenghtValue;
    }

    public int getAgilityValue() {
        return agilityValue;
    }

    public void setAgilityValue(int agilityValue) {
        this.agilityValue = agilityValue;
    }

    public int getToughnessValue() {
        return toughnessValue;
    }

    public void setToughnessValue(int toughnessValue) {
        this.toughnessValue = toughnessValue;
    }

    public int getMindValue() {
        return mindValue;
    }

    public void setMindValue(int mindValue) {
        this.mindValue = mindValue;
    }

    public int getUnassignedAttributePoints() {
        return unassignedAttributePoints;
    }

    public void setUnassignedAttributePoints(int unassignedAttributePoints) {
        this.unassignedAttributePoints = unassignedAttributePoints;
    }

    public int getRoleSelectedValue() {
        return roleSelectedValue;
    }

    public void setRoleSelectedValue(int roleSelectedValue) {
        this.roleSelectedValue = roleSelectedValue;
    }

    public int getOriginSelectedValue() {
        return originSelectedValue;
    }

    public void setOriginSelectedValue(int originSelectedValue) {
        this.originSelectedValue = originSelectedValue;
    }

    public int getMediumHpValue() {
        return mediumHpValue;
    }

    public void setMediumHpValue(int mediumHpValue) {
        this.mediumHpValue = mediumHpValue;
    }

    public String getNameValue() {
        return nameValue;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<OriginEnum> getOriginList() {
        return originList;
    }

    public void setOriginList(List<OriginEnum> originList) {
        this.originList = originList;
    }

    public TCDServiceLocal getTcdService() {
        return tcdService;
    }

    public void setTcdService(TCDServiceLocal tcdService) {
        this.tcdService = tcdService;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    
    
    
}
