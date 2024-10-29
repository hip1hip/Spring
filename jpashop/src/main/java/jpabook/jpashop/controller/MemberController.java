package jpabook.jpashop.controller;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm()); // Model 컨트롤러에서 뷰로 넘어갈때 데이터를 가지고 넘어감
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(@Valid MemberForm form, BindingResult result) {  //@Valid Form 에 있는 @NotEmpty 을 벨리데이션 해줌 //BindingResult 쓰면 오류가 담겨서 아래 코드가 실행이 됨

        if (result.hasErrors()){
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";  //다시 재로딩 안하게 홈으로,

    }



}
