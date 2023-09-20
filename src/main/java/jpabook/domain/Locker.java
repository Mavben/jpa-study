//package jpabook.model.entity;
//
//import javax.persistence.*;
//
//@Entity
//public class Locker {
//
//    @Id @GeneratedValue
//    @Column(name = "LOCKER_ID")
//    private Long id;
//    private String username;
//
//    @OneToOne(mappedBy = "locker")
//    private Member member;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Member getMember() {
//        return member;
//    }
//
//    public void setMember(Member member) {
//        this.member = member;
//    }
//}
