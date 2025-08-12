package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse <T>{
	//<T> 是指資料可以單筆 可以多筆 是一個
	private boolean success;
	private T data;
	private String message;
}

/*
 *
 */
