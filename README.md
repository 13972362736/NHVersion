# NHVersion
NHVersion���

api�ӿ���Ҫ�ְ汾ͬʱ�����ʹ�÷���ͨ���ƶ���app�ĺ�̨�ӿ������ְ汾���������ÿ���ӿڶ����¸���������ɴ����ظ����롣
ʹ��NHVersion�����Խ�������ظ����⣬ͬʱ��û����ȫһ�µİ汾ӳ��ʱ�������Ը����ṩ�İ汾���ҵ�����Ƶİ汾���е��á�
NHVersion���Ŀ�Դ���������https://github.com/jeffreyning/NHVersion
����jar�����nhversion-1.0.jar
����jar(֧��spring)�����nhversion-1.1.jar

��û��NHVersion��������£�һ�����ifelse�����汾�жϣ��������µĴ���
��ΪCalcu�Ľӿ�ͨ��ifelse�ж�v1_0_1 v_1_0_5 v1_1_0��3���汾�����Ҫ�����µİ汾��
����Ҫ�޸�Calcu���ڲ�ifelse�߼����������׳�������ÿ���汾��Ҫ���±�д��
public class NoNHVersionController {
	public static int calcu(int param,String version){
		if(version.equals("v1_0_1")){
			System.out.println("this is nonhversioin v1_0_1");
			return param+1;
		}else if(version.equals("v1_0_5")){
			System.out.println("this is nonhversion v1_0_5");
			return param+5;
		}else if(version.equals("v1_1_0")){
			System.out.println("this is nonhversion v1_1_0");
			return param+10;
		}
		System.out.println("this is nonhversion not catch");
		return 0;
	}
}

NHVersion��⽫�����߼������handler��ͨ��mapά��handler��version��ӳ���ϵ��
�����°汾ʱֻ��ʵ���µ�handler����ע��map�У������޸Ľӿ�����Ĵ��롣���ҿ���֧�ְ汾���Զ�����ƥ�䡣
����V1_0_6û����ȫ���handler������Զ�����ƥ��V1_0_5���е��á�



ÿ����ͬ�汾��Ҫ��дhandler
@ControllerMappingAnno(controllerName="NHVersionController",funcName="calcu",funcVer="v1_0_0")
ע�������������handler��version��ӳ���ϵ����NHVersionController�ӿ��࣬calcu������Ӧ��v1_0_0�汾��handler����CalcuCmd1
֧�ְ���springbeanid����cmd����@ControllerMappingAnno(controllerName="NHVersionController",funcName="calcu",funcVer="v1_0_0" beanId="cmd1")

package com.jeffreyning.nhversion.demo.controller.cmd;
import java.util.HashMap;
import java.util.Map;

import com.jeffreyning.nhversion.common.version.cmd.IControllerCommand;
import com.jeffreyning.nhversion.common.version.mapping.ControllerMappingAnno;
//@Component("cmd1")
//@ControllerMappingAnno(controllerName="NHVersionController",funcName="calcu",funcVer="v1_0_0" beanId="cmd1")
@ControllerMappingAnno(controllerName="NHVersionController",funcName="calcu",funcVer="v1_0_0")
public class CalcuCmd1 extends IControllerCommand{

	@Override
	public Map execute(Map paramMap) {
		System.out.println("this is nhversion v1_0_0");
		int param=(Integer) paramMap.get("param");
		int ret=param+1;
		Map retMap=new HashMap();
		retMap.put("retInt", ret);
		return retMap;
	}
}


ʹ��NHVersion����ӿڲ��дΪ
CommonControllerMapping.execVersionMapping�����汾ӳ�䲢�����ҳ���handler����
����Ϊ�ӿ����ʶ��������ʶ���汾�ţ�������map��
public class NHVersionController {
	public static int calcu(int param,String version){
		Map paramMap=new HashMap();
    	paramMap.put("version", version);
    	paramMap.put("param", param);
    	Map retMap=CommonControllerMapping.execVersionMapping("NHVersionController","calcu", version, paramMap);
    	Integer retInt=(Integer) retMap.get("retInt");
		return retInt;
	}
}

@ControllerMappingAnnoά����ӳ���ϵ��ͨ���Զ�ɨ��ע�뵽map��
CommonControllerMapping.batchRegistryByPackage("com.jeffreyning.nhversion.demo.controller.cmd");
package com.jeffreyning.nhversion.demo;

import com.jeffreyning.nhversion.common.version.mapping.CommonControllerMapping;
import com.jeffreyning.nhversion.demo.controller.NoNHVersionController;
import com.jeffreyning.nhversion.demo.controller.NHVersionController;

public class Demo {

	public static void main(String[] args) throws Exception {
		CommonControllerMapping.batchRegistryByPackage("com.jeffreyning.nhversion.demo.controller.cmd");
		NoNHVersionController.calcu(1, "v1_0_1");
		NHVersionController.calcu(1,"v1_0_1");
		NoNHVersionController.calcu(1, "v1_0_6");
		NHVersionController.calcu(1,"v1_0_6");
	}

}

ע�⣺�汾�Ÿ�ʽΪvxx_xx_xx xx����2λ���� ��v01_0_10 v1_1_6������ȷ�ĸ�ʽ
�����Ҫ����spring�е�cmd������Ҫ������spring�����ļ������<bean class="com.jeffreyning.nhversion.common.version.util.NHBeanUtil"></bean>
����
