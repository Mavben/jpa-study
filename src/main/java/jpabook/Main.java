package jpabook;

import jakarta.persistence.*;
import jpabook.model.entity.Member;
import jpabook.model.entity.Team;

import java.util.List;

// 엔티티 매니저 설정, 트랜잭션 관리, 비즈니스 로직

public class Main {

    public static void main(String[] args) {

        // 엔티티 매니저 팩토리 생성 - jpabook
        // 전체에서 딱 한 번만 공유하고 생성 가능
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); // 엔티티 매니저 생성

        // JPA는 트랜잭션 안에서 데이터를 변경해야 함
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 API

        try {

            tx.begin(); // 트랜잭션 시작
            logic(em); // 비즈니스 로직 실행
            Member member1 = new Member("member1", "회원1");
            Member member2 = new Member("member2", "회원2");
            Team team1 = new Team("team1", "팀1");
            em.persist(team1);

            em.persist(member1);
            em.persist(member2);

            tx.commit();// 트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 예외 발생 시 트랜잭션 롤백
        } finally {
            em.close(); // 엔티티 매니저 종료
        }

        emf.close(); // 엔티티 매니저 팩토리 종료 - 애플리케이션 종료를 의미함
    }

    // 비즈니스 로직
    private static void logic(EntityManager em) {

        // 등록
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("펭수");
        member.setAge(5);

        // 엔티티 저장
        em.persist(member);

        // 수정
        member.setAge(20);

        // 한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        // 목록 조회 - JPQL(select m from Member m)
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());

        // 삭제
        em.remove(member);

    }


    public void testSave() {

    }

    // 연관관계 수정
    public static void updateRelation(EntityManager em) {

        Team team2 = new Team ("team2", "팀2");
        em.persist(team2);

        Member member = em.find(Member.class, "Member1");
        member.setTeam(team2);
    }

    // 연관관계 제거
    public static void deleteRelation(EntityManager em) {

        Member member1 = em.find(Member.class, "Member1");
        member1.setTeam(null);
    }

    // 연관된 엔터티 삭제
    public static void deleteTeam(EntityManager em) {

        Member member1 = em.find(Member.class, "Member1");
        Member member2 = em.find(Member.class, "Member2");
        member1.setTeam(null);
        member2.setTeam(null);


        Team team = em.find(Team.class, "team1");
        em.remove(team);
    }

    // 객체 그래프 탐색
    public void biDirection() {


        Team team = em.find(Team.class, "team1");
        List<Member> members = team.getMembers();

        for (Member member : members) {
            System.out.println("member.username = " +
                    member.getUsername);
        }
    }

    public void testSaveNonOwner() {

        // 회원1 저장
        Member member1 = new Member("member1", "회원1");
        em.persist(member1);

        // 회원2 저장
        Member member2 = new Member("member2", "회원2");
        em.persist(member2);

        Team team1 = new Team("team1", "팀1");
        // 양방향 연관관계의 유의점 - 주인이 아닌 곳만 연관관계 설정
        // 양방향 값을 모두 입력하지 않을 시 JPA 사용하지 않는 순수한 객체에서 문제 발생
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        em.persist(team1);


    }

}