package jpabook;

import jpabook.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class PersistenceContext {

    public static void main(String[] args) {

        // 변경 감지 - 엔티티 수정하기

        EntityManagerFactory emf = null;
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin(); // 트랜잭션 시작

        // 영속 엔티티 조회
        Member memberA = em.find(Member.class, "memberA");

        // 영속 엔티티 데이터 수정
        memberA.setUsername("hi");
        memberA.setAge(10);

        // em.update(member) - 해당 메소드 없음

        transaction.commit(); // 트랜잭션 커밋

        // 준영속
        // 엔티티를 준영속 상태로 전환 : detach()

        testDetached(em); // 'em' 인스턴스를 매개변수로 전달

        // 영속성 컨텍스트 초기화 : clear()
        // 영속 엔티티 조회

        Member member = em.find(Member.class, "memberA");

        em.clear();

        // 준영속 상태
        member.setUsername("changeName");
    }

    // 메서드 시그니처를 수정하여 'em' 매개변수를 받도록 변경
    public static void testDetached(EntityManager em) {

        // 회원 엔티티 생성, 비영속 상태
        Member member = new Member();
        member.setId(Long.valueOf("memberA"));
        member.setUsername("회원A");

        // 회원 엔티티 영속 상태
        em.persist(member);

        // 회원 엔티티를 영속성 컨텍스트로 분리, 준영속 상태
        em.detach(member);

    }
}



//package jpabook;
//
//
//import jpabook.model.entity.Member;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//
//public class PersistenceContext {
//
//    public static void main(String[] args) {
//
//        // 변경 감지 - 엔티티 수정하기
//
//        EntityManagerFactory emf = null;
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//
//        transaction.begin(); // 트랜잭션 시작
//
//        // 영속 엔티티 조회
//        Member memberA = em.find(Member.class, "memberA");
//
//        // 영속 엔티티 데이터 수정
//        memberA.setUsername("hi");
//        memberA.setAge(10);
//
//        // em.update(member) - 해당 메소드 없음
//
//        transaction.commit(); // 트랜잭션 커밋
//
//
//        // 준영속
//        // 엔티티를 준영속 상태로 전환 : detach()
//
//        public void testDetached() {
//
//            // 회원 엔티티 생성, 비영속 상태
//            Member member = new Member();
//            member.setId(Long.valueOf("memberA"));
//            member.setUsername("회원A");
//
//            // 회원 엔티티 영속 상태
//            EntityManager em = null;
//            em.persist(member);
//
//            // 회원 엔티티를 영속성 컨텍스트로 분리, 준영속 상태
//            em.detach(member);
//
//            transaction.commit(); // 트랜잭션 커밋
//        }
//
//        // 영속성 컨텍스트 초기화 : clear()
//        // 영속 엔티티 조회
//
//        Member member = em.find(Member.class, "memberA");
//
//        em.clear();
//
//        // 준영속 상태
//        member.setUsername("changeName");
//
//    }
//}


/*
    영속성 컨텍스트의 특징
        - 영속 상태는 식별자 값(@Id로 테이블의 기본 키와 매핑한 값)이 반드시 있어야 한다.
        - 플러시(flush) : 트랜잭션을 커밋하는 순간 영속성 컨텍스트는 새로 저장된 엔티티를 db에 반영한다.

    @org.hibernate.annotations.DynamicUpdate - 수정된 데이터만 사용해서 동적으로 UPDATE SQL 생성

 */