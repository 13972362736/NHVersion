package com.jeffreyning.nhversion.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jeffreyning.nhversion.common.version.mapping.CommonControllerMapping;
import com.jeffreyning.nhversion.demo.controller.FrontVersionChangeController;
import com.jeffreyning.nhversion.demo.controller.NoNHVersionController;
import com.jeffreyning.nhversion.demo.controller.NHVersionController;

public class Demo {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("applicationContext.xml");
		CommonControllerMapping.batchRegistryByPackage("com.jeffreyning.nhversion.demo.controller.cmd");
		NoNHVersionController.calcu(1, "v1_0_1");
		NHVersionController.calcu(1,"v1_0_1");
		NoNHVersionController.calcu(1, "v1_0_6");//��ͳifelse���Զ���������
		NHVersionController.calcu(1,"v1_0_6");//������106��ʵ�������Զ�����Ϊ105��cmdʵ��
		
		//ʹ��nhversion-1.3.0-RELEASE.jarʱ֧��
		FrontVersionChangeController.calcu(1,"v3_1_0");//ǰ̨version 310ӳ��Ϊ��̨version 105
		FrontVersionChangeController.calcu(1,"v3_1_1");//ǰ̨version 311ӳ��Ϊ��̨version 105
		FrontVersionChangeController.calcu(1,"v3_2_0");//ǰ̨version 320ӳ��Ϊ��̨version 110
	}

}
