package com.melody.meishi.center;

import com.meishi.ws.service.MeishiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cooper on 2015/9/13.
 */
@Controller
@RequestMapping(value = "/center")
public class MeishiController {

    @Resource
    private MeishiService meishiService;



}
