package com.heroumcaslu.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component //Scaneada pelo ComponentScan
//@Repository //Especialização - > Trabalhar com DAO
//@Service //Aconselhavel utilizar em classes da camada de serviço
public class DateUtil {
	
	public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {
		
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
		
	}

}
