package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* 생성 */
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            /* 조회 */
//            Member findMember = em.find(Member.class, 1L);

            /* 수정 */
//            findMember.setName("HelloJPA");

            /* 삭제 */
//            em.remove(findMember);

            /* JPQL */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            /* 비영속 */
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            /* 영속 */
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

            /* 1차 캐싱 조회, 영속 엔티티의 동일성 보장 */
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (findMember1 == findMember2));

            /* 쓰기 지연 */
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "A");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("=========================");

            /* 변경 감지 */
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZ");

            /* 플러시 */
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();
//            System.out.println("=========================");

            /* 준영속 */
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//            em.detach(member);
//            Member member2 = em.find(Member.class, 150L);

            Member member = new Member();
            member.setId(3L);
            member.setUsername("C");
            member.setRoleType(RoleType.GUEST);

            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}