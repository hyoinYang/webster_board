package web1.web1.domain;

import lombok.Getter;

public enum GenderType {
    BOYS(1),GIRLS(2),MIXED(3);
    private final int typeNumber;
    GenderType(int typeNumber){
        this.typeNumber = typeNumber;
    }
    public static GenderType of (int typeNumber){
        if(typeNumber == 1){
            return GenderType.BOYS;
        }else if(typeNumber == 2){
            return GenderType.GIRLS;
        }else if(typeNumber == 3){
            return GenderType.MIXED;
        }else{
            return null;
        }
    }
}
