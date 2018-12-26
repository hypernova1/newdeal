package com.bit.board.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bit.board.model.MemoDto;
import com.bit.board.service.MemoService;
import com.bit.member.model.MemberDto;

@Controller
public class MemoController {

  @Autowired
  private MemoService memoService;
  
  @PostMapping(value="memo", headers= {"Content-Type=application/json"})
  public @ResponseBody String write(@RequestBody MemoDto memoDto, HttpSession session) {
    
    MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
    if(memberDto != null) {
      memoDto.setId(memberDto.getId());
      memoDto.setName(memberDto.getName());
      memoService.writeMemo(memoDto);
    }
    
    String memoList = memoService.listMomo(memoDto.getSeq());
    return memoList;
  }
  
  @GetMapping("memo/{seq}")
  public @ResponseBody String list(@PathVariable int seq) {
    String memoList = memoService.listMomo(seq);
    return memoList;
  }
  
  @PutMapping(value="memo", headers= {"Content-Type=application/json"})
  public @ResponseBody String modify(@RequestBody MemoDto memoDto, HttpSession session) {
    
    MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
    if(memberDto != null) {
      memoService.modifyMemo(memoDto);
    }
    
    String memoList = memoService.listMomo(memoDto.getSeq());
    return memoList;
  }
  
  @DeleteMapping("memo/{mseq}/{seq}")
  public @ResponseBody String delete(@PathVariable int mseq, @PathVariable int seq) {
    memoService.deleteMomo(mseq);
    String list = memoService.listMomo(seq);
    return list;
  }
  
}
