package com.dongzhic.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dongzhic
 */
@Controller
@RequestMapping("/threadLocal")
public class ThreadLoaclController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test() {
        return RequestHolder.getId() == null ? -1 : RequestHolder.getId();
    }
}
