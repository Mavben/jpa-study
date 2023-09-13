package jpabook.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MEMBER")
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
    private String getUsername;


    // Member 엔티티에서 Product 엔티티로의 양방향 관계 설정
    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT",
        joinColumns = @JoinColumn(name = "MEMBER_ID"),
        inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
    )

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        //product.getMembers().add(this);
    }

    public List<Product> getProducts() {
        return null;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Member() {

    }

    public Member(String member1, String 회원1) {
    }

    public String getGetUsername() {
        String getUsername = null;
        return getUsername;
    }

    public void setGetUsername(String getUsername) {
        this.getUsername = getUsername;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setUsername(String hi) {
    }

    public void setAge(int i) {
    }

    public void setTeam(Team team1) {
    }

    public String getName() {
        return null;
    }
}

