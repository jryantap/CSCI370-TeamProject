package edu.qc.seclass.grocerylist;

/**
 * Created by sam on 4/16/2018.
 */

public class type {
    private String typeName;
    private int typeId;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public type(String typeName, int typeId) {

        this.typeName = typeName;
        this.typeId = typeId;
    }
}
