package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 使用者資料
/*
 use web;
create table if not exists user (
	id int auto_increment primary key,
    username varchar(50) not null unique,
    hash varchar(255) not null,
    salt varchar(255) not null
);
 */

//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
@Data
public class User {
	private Integer id;
	private String username;
	private String hash;
	private String salt;
	
	
}
