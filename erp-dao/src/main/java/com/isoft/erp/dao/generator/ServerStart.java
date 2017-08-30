package com.isoft.erp.dao.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * @description,通过连接数据库生成数据访问层代码
 * @author Jacob
 * @company <p>www.eunis.com.cn</p>
 * @email 
 * Created on 2016年12月6日
 */
@SuppressWarnings("All")
public class ServerStart {
	
	public void generator() throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		File configFile = new File("/config.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	public static void main(String[] args) throws Exception {
		try {
			ServerStart serverStart = new ServerStart();
			serverStart.generator();
			System.out.println("=============================执行完成========================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
