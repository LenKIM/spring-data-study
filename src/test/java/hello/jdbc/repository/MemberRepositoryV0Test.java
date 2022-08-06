package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {

        Member member = new Member(UUID.randomUUID().toString(), 10000);
        repository.save(member);

        Member foundMember = repository.findById(member.getMemberId());


        repository.update(member.getMemberId(), 20000);
        Member updatedMember = repository.findById(member.getMemberId());
        Assertions.assertThat(updatedMember).isEqualTo(member);
    }
}
