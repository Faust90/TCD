package tcd.utils;

public enum AttributeEnum {

    STRENGHT(1,"attribute.strenght"),
    AGILITY(2,"attribute.agility"),
    TOUGHNESS(3,"attribute.toughness"),
    MIND(4,"attribute.mind");
    
    private int idAttribute;
    private String attributeName;

    private AttributeEnum(int idAttribute, String attributeName) {
        this.idAttribute = idAttribute;
        this.attributeName = attributeName;
    }
    
    public int getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(int idAttribute) {
        this.idAttribute = idAttribute;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
    
    
}
