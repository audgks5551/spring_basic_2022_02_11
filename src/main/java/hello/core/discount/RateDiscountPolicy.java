package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy") // 의존 주입할 때 두개 이상의 구현체가 있으면 지정가능
//@MainDiscountPolicy // 위와 같은 효과 나타남(어노테이션을 만든 이유는 컴파일시 문자를 잘못 작성하여도 컴파일 오류가 안나기 때문)
@Primary
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }

    }
}
