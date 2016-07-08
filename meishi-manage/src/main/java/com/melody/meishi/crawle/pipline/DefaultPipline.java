package com.melody.meishi.crawle.pipline;

import com.meishi.ws.service.MeishiService;
import org.apache.http.annotation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


@ThreadSafe
@Component(value = "douguoPipline")
public class DefaultPipline implements Pipeline {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private String filePath;

	@Resource
	private MeishiService meishiService;
	
	public DefaultPipline() {
		filePath = "D:\\webmagic-meishi\\data\\douguo\\东北菜\\";
	}
	
	@Override
	public void process(ResultItems resultItems, Task task) {

	}


	public void writeFile(String filePath, String sets) throws IOException {
	    FileWriter fw = new FileWriter(filePath);
	    PrintWriter out = new PrintWriter(fw);
	    out.write(sets);
	    out.println();
	    fw.close();
	    out.close();
	   }
}