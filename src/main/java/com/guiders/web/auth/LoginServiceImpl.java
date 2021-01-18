package com.guiders.web.auth;

import com.guiders.web.member.MemberDAO;
import com.guiders.web.member.GuiderVO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final SqlSession sqlSession;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void join(GuiderVO guiderVO) {
        guiderVO.setPassword(bCryptPasswordEncoder.encode(guiderVO.getPassword()));

        sqlSession.getMapper(MemberDAO.class).insertMember(guiderVO);

        if (guiderVO.getQuote() != null) {
            sqlSession.getMapper(MemberDAO.class).insertGuider(guiderVO);
        }

    }

}
