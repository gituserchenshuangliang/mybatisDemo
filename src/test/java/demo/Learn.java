package demo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.csl.demo.springmybaits.dao.Mapper;

/**
 * @author Cherry
 * @date 2019年5月16日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:applicationContext.xml" })
@WebAppConfiguration
public class Learn extends AbstractJUnit4SpringContextTests {
	private static Logger logger = LoggerFactory.getLogger(Learn.class);
	@Autowired
	private Mapper mapper;
	
	@Test
	public void shows(){
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("username","chen");
		m.put("price",6000);
		//ArrayList<HashMap<String, Object>> lists = mapper.getAllUser();
		ArrayList<HashMap<String, Object>> list = mapper.showView(25);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		int count = mapper.queryViewForMap(m);
		logger.debug(count+"");
	}
}
