package jpabook.model.entity;

import java.io.Serializable;

public class MemberProductId implements Serializable {

    private String member;
    private String products;

    @Override
    public boolean equals(Object o) {

        return false;
    }

    @Override
    public int hashCode() {

        return 0;
    }


}
