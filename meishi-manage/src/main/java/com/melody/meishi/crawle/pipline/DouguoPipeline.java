package com.melody.meishi.crawle.pipline;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.meishi.ws.service.MeishiService;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;


@ThreadSafe
@Service(value = "douguoPipline")
public class DouguoPipeline implements Pipeline {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private String filePath;

	@Resource
	private MeishiService meishiService;
	
	public DouguoPipeline() {
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