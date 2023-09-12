package jpabook.model.entity;

import jakarta.persistence.*;

import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;


    // 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

//    // 연관관계 설정
//    public void setTeam(Team team) {
//        this.team = team;
//    }

    // join table - 다대다 관계

    public Member(String 회원2) {
        this(null, 회원2);
    }



    public Member(String member2, String 회원2) {
    }

    public Member() {

    }

    public void getTeam() {
    }

    public void setTeam(Team team2) {
        this.team = team;
    }

    public void setId(String id) {
    }

    public void setUsername(String 펭수) {
    }

    public void setAge(int i) {
    }

    public String getUsername() {
    }
}

