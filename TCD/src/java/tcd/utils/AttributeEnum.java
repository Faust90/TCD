package tcd.utils;

public enum AttributeEnum {

    STRENGHT(1,"attribute.strenght"),
    AGILITY(2,"attribute.agility"),
    TOUGHNESS(3,"attribute.toughness"),
    MIND(4,"attribute.mind");

    private static Exception MissingResourceException(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
    
    public static AttributeEnum getValue(int value) throws IllegalArgumentException {
      
        for(AttributeEnum att : AttributeEnum.values()){
            if(value == att.getIdAttribute()){
                return att;
            }
        }        
        throw new IllegalArgumentException("No Attribute found for value "+ value);
    }
    
}
