package jpabook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="MEMBER")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
    private String getUsername;


    // Product 엔티티에서 Member 엔티티로의 양방향 관계 설정
    @ManyToMany(mappedBy = "products") // 역방향 추가
    private List<Member> members = new ArrayList<>();


    public String getName() {
        return null;
    }

    public Calendar getMembers() {
        return null;
    }
}