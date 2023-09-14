package jpabook.model.entity;


import javax.persistence.MappedSuperclass;


// 엔터티와 실제로 매핑되지 않고 매핑 정보를 상속하는 목적
// 추상 클래스와 비슷함
@MappedSuperclass

public abstract class BaseEntity {

}
