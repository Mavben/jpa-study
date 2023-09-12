package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String username;


    @ManyToOne // 다대일 매핑 정보
    @JoinColumn(name="TEAM_ID") // JoinColumn - 외래 키 매핑할 때
    private Team team;
}
